package com.pb.web.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.pb.entity.Account;

public class LoginController extends AbstractController {
	@Autowired
	private UserDao serDaou;
	public UserDao getSerDaou() {
		return serDaou;
	}
	public void setSerDaou(UserDao serDaou) {
		this.serDaou = serDaou;
	}
	private String successView;
	private String failView;
	
	public String getSuccessView() {
		return successView;
	}
	public void setSuccessView(String successView) {
		this.successView = successView;
	}
	public String getFailView() {
		return failView;
	}
	public void setFailView(String failView) {
		this.failView = failView;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(411111);
		String cardNo=request.getParameter("cardNo");
		String password=request.getParameter("password");
		System.out.println("修改jx_branch的日志为222");
//		Account account =getAccount(cardNo,password);
		Map<String ,Object> model=new HashMap<String,Object>();
//		if(account !=null){
//			model.put("account", account);
//			return new ModelAndView(getSuccessView(),model);
//		}else{
//			model.put("error", "卡号和密码不正确");
//			return new ModelAndView(getFailView(),model);
//		}	
		List list = (List) serDaou.doquery();
		System.out.println(list.size());
		Map map = new HashMap();
		for (int i = 0; i < list.size(); i++) {
			map = (Map) list.get(0);
			System.out.println(map.get("sqyy"));
			model.put("sqyy", map.get("sqyy"));
			model.put("zt", map.get("zt"));
		}
			
		
		return new ModelAndView(getSuccessView(),model);
	}
	public Account getAccount(String cardNo,String password){
		if(cardNo.equals("123")&&password.equals("123")){
			Account account =new Account();
			account.setCardNo(cardNo);
			account.setBalance(88.8f);
			return account;
		}else{
			return null;
		}
	}

}
