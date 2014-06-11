package cn.edu.thu.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.junit.Test;

import cn.edu.thu.bean.Item;
import cn.edu.thu.bean.Movie;
import cn.edu.thu.bean.Rating;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:37:39
 */
public class SQLUtil {
    DBUtil db = new DBUtil();

    /**
     * 查询所有用户的评分
     */
    public List<Rating> getRatings() throws SQLException{
        db.openConnection();
        String query = "select userid,itemid,rating from ratings ";
        ResultSet rs = db.queryDB(query);
        List<Rating> list = new ArrayList<Rating>();
        while (rs.next()) {
            int uid = rs.getInt(1);
            int itemid = rs.getInt(2);
            int rating = rs.getInt(3);
            Rating rat = new Rating();
            rat.setUserid(uid);
            rat.setItemid(itemid);
            rat.setRating(rating);
            list.add(rat);
        }
        db.closeConnection();
        return list;
    }
    /**
     * 查询给定用户评论过的item数据
     */
    public List<Rating> getRatings(int userid) throws SQLException {
        db.openConnection();
        String query = "select userid,itemid,rating from ratings where userid = "
                + userid;
        ResultSet rs = db.queryDB(query);
        List<Rating> list = new ArrayList<Rating>();
        while (rs.next()) {
            int uid = rs.getInt(1);
            int itemid = rs.getInt(2);
            int rating = rs.getInt(3);
            Rating rat = new Rating();
            rat.setUserid(uid);
            rat.setItemid(itemid);
            rat.setRating(rating);
            list.add(rat);
        }
        db.closeConnection();
        return list;
    }
    /**
     * 查询某用户评论过的数据，放入map中
     */
    public Map<Integer,Integer> getPartRatings(int userid) throws SQLException{
        db.openConnection();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        String query = "select itemid,rating from ratings where userid = " + userid;
        ResultSet rs = db.queryDB(query);
        while(rs.next()){
            int itemid = rs.getInt(1);
            int rating = rs.getInt(2);
            map.put(itemid, rating);
        }
        db.closeConnection();
        return map;
    }
    /**
     * 查询所有用户评论过的数据
     */
    public Set<Rating> getAllRatings() throws SQLException{
        db.openConnection();
        Set<Rating> set = new HashSet<Rating>();
        String query = "select userid,itemid,rating from ratings ";
        ResultSet rs = db.queryDB(query);
        while(rs.next()){
            int userid = rs.getInt(1);
            int itemid = rs.getInt(2);
            int rating = rs.getInt(3);
            Rating r = new Rating();
            r.setUserid(userid);
            r.setItemid(itemid);
            r.setRating(rating);
            set.add(r);
        }
        db.closeConnection();
        return set;
    }
    /**
     * 获取所有itemid
     * @return
     * @throws SQLException
     */
    public Set<Integer> getAllItems() throws SQLException{
        db.openConnection();
        Set<Integer> set = new HashSet<Integer>();
        String query = "select itemid from items ";
        ResultSet rs = db.queryDB(query);
        while(rs.next()){
            int userid = rs.getInt(1);
            set.add(userid);
        }
        db.closeConnection();
        return set;
    }
    /**
     * 查询用户评论过的rating数据的平均值
     */
    public double getAvgRatings(int userid) throws SQLException {
        db.openConnection();
        String query = "select avg(rating) from ratings where userid = "
                + userid;
        ResultSet rs = db.queryDB(query);
        double ret = 0.0;
        while (rs.next()) {
            ret = rs.getDouble(1);
        }
        db.closeConnection();
        return ret;
    }

