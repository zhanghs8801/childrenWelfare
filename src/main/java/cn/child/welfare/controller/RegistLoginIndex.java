package cn.child.welfare.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.child.welfare.service.user.UserService;

/**
 * 注册/登录索引页
 */
@Controller
public class RegistLoginIndex {
	@Autowired
	private UserService userService;

	/**
	 * 注册页
	 */
	@RequestMapping(value = "/register/", method = RequestMethod.GET)
	public String showRegister() {
		return "register";
	}

	/**
	 * 登录页
	 */
	@RequestMapping(value = "/login/")
	public String showLogin(ModelMap map) {
		map.put("message", "");
		return "login";
	}

	/**
	 * <p>
	 * 检测邮箱是否被注册<br>
	 * 注意：bootstrapValidator验证一定要返回json格式的数据，并且要是以下的内容<br>
	 * {"valid":false} 表示不合法，验证不通过<br>
	 * {"valid":true}  表示合法，验证通过<br>
	 * </p>
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/oauth", method = RequestMethod.GET)
	@ResponseBody
	public String canRegister(String email) {
		JSONObject jsonResult = new JSONObject();
		boolean exist = userService.exist(email);
		if (exist) {
			jsonResult.put("valid", false);
		} else {
			jsonResult.put("valid", true);
		}
		return jsonResult.toString();
	}
}
