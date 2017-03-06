package cn.child.welfare.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import cn.child.welfare.entity.User;

@Component
public class ChildrenFormAuthenticationFilter extends FormAuthenticationFilter{
	/**
	 * 检测当前用户是否已登录
	 * @param currentSubject
	 * @return
	 */
	protected boolean hasLogin(Subject currentSubject) {
		return currentSubject != null && currentSubject.isAuthenticated();
	}
	
	/**
	 * 检测是否是已经登录的用户并且仍然继续访问登录请求
	 * @param currentSubject
	 * @param request
	 * @return
	 */
	protected boolean hasLoginAndAcessLogin(Subject currentSubject, HttpServletRequest request) {
		if (hasLogin(currentSubject)
				&& request.getRequestURI().endsWith("/login/")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 检测是否是注册请求<br>
	 * Rest访问方式，对应调用
	 * {@link cn.child.welfare.controller.UserController#createUser(User user, UriComponentsBuilder uriBuilder)}
	 * 方法
	 * 
	 * @return
	 */
	protected boolean isRegisterRequest(HttpServletRequest request) {
		return request.getRequestURI().endsWith("/user/")
				&& request.getMethod().equals("POST");
	}
	
	@Override
	protected boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		// 注册，不需要认证
		if (isRegisterRequest(request)) {
			return true;
		}
		Subject currentSubject = SecurityUtils.getSubject();
		// 已登录，并且还是访问的/login/请求，直接跳转至对应的首页
		if (hasLoginAndAcessLogin(currentSubject, request)) {
			return redirect(currentSubject, servletRequest, servletResponse);
		}
		return super.preHandle(servletRequest, servletResponse);
	}
	
	@Override
	protected String getPassword(ServletRequest request) {
		String password = super.getPassword(request);
		Md5Hash md5Hash = new Md5Hash(password);
		String tokenCredentials = md5Hash.toString();
		return tokenCredentials;
	}
	
	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		return new UsernamePasswordToken(getUsername(request), getPassword(request));
	}
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
		WebUtils.getAndClearSavedRequest(request);
		return redirect(subject, request, response);
	}
	
	private boolean redirect(Subject subject, ServletRequest request, ServletResponse response) throws Exception {
		WebUtils.redirectToSavedRequest(request, response, "/user/");
		return true;
		/*if (subject.hasRole(Constant.ADMIN_ROLE)) {
			WebUtils.redirectToSavedRequest(request, response, "/users");
			return true;
		}
		if (subject.isPermitted(Constant.YYG_PERMISSION_KEY)) {
			WebUtils.redirectToSavedRequest(request, response, "/queryLogisticsInfo");
			return true;
		}
		if (subject.isPermitted(Constant.FLS_PERMISSION_KEY)) {
			WebUtils.redirectToSavedRequest(request, response, "/couponList");
			return true;
		}
		if (subject.isPermitted(Constant.MESSAGE_PERMISSION_KEY)) {
			WebUtils.redirectToSavedRequest(request, response, "/messages");
			return true;
		}
		if (subject.isPermitted(Constant.COMMENT_PERMISSION_KEY)) {
			WebUtils.redirectToSavedRequest(request, response, "/comments");
			return true;
		}
		if (subject.isPermitted(Constant.CARDPACKAGE_PERMISSION_KEY)) {
			WebUtils.redirectToSavedRequest(request, response, "/cardPackages");
			return true;
		}*/
	}
	
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
		String message = "";
        if (e instanceof IncorrectCredentialsException || e instanceof UnknownAccountException){
            message = "用户或密码错误, 请重试.";
        } else if (e.getMessage() != null && e.getMessage().startsWith("msg:")){
            message = StringUtils.replace(e.getMessage(), "msg:", "");
        } else{
            message = "系统出现点问题，请稍后再试！";
            e.printStackTrace();
        }
        request.setAttribute(getFailureKeyAttribute(), e.getClass().getName());
        request.setAttribute("message", message);
        return true;
	}
	
}
