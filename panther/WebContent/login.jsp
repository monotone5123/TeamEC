<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="./css/cssreset.css">
<link rel="stylesheet" href="./css/panther.css">
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/header.css">
<title>ログイン画面</title>

</head>

<body>

	<jsp:include page="header.jsp" />

	<div id="contents">

		<h1>ログイン画面</h1>

		<s:if test="userIdErrorMessage!=null && userIdErrorMessage.size>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="userIdErrorMessage">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="passwordErrorMessage!=null && passwordErrorMessage.size>0">
			<div class="error">
				<div class="error-message">
					<s:iterator value="passwordErrorMessage">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>

		<s:if test="loginErrorMessage!=null">

			<div class="error">
				<div class="error-message">
					<s:property value="loginErrorMessage" />
				</div>
			</div>
		</s:if>

		<!-- 入力フォーム -->

		<s:form action="LoginAction">

			<table class="vertical-list-table">
				<tr>
					<th scope="row"><s:label value="ユーザーID" /></th>
					<td><s:if test="userId != null">
							<s:textfield name="userId" value="%{userId}" placeholder="ユーザーID"
								class="text" />
						</s:if> <s:else>
							<s:textfield name="userId" value="%{#session.savedUserId}"
								placeholder="ユーザーID" class="text" />
						</s:else></td>

				</tr>
				<tr>
					<th scope="row"><s:label value="パスワード" /></th>
					<td><s:password name="password" placeholder="パスワード"
							class="text" /></td>
				</tr>

			</table>

			<div class="box">

				<s:if test="#session.remainIdFlag==true || remainIdFlag==true">
					<s:checkbox name="remainIdFlag" checked="checked" />
				</s:if>
				<s:else>
					<s:checkbox name="remainIdFlag" />
				</s:else>
				<p>ユーザーID保存</p>

			</div>

			<br>

			<div id="underbutton">

				<div class="submit_btn_box3">
					<s:submit value="ログイン" class="submit_btn3" />
				</div>

				<div class="submit_btn_box3">
					<a class="submit_anc01" href='<s:url action="CreateUserAction"/>'>新規ユーザー登録</a>
				</div>

				<div class="submit_btn_box3">
					<a class="submit_anc01"
						href='<s:url action="ResetPasswordAction"/>'>パスワード再設定</a>
				</div>

			</div>

		</s:form>

	</div>

</body>
</html>