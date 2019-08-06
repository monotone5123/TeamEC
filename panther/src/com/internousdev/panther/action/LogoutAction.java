package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;

	public String execute() {
		UserInfoDAO userInfoDAO = new UserInfoDAO();
//		                sessionから値をString型の値を取り出すために使用
		String userId = String.valueOf(session.get("userId"));
//		                      sessionから値をboolean型の値を取り出すために使用
		boolean savedUserId = Boolean.valueOf(String.valueOf(session.get("remainIdFlag")));
		int count;
		try {
			count = userInfoDAO.logout(userId);
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
		if(count > 0) {
			session.clear();
			if(savedUserId){
				session.put("remainIdFlag", savedUserId);
				session.put("savedUserId", userId);
			}
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
