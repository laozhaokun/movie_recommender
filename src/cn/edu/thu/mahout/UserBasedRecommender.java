package cn.edu.thu.mahout;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.struts2.ServletActionContext;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月11日 上午11:07:57
 */
public class UserBasedRecommender {
	public List<RecommendedItem> recommend(int userid,int size) throws TasteException, IOException{
		List<RecommendedItem> list = null;
//		MovieDataModel model = new MovieDataModel();
		String file=ServletActionContext.getServletContext().getRealPath("/u1.base");
		DataModel model = new FileDataModel(new File(file));
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		 UserNeighborhood neighborhood = new NearestNUserNeighborhood(25,similarity, model);
		Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		list = recommender.recommend(userid, size);
		return list;
	}

}
