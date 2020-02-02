package app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.utils.Constants;

public final class MySQLConnect {
	public Connection conn;
	private Statement statement;
	public static MySQLConnect db;

	private MySQLConnect() {
		try {
			Class.forName(Constants.DB_DRIVER).newInstance();
			this.conn = (Connection) DriverManager.getConnection(Constants.DB_URL + Constants.DB_NAME, Constants.DB_USERNAME,
					Constants.DB_PASSWORD);
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 *
	 * @return MysqlConnect Database connection object
	 */
	public static synchronized MySQLConnect getDbCon() {
		if (db == null) {
			db = new MySQLConnect();
		}
		return db;

	}

	/**
	 *
	 * @param query String The query to be executed
	 * @return a ResultSet object containing the results or null if not available
	 * @throws SQLException
	 */
	public ResultSet query(String query) throws SQLException {
		statement = db.conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		return res;
	}

}