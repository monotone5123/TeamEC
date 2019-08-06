package com.internousdev.panther.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.panther.dto.PurchaseHistoryInfoDTO;
import com.internousdev.panther.util.DBConnector;

public class PurchaseHistoryInfoDAO {

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryList(String userId) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con =db.getConnection();
		List<PurchaseHistoryInfoDTO> PurchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();

		String sql = "SELECT "
				+ "phi.id as id, " /* product_infoID */ /* purchase_history_info↓ */
				+ "phi.user_id as user_id, " /* ユーザーID */
				+ "pi.product_id as product_id, " /* 商品ID */ /* product_info↓*/
				+ "pi.product_name as product_name, " /*商品名*/
				+ "pi.product_name_kana as product_name_kana, " /* 商品名かな */
				+ "pi.product_description as product_description, " /* 商品詳細 */
				+ "pi.category_id as category_id, " /* カテゴリID */
				+ "pi.price, " /* 価格 */
				+ "pi.image_file_name as image_file_name, " /* 画像ファイルパス */
				+ "pi.image_file_path as image_file_path, " /* 画像ファイル名 */
				+ "pi.release_company, " /* 発売会社名 */
				+ "pi.release_date, " /* 発売年月日 */
				+ "phi.price as price, " /* 値段 */ /* purchase_history_info↓ */
				+ "phi.product_count as product_count, " /* 個数 */
				+ "phi.price * phi.product_count as subtotal, " /* 合計金額 */
				+ "phi.regist_date as regist_date, " /* 登録日 */
				+ "di.family_name as family_name, " /* 姓 */ /* destination_info↓ */
				+ "di.first_name as first_name, " /* 名 */
				+ "di.user_address as user_address " /* 住所 */
				+ "FROM purchase_history_info as phi " /* 結合↓ */
				+ "LEFT JOIN product_info as pi "
				+ "ON phi.product_id = pi.product_id "
				+ "LEFT JOIN destination_info as di "
				+ "ON phi.destination_id = di.id "
				+ "WHERE phi.user_id = ? "
				+ "ORDER BY regist_date DESC ";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDTO.setId(rs.getInt("id"));
				purchaseHistoryInfoDTO.setUserId(rs.getString("user_id"));
				purchaseHistoryInfoDTO.setProductId(rs.getInt("product_id"));
				purchaseHistoryInfoDTO.setProductCount(rs.getInt("product_count"));
				purchaseHistoryInfoDTO.setProductName(rs.getString("product_name"));
				purchaseHistoryInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				purchaseHistoryInfoDTO.setPrice(rs.getInt("price"));
				purchaseHistoryInfoDTO.setImageFileName(rs.getString("image_file_name"));
				purchaseHistoryInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				purchaseHistoryInfoDTO.setReleaseCompany(rs.getString("release_company"));
				purchaseHistoryInfoDTO.setReleaseDate(rs.getDate("release_date"));
				purchaseHistoryInfoDTO.setSubtotal(rs.getInt("subtotal"));
				purchaseHistoryInfoDTO.setFamilyName(rs.getString("family_name"));
				purchaseHistoryInfoDTO.setFirstName(rs.getString("first_name"));
				purchaseHistoryInfoDTO.setUserAddress(rs.getString("user_address"));
				PurchaseHistoryInfoDTOList.add(purchaseHistoryInfoDTO);
			}

			con.close();

		return PurchaseHistoryInfoDTOList;
	}

	public int regist(String userId, int productId, int productCount, int destinationId,int price) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "insert into purchase_history_info(user_id,product_id,product_count,destination_id,price,regist_date,update_date)values(?,?,?,?,?,now(),now())";

		int count = 0;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			ps.setInt(3, productCount);
			ps.setInt(4, destinationId);
			ps.setInt(5, price);
			count = ps.executeUpdate();

			con.close();

		return count;
	}

	public int deleteAll(String userId) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from purchase_history_info where user_id=?";
		int count = 0;

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			count = ps.executeUpdate();

			con.close();

		return count;
	}

	public boolean addressCheck(int id, String userId) throws SQLException {
		boolean result = false;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select * from destination_info where user_id = ? and id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userId);
		ps.setInt(2, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			result = true;
		}
		return result;

	}
}