<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="history.HistoryService"%>
<%@ page import="history.History"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid;
	border-collapse: collapse;
	border-color: #cccccc;
	text-align: center;
}

th {
	background-color: #00b359;
	color: #fffff0;
	padding: 2px;
}

table {
	width: 98%;
	margin: auto;
	font-size: 10pt;
}

.tbody-tr1-td1 {
	height: 70px;
}

tr {
	height: 30px;
}
</style>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<%
	List<History> list = new ArrayList<History>();
	HistoryService historyService = new HistoryService();
	
	if(request.getParameter("ID")!=null){
		int i=Integer.parseInt((String)request.getParameter("ID"));
		historyService.delete(i);
	}
	list = historyService.search();
	%>
	<h1>와이파이 정보 구하기</h1>
	<a href='index.jsp'>홈</a> |
	<a href='search_wifi_history.jsp'>위치 히스토리 목록</a> |
	<a href='load_wifi.jsp'>Open API 와이파이 정보 가져오기</a>
	<table>
		<thead>
			<tr class='thead-tr'>
				<th><b>ID</b></th>
				<th><b>X좌표</b></th>
				<th><b>Y좌표</b></th>
				<th><b>조회일자</b></th>
				<th><b>비고</b></th>
			</tr>
		</thead>
		<tbody>
			<%
			for (History h : list) {
			%>
			<tr>
				<td><b><%=h.getID()%></b></td>
				<td><b><%=h.getLAT()%></b></td>
				<td><b><%=h.getLNT()%></b></td>
				<td><b><%=h.getSEARCH_DATE()%></b></td>
				<td>
					<a href="search_wifi_history.jsp?ID=<%=h.getID()%>">
						<button>삭제</button>
					</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>