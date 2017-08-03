package com.pb.web.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestAnnotation {
	@Autowired
	private UserDao serDaou;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView hello(){
		Map<String ,Object> model=new HashMap<String,Object>();
		List list = (List) serDaou.doquery();
		System.out.println(list.size());
		Map map = new HashMap();
		for (int i = 0; i < list.size(); i++) {
			map = (Map) list.get(0);
			System.out.println(map.get("sqyy"));
			model.put("sqyy", map.get("sqyy"));
			model.put("zt", map.get("zt"));
		}
			
		return new ModelAndView("login",model);
	}
	
	
	//数据同步
	@RequestMapping(value="/datasave",method=RequestMethod.GET)
	public void datasave(){
		System.out.println("111111111111");
		Map<String ,Object> model=new HashMap<String,Object>();
//		model.put("sqyy", 1);
//		model.put("zt", 2);
		List list = (List) serDaou.getData("t_user");
		//处理返回的数据集（循环list和map），保存到远程的txt文件中
		StringBuffer str = new StringBuffer();
		Map map = new HashMap();
		Iterator iterator = null;
		for (int i = 0; i < list.size(); i++) {
			map = (Map) list.get(i);
			System.out.println(map);
			iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry entry = (Entry) iterator.next();
				str.append(entry.getValue()+",");
			}
			str=str.replace((str.length()-1),str.length(),";\n");
		}
		System.out.println(str);
		File file = new File("d:\\array.txt");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(str.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
