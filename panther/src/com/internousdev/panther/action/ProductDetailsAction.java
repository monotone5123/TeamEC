package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.ProductInfoDAO;
import com.internousdev.panther.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class ProductDetailsAction extends ActionSupport implements SessionAware{

	private int productId;
	private List<Integer> productCountList;
	private List<ProductInfoDTO> catergoryProductList;
	private ProductInfoDTO productInfoDTO = new ProductInfoDTO();

	private Map<String, Object> session;

	public String execute() {

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		try {
			productInfoDTO = productInfoDAO.getProductInfoByProductId(productId);
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}


		if(productInfoDTO.getProductId() == 0) {
			productInfoDTO = null;
		} else {
			try {
				catergoryProductList = productInfoDAO.getCatergoryProductList(productInfoDTO.getCategoryId(), productInfoDTO.getProductId(), 0, 3);
			} catch (SQLException e) {
				e.printStackTrace();
				return ERROR;
			}
		}
	return SUCCESS;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public List<Integer> getProductCountList() {
		return productCountList;
	}

	public void setProductCountList(List<Integer> productCountList) {
		this.productCountList = productCountList;
	}

	public List<ProductInfoDTO> getCatergoryProductList() {
		return catergoryProductList;
	}

	public void setatergoryProductList(List<ProductInfoDTO> catergoryProductList) {
		this.catergoryProductList = catergoryProductList;
	}

	public ProductInfoDTO getProductInfoDTO() {
		return productInfoDTO;
	}

	public void setProductInfoDTO(ProductInfoDTO productInfoDTO) {
		this.productInfoDTO = productInfoDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
