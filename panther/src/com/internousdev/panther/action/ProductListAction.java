package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.ProductInfoDAO;
import com.internousdev.panther.dto.MCategoryDTO;
import com.internousdev.panther.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware {
	private List<ProductInfoDTO> productInfoDTOList;
	private List<MCategoryDTO> mCategoryDTOList;
	private Map<String, Object> session;

	public String execute(){
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		try {
			productInfoDTOList = productInfoDAO.getProductInfoList();
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}


	if (!session.containsKey("mCategoryDTOList")) {
		List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
		session.put("mCategoryDTOList", mCategoryDTOList);
	}

	return SUCCESS;
}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}
	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList) {
		this.productInfoDTOList = productInfoDTOList;
	}
	public List<MCategoryDTO> getMCategoryDTOList() {
		return mCategoryDTOList;
	}
	public void setMCategoryList(List<MCategoryDTO> mCategoryDTOList) {
		this.mCategoryDTOList = mCategoryDTOList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}