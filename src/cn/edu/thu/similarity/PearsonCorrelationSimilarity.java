package cn.edu.thu.similarity;

import java.util.List;

import cn.edu.thu.bean.Rating;
import cn.edu.thu.util.RatingReader;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:31:54 
 * 皮尔逊Pearson Correlation 对用户X,Y
 *          sum^2X:X的所有评分项之平方和 sum^2Y:Y的所有评分项之平方和 sumXY:sumX
 *          、sumY的交集之和，即X、Y都评价了的项之和 相关性：sumXY / sqrt(sumX^2 * sumY^2)
 *          两个变量之间的皮尔逊相关系数定义为两个变量之间的协方差和标准差的商： p(X,Y) = (xi - avg(x))(yi -
 *          avg(y)) /sqrt((xi - avg(x))^2) * sqrt((yi - avg(y))^2)
 *          皮尔逊距离度量的是两个变量X和Y之间的距离：d(X,Y) = 1 -p(X,Y). 1/(n -1) * sum((Xi -
 *          avg(X)) /p(X) * (Yi - avg(Y))) / p(Y)
 */
public class PearsonCorrelationSimilarity implements IDistance {
	RatingReader reader = new RatingReader();

	@Override
	public double getDistance(int id1, int id2) {
		List<Rating> lr1 = reader.readUserItemRatings(id1);
		List<Rating> lr2 = reader.readUserItemRatings(id2);
		
		double avgX = getAvgRating(lr1);
		double avgY = getAvgRating(lr2);
		double sumXY = 0, sumX = 0, sumY = 0;
		
		for (int i = 0; i < lr1.size(); i++) {
			double rating1 = lr1.get(i).getRating();
			sumX += (rating1 - avgX) * (rating1 - avgX);
		}
		for (int j = 0; j < lr2.size(); j++) {
			double rating2 = lr2.get(j).getRating();
			sumY += (rating2 - avgY) * (rating2 - avgY);
		}
		for (int i = 0; i < lr1.size(); i++) {
			double rating1 = lr1.get(i).getRating();
			for (int j = 0; j < lr2.size(); j++) {
				double rating2 = lr2.get(j).getRating();
				if (lr1.get(i).getItemid() == lr2.get(j).getItemid()) {
					sumXY += (rating1 - avgX) * (rating2 - avgY);
				}
			}
		}
		return sumXY / (Math.sqrt(sumX * sumY));
	}

	/**
	 * 计算用户的rating总和
	 * 
	 * @param userid
	 */
	public double getAvgRating(List<Rating> lr) {
		double sum = 0.0;
		for (Rating r : lr) {
			sum += r.getRating();
		}
		return sum;
	}

}
