package cn.child.welfare.service.user;

import java.util.List;

import cn.child.welfare.entity.User;

public interface UserService{
	/**
	 * 判断用户是否存在
	 * @param email
	 * @return
	 */
	boolean exist(String email);
	/**
	 * 获取用户列表
	 * @return
	 */
	List<User> findAll();
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	User getUserById(int id);
	/**
	 * 根据邮箱查询用户
	 * @param email
	 * @return
	 */
	User queryUserByEmail(String email);
	/**
	 * 创建实体
	 * 
	 * @param user
	 */
	void create(User user);

	/**
	 * 更新实体
	 * 
	 * @param user
	 */
	void update(User user);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(int id);
}
