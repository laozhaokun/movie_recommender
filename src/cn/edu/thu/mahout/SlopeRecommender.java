package cn.edu.thu.mahout;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.struts2.ServletActionContext;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月11日 上午11:16:27
 */
public class SlopeRecommender {

	public List<RecommendedItem> recommend(int userid,int size) throws TasteException, IOException{
		List<RecommendedItem> list = null;
//		MovieDataModel model = new MovieDataModel();
		String file=ServletActionContext.getServletContext().getRealPath("/u1.base");
		DataModel model = new FileDataModel(new File(file));
		Recommender recommender = new CachingRecommender(new SlopeOneRecommender(model));
		list = recommender.recommend(userid, size);
		return list;
	}
}
