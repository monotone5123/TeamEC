package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.DestinationInfoDAO;
import com.internousdev.panther.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteDestinationAction extends ActionSupport implements SessionAware {
	private String id;
	public List<DestinationInfoDTO> DestinationInfoDTOList;
	public Map<String, Object> session;

	public String execute() {
		if(!session.containsKey("id") && !session.containsKey("userId")) {
			return "sessionTimeout";
		}

		String result = ERROR;
		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		int count = 0;
		try {
			count = destinationInfoDAO.deleteDes(Integer.parseInt(id), String.valueOf(session.get("userId")));
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
		if(count > 0) {
			try {
				DestinationInfoDTOList = destinationInfoDAO.getDestinationInfo(session.get("userId").toString());
			} catch (SQLException e) {
				e.printStackTrace();
				return ERROR;
			}
			result = SUCCESS;
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

	public List<DestinationInfoDTO> getDestinationInfoDTOList() {
		return DestinationInfoDTOList;
	}

	public void setDestinationInfoDTOList(List<DestinationInfoDTO> destinationInfoDTOList) {
		DestinationInfoDTOList = destinationInfoDTOList;
	}
}
