package com.internousdev.panther.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.CartInfoDAO;
import com.internousdev.panther.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware{
	private ArrayList<CartInfoDTO>cartlistDTO;
	private Map<String,Object>session;
	private String cartMessage;
	private ArrayList<String> checkList;
	private int totalprice;
	private String userId;
	private int count;

	public String execute(){
		if (!(session.containsKey("tempUserId") || session.containsKey("userId"))) {
			return "sessionTimeout";
		}

		CartInfoDAO dao = new CartInfoDAO();
		String result = SUCCESS;

		if( session.containsKey("userId") ){
			userId = session.get("userId").toString();
		}else{
			userId = session.get("tempUserId").toString();
		}
		try{
			if(checkList.isEmpty()){
				cartMessage = "削除する商品を選択してください。";
			}
			dao.deleteCart( userId ,checkList);

			cartlistDTO = dao.cartSelect( userId );

			for(int i=0; i<cartlistDTO.size();i++){
				totalprice += cartlistDTO.get(i).getSubprice();
			}
			if(cartlistDTO.isEmpty()){
				count = 0;
				cartMessage = "カート情報がありません。";
			}

		}catch(SQLException e){
			e.printStackTrace();
			return "DBError";
		}

		return result;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public ArrayList<String> getCheckList() {
		return checkList;
	}
	public void setCheckList(ArrayList<String> checkList) {
		this.checkList = checkList;
	}

	public ArrayList<CartInfoDTO> getCartlistDTO() {
		return cartlistDTO;
	}

	public void setCartlistDTO(ArrayList<CartInfoDTO> cartlistDTO) {
		this.cartlistDTO = cartlistDTO;
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