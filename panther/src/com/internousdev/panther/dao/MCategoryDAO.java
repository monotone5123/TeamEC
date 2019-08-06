package com.internousdev.panther.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.panther.dto.MCategoryDTO;
import com.internousdev.panther.util.DBConnector;

public class MCategoryDAO {

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	public List<MCategoryDTO> getMCategoryList() throws SQLException{

		String sql="SELECT * FROM m_category";
		List<MCategoryDTO> mCategoryList=new ArrayList<MCategoryDTO>();
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();

		while(rs.next()){
			MCategoryDTO mCategory=new MCategoryDTO();
			mCategory.setId(rs.getInt("id"));
			mCategory.setCategoryId(rs.getInt("category_id"));
			mCategory.setCategoryName(rs.getString("category_name"));
			mCategory.setCategoryDescription(rs.getString("category_description"));
			mCategoryList.add(mCategory);
		}

		con.close();

		return mCategoryList;
	}
}
