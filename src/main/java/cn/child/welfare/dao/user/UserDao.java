package cn.child.welfare.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.child.welfare.entity.User;

@Mapper
public interface UserDao{
	/**
	 * 判断用户是否存在
	 * @param email
	 * @return
	 */
	boolean exist(String email);
	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	User getUserById(int id);
	/**
	 * 获取用户列表
	 * @return
	 */
	List<User> findAll();
	/**
	 * 根据邮箱查询用户(精确查找)
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
