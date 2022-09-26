package history;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class HistoryService {

	/* --- 삽입 메소드 --- */
	public void insert(History history) {

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
			String sql = "insert into search_wifi_history " + "(LAT, LNT, SEARCH_DATE) VALUES (?, ?, ?);";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, history.getLAT());
			preparedStatement.setString(2, history.getLNT());
			preparedStatement.setString(3, history.getSEARCH_DATE());
			int affected = preparedStatement.executeUpdate();

			if (affected > 0) {

			} else {
				System.out.println("저장 실패");
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

	/* --- 조회 메소드 --- */

	public List<History> search() {
		List<History> list = new ArrayList<History>();

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
			String sql = "SELECT * FROM search_wifi_history ORDER BY ID DESC;";

			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				History history = new History(rs.getInt("ID"), rs.getString("LAT"), rs.getString("LNT"),
						rs.getString("SEARCH_DATE"));

				list.add(history);
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

	/* --- 삭제 메소드 --- */
	public void delete(int i) {

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
			String sql = "DELETE FROM search_wifi_history WHERE ID = ?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, i);
			preparedStatement.executeUpdate();

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
