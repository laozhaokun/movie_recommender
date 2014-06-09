package cn.edu.thu.recommender.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:37:30
 */
public class DBUtil {
	   public Connection connection;

	    /**
	     * 连接数据库
	     */
	    public boolean openConnection() {
	        boolean ret = false;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(Config.URL,
	                    Config.DB_NAME, Config.DB_PASS);
	            ret = true;
	        } catch (SQLException e) {
	            System.err.println("open Error.");
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return ret;
	    }

	    /**
	     * 关闭数据库连接
	     */
	    public boolean closeConnection() {
	        boolean ret = false;
	        try {
	            connection.close();
	            ret = true;
	        } catch (SQLException e) {
	            System.err.println("close Error.");
	            e.printStackTrace();
	        }
	        return ret;
	    }

	    /**
	     * 获取数据库连接对象
	     */
	    public Connection getConnection() {
	        return connection;
	    }

	    /**查询用户1评价过的电影
	     * select u.userid,d.itemid,i.movieid,i.movietitle,d.rating 
	     * from user u,item i,data d where 
	     * u.userid = d.userid and d.itemid = i.movieid 
	     * and u.userid = 1;
	     * 查询
	     */
	    public ResultSet queryDB(String query) {
	        ResultSet ret = null;
	        try {
	            Statement stmt = connection.createStatement();
	            ret = stmt.executeQuery(query);
	        } catch (SQLException e) {
	            System.err.println("query error!");
	            e.printStackTrace();
	        }
	        return ret;
	    }

	    /**
	     * 更新
	     */
	    public int updateDB(String update) {
	        int rows = 0;
	        try {
	            Statement stmt = connection.createStatement();
	            rows = stmt.executeUpdate(update);
	        } catch (SQLException e) {
	            System.err.println("update error!");
	            e.printStackTrace();
	        }
	        return rows;
	    }
	    public DataSource getDataSource(){
	        return (DataSource) connection;
	    }
}
