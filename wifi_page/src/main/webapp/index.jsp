<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>와이파이 정보 구하기</h1>
	<a href='index.jsp'>홈</a> |
	<a href='search_wifi_history.jsp'>위치 히스토리 목록</a> |
	<a href='load_wifi.jsp'>Open API 와이파이 정보 가져오기</a>
	<form action="show_wifi.jsp">
		<b>LAT:</b><input type='text' id='LAT' name='LAT' value='0.0'><b>,
			LNT:</b><input type='text' id='LNG' name='LNG' value='0.0'> <input
			type='button' value='내 위치 가져오기'
			onclick="navigator.geolocation.getCurrentPosition(onGeoOk,onGeoError)">
		<input type='submit' value='근처 WIFI 정보 보기'">
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
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>작업일자</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan='17' class='tbody-tr1-td1'><b>위치 정보를 입력한 후에 조회해
						주세요.</b></td>
			</tr>
		</tbody>
	</table>
</body>
</html>