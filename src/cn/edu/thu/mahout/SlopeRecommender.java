package cn.edu.thu.mahout;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月11日 上午11:16:27
 */
public class SlopeRecommender {

	public List<RecommendedItem> recommend(int userid,int size) throws TasteException{
		System.out.println("slope ...");
		List<RecommendedItem> list = null;
		MovieDataModel model = new MovieDataModel();
		Recommender recommender = new CachingRecommender(new SlopeOneRecommender(model));
		list = recommender.recommend(userid, size);
		System.out.println("slope end...");
		return list;
	}
}
