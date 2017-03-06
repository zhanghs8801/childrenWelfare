package cn.child.welfare.controller;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import cn.child.welfare.entity.User;
import cn.child.welfare.page.PageContext;
import cn.child.welfare.service.user.UserService;

@Controller
public class UserController{
	private Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public String show(ModelMap modelMap, String pageNum) {
		//http://localhost:8080/welfare/user/
		//http://localhost:8080/welfare/user/?pageNum=4
		PageContext page = PageContext.getContext();
		int currentPage = 1;
		if(pageNum != null){
			currentPage = Integer.parseInt(pageNum);
		}
		page.setCurrentPage(currentPage);
        page.setPagination(true);// 开启分页模式
		
		List<User> users = userService.findAll();
		modelMap.put("users", users);
		return "users";
	}

	/**
	 * 创建用户
	 * @param user
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public String createUser(User user, UriComponentsBuilder ucBuilder) {
		String email = user.getEmail();
		if (userService.exist(email)) {
			logger.warn("A User with name " + email + " already exist");
			return "redirect:/user/";
		}
		userService.create(user);
		HttpHeaders headers = new HttpHeaders();
		URI location = ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
		headers.setLocation(location);
		// 注册后自动登录
	    UsernamePasswordToken token = new UsernamePasswordToken();  
	    token.setUsername(user.getEmail());  
	    token.setPassword(user.getPassword().toCharArray());  
	    SecurityUtils.getSubject().login(token);  
		return "redirect:/user/";
	}

	/**
	 * 用户详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable("id") int id, ModelMap modelMap) {
		logger.info("Fetching User with id " + id);
		User user = userService.getUserById(id);
		modelMap.put("user", user);
		return "user";
	}
}
