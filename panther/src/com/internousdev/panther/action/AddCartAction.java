package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.CartInfoDAO;
import com.internousdev.panther.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{
	private String userId;
	private int productId;
	private int productCount;
	private ArrayList<CartInfoDTO>cartlistDTO;
	private Map<String,Object>session;
	private String cartMessage;
	private int totalprice;

	public String execute(){
		if (!(session.containsKey("tempUserId") || session.containsKey("userId"))) {
			return "sessionTimeout";
		}

		CartInfoDAO dao = new CartInfoDAO();
		if( session.containsKey("userId")){
			userId = session.get("userId").toString();
		}else{
			userId = session.get("tempUserId").toString();
		}
		try{
			if(productCount < 1 || productCount > 5){
				return "DBError";
			}

			dao.addCartMethod(userId, productId, productCount);//user_id(仮ID), product_id(商品ID), product_count(商品個数)
			cartlistDTO = dao.cartSelect(userId);//カーと情報追加後、カートの中身を表示

			for(int i=0; i<cartlistDTO.size();i++){
				//合計金額、オーバーフローした場合は例外
				totalprice = Math.addExact(totalprice, cartlistDTO.get(i).getSubprice());
			}

			if(cartlistDTO.isEmpty()){
				cartMessage = "カート情報がありません。";
			}
		}catch(SQLException e){
			e.printStackTrace();
			return "DBError";
		}catch(ArithmeticException e){
			e.printStackTrace();
			return "DBError";
		}


		return SUCCESS;
	}

	public String getCartMessage() {
		return cartMessage;
	}
	public void setCartMessage(String cartMessage) {
		this.cartMessage = cartMessage;
	}

	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CartInfoDTO> getCartlistDTO() {
		return cartlistDTO;
	}

	public void setCartlistDTO(ArrayList<CartInfoDTO> cartlistDTO) {
		this.cartlistDTO = cartlistDTO;
	}

}