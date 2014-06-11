package cn.edu.thu.mahout;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import cn.edu.thu.util.DBUtil;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 下午5:12:08
 */
public class MovieDataModel extends MySQLJDBCDataModel{
	private static final long serialVersionUID = 4962155171407824847L;
	public static final String RATING_TABLE = "ratings";
	    public static final String USERID_COLUMN = "userid";
	    public static final String ITEMID_COLUMN = "itemid";
	    public static final String RATING_COLUMN = "rating";
	    
	    public MovieDataModel(String dataSourceName) throws TasteException {
	        super(lookupDataSource(dataSourceName),RATING_TABLE,USERID_COLUMN,ITEMID_COLUMN,RATING_COLUMN, null);
	    }
	    public MovieDataModel() { 
	        //DBUtil.getDataSource() 将返回应用的数据源
	        // 此应用是 J2EE 应用，所以这里会采用 JDNI 的方式创建数据库链接。
	        super(new DBUtil().getDataSource(), RATING_TABLE, USERID_COLUMN, 
	            ITEMID_COLUMN, RATING_COLUMN,null); 
	    }
	    
}
