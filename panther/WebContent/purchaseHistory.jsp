<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">
  <link rel="stylesheet" href="./css/panther.css">
  <link rel="stylesheet" href="./css/cssreset.css">
  <link rel="stylesheet" href="./css/purchaseHistory.css">
  <link rel="stylesheet" href="./css/header.css">
  <title>商品購入履歴画面</title>

</head>

<body>

	<jsp:include page="header.jsp" />

	<div id="main">
		<h1>商品購入履歴画面</h1>

		<s:if test="purchaseHistoryInfoDTOList!=null && purchaseHistoryInfoDTOList.size()>0">
			<table class="table1">
				<thead>
					<tr>
						<th class=t1>商品名</th>
						<th class=t2>ふりがな</th>
						<th class=t3>商品画像</th>
						<th class=t4>発売会社名</th>
						<th class=t4>発売年月日</th>
						<th class=t5>値段</th>
						<th class=t6>個数</th>
						<th class=t7>合計金額</th>
						<th class=t8>宛先名前</th>
						<th class=t9>宛先住所</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="purchaseHistoryInfoDTOList">
						<tr>
							<td><s:property value="productName" /></td>
							<td><s:property value="productNameKana" /></td>
							<td><img
								src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
								width="50px" height="50px" /></td>
							<td><s:property value="releaseCompany" /></td>
							<td><s:property value="releaseDate" /></td>
							<td><s:property value="price" />円</td>
							<td><s:property value="productCount" />個</td>
							<td><s:property value="subtotal" />円</td>
							<td><s:property value="familyName" /><span>　</span>
							<s:property value="firstName" /></td>
							<td><s:property value="userAddress" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div class="btn">
				<a class="submit_anc01" href='<s:url action="DeletePurchaseHistoryAction"/>'>履歴削除</a>
			</div>
		</s:if>
		<s:else>
			<div class="cautionMessage">商品購入履歴情報がありません。</div>
		</s:else>
	</div>

</body>
</html>