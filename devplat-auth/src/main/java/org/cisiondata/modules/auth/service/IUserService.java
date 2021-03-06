package org.cisiondata.modules.auth.service;

import org.cisiondata.modules.abstr.service.IGenericService;
import org.cisiondata.modules.auth.entity.User;
import org.cisiondata.utils.exception.BusinessException;

public interface IUserService extends IGenericService<User, Long> {
	
	/**
	 * 新增用户
	 * @param user
	 * @throws BusinessException
	 */
	public void insertUser(User user) throws BusinessException;

	/**
	 * 修改用户信息
	 * @param user
	 * @throws BusinessException
	 */
	public void updateUser(User user) throws BusinessException;
	
	/**
	 * 修改用户密码
	 * @param account
	 * @param originalPassword
	 * @param newPassword
	 * @throws BusinessException
	 */
	public void updateUserPassword(String account, String originalPassword, String newPassword) 
			throws BusinessException;
	
	/**
	 * 根据用户账号读取用户数据
	 * @param account
	 * @return
	 * @throws BusinessException
	 */
	public User readUserByAccount(String account) throws BusinessException;
	
	/**
	 * 根据accessId读取用户accessKey
	 * @param accessId
	 * @return
	 * @throws BusinessException
	 */
	public String readUserAccessKeyByAccessId(String accessId) throws BusinessException;
	
	/**
	 * 根据用户账号和密码读取用户数据
	 * @param account
	 * @param password
	 * @return
	 * @throws BusinessException
	 */
	public User readUserByAccountAndPassword(String account, String password) throws BusinessException;
	
	/**
	 * 删除用户缓存
	 * @param account
	 * @throws BusinessException
	 */
	public void deleteUserCache(String account) throws BusinessException;
	
}
