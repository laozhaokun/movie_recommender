package cn.edu.thu.recommender.recommender;

import java.util.HashMap;
import java.util.List;

import cn.edu.thu.recommender.bean.Rating;
import cn.edu.thu.recommender.similarity.EuclideanDistance;
import cn.edu.thu.recommender.similarity.IDistance;
import cn.edu.thu.recommender.util.PrintUtil;
import cn.edu.thu.recommender.util.RatingReader;
import cn.edu.thu.recommender.util.SortUtil;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午11:29:34
 */
public class UserBasedRecommender implements IRecommender {

	@Override
	public HashMap<Integer, Double> getRecommendations(int userid,
			IDistance distance) {
		RatingReader reader = new RatingReader();
		HashMap<Integer, Double> scoreMap = new HashMap<Integer, Double>();
		List<Rating> lr = reader.readAllUserItemRatings();
		for(int i=0;i<lr.size();i++){
			if(i == userid)//自己不与自己比较
				continue;
			//计算目标用户与系统中所有用户的距离！//TODO:建立一张新的表，存放距离
			double similarity = distance.getDistance(userid, i);
			if(similarity <= 0)
				continue;
			for(Rating r : lr){
				if(scoreMap.containsKey(r.getItemid())){
					scoreMap.put(r.getItemid(), scoreMap.get(r.getItemid()) + r.getRating() * similarity);
				}else
					scoreMap.put(r.getItemid(), r.getRating() * similarity);
			}
		}
		
		return SortUtil.sortMapByValue(scoreMap);
	}
	
	public static void main(String[] args) {
		UserBasedRecommender ubr = new UserBasedRecommender();
		IDistance distance = new EuclideanDistance();
		HashMap<Integer,Double> map = ubr.getRecommendations(1, distance);
		PrintUtil.print(map);
	}

}
