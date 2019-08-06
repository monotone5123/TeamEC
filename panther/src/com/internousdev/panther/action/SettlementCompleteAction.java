package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.CartInfoDAO;
import com.internousdev.panther.dao.PurchaseHistoryInfoDAO;
import com.internousdev.panther.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private Map<String, Object> session;

	public String execute(){
		//sessionがタイムアウトのチェック
		if(!session.containsKey("tempUserId") && !session.containsKey("userId")) {
			return "sessionTimeout";
		}

		String result = ERROR;

		String userId = session.get("userId").toString();
		PurchaseHistoryInfoDAO purcharseHistoryInfoDAO = new PurchaseHistoryInfoDAO();

		try {
			if(!(purcharseHistoryInfoDAO.addressCheck(Integer.valueOf(id), userId))){
				return ERROR;
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			return ERROR;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return ERROR;
		}

		@SuppressWarnings("unchecked")
		List<CartInfoDTO> cartInfoDTOList = (List<CartInfoDTO>) session.get("cartInfoDTOList");


		int count = 0;
		for (CartInfoDTO dto : cartInfoDTOList){
			try {
				count += purcharseHistoryInfoDAO.regist(
						userId,
						dto.getProductId(),
						dto.getProductCount(),
						Integer.parseInt(id),
						dto.getPrice()
				);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return ERROR;

			} catch (SQLException e) {
				e.printStackTrace();
				return ERROR;

			}
		}
		if(count > 0){
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			try {
				count = cartInfoDAO.deleteAll(String.valueOf(session.get("userId")));
			} catch (SQLException e) {
				e.printStackTrace();
				return ERROR;
			}
			if(count > 0){

				result = SUCCESS;

			}
		}
		return result;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
