package cn.edu.thu.recommender.recommender;

import java.util.HashMap;

import cn.edu.thu.recommender.similarity.IDistance;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午11:24:08
 */
public interface IRecommender {
    /**
     * 为给定的用户获取推荐列表
     *
     * @param preferences 偏好列表
     * @param userid 被推荐的用户id
     * @param distance 使用哪种距离
     * @return 一个包含预估评分的推荐列表
     */
    public HashMap<Integer,Double> getRecommendations(int userid, IDistance distance);
}
