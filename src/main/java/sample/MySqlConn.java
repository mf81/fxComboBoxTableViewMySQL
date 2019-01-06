package sample;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;

public class MySqlConn {

    private static String url = "jdbc:mysql://localhost:3306/bazka?useSSL=false";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "Maciek81";
    private static Connection con;

    private static MySqlConn ourInstance = new MySqlConn();
    public static MySqlConn getInstance() {
        return ourInstance;
    }
    private MySqlConn() {
        getConnection();
    }

    public Connection getConnection() {

        try {
            Class.forName(driverName).newInstance();
            try {
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to MySQL database.");
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
                System.out.println(ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
            System.out.println(ex);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return con;
    }

    public ResultSet getStatment(String sql) throws SQLException {
        ResultSet getStatment = con.createStatement().executeQuery(sql);
        return getStatment;

    }

    public java.sql.PreparedStatement prepSt (String sql) throws SQLException {
        return con.prepareStatement(sql);
    }

    public PreparedStatement putNewStatment(String sql) throws SQLException {
        PreparedStatement putNewStatment = (PreparedStatement) con.prepareStatement(sql);
        return putNewStatment;

    }

}

