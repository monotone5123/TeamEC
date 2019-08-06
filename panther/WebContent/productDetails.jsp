<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">
  <link rel="stylesheet" href="./css/panther.css">
  <link rel="stylesheet" href="./css/productDetails.css">
  <link rel="stylesheet" href="./css/cssreset.css">
  <link rel="stylesheet" href="./css/header.css">
  <title>商品詳細画面</title>

</head>

<body>

	<jsp:include page="header.jsp" />

	<div id="contents">

		<h1>商品詳細</h1>

		<s:if test="productInfoDTO!=null">
			<s:form action="AddCartAction">

				<div class="center">

					<img
						src='<s:property value="productInfoDTO.imageFilePath"/>/<s:property value="productInfoDTO.imageFileName"/>'
						width="320px" height="320px" />

					<table class="list-box">

						<tr>
							<th scope="row"><s:label value="商品名" /></th>
							<td><s:property value="productInfoDTO.productName" /></td>
						</tr>

						<tr>
							<th scope="row"><s:label value="商品名ふりがな" /></th>
							<td><s:property value="productInfoDTO.productNameKana" /></td>
						</tr>

						<tr>
							<th scope="row"><s:label value="値段" /></th>
							<td><s:property value="productInfoDTO.price" />円</td>
						</tr>

						<tr>
							<th scope="row"><s:label value="購入個数" /></th>
							<td><select name="productCount">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								</select>個</td>
						</tr>

						<tr>
							<th scope="row"><s:label value="発売会社名" /></th>
							<td><s:property value="productInfoDTO.releaseCompany" /></td>
						</tr>

						<tr>
							<th scope="row"><s:label value="発売年月日" /></th>
							<td><s:property value="productInfoDTO.releaseDate" /></td>
						</tr>

						<tr>
							<th scope="row"><s:label value="商品詳細情報" /></th>
							<td><s:property value="productInfoDTO.productDescription" /></td>
						</tr>

					</table>

				</div>

				<div class="submit_btn_box3">
					<s:submit class="submit_btn3" value="カートに追加"></s:submit>
				</div>
				<s:hidden name="productId" value="%{productInfoDTO.productId}" />

			</s:form>

			<s:if
				test="catergoryProductList!=null && catergoryProductList.size()>0">

					<div class="categoryproducts-box">

						<h2>【関連商品】</h2>

						<s:iterator value="catergoryProductList">

							<div class="recommend-box">
								<a href='<s:url action="ProductDetailsAction">
					            <s:param name="productId" value="%{productId}"/>
					</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
									width="100px" height="100px" class="item-image-box-100" /> <s:property
										value="productName" /><br> </a>
							</div>
						</s:iterator>
					</div>
			</s:if>
		</s:if>

		<s:else>
			<div class="info">商品の詳細情報がありません。</div>
		</s:else>

	</div>

</body>
</html>