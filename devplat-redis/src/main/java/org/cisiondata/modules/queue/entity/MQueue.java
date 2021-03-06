package org.cisiondata.modules.queue.entity;

public enum MQueue {
	
	DEFAULT_QUEUE("defaultQueue", "default"),
	DEFAULT_TOPIC_QUEUE("defaultTopicQueue", "topic"),
	REQUEST_ACCESS_QUEUE("requestAccessQueue", "requestAccess"),
	RESPONSE_RESULT_QUEUE("responseResultQueue", "responseResult");
	
	private String name = null;
	
	private String routingKey = null;
	
	private MQueue(String name, String routingKey) {
		this.name = name;
		this.routingKey = routingKey;
	}

	public String getName() {
		return name;
	}

	public String getRoutingKey() {
		return routingKey;
	}


}
