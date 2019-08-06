package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	public String execute() {
		if(!session.containsKey("tempUserId") && !session.containsKey("userId")) {
			return "sessionTimeout";
		}

		String result = ERROR;
		DestinationInfoDAO dest = new DestinationInfoDAO();
		int count = 0;

//		nullでも許容する場合は"valueOf"を使用している。(数値を文字列に変換)
		try {
			count = dest.insert(
					session.get("userId").toString(),
					session.get("familyName").toString(),
					session.get("firstName").toString(),
					String.valueOf(session.get("familyNameKana")),
					String.valueOf(session.get("firstNameKana")),
					String.valueOf(session.get("email")),
					String.valueOf(session.get("telNumber")),
					session.get("userAddress").toString()
				);

		}catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}

		if(count > 0) {
			result = SUCCESS;
		}

//		セッションオブジェクトの削除
		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("email");
		session.remove("telNumber");
		session.remove("userAddress");

		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
