package cn.edu.thu.mahout;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.IRStatistics;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.eval.GenericRecommenderIRStatsEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.common.RandomUtils;
import org.junit.Test;

import cn.edu.thu.util.Config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 下午5:15:00
 */
public class RecommenderWithMahout {
    public static void main(String[] args) {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setDatabaseName("rec");
            JDBCDataModel dm = new MySQLJDBCDataModel(dataSource,"ratings","userid","itemid","rating","");
            UserSimilarity similarity = new PearsonCorrelationSimilarity(dm);
            UserNeighborhood neighbor = new NearestNUserNeighborhood(2,similarity, dm);
            Recommender recommender = new GenericUserBasedRecommender(dm, neighbor, similarity);
            List<RecommendedItem> list = recommender.recommend(1, 3);// recommend
                                                                     // one item
                                                                     // to user
                                                                     // 1
            for (RecommendedItem ri : list) {
                System.out.println(ri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    @Test
    public void test() {
        RandomUtils.useTestSeed();
        try {
            DataModel dataModel = new FileDataModel(new File(
                    Config.UA_FILE));
//            RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
            RecommenderIRStatsEvaluator evaluator = new GenericRecommenderIRStatsEvaluator();
            RecommenderBuilder builder = new RecommenderBuilder() {

                @Override
                public Recommender buildRecommender(DataModel arg0)
                        throws TasteException {
//                    UserSimilarity similarity = new PearsonCorrelationSimilarity(
//                            arg0);
//                    UserNeighborhood neighbor = new NearestNUserNeighborhood(2,
//                            similarity, arg0);
//                    return new GenericUserBasedRecommender(arg0, neighbor,
//                            similarity);
                        return new SlopeOneRecommender(arg0);
                }
            };
            try {
//                double score = evaluator.evaluate(builder, null, dataModel,
//                        0.7, 1.0);
//                System.out.println(score);
                IRStatistics statis = evaluator.evaluate(builder, null, dataModel, null, 2,GenericRecommenderIRStatsEvaluator.CHOOSE_THRESHOLD,1.0);
                System.out.println(statis.getPrecision());
                System.out.println(statis.getRecall());
            } catch (TasteException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