    /**
     * 找出10部评分均值最高的电影
     */
    public List<Movie> getAvgRatingDesc() throws SQLException{
        db.openConnection();
        String query = "select title, avgrating, nbratings from items, "
                + "(select round(avg(rating),1) as avgrating, "
                + "count(userid) as nbratings, itemid "
                + "from ratings "
                + "group by itemid "
                + "order by avgrating desc "
                + "limit 10 "
                + ") as avgratingbyitems "
                + "where item.itemid = avgratingbyitems.itemid "
                + "order by avgrating desc";
        System.out.println(query);
        ResultSet rs = db.queryDB(query);
        List<Movie> list = new ArrayList<Movie>();
        while(rs.next()){
            String movietitle = rs.getString(1);
            double avgrating = rs.getDouble(2);
            int nbratings = rs.getInt(3);
            Movie movie = new Movie();
            movie.setTitle(movietitle);
            movie.setAvgrating(avgrating);
            movie.setNbratings(nbratings);
            list.add(movie);
        }
        db.closeConnection();
        return list;
    }
    /**
     * 找出10部评分次数最多的电影
     */
    public List<Movie> getMostRatingDesc() throws SQLException{
        db.openConnection();
        String query = "select title,item.itemid, avgrating, nbratings "
                + "from items, "
                + "(select round(avg(rating),1) as avgrating, "
                + "count(userid) as nbratings, itemid "
                + "from ratings "
                + "group by itemid "
                + "order by nbratings desc "
                + "limit 10 "
                + ") as avgratingbyitems "
                + "where item.itemid = avgratingbyitems.itemid "
                + "order by nbratings desc";
        ResultSet rs = db.queryDB(query);
        List<Movie> list = new ArrayList<Movie>();
        while(rs.next()){
            String movietitle = rs.getString(1);
            double avgrating = rs.getDouble(3);
            int nbratings = rs.getInt(4);
            Movie movie = new Movie();
            movie.setTitle(movietitle);
            movie.setAvgrating(avgrating);
            movie.setNbratings(nbratings);
            list.add(movie);
        }
        db.closeConnection();
        return list;
    }
    /**
     * 获取所有用户
     * @return
     * @throws SQLException
     */
    public Set<Integer> getUserIds() throws SQLException{
        db.openConnection();
        String query = "select userid from users";
        ResultSet rs = db.queryDB(query);
        Set<Integer> set = new HashSet<Integer>();
        while(rs.next()){
            set.add(rs.getInt(1));
        }
        db.closeConnection();
        return set;
    }
    
    public Movie getMovieInfo(int itemid){
        db.openConnection();
        String query = "select itemid,title from items where itemid = " + itemid;
        ResultSet rs = db.queryDB(query);
        Movie movie = new Movie();
        try {
            while(rs.next()){
                try {
                	movie.setId(rs.getInt("itemid"));
                	movie.setTitle(rs.getString("title"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.closeConnection();
        return movie;
    }
    /**
     * 查询给定用户评论过的数据及评分
     */
    public ArrayList<Movie> getUserRatings(int userid) throws SQLException {
        db.openConnection();
        String query = " select r.itemid,r.rating,i.title from "
        		+ "ratings r,items i where r.itemid= i.itemid and r.userid= "
                + userid;
        ResultSet rs = db.queryDB(query);
        ArrayList<Movie> movielist = new ArrayList<Movie>();
        while (rs.next()) {
        	Movie movie = new Movie();
        	movie.setId(rs.getInt("itemid"));
        	movie.setTitle(rs.getString("title"));
        	movie.setScore(rs.getInt("rating"));
        	movielist.add(movie);
        }
        db.closeConnection();
        return movielist;
    }
    /**
     * 获取获得推荐的电影的信息
     * @param list
     * @return
     */
    public ArrayList<Movie> getMovieInfoList(List<RecommendedItem> list){
        db.openConnection();
        ArrayList<Movie> movielist = new ArrayList<Movie>();
        for(RecommendedItem ri : list){
        	String query = "select itemid,title from items where itemid = " + ri.getItemID();
        	ResultSet rs = db.queryDB(query);
            try {
                while(rs.next()){
                    try {
                    	Movie movie = new Movie();
                    	movie.setId(rs.getInt("itemid"));
                    	movie.setTitle(rs.getString("title"));
                    	movie.setScore(ri.getValue());
                    	movielist.add(movie);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        db.closeConnection();
        return movielist;
    }
    @Test
    public void test() throws SQLException{
        Set<Integer> set = getUserIds();
        for(Integer s : set)
            PrintUtil.print(s);
//        List<Movie> list = getMostRatingDesc();
//        for(Movie m : list){
//            PrintUtil.print(m.getTitle()+" | " +m.getAvgrating() + " | " + m.getNbratings());
//        }
    }
}

