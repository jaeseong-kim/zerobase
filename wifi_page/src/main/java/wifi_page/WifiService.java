package wifi_page;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiService {

	public List<WifiInfo> print() {

		List<WifiInfo> list = new ArrayList<WifiInfo>();

		String url = "jdbc:mariadb://localhost:3306/wifi";
		String dbUserId = "testuser";
		String dbPassword = "zerobase";

		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "SELECT * FROM wifi_info ORDER BY DIST ASC LIMIT 20;";

			preparedStatement = connection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				WifiInfo w = new WifiInfo();
				w.setMGR_NO(rs.getString("MGR_NO"));
				w.setDIST(rs.getDouble("DIST"));
				w.setWRDOFC(rs.getString("WRDOFC"));
				w.setMAIN_NM(rs.getString("MAIN_NM"));
				w.setADRES1(rs.getString("ADRES1"));
				w.setADRES2(rs.getString("ADRES2"));
				w.setINSTL_FLOOR(rs.getString("INSTL_FLOOR"));
				w.setINSTL_TY(rs.getString("INSTL_TY"));
				w.setINSTL_MBY(rs.getString("INSTL_MBY"));
				w.setSVC_SE(rs.getString("SVC_SE"));
				w.setCMCWR(rs.getString("CMCWR"));
				w.setCNSTC_YEAR(rs.getString("CNSTC_YEAR"));
				w.setINOUT_DOOR(rs.getString("INOUT_DOOR"));
				w.setREMARS3(rs.getString("REMARS3"));
				w.setLAT(rs.getString("LAT"));
				w.setLNT(rs.getString("LNT"));
				w.setWORK_DTTM(rs.getString("WORK_DTTM"));
				list.add(w);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return list;
	}

	public void insert(List<WifiInfo> wifiInfo) {
		/*
		 * 1.드라이버 로드 2.커넥션 객체 생성 3.스테이트먼트 객체 생성 4.쿼리 실행 5.결과 실행 6.객체 해제
		 */

		String url = "jdbc:mariadb://localhost:3306/wifi";
		String dbUserId = "testuser";
		String dbPassword = "zerobase";

		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			for (WifiInfo i : wifiInfo) {
				String sql = "insert into wifi_info " + "(MGR_NO, DIST, WRDOFC, MAIN_NM, ADRES1, "
						+ "ADRES2, INSTL_FLOOR, INSTL_TY, INSTL_MBY, " + "SVC_SE, CMCWR, CNSTC_YEAR, INOUT_DOOR, "
						+ "REMARS3, LAT, LNT, WORK_DTTM) " + "VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
						+ "?, ?, ?, ?, ?, ?, ?);";

				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, i.getMGR_NO());
				preparedStatement.setDouble(2, i.getDIST());
				preparedStatement.setString(3, i.getWRDOFC());
				preparedStatement.setString(4, i.getMAIN_NM());
				preparedStatement.setString(5, i.getADRES1());
				preparedStatement.setString(6, i.getADRES2());
				preparedStatement.setString(7, i.getINSTL_FLOOR());
				preparedStatement.setString(8, i.getINSTL_TY());
				preparedStatement.setString(9, i.getINSTL_MBY());
				preparedStatement.setString(10, i.getSVC_SE());
				preparedStatement.setString(11, i.getCMCWR());
				preparedStatement.setString(12, i.getCNSTC_YEAR());
				preparedStatement.setString(13, i.getINOUT_DOOR());
				preparedStatement.setString(14, i.getREMARS3());
				preparedStatement.setString(15, i.getLAT());
				preparedStatement.setString(16, i.getLNT());
				preparedStatement.setString(17, i.getWORK_DTTM());
				int affected = preparedStatement.executeUpdate();

				if (affected > 0) {

				} else {
					System.out.println("저장 실패");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

	public List<WifiInfo> search() {
		List<WifiInfo> list = new ArrayList<WifiInfo>();

		String url = "jdbc:mariadb://localhost:3306/wifi";
		String dbUserId = "testuser";
		String dbPassword = "zerobase";

		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			String sql = "select MGR_NO,LAT,LNT from wifi_info;";

			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				WifiInfo wifiInfo = new WifiInfo();
				wifiInfo.setMGR_NO(rs.getString("MGR_NO"));
				wifiInfo.setLAT(rs.getString("LAT"));
				wifiInfo.setLNT(rs.getString("LNT"));

				list.add(wifiInfo);
			}

			if (rs != null && !rs.isClosed()) {
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		return list;
	}

	public void update(List<WifiInfo> list) {

		String url = "jdbc:mariadb://localhost:3306/wifi";
		String dbUserId = "testuser";
		String dbPassword = "zerobase";

		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);

			for (WifiInfo w : list) {
				String sql = "update wifi_info set DIST= ? where MGR_NO = ?;";

				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setDouble(1, w.getDIST());
				preparedStatement.setString(2, w.getMGR_NO());
				int affected = preparedStatement.executeUpdate();

				if (affected > 0) {

				} else {
					System.out.println("수정 실패");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
