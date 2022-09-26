package history;

public class History {
	private int ID;
	private String LAT;
	private String LNT;
	private String SEARCH_DATE;
	
	public History(String lAT, String lNT, String sEARCH_DATE) {
		super();
		LAT = lAT;
		LNT = lNT;
		SEARCH_DATE = sEARCH_DATE;
	}
	
	public History(int iD,String lAT, String lNT, String sEARCH_DATE) {
		super();
		ID=iD;
		LAT = lAT;
		LNT = lNT;
		SEARCH_DATE = sEARCH_DATE;
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public String getSEARCH_DATE() {
		return SEARCH_DATE;
	}
	public void setSEARCH_DATE(String sEARCH_DATE) {
		SEARCH_DATE = sEARCH_DATE;
	}
}
