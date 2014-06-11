package cn.edu.thu.mahout;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月11日 上午10:30:41
 */
public class ItemBasedRecommender {
	/**
	 * 
	 * @param userid	当前用户id
	 * @param size	推荐多少个
	 * @return	推荐列表
	 * @throws TasteException
	 */
	public List<RecommendedItem> recommend(int userid,int size) throws TasteException{
		List<RecommendedItem> list = null;
        JDBCDataModel model = new MySQLJDBCDataModel();
		ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
		Recommender recommender = new GenericItemBasedRecommender(model, similarity);
		list = recommender.recommend(userid, size);
		return list;
	}
}
