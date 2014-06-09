package cn.edu.thu.recommender.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.thu.recommender.bean.Rating;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午11:08:51
 */
public class RatingReader {
	SQLUtil  sq = new SQLUtil();
	
	/**
	 * 读取给定用户的评分数据
	 */
	public List<Rating> readUserItemRatings(int userid) {
		try {
			return sq.getRatings(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 读取所有用户的评分数据
	 */
	public List<Rating> readAllUserItemRatings() {
		try {
			return sq.getRatings();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
