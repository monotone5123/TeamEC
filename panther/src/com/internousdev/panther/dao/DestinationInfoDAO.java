package com.internousdev.panther.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.panther.dto.DestinationInfoDTO;
import com.internousdev.panther.util.DBConnector;

public class DestinationInfoDAO {

	public int insert(String userId, String familyName, String firstName, String familyNameKana, String firstNameKana, String email, String telNumber, String userAddress) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

//		入力内容をデータベースに入れるSQL文

		String sql = "insert into destination_info(user_id, family_name, first_name, family_name_kana, first_name_kana, email, tel_number, user_address, regist_date, update_date)"
				       + "values (?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, familyName);
			ps.setString(3, firstName);
			ps.setString(4, familyNameKana);
			ps.setString(5, firstNameKana);
			ps.setString(6, email);
			ps.setString(7, telNumber);
			ps.setString(8, userAddress);
			count = ps.executeUpdate();

			con.close();

		return count;
	}

	public List<DestinationInfoDTO> getDestinationInfo(String userId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<DestinationInfoDTO> destinationList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT id, family_name, first_name, family_name_kana, first_name_kana, email, tel_number, user_address FROM destination_info WHERE user_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				DestinationInfoDTO dest = new DestinationInfoDTO();
				dest.setId(rs.getInt("id"));
				dest.setFamilyName(rs.getString("family_name"));
				dest.setFirstName(rs.getString("first_name"));
				dest.setFamilyNameKana(rs.getString("family_name_kana"));
				dest.setFirstNameKana(rs.getString("first_name_kana"));
				dest.setEmail(rs.getString("email"));
				dest.setTelNumber(rs.getString("tel_number"));
				dest.setUserAddress(rs.getString("user_address"));
				destinationList.add(dest);
			}

				con.close();

		return destinationList;
	}

	public int deleteDes(int id, String userId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from destina"
				+ "tion_info where id = ? and user_id = ?";

		int count = 0;

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, userId);
			count = ps.executeUpdate();

			con.close();

		return count;
	}
}
