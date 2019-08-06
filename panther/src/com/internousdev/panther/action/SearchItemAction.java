package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.MCategoryDAO;
import com.internousdev.panther.dao.ProductInfoDAO;
import com.internousdev.panther.dto.MCategoryDTO;
import com.internousdev.panther.dto.ProductInfoDTO;
import com.internousdev.panther.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private String categoryId;
	private String keywords;
	private List<String> keywordsErrorMessageList;
	private List<ProductInfoDTO> productInfoDTOList;

	public String execute(){

		InputChecker ic=new InputChecker();
		ProductInfoDAO productInfoDAO=new ProductInfoDAO();

		// カテゴリ未指定の場合
		if(categoryId==null){
			categoryId="1";
		}

		// 検索ワードの設定
		if(!(keywords.equals(""))){
			keywordsErrorMessageList=ic.doCheck("検索ワード", keywords, 0, 50, true, true, true, true, true, true);
			if(keywordsErrorMessageList.size()>0) {
				return SUCCESS;
			}
		}

		if(StringUtils.isBlank(keywords)){
			keywords="";
		}else{
			keywords=keywords.replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		}

		// 1の場合はキーワードで検索、その他はキーワードとカテゴリーIDで検索
		switch(categoryId){
			case "1":
				try {
					productInfoDTOList=productInfoDAO.getProductInfoListByKeyword(keywords.split(" "));
				} catch (SQLException e) {
					e.printStackTrace();
					return ERROR;
				}
				break;
			default:
				try {
					productInfoDTOList=productInfoDAO.getProductInfoListByKeywordAndCategoryId(keywords.split(" "), categoryId);
				} catch (SQLException e) {
					e.printStackTrace();
					return ERROR;
				}
				break;
		}

		// リストが表示されなければ、
		if(!session.containsKey("mCategoryList")){
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

	public String getKeywords(){
		return keywords;
	}

	public void setKeywords(String keywords){
		this.keywords=keywords;
	}

	public List<String> getKeywordsErrorMessageList(){
		return keywordsErrorMessageList;
	}

	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList){
		this.keywordsErrorMessageList=keywordsErrorMessageList;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId=categoryId;
	}

	public List<ProductInfoDTO> getProductInfoDTOList(){
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList){
		this.productInfoDTOList=productInfoDTOList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session=session;
	}

}
