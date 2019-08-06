<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">
  <script src="./js/cart.js"></script>
  <link rel="stylesheet" href="./css/cssreset.css">
  <link rel="stylesheet" href="./css/panther.css">
  <link rel="stylesheet" href="./css/cart.css">
  <link rel="stylesheet" href="./css/header.css">
  <title>Cart画面</title>

</head>

<body>
		<jsp:include page="header.jsp" />

		<div id="contents">

			<h1>カート画面</h1>

		    <s:if test="cartMessage != null && count == 0">
			  <div class="cautionMessage">
				<s:property value="cartMessage" escape="true" />
			  </div>
		    </s:if>

	        <s:else>
		      <s:form id="cartForm">

			    <table class="carttable">

				  <tr>
					<th><s:label value="#"/></th>
					<th><s:label value="商品名"/></th>
					<th><s:label value="商品名ふりがな"/></th>
					<th><s:label value="商品画像"/></th>
					<th><s:label value="値段"/></th>
					<th><s:label value="発売会社名"/></th>
					<th><s:label value="発売年月日"/></th>
					<th><s:label value="購入個数"/></th>
					<th><s:label value="合計金額"/></th>
				  </tr>

				<s:iterator value="cartlistDTO">

				  <tr>
					<td><s:checkbox name="checkList" class="checkList" value="0" fieldValue="%{cartinfoId}" onchange="checkValue(this)"/></td>
					<td><s:property value="productName" /></td>
					<td><s:property value="productNameKana" /></td>
					<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'></td>
					<td><s:property value="price" />円</td>
					<td><s:property value="releaseCompany" /></td>
					<td><s:property value="releaseDate" /></td>
					<td><s:property value="productCount" /></td>
					<td><s:property value="subprice" />円</td>
				  </tr>

				</s:iterator>

			</table>

				<h2><s:label value="カート合計金額 ：" /><s:property value="totalprice" />円</h2><br>

				<div class="submit_btn_box4">
				  <s:submit value="決済" class="submit_btn4" onclick="goSettlementConfirmAction()"/>
				</div>
				<div class="submit_btn_box3">
				  <s:submit value="削除" id="deleteButton" class="submit_btn3" onclick="goDeleteCartAction()" disabled="true"/>
				</div>

		</s:form>
	</s:else>
</div>

</body>
</html>