package cn.edu.thu.similarity;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:22:21
 */
public interface IDistance {
    /**
     * 两个事物之间的距离的计算
     *@preferences preference list
     * @param id1
     * @param id2
     * @return 【-1，1】
     */
    public double getDistance(int id1, int id2);
}
