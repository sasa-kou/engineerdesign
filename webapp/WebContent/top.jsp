<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="design.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アプリ名</title>
<link rel="stylesheet" href="top.css">
</head>
<body>
	<%//usernameを取得する
	String username = (String)session.getAttribute("username");%>
<h4>ようこそ<%= username %>さん</h4>

<center><h1>アプリ名</h1></center>

<div class="container1">
 <div class="button1" >
  <input type="button"
   style="width:135px; padding:15px;font-size:18px"
    onClick="location.href='cal.html'" value="カロリー計算">
 </div>
 <div class="messe1">
   あなたが食べたメニューを選ぶと摂取カロリーがわかるよ！
 </div>
</div>

<div class="container2">
  <div class="button2">
   <input type="button"
   style="width:135px;padding:15px;font-size:18px"
    onClick="location.href='diaryServlet'" value="食事日記">
  </div>
  <div class="messe2">
  いままでの記録が見れるよ！	
 </div>
</div>
</body>
</html>

