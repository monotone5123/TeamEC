package com.internousdev.panther.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.panther.dao.CartInfoDAO;
import com.internousdev.panther.dao.UserInfoDAO;
import com.internousdev.panther.dto.CartInfoDTO;
import com.internousdev.panther.dto.ProductInfoDTO;
import com.internousdev.panther.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String userId;
	private String password;
	private String remainIdFlag;
	private List<String> userIdErrorMessage = new ArrayList<String>();
	private List<String> passwordErrorMessage = new ArrayList<String>();
	private ArrayList<CartInfoDTO> cartlistDTO = new ArrayList<CartInfoDTO>();// cartActionから流用
	private ArrayList<ProductInfoDTO> productlist = new ArrayList<ProductInfoDTO>();// cartActionから流用
	private String loginErrorMessage;
	private String cartMessage;
	private int totalprice = 0;

	public String execute() {
		if (!(session.containsKey("tempUserId") || session.containsKey("userId"))) {
			return "sessionTimeout";
		}
		InputChecker ic = new InputChecker();

		boolean canLogin = false;
		session.remove("remainIdFlag");
		session.remove("savedUserId");
		if (!(session.containsKey("createUserFlag"))) {// ユーザー登録機能から来てない場合:入力チェック
			userIdErrorMessage = ic.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false);
			passwordErrorMessage = ic.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false);

			if (!(userIdErrorMessage.isEmpty() && passwordErrorMessage.isEmpty())) {// 入力エラーのリストが空か判断
				return ERROR;
			}
		} else {// ユーザー登録機能から来てる場合:セッション内の情報をuserIdとpasswordに代入
			userId = String.valueOf(session.get("userIdForCreateUser"));
			password = String.valueOf(session.get("password"));
			session.remove("userIdForCreateUser");
			session.remove("password");
			session.remove("createUserFlag");
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();

		try {
			canLogin = userInfoDAO.canLogin(userId, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return "DBError";
		}

		if (!canLogin) {
			loginErrorMessage = "ユーザーIDまたはパスワードが異なります。";
			return ERROR;
		}
		if (Boolean.valueOf(remainIdFlag)) {// ID保存チェックの値がNullかどうかで処理を分けている
			session.put("remainIdFlag", true);
		} else {
			session.remove("savedUserId");
			session.put("remainIdFlag", false);
		}

		// カート
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		int result = 0;
		try {
			result = cartInfoDAO.checkAndTiedCart(String.valueOf(session.get("tempUserId")), userId);
		} catch (SQLException e) {
			e.printStackTrace();
			return "DBError";
		}

		session.put("userId", userId);
		session.put("logined", 1);

		// 遷移先決定
		if (result == 0) {// カートに何も入ってない
			return SUCCESS;
		}
		if (session.containsKey("cComeFlag")) {// カート画面から来た場合
			session.remove("cComeFlag");
			try {
				cartlistDTO = cartInfoDAO.cartSelect(userId);
				for (int i = 0; i < cartlistDTO.size(); i++) {
					totalprice += cartlistDTO.get(i).getSubprice();
				}

				if (cartlistDTO.isEmpty()) {
					cartMessage = "カート情報がありません。";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return "DBError";
			}

			return "cart";
		}

		return SUCCESS;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemainIdFlag() {
		return remainIdFlag;
	}

	public void setRemainIdFlag(String remainIdFlag) {
		this.remainIdFlag = remainIdFlag;
	}

	public List<String> getUserIdErrorMessage() {
		return userIdErrorMessage;
	}

	public void setUserIdErrorMessage(List<String> userIdErrorMessage) {
		this.userIdErrorMessage = userIdErrorMessage;
	}

	public List<String> getPasswordErrorMessage() {
		return passwordErrorMessage;
	}

	public void setPasswordErrorMessage(List<String> passwordErrorMessage) {
		this.passwordErrorMessage = passwordErrorMessage;
	}

	public String getLoginErrorMessage() {
		return loginErrorMessage;
	}

	public void setLoginErrorMessage(String loginErrorMessage) {
		this.loginErrorMessage = loginErrorMessage;
	}

	public ArrayList<CartInfoDTO> getCartlistDTO() {
		return cartlistDTO;
	}

	public void setCartlistDTO(ArrayList<CartInfoDTO> cartlistDTO) {
		this.cartlistDTO = cartlistDTO;
	}

	public ArrayList<ProductInfoDTO> getProductlist() {
		return productlist;
	}

	public void setProductlist(ArrayList<ProductInfoDTO> productlist) {
		this.productlist = productlist;
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

}
