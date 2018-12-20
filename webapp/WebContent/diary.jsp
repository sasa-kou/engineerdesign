<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="design.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>食事日記</title>
</head>
<body>
	<%//usernameを取得する
	String username = (String)session.getAttribute("username");
	  //これまでの記録を取得する
	ArrayList<calBean> record = (ArrayList<calBean>)request.getAttribute("record");%>
	<%= username %>さんの記録<br>
	<table border="1">
	 <tr>
	  <th>日付</th><th>時間帯</th><th>メニュー</th><th>カロリー</th>
	 </tr>
	 <tr>
	  <td><%= record.get(0).r_day() %></td>
	  <td><%= record.get(0).r_time() %></td>
	  <td><%= record.get(0).r_food() %></td>
	  <td><%= record.get(0).r_cal() %></td>
	 </tr>
	</table>
	<br>
	<div align="right"><input type="button" onClick="location.href='top.jsp'" value="トップへ"></div>
</body>
</html>