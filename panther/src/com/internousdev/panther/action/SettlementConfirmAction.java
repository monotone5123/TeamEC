
package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.CartInfoDAO;
import com.internousdev.panther.dao.DestinationInfoDAO;
import com.internousdev.panther.dto.CartInfoDTO;
import com.internousdev.panther.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware {
	private List<DestinationInfoDTO> destinationInfoDTOList;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		ArrayList<CartInfoDTO> cartlist = new ArrayList<CartInfoDTO>();
		String userId = null;

		int logincheck = Integer.parseInt(String.valueOf(session.get("logined")));

		if(logincheck==1){

			userId = session.get("userId").toString();

			try {
				cartlist = cartInfoDAO.cartSelect(userId);
			} catch (SQLException e) {
				e.printStackTrace();
				return ERROR;
			}
			session.put("cartInfoDTOList", cartlist);

			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();

			try{
			destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(String.valueOf(session.get("userId")));
			}catch(SQLException e){
				e.printStackTrace();
				return ERROR;
			}
			result = SUCCESS;
		}else{
			session.put("cComeFlag", 1);
			result = "login";
		}
		return result;
	}

	public List<DestinationInfoDTO> getDestinationInfoDTOList() {
		return destinationInfoDTOList;
	}

	public void setDestinationInfoDTOList(List<DestinationInfoDTO> destinationInfoDTOList) {
		this.destinationInfoDTOList = destinationInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
