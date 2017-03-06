package cn.child.welfare.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.child.welfare.dao.user.UserDao;
import cn.child.welfare.entity.User;
import cn.child.welfare.tool.MD5Util;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean exist(String email) {
		return userDao.exist(email);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}
	
	@Override
	public User queryUserByEmail(String email) {
		return userDao.queryUserByEmail(email);
	}

	@Override
	public void create(User user) {
		String password = user.getPassword();
		String encodedPwd = MD5Util.encode(password);
		user.setPassword(encodedPwd);
		userDao.create(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

}
