package wifi_page;

public class WifiInfo {
	private String MGR_NO;
	private double DIST;
	private String WRDOFC;
	private String MAIN_NM;
	private String ADRES1;
	private String ADRES2;
	private String INSTL_FLOOR;
	private String INSTL_TY;
	private String INSTL_MBY;
	private String SVC_SE;
	private String CMCWR;
	private String CNSTC_YEAR;
	private String INOUT_DOOR;
	private String REMARS3;
	private String LAT;
	private String LNT;
	private String WORK_DTTM;
	
	public WifiInfo() {
		
	}
	
	public WifiInfo(String mGR_NO, double dIST, String wRDOFC, String mAIN_NM, String aDRES1, String aDRES2,
			String iNSTL_FLOOR, String iNSTL_TY, String iNSTL_MBY, String sVC_SE, String cMCWR, String cNSTC_YEAR,
			String iNOUT_DOOR, String rEMARS3, String lAT, String lNT, String wORK_DTTM) {
		super();
		MGR_NO = mGR_NO;
		DIST = dIST;
		WRDOFC = wRDOFC;
		MAIN_NM = mAIN_NM;
		ADRES1 = aDRES1;
		ADRES2 = aDRES2;
		INSTL_FLOOR = iNSTL_FLOOR;
		INSTL_TY = iNSTL_TY;
		INSTL_MBY = iNSTL_MBY;
		SVC_SE = sVC_SE;
		CMCWR = cMCWR;
		CNSTC_YEAR = cNSTC_YEAR;
		INOUT_DOOR = iNOUT_DOOR;
		REMARS3 = rEMARS3;
		LAT = lAT;
		LNT = lNT;
		WORK_DTTM = wORK_DTTM;
	}
	
	public String getMGR_NO() {
		return MGR_NO;
	}
	public void setMGR_NO(String mGR_NO) {
		MGR_NO = mGR_NO;
	}
	public double getDIST() {
		return DIST;
	}
	public void setDIST(double dIST) {
		DIST = dIST;
	}
	public String getWRDOFC() {
		return WRDOFC;
	}
	public void setWRDOFC(String wRDOFC) {
		WRDOFC = wRDOFC;
	}
	public String getMAIN_NM() {
		return MAIN_NM;
	}
	public void setMAIN_NM(String mAIN_NM) {
		MAIN_NM = mAIN_NM;
	}
	public String getADRES1() {
		return ADRES1;
	}
	public void setADRES1(String aDRES1) {
		ADRES1 = aDRES1;
	}
	public String getADRES2() {
		return ADRES2;
	}
	public void setADRES2(String aDRES2) {
		ADRES2 = aDRES2;
	}
	public String getINSTL_FLOOR() {
		return INSTL_FLOOR;
	}
	public void setINSTL_FLOOR(String iNSTL_FLOOR) {
		INSTL_FLOOR = iNSTL_FLOOR;
	}
	public String getINSTL_TY() {
		return INSTL_TY;
	}
	public void setINSTL_TY(String iNSTL_TY) {
		INSTL_TY = iNSTL_TY;
	}
	public String getINSTL_MBY() {
		return INSTL_MBY;
	}
	public void setINSTL_MBY(String iNSTL_MBY) {
		INSTL_MBY = iNSTL_MBY;
	}
	public String getSVC_SE() {
		return SVC_SE;
	}
	public void setSVC_SE(String sVC_SE) {
		SVC_SE = sVC_SE;
	}
	public String getCMCWR() {
		return CMCWR;
	}
	public void setCMCWR(String cMCWR) {
		CMCWR = cMCWR;
	}
	public String getCNSTC_YEAR() {
		return CNSTC_YEAR;
	}
	public void setCNSTC_YEAR(String cNSTC_YEAR) {
		CNSTC_YEAR = cNSTC_YEAR;
	}
	public String getINOUT_DOOR() {
		return INOUT_DOOR;
	}
	public void setINOUT_DOOR(String iNOUT_DOOR) {
		INOUT_DOOR = iNOUT_DOOR;
	}
	public String getREMARS3() {
		return REMARS3;
	}
	public void setREMARS3(String rEMARS3) {
		REMARS3 = rEMARS3;
	}
	public String getLAT() {
		return LAT;
	}
	public void setLAT(String lAT) {
		LAT = lAT;
	}
	public String getLNT() {
		return LNT;
	}
	public void setLNT(String lNT) {
		LNT = lNT;
	}
	public String getWORK_DTTM() {
		return WORK_DTTM;
	}
	public void setWORK_DTTM(String wORK_DTTM) {
		WORK_DTTM = wORK_DTTM;
	}

	@Override
	public String toString() {
		return "WifiInfo [MGR_NO=" + MGR_NO + ", DIST=" + DIST + ", WRDOFC=" + WRDOFC + ", MAIN_NM=" + MAIN_NM
				+ ", ADRES1=" + ADRES1 + ", ADRES2=" + ADRES2 + ", INSTL_FLOOR=" + INSTL_FLOOR + ", INSTL_TY="
				+ INSTL_TY + ", INSTL_MBY=" + INSTL_MBY + ", SVC_SE=" + SVC_SE + ", CMCWR=" + CMCWR + ", CNSTC_YEAR="
				+ CNSTC_YEAR + ", INOUT_DOOR=" + INOUT_DOOR + ", REMARS3=" + REMARS3 + ", LAT=" + LAT + ", LNT=" + LNT
				+ ", WORK_DTTM=" + WORK_DTTM + "]";
	}
	
	
	
}
