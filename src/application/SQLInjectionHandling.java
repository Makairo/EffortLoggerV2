package application;

//Jerry Gao

//Use Java's PreparedStatement to handle any string inputs

import java.sql.Connection;

import java.sql.DatabaseMetaData;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.sql.PreparedStatement;

public class SQLInjectionHandling {

	/*
	 * public static String SQLTest(User inUser) throws SQLException {
	 * 
	 * Connection conn = null;
	 * 
	 * Statement statement = null;
	 * 
	 * ResultSet resultSet = null;
	 * 
	 * // the following is a test database used so we have the SQL rules,
	 * 
	 * // and the url will be changed to the actual one later
	 * 
	 * try {
	 * 
	 * String url = "jdbc:sqlite::memory:";
	 * 
	 * conn = DriverManager.getConnection(url);
	 * 
	 * }
	 * 
	 * //looking for errors with the connection
	 * 
	 * catch (SQLException e) {
	 * 
	 * System.out.println(e.getMessage());
	 * 
	 * } finally {
	 * 
	 * try {
	 * 
	 * if (conn != null) {
	 * 
	 * conn.close();
	 * 
	 * }
	 * 
	 * } catch (SQLException ex) {
	 * 
	 * System.out.println(ex.getMessage());
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //created a prepared statement
	 * 
	 * String userPass = inUser.getName()+inUser.getPassword();
	 * 
	 * PreparedStatement pstmt = conn.prepareStatement(userPass);
	 * 
	 * //print out if needed to test
	 * 
	 * //System.out.println(pstmt);
	 * 
	 * //will convert this function back to PreparedStatement when we have a DB
	 * 
	 * return userPass;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 */

	// the above will be done when we have a proper SQL DB to cover using Prepared
	// Statements.

	// For now,the test will simply iterate over string inputs and declare if they
	// are fit or not

	public static Boolean SQLTestMini(User inUser)

	{

		boolean flag = true;
		//test a name and pwd
		String username = inUser.getName();

		String pwd = inUser.getPassword();

		for (int i = 0; i < username.length(); i++) {
			char c1 = username.charAt(i);
			char c2 = pwd.charAt(i);
			//if the pwd or username contains a ', ", or \ it is invalid
			if (c1 == '\'' || c1 == '\"' || c1 == '\\') {
				flag = false;
				break;
			}
			if (c2 == '\'' || c2 == '\"' || c2 == '\\') {
				flag = false;
				break;
			}

		}
		//return
		return flag;

	}

	public static Boolean ASCIICheck(String s) {
		//since we are not yet committed to an SQL database, this is
		//a non-ASCII character checker for any string input
		boolean flag = true;
		int length = s.length();
		//excessive length if > 32 characters
		if (s.length() > 32) {
			return false;
		}
		//if string is null, it's still true as there's no non-ascii chars inside.
		if (s != null) {
			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);
				if (c < 0x20 || c > 0x7E) {
					//if the character at i is not an ascii char, false
					//else, it's true.
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

}
