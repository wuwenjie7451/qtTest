package com.pb.web.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

@SuppressWarnings("all")
// SimpleFormController是spring提供的表单控制器，把页面中Form中的元素名称设定为和bean中的一样，当传入的时候Spring会自动抓取form中和Bean名称一样的元素值，把它转换成一个bean,使得开发人员可以很方便的使用。
public class UserController extends SimpleFormController {
	private String viewpage;
	private UserDao dao;

	public String getViewpage() {
		return viewpage;
	}

	public void setViewpage(String viewpage) {
		this.viewpage = viewpage;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		UserDao tmp = (UserDao) command;
		List<Map<String, Object>> list = dao.doquery();
		List<UserPO> users = new ArrayList<UserPO>();
		UserPO user;
//		for (UserPO userPO : list) {
//			user = new UserPO();
//			user.setUserId(userPO.getUserId());
//			user.setUserName(userPO.getUserName());
//			user.setUserPwd(userPO.getUserPwd());
//			user.setUserEmail(userPO.getUserEmail());
//			users.add(user);
//		}
		Map mp = new HashMap();
		mp.put("list", users);
		return new ModelAndView(getViewpage(), mp);
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

}
