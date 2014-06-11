package cn.edu.thu.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 下午4:24:33
 */
public class SortUtil {
    /**
     * map按值排序，asc
     * @param map
     * @return
     */
    public static <K, V extends Comparable<? super V>> HashMap<K,V> sortMapByValue(Map<K,V> map){
        List<Map.Entry<K,V>> list = new LinkedList<Map.Entry<K,V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>(){
            @Override
            public int compare(Map.Entry<K, V> o1,Map.Entry<K, V> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        HashMap<K,V> ret = new LinkedHashMap<K,V>();
        for(Map.Entry<K, V> m : list){
            ret.put(m.getKey(), m.getValue());
        }
        return ret;
    }
    @Test
    public void test(){
        Map<Integer, Double> ret = new HashMap<Integer,Double>();
        ret.put(1, 0.18644049303111404);
        ret.put(2, 0.2123570251158737);
        ret.put(3, 0.2129042693314699);
        ret.put(4, 0.19770798467995848);
        ret = SortUtil.sortMapByValue(ret);
        PrintUtil.print(ret);
    }
}
