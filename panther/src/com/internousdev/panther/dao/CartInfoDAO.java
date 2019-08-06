package com.internousdev.panther.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.panther.dto.CartInfoDTO;
import com.internousdev.panther.util.DBConnector;

public class CartInfoDAO {

	public ArrayList<CartInfoDTO> cartSelect(String userId) throws SQLException{// カートリストを返す

		ArrayList<CartInfoDTO> cartlist = new ArrayList<CartInfoDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT "
				+ "ci.id,"
				+ "ci.user_id,"
				+ "ci.product_id,"
				+ "ci.product_count,"
				+ "pi.product_id,"
				+ "pi.product_name,"
				+ "pi.product_name_kana,"
				+ "pi.product_description,"
				+ "pi.price,"
				+ "pi.image_file_path,"
				+ "pi.image_file_name,"
				+ "pi.release_date,"
				+ "pi.release_company "
				+ "FROM cart_info ci "
				+ "JOIN product_info pi "
				+ "ON ci.product_id=pi.product_id "
				+ "WHERE user_id=? "
				+ "ORDER BY ci.update_date DESC,ci.regist_date DESC";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			CartInfoDTO dto = new CartInfoDTO();
			dto.setCartinfoId(rs.getInt("id"));
			dto.setUserId(rs.getString("user_id"));
			dto.setProductId(rs.getInt("product_id"));
			dto.setProductCount(rs.getInt("product_count"));
			dto.setProductName(rs.getString("product_name"));
			dto.setProductNameKana(rs.getString("product_name_kana"));
			dto.setProductDescription(rs.getString("product_description"));
			dto.setPrice(rs.getInt("price"));

			//int型の範囲を超えた場合は例外とする
			dto.setSubprice( Math.multiplyExact(rs.getInt("price"),rs.getInt("product_count")) );

			dto.setImageFilePath(rs.getString("image_file_path"));
			dto.setImageFileName(rs.getString("image_file_name"));
			dto.setReleaseDate(rs.getDate("release_date"));
			dto.setReleaseCompany(rs.getString("release_company"));

			cartlist.add(dto);
		}
		    con.close();
		return cartlist;
	}

	public void addCartMethod (String user_id, int product_id, int product_count) throws SQLException{//カート追加

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql ="select * from cart_info where user_id =? and product_id = ?";//すでにカート情報テーブルに存在してないか確認
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user_id);
		ps.setInt(2, product_id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){//存在してる場合
			String sql2 = "update cart_info set product_count = product_count + ?,update_date = now() where user_id = ? and product_id = ?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, product_count);
			ps2.setString(2, user_id);
			ps2.setInt(3, product_id);
			ps2.execute();
		} else {//存在してない場合
			String sql2 = "INSERT INTO cart_info(user_id,product_id,product_count,regist_date,update_date)VALUES(?,?,?,now(),now())";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, user_id);
			ps2.setInt(2, product_id);
			ps2.setInt(3, product_count);
			ps2.execute();
		}

		con.close();
	}

	public void deleteCart(String userId ,ArrayList<String>checklist) throws SQLException{//カート内削除

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "DELETE FROM cart_info WHERE user_id=? AND id=?";

		PreparedStatement ps = con.prepareStatement(sql);

		for(int i=0; i<checklist.size();i++){
			ps.setString(1, userId);
			ps.setInt(2, Integer.parseInt(checklist.get(i)));
			ps.executeUpdate();
		}

		con.close();
	}

	public int checkAndTiedCart(String tempUserId, String userId) throws SQLException {// カートを仮ユーザーIDで参照し、紐づけするメソッド

		int result = 0;// 更新回数
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String tempUserIdSql = "select * from cart_info where user_id = ?";// 仮IDでのカート参照
		PreparedStatement ps = con.prepareStatement(tempUserIdSql);
		ps.setString(1, tempUserId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			result++;
			int productId = rs.getInt("product_id");
			String userIdCheckSql = "select * from cart_info where user_id = ? and product_id = ?";// ユーザーIDに紐づく同じ商品がないか確認
			PreparedStatement ps2 = con.prepareStatement(userIdCheckSql);
			ps2.setString(1, userId);
			ps2.setInt(2, productId);
			ResultSet rs2 = ps2.executeQuery();

			if (rs2.next()) {// 同じ商品がある場合は既存のものに追加して、仮ユーザーIDのほうを削除する
				String addCartSql = "update cart_info set product_count = product_count + ?, update_date = now() where user_id = ? and product_id=?";
				PreparedStatement ps3 = con.prepareStatement(addCartSql);
				ps3.setInt(1, rs.getInt("product_count"));
				ps3.setString(2, userId);
				ps3.setInt(3, productId);
				ps3.execute();
				String deleteTempCartSql = "delete from cart_info where user_id = ? and product_id = ?";
				PreparedStatement ps4 = con.prepareStatement(deleteTempCartSql);
				ps4.setString(1, tempUserId);
				ps4.setInt(2, productId);
				ps4.execute();
			} else {// ない場合は仮ユーザーIDをユーザーIDに書きかえる
				String changeIdSql = "update cart_info set user_id = ? , update_date = now() where user_id = ? and product_id = ?";
				PreparedStatement ps3 = con.prepareStatement(changeIdSql);
				ps3.setString(1, userId);
				ps3.setString(2, tempUserId);
				ps3.setInt(3, productId);
				ps3.execute();
			}
		}

		       con.close();

		return result;
	}

	public int deleteAll(String userId)throws SQLException {//カート情報テーブルのuser_idを削除し更新行数を返す
		DBConnector db = new DBConnector();
		Connection con= db.getConnection();
		int count = 0;
		String sql = "delete from cart_info where user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);

			count = ps.executeUpdate();

			con.close();

			return count;
	}
}
