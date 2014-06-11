package cn.edu.thu.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import cn.edu.thu.bean.Movie;
import cn.edu.thu.mahout.ItemBasedRecommender;
import cn.edu.thu.mahout.SlopeRecommender;
import cn.edu.thu.mahout.UserBasedRecommender;
import cn.edu.thu.service.RecommendService;
import cn.edu.thu.util.PrintUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月11日 上午11:29:29
 */
public class RecommendAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int userid;
	private int size;
	private String method;
	private ArrayList<Movie> recommendedmovielist;
	private ArrayList<Movie> usermovielist;
	RecommendService service = new RecommendService();
	
	public String getRecommendation() throws TasteException, SQLException{
		usermovielist = service.getMovieInfoList(userid);
		if(method.equals("mahout_userbased")){
			List<RecommendedItem> list = new UserBasedRecommender().recommend(userid,size);
			recommendedmovielist = service.getMovieInfoList(list);
		}
		else if(method == "mahout_itembased"){
			List<RecommendedItem> list = new ItemBasedRecommender().recommend(userid,size);
			recommendedmovielist = service.getMovieInfoList(list);
		}
		else{
			List<RecommendedItem> list = new SlopeRecommender().recommend(userid,size);
			recommendedmovielist = service.getMovieInfoList(list);
		}
		System.out.println("method = " + method);
		PrintUtil.print(recommendedmovielist);
		return SUCCESS;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public ArrayList<Movie> getRecommendedmovielist() {
		return recommendedmovielist;
	}
	public void setRecommendedmovielist(ArrayList<Movie> recommendedmovielist) {
		this.recommendedmovielist = recommendedmovielist;
	}
	public ArrayList<Movie> getUsermovielist() {
		return usermovielist;
	}
	public void setUsermovielist(ArrayList<Movie> usermovielist) {
		this.usermovielist = usermovielist;
	}
	

}
