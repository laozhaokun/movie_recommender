package cn.edu.thu.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.edu.thu.bean.Movie;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:40:16
 */
public class PrintUtil {
    /**
     * 打印字符串
     * @param str
     */
    public static void print(String str){
        System.out.println(str);
    }
    /**
     * 打印List
     * @param list
     */
    public static <E> void print(List<E> list){
        for(E li : list)
            System.out.println(li);
    }
    /**
     * 打印Map
     * @param map
     */
    public static <K, V> void print(Map<K,V> map){
        for(Map.Entry<K, V> m : map.entrySet()){
            System.out.println(m.getKey() + " , " + m.getValue());
        }
    }
    /**
     * 打印Map,指定长度
     * @param map
     */
    public static <K, V> void print(Map<K,V> map,int n){
        int k = 0;
        for(Map.Entry<K, V> m : map.entrySet()){
            System.out.println(m.getKey() + " , " + m.getValue());
            k++;
            if(k>n)
                break;
        }
    }
    public static void print(double d) {
        System.out.println(d);
    }
    
	public static void print(ArrayList<Movie> list){
		for (Movie ri : list) {
	        System.out.println(ri.getTitle() +"\t" + ri.getScore());
	    }
		System.out.println("--------------------------------------");
	}
}
