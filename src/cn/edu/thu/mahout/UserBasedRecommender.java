package cn.edu.thu.mahout;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月11日 上午11:07:57
 */
public class UserBasedRecommender {
	public static void main(String[] args) throws TasteException {
		List<RecommendedItem> list = new UserBasedRecommender().recommend(1,2);
		for (RecommendedItem ri : list) {
	        System.out.println(ri);
	    }
	}
	public List<RecommendedItem> recommend(int userid,int size) throws TasteException{
		List<RecommendedItem> list = null;
		MovieDataModel model = new MovieDataModel();
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		 UserNeighborhood neighborhood = new NearestNUserNeighborhood(2,similarity, model);
		Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		list = recommender.recommend(userid, size);
		return list;
	}

}
