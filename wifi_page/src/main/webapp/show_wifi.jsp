<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="wifi_page.Distance"%>
<%@ page import="wifi_page.WifiInfo"%>
<%@ page import="wifi_page.WifiService"%>
<%@ page import="history.History"%>
<%@ page import="history.HistoryService"%>

<%@ page import="java.util.List"%>

<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
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
</style>
<script>
	function onGeoOk(position) {
		const lat = position.coords.latitude;
		const lng = position.coords.longitude;
		document.getElementById("LAT").value = lat;
		document.getElementById("LNG").value = lng;
	}
	function onGeoError() {
		alert("위치를 찾을 수 없습니다.");
	}
</script>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<%
	/* --- search_wifi_history테이블에 LAT, LNG 값 넣기 --- */
	String lat = (String) request.getParameter("LAT");
	String lng = (String) request.getParameter("LNG");

	if ((lat != null && Double.parseDouble(lat) != 0.0) && (lng != null && Double.parseDouble(lng) != 0.0)) {

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime date = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(),
		now.getMinute(), now.getSecond());

		History history = new History(lat, lng, date.toString());
		HistoryService service = new HistoryService();
		int result = 0;
		service.insert(history);

		/* --- 와이파이의 거리 계산 --- */
		WifiService wifiService = new WifiService();
		List<WifiInfo> list = wifiService.search();

		double lat1 = Double.parseDouble(lat);
		double lng1 = Double.parseDouble(lng);

		for (WifiInfo i : list) {
			double lat2 = Double.parseDouble(i.getLAT());
			double lng2 = Double.parseDouble(i.getLNT());
			double dist = Math.round(Distance.getDistance(lat1, lng1, lat2, lng2) * 10000) / 10000.0;

			i.setDIST(dist);
		}

		wifiService.update(list);
	%>
	<h1>와이파이 정보 구하기</h1>
	<a href='index.jsp'>홈</a> |
	<a href='search_wifi_history.jsp'>위치 히스토리 목록</a> |
	<a href='load_wifi.jsp'>Open API 와이파이 정보 가져오기</a>
	<form action=''>
		<b>LAT:</b><input type='text' id='lAT' name='LAT' value='0.0'><b>,
			LNT:</b><input type='text' id='LNG' name='LNG' value='0.0'> <input
			type='button' value='내 위치 가져오기'
			onclick="navigator.geolocation.getCurrentPosition(onGeoOk,onGeoError)">
		<input type='submit' value='근처 WIFI 정보 보기'>
	</form>
	<table>
		<thead>
			<tr class='thead-tr'>
				<th>거리(Km)</th>
				<th>관리번호</th>
				<th>자치구</th>
				<th>와이파이명</th>
				<th>도로명주소</th>
				<th>상세주소</th>
				<th>설치위치(층)</th>
				<th>설치유형</th>
				<th>설치기관</th>
				<th>서비스구분</th>
				<th>망종류</th>
				<th>설치년도</th>
				<th>실내외구분</th>
				<th>WIFI접속환경</th>
				<th>X좌포</th>
				<th>Y좌표</th>
				<th>작업일자</th>
			</tr>
		</thead>
		<tbody>
			<%
			list = wifiService.print();
			for (WifiInfo w : list) {
			%>
			<tr>
				<td><%=w.getDIST()%></td>
				<td><%=w.getMGR_NO()%></td>
				<td><%=w.getWRDOFC()%></td>
				<td><%=w.getMAIN_NM()%></td>
				<td><%=w.getADRES1()%></td>
				<td><%=w.getADRES2()%></td>
				<td><%=w.getINSTL_FLOOR()%></td>
				<td><%=w.getINSTL_TY()%></td>
				<td><%=w.getINSTL_MBY()%></td>
				<td><%=w.getSVC_SE()%></td>
				<td><%=w.getCMCWR()%></td>
				<td><%=w.getCNSTC_YEAR()%></td>
				<td><%=w.getINOUT_DOOR()%></td>
				<td><%=w.getREMARS3()%></td>
				<td><%=w.getLAT()%></td>
				<td><%=w.getLNT()%></td>
				<td><%=w.getWORK_DTTM()%></td>
			</tr>
			<%
			}
		} else {
				out.write("<script> alert(\"LAT와 LNG에 값을 입력해 주세요.\")</script>");
				
			}
			%>
		</tbody>
	</table>
</body>
</html>