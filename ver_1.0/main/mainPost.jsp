<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>

<body>
	<%
		String menu = request.getParameter("menu");
		if (menu.equals("intro")) {
			menu = "./intro/"+"intro.jsp";
		} else if (menu.equals("notice")) {
			menu = "./notice/"+"NoticeTextView.jsp";
		} else if (menu.equals("freeboard")) {
			menu = "./freeboard/"+"free_board.jsp";
		} else if (menu.equals("qa")) {
			menu = "./qa/"+"QnATextView.jsp";
		}
	%>
	<table border="1" align="center" width="1000" height="600">
		<tr height="10%">
			<td colspan="2" align="center"><%@ include file="mainHeader.jsp"%>
			</td>
		</tr>
		<tr height=80%>
			<td width=15%><%@ include file="mainMenu.jsp"%>
			</td>
			<td width="85%">
				<jsp:include page="<%=menu %>" flush="false"/>
		</tr>
		<tr height=10%>
			<td colspan="2" align="center"><%@ include file="mainFooter.jsp"%>
			</td>
		</tr>
	</table>

</body>
</html>