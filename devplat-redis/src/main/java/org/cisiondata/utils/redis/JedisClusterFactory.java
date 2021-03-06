package org.cisiondata.utils.redis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {

	private final Logger LOG = LoggerFactory.getLogger(JedisClusterFactory.class);
	
	private JedisCluster jedisCluster = null;

	@SuppressWarnings("unused")
	private Resource addressConfig = null;
	private String addressKeyPrefix = "redis.cluster.address";

	private Integer timeout = null;
	private Integer maxRedirections = null;
	private GenericObjectPoolConfig genericObjectPoolConfig = null;
	
	private Pattern pattern = Pattern.compile("^.+[:]\\d{1,5}\\s*$");

	@Override
	public JedisCluster getObject() throws Exception {
		return jedisCluster;
	}

	@Override
	public Class<? extends JedisCluster> getObjectType() {
		return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Set<HostAndPort> hostAndPorts = this.parseHostAndPort();
		jedisCluster = new JedisCluster(hostAndPorts, timeout, maxRedirections, genericObjectPoolConfig);
	}
	
	private Set<HostAndPort> parseHostAndPort() {
		Properties properties = new Properties();
		InputStream in = null;
		try {
			/**
			properties.load(this.addressConfig.getInputStream());
			*/
			in = JedisClusterFactory.class.getClassLoader().getResourceAsStream("redis/env.local.properties");
			properties.load(in);
			Set<HostAndPort> hostAndPorts = new HashSet<HostAndPort>();
			for (Object key : properties.keySet()) {
				if (!((String) key).startsWith(addressKeyPrefix)) continue;
				String value = (String) properties.get(key);
				boolean isIpPort = pattern.matcher(value).matches();
				if (!isIpPort) {
					throw new IllegalArgumentException("ip 或  port 不合法");
				}
				String[] ipAndPort = value.split(":");
				HostAndPort hostAndPort = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
				hostAndPorts.add(hostAndPort);
				LOG.info("Redis Cluster Host: {} : {}", hostAndPort.getHost(), hostAndPort.getPort());
			}
			return hostAndPorts;
		} catch (Exception e) {
			LOG.error("解析redis配置文件失败", e);
		} finally {
			try {
				if (null != in) in.close();
			} catch (IOException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return null;
	}
	
	public void setAddressConfig(Resource addressConfig) {
		this.addressConfig = addressConfig;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setMaxRedirections(int maxRedirections) {
		this.maxRedirections = maxRedirections;
	}

	public void setAddressKeyPrefix(String addressKeyPrefix) {
		this.addressKeyPrefix = addressKeyPrefix;
	}

	public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
		this.genericObjectPoolConfig = genericObjectPoolConfig;
	}

}
