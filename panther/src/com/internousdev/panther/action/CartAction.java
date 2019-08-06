package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.CartInfoDAO;
import com.internousdev.panther.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class CartAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private ArrayList<CartInfoDTO>cartlistDTO = new ArrayList<CartInfoDTO>();
	private String cartMessage;
	private int totalprice=0;
	private String userId;
	private int count;

	public String execute(){
		if (!(session.containsKey("tempUserId") || session.containsKey("userId"))) {
			return "sessionTimeout";
		}

		CartInfoDAO dao = new CartInfoDAO();

		if( session.containsKey("userId") ){
			userId = session.get("userId").toString();
		}else{
			userId = session.get("tempUserId").toString();
		}

		try{
			cartlistDTO = dao.cartSelect( userId );

			for(int i=0; i<cartlistDTO.size();i++){
				totalprice += cartlistDTO.get(i).getSubprice();
				count += cartlistDTO.get(i).getProductCount();
			}

			if(cartlistDTO.isEmpty()){
				cartMessage = "カート情報がありません。";
			}
		}catch(SQLException e){
			e.printStackTrace();
			return "DBError";
		}
		return SUCCESS;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public ArrayList<CartInfoDTO> getCartlistDTO() {
		return cartlistDTO;
	}
	public void setCartlistDTO(ArrayList<CartInfoDTO> cartlistDTO) {
		this.cartlistDTO = cartlistDTO;
	}


	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getCartMessage() {
		return cartMessage;
	}
	public void setCartMessage(String cartMessage) {
		this.cartMessage = cartMessage;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
