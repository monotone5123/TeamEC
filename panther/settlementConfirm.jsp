<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">
  <link rel="stylesheet" href="./css/cssreset.css">
  <link rel="stylesheet" href="./css/panther.css">
  <link rel="stylesheet" href="./css/settlementConfirm.css">
  <link rel="stylesheet" href="./css/header.css">
  <title>決済確認画面</title>

</head>

<body>

	<script src="./js/settlementConfirm.js"></script>

	<jsp:include page="header.jsp" />

	<div class="bodyContent">

	  <h1>決済確認画面</h1>

	<s:if
		test="destinationInfoDTOList!=null && destinationInfoDTOList.size()>0">
		<div class="announce">
			<h4>宛先情報を選択してください。</h4>
		</div>
		<s:form id="destinationSelect">
			<table class="destinationList">
				<tr>
					<td>#</td>
					<td>姓</td>
					<td>名</td>
					<td>ふりがな</td>
					<td>住所</td>
					<td>電話番号</td>
					<td>メールアドレス</td>
				</tr>
				<s:iterator value="DestinationInfoDTOList" status="st">
					<tr>
						<s:if test="#st.index == 0">
							<th><input type="radio" name="id"
								value='<s:property value="id"/>' checked="checked"></th>
						</s:if>
						<s:else>
							<th><input type="radio" name="id"
								value='<s:property value="id"/>'></th>
						</s:else>
						<th><s:property value="familyName" /></th>
						<th><s:property value="firstName" /></th>
						<th><s:property value="familyNameKana" /><span>　</span>
						<s:property value="firstNameKana" /></th>
						<th><s:property value="userAddress" /></th>
						<th><s:property value="telNumber" /></th>
						<th><s:property value="email" /></th>
					</tr>
				</s:iterator>
			</table>
			<div class="submit_btn_box3">
				<s:submit class="submit_btn3" value="決済"
					onClick="goSettlementCompleteAction()" />
			</div>
			<div class="submit_btn_box3">
				<s:submit class="submit_btn3" value="削除"
					onClick="goDeleteDestinationAction()" />
			</div>
		</s:form>
	</s:if>
	<s:else>
		<div class="announce">
			<h4>宛先情報がありません。</h4>
		</div>
	</s:else>
	<div class="button_box">
	  <a href='<s:url action= "CreateDestinationAction"/>' class="desAnc">新規宛先登録</a>
	</div>
	</div>

</body>
</html>