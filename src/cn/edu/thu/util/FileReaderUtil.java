package cn.edu.thu.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cn.edu.thu.bean.Item;
import cn.edu.thu.bean.Rating;
import cn.edu.thu.bean.User;


/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:04:54
 */
public class FileReaderUtil {
    /**
     * 读取用户列表信息
     */
    public static List<User> readUserFile(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String str = "";
        List<User> list = new ArrayList<User>();
        while ((str = br.readLine()) != null) {
            User user = new User();
            String temp[] = str.split("\\|");
            for (int i = 0; i < temp.length; i++) {
                user.setUserid(Integer.valueOf(temp[0]));
                user.setAge(Integer.valueOf(temp[1]));
                user.setGender(temp[2]);
                user.setOccupation(temp[3]);
                user.setZipcode(temp[4]);
            }
            list.add(user);
        }
        is.close();
        isr.close();
        br.close();
        return list;
    }
    
    /**
     * 通过userid,itemid得到Rating对象
     */
    public static Rating getData(int userid,int itemid) throws IOException {
        List<Rating> list = readRatingFile(Config.RATING_FILE);
        for (Rating data : list) {
            if (data.getUserid() == userid && data.getItemid() == itemid)
                return data;
        }
        return null;
    }
    
    /**
     * 读取评分数据列表信息
     */
    public static List<Rating> readRatingFile(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String str = "";
        List<Rating> list = new ArrayList<Rating>();
        while ((str = br.readLine()) != null) {
            Rating data = new Rating();
            String temp[] = str.split("\t");
            for (int i = 0; i < temp.length; i++) {
                data.setItemid(Integer.valueOf(temp[0]));
                data.setUserid(Integer.valueOf(temp[1]));
                data.setRating(Integer.valueOf(temp[2]));
                data.setTimestamp(Integer.valueOf(temp[3]));
            }
            list.add(data);
        }
        is.close();
        isr.close();
        br.close();
        return list;
    }
    
    /**
     * 通过movieid得到Item对象
     */
    public static Item getItem(int itemid) throws IOException {
        List<Item> list = readItemFile(Config.ITEM_FILE);
        for (Item item : list) {
            if (item.getItemid() == itemid)
                return item;
        }
        return null;
    }
    
    /**
     * 读取电影列表信息
     */
    public static List<Item> readItemFile(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String str = "";
        List<Item> list = new ArrayList<Item>();
        while ((str = br.readLine()) != null) {
            Item item = new Item();
            String temp[] = str.split("\\|");
            for (int i = 0; i < temp.length; i++) {
                item.setItemid(Integer.valueOf(temp[0]));
                item.setMovieTitle(temp[1]);
                item.setReleaseDate(temp[2]);
                item.setImdbURL(temp[3]);
                item.setAction(Integer.valueOf(temp[4]));
                item.setAdventure(Integer.valueOf(temp[5]));
                item.setAnimation(Integer.valueOf(temp[6]));
                item.setChildren(Integer.valueOf(temp[7]));
                item.setComedy(Integer.valueOf(temp[8]));
                item.setCrime(Integer.valueOf(temp[9]));
                item.setDocumentary(Integer.valueOf(temp[10]));
                item.setDrama(Integer.valueOf(temp[11]));
                item.setFantasy(Integer.valueOf(temp[12]));
                item.setFilmnoir(Integer.valueOf(temp[13]));
                item.setHorror(Integer.valueOf(temp[14]));
                item.setMusical(Integer.valueOf(temp[15]));
                item.setMystery(Integer.valueOf(temp[16]));
                item.setRomance(Integer.valueOf(temp[17]));
                item.setScifi(Integer.valueOf(temp[18]));
                item.setThriller(Integer.valueOf(temp[19]));
                item.setWar(Integer.valueOf(temp[20]));
                item.setWestern(Integer.valueOf(temp[21]));
            }
            list.add(item);
        }
        is.close();
        isr.close();
        br.close();
        return list;
    }
}
