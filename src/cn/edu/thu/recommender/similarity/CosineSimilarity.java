package cn.edu.thu.recommender.similarity;

import java.util.List;

import cn.edu.thu.recommender.bean.Rating;
import cn.edu.thu.recommender.util.RatingReader;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:33:20
 * 余弦公式  cos(x,y) = x * y / |x|*|y|
 */
public class CosineSimilarity implements IDistance{

	@Override
	public double getDistance(int id1, int id2) {
		RatingReader reader = new RatingReader();
		List<Rating> lr1 = reader.readUserItemRatings(id1);
		List<Rating> lr2 = reader.readUserItemRatings(id2);
		
		int r1_dist = 0,r2_dist = 0,sum = 0;
		// user1
        for (int i = 0; i < lr1.size(); i++) {
        	r1_dist += lr1.get(i).getRating() * lr1.get(i).getRating();
        }
        // user2
        for (int i = 0; i < lr2.size(); i++) {
            r2_dist += lr2.get(i).getRating() * lr2.get(i).getRating();
        }
        //common
        for(Rating r1 : lr1){
        	for(Rating r2 : lr2){
        		if(r1.getItemid() == r2.getItemid()){
        			sum += r1.getRating() * r2.getRating();
        		}
        	}
        }
		return sum / Math.sqrt(r1_dist)*Math.sqrt(r2_dist);
	}

}
