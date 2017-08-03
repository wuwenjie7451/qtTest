package com.pb.web.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

@SuppressWarnings("all")
public class UserDao extends JdbcDaoSupport {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Map<String, Object>> doquery() {
		String sql = "select zt,sqyy from t_xs_zysq where id=5147";
		return super.getJdbcTemplate().queryForList(sql);
	}

	public List getData(String tablename) {
		String sql = "select * from "+tablename;
		return super.getJdbcTemplate().queryForList(sql);
	}
}
