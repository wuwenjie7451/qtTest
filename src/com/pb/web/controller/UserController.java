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
// SimpleFormController��spring�ṩ�ı�����������ҳ����Form�е�Ԫ�������趨Ϊ��bean�е�һ�����������ʱ��Spring���Զ�ץȡform�к�Bean����һ����Ԫ��ֵ������ת����һ��bean,ʹ�ÿ�����Ա���Ժܷ����ʹ�á�
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
