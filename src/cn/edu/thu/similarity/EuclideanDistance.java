package cn.edu.thu.similarity;

import java.util.List;

import cn.edu.thu.bean.Rating;
import cn.edu.thu.util.RatingReader;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:35:59
 * 欧氏距离（ Euclidean distance）是一个通常采用的距离定义，它是在m维空间中两个点之间的真实距离。
 * 在二维和三维空间中的欧式距离的就是两点之间的距离，二维的公式是 d = sqrt((x1-x2)^2+(y1-y2)^2) 
 */
public class EuclideanDistance implements IDistance {

	@Override
	public double getDistance(int id1, int id2){
		
		RatingReader reader = new RatingReader();
		List<Rating> lr1 = reader.readUserItemRatings(id1);
		List<Rating> lr2 = reader.readUserItemRatings(id2);
        
        double sumOfSquares = 0;
        
        for(Rating r1 : lr1){
        	for(Rating r2 : lr2){
        		if(r1.getItemid() == r2.getItemid()){
        			sumOfSquares += Math.pow(r1.getRating() - r2.getRating(), 2);
        		}
        	}
        }
        return 1 / (1 + Math.sqrt(sumOfSquares));//归一化
	}

}
