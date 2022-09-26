<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="wifi_page.WifiInfo"%>
<%@ page import="wifi_page.WifiService"%>
<%@ page import="wifi_page.Api"%>

<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.parser.JSONParser"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<style>
h1, div {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<%
	/* --- API정보 가져오기 전 총 데이터 갯수 가져오기 --- */
	Api api = new Api();
	String jStr = api.callApi(1, 1);

	JSONParser parser = new JSONParser();
	JSONObject jMain = (JSONObject) parser.parse(jStr);
	JSONObject jSub = (JSONObject) jMain.get("TbPublicWifiInfo");
	Long maxCnt = (Long) jSub.get("list_total_count");
	System.out.println(maxCnt);

	/* --- 호출 횟수 계산 --- */
	int callCnt = (int) (maxCnt / 1000);
	int remainder = (int) (maxCnt % 1000);
	int start = 1;
	int end = 1000;

	/* --- 와이파이 데이터를 list에 넣기 --- */
	List<WifiInfo> list = new ArrayList<WifiInfo>();
	while (callCnt > 0) {

		jStr = api.callApi(start, end);

		jMain = (JSONObject) parser.parse(jStr);
		jSub = (JSONObject) jMain.get("TbPublicWifiInfo");
		JSONArray jArr = (JSONArray) jSub.get("row");

		if (jArr.size() > 0) {
			for (int i = 0; i < jArr.size(); i++) {
		JSONObject jObj = (JSONObject) jArr.get(i);

		WifiInfo wifiInfo = new WifiInfo((String) jObj.get("X_SWIFI_MGR_NO"), 0.0,
				(String) jObj.get("X_SWIFI_WRDOFC"), (String) jObj.get("X_SWIFI_MAIN_NM"),
				(String) jObj.get("X_SWIFI_ADRES1"), (String) jObj.get("X_SWIFI_ADRES2"),
				(String) jObj.get("X_SWIFI_INSTL_FLOOR"), (String) jObj.get("X_SWIFI_INSTL_TY"),
				(String) jObj.get("X_SWIFI_INSTL_MBY"), (String) jObj.get("X_SWIFI_SVC_SE"),
				(String) jObj.get("X_SWFIFI_CMCWR"), (String) jObj.get("X_SWIFI_CNSTC_YEAR"),
				(String) jObj.get("X_SWIFI_INOUT_DOOR"), (String) jObj.get("X_SWIFI_REMARS3"),
				(String) jObj.get("LNT"), (String) jObj.get("LAT"), (String) jObj.get("WORK_DTTM"));

		list.add(wifiInfo);
			}
		}

		start += 1000;
		end += 1000;
		callCnt--;
	}

	//나머지 데이터 넣기
	jStr = api.callApi(start, start + remainder);

	jMain = (JSONObject) parser.parse(jStr);
	jSub = (JSONObject) jMain.get("TbPublicWifiInfo");
	JSONArray jArr = (JSONArray) jSub.get("row");

	if (jArr.size() > 0) {
		for (int i = 0; i < jArr.size(); i++) {
			JSONObject jObj = (JSONObject) jArr.get(i);

			WifiInfo wifiInfo = new WifiInfo((String) jObj.get("X_SWIFI_MGR_NO"), 0.0, (String) jObj.get("X_SWIFI_WRDOFC"),
			(String) jObj.get("X_SWIFI_MAIN_NM"), (String) jObj.get("X_SWIFI_ADRES1"),
			(String) jObj.get("X_SWIFI_ADRES2"), (String) jObj.get("X_SWIFI_INSTL_FLOOR"),
			(String) jObj.get("X_SWIFI_INSTL_TY"), (String) jObj.get("X_SWIFI_INSTL_MBY"),
			(String) jObj.get("X_SWIFI_SVC_SE"), (String) jObj.get("X_SWFIFI_CMCWR"),
			(String) jObj.get("X_SWIFI_CNSTC_YEAR"), (String) jObj.get("X_SWIFI_INOUT_DOOR"),
			(String) jObj.get("X_SWIFI_REMARS3"), (String) jObj.get("LNT"), (String) jObj.get("LAT"),
			(String) jObj.get("WORK_DTTM"));

			list.add(wifiInfo);
		}
	}

	/* --- DB에 넣기 --- */
	WifiService wifiService = new WifiService();
	wifiService.insert(list);
	%>

	<h1><%=maxCnt%>개의 WIFI정보를 정상적으로 저장하였습니다.
	</h1>
	<div>
		<a href='index.jsp'>홈으로 가기</a>
	</div>
</body>
</html>