package cn.edu.thu.mahout;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月11日 上午11:19:11
 */
public class Test {
	public static void main(String[] args) throws TasteException {
//		testItemBased();
		testUserBased();
//		testSlope();
	}
	public static void testItemBased() throws TasteException {
		List<RecommendedItem> list = new ItemBasedRecommender().recommend(1,2);
		print(list);
	}
	public static void testUserBased() throws TasteException {
		List<RecommendedItem> list = new UserBasedRecommender().recommend(1,2);
		print(list);
	}
	public static void testSlope() throws TasteException {
		List<RecommendedItem> list = new SlopeRecommender().recommend(1,2);
		print(list);
	}
	public static void print(List<RecommendedItem> list){
		for (RecommendedItem ri : list) {
	        System.out.println(ri.getItemID() +"\t" + ri.getValue());
	    }
		System.out.println("--------------------------------------");
	}
}
