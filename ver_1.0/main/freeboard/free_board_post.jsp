<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, java.sql.*"%>
<%@ page import="pubg.util.FreeBoardBeanz"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판</title>
</head>
<body>
	<jsp:useBean id="FBbean" class="pubg.util.FreeBoardBeanz" scope="page" />
	<jsp:useBean id="FBjdbc" class="pubg.util.FreeBoardJDBC" scope="page" />
	<%
		int regno = Integer.parseInt(request.getParameter("regno"));
		Vector<FreeBoardBeanz> vt = FBjdbc.getFBoardText(regno);
		for (int i = 0; i < vt.size(); i++) {
			FreeBoardBeanz regBean = (FreeBoardBeanz) vt.elementAt(i);
	%>

	<table border="1">
		<tr>
			<th>글번호(regno)</th>
			<th>작성자(user_id)</th>
			<th>작성일(f_date)</th>
		</tr>
		<tr>
			<td><%=regBean.getRegno()%></td>
			<td><%=regBean.getUser_id()%></td>
			<td><%=regBean.getF_date()%></td>
		</tr>
		<tr>
			<th>글제목(f_title)</th>
			<td colspan="2"><%=regBean.getF_title()%></td>
		</tr>
		<tr>
			<td colspan="3"><%=regBean.getF_text()%></td>
		</tr>
	</table>
	<%
		}
	%>
	<p>
		<button type="button" onclick="location='free_board.jsp'">목록</button>
		<button type="button" onclick="window.history.back();">뒤로가기</button>
	</p>

</body>
</html>