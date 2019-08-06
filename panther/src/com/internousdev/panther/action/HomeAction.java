package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.MCategoryDAO;
import com.internousdev.panther.dto.MCategoryDTO;
import com.internousdev.panther.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;


public class HomeAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute(){

		// tempUserIdの割り当て（randomValueを利用)
		if(!(session.containsKey("userId"))&&!(session.containsKey("tempUserId"))){
			CommonUtility cu=new CommonUtility();
			session.put("tempUserId", cu.getRamdomValue());
		}

		if(!(session.containsKey("logined"))){
			session.put("logined", 0);
		}

		// エラーを吐いた場合の処理
		if(!(session.containsKey("mCategoryList"))){
			MCategoryDAO mCategoryDAO=new MCategoryDAO();
			List<MCategoryDTO> mCategoryList=new ArrayList<MCategoryDTO>();

			try{
				mCategoryList=mCategoryDAO.getMCategoryList();
			}catch(NullPointerException e){
				e.printStackTrace();
				mCategoryList=null;
			}catch(SQLException e){
				e.printStackTrace();
				mCategoryList=null;
			}

			session.put("mCategoryList", mCategoryList);
		}

		return SUCCESS;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session=session;
	}

}
