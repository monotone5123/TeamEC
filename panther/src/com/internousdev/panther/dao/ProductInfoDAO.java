package com.internousdev.panther.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.panther.dto.ProductInfoDTO;
import com.internousdev.panther.util.DBConnector;

public class ProductInfoDAO {
//商品情報を所得
	public List<ProductInfoDTO> getProductInfoList() throws SQLException {

		DBConnector db = new DBConnector();
//DBに接続
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info";

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTOList.add(productInfoDTO);
			}

			con.close();

			return productInfoDTOList;
	}
//商品IDを所得
	public ProductInfoDTO getProductInfoByProductId(int productId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		String sql = "select * from product_info where product_id=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
			}

			con.close();

			return productInfoDTO;
		}

//関連商品の所得
//limitOffsetでデータを所得する位置を決める的な感じ？  limitRowCountでデータから所得したい件数を指定する感じ？だと思われる。
	public List<ProductInfoDTO> getCatergoryProductList(int categoryId, int productId, int limitOffset,int limitRowCount) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where category_id=? and product_id not in(?) order by rand() limit ?,?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, limitOffset);
			preparedStatement.setInt(4, limitRowCount);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTOList.add(productInfoDTO);
			}

			con.close();

			return productInfoDTOList;
		}

	// 検索ワードで商品情報を取得
	public List<ProductInfoDTO> getProductInfoListByKeyword(String[] keywordsList) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="SELECT * FROM product_info";
		List<ProductInfoDTO> productInfoDTOList=new ArrayList<ProductInfoDTO>();
		boolean initializeFlag=true;

		for(String keywords : keywordsList){
			if(!(keywords.equals(""))){
				if(initializeFlag){
					sql += " WHERE (product_name like '%" + keywords + "%' OR product_name_kana like '%" + keywords + "%')";
					initializeFlag=false;
				}else{
					sql += " OR (product_name like '%" + keywords + "%' OR product_name_kana like '%" + keywords + "%')";
				}
			}
		}

		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();

		while(rs.next()){
			ProductInfoDTO productInfoDTO=new ProductInfoDTO();
			productInfoDTO.setId(rs.getInt("id"));
			productInfoDTO.setProductId(rs.getInt("product_id"));
			productInfoDTO.setProductName(rs.getString("product_name"));
			productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
			productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
			productInfoDTO.setImageFileName(rs.getString("image_file_name"));
			productInfoDTO.setPrice(rs.getInt("price"));
			productInfoDTO.setReleaseCompany(rs.getString("release_company"));
			productInfoDTO.setReleaseDate(rs.getDate("release_date"));
			productInfoDTO.setProductDescription(rs.getString("product_description"));
			productInfoDTO.setCategoryId(rs.getInt("category_id"));
			productInfoDTOList.add(productInfoDTO);
			}

		con.close();

		return productInfoDTOList;
	}

	// 検索ワードとカテゴリIDで取得
	public List<ProductInfoDTO> getProductInfoListByKeywordAndCategoryId(String[] keywordsList, String categoryId) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="SELECT * FROM product_info WHERE category_id =" + categoryId;
		List<ProductInfoDTO> productInfoDTOList=new ArrayList<ProductInfoDTO>();
		boolean initializeFlag=true;

		// 検索ワードの内容判定
		for(String keywords : keywordsList){
			if(!(keywords.equals("")) || keywordsList.length == 1){
				if(initializeFlag){
					sql += " AND ((product_name like '%" + keywords + "%' OR product_name_kana like '%" + keywords + "%')";
					initializeFlag=false;
				}else{
					sql += " OR (product_name like '%" + keywords + "%' OR product_name_kana like '%" + keywords + "%')";
				}
			}
		}
		sql += ")" ;

			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ProductInfoDTO productInfoDTO=new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTOList.add(productInfoDTO);
			}

		con.close();

		return productInfoDTOList;
	}
}
