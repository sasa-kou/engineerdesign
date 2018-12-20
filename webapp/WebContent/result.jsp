<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="design.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カロリー計算結果</title>
</head>
<body>
<%//usernameを取得する
	String username = (String)session.getAttribute("username");%>
<h1><%= username %>のカロリー</h1>
<table>
 <tr>
  <th>メニュー</th>
  <th>カロリー</th>
 </tr>
 <%//メニュー名とカロリーをそれぞれ取得する 
 	String shushoku = (String)request.getAttribute("shushoku");
 	int shushokucal = (Integer)request.getAttribute("shushokucal");
 
 	int sumcal = (Integer)request.getAttribute("sumcal");%>
 <tr>
  <td><%= shushoku %></td>
  <td><%= shushokucal %></td>
  <td>計<%= sumcal %>kcal</td>
 </tr>
</table>

<input type="button" onClick="location.href='diary.jsp'" value="日記へ">
<input type="button" onClick="location.href='top.jsp'" value="トップページへ">
</body>
</html>