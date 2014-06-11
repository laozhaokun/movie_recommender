package cn.edu.thu.bean;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:10:54
 */

/**
 * u.data     -- The full u data set, 100000 ratings by 943 users on 1682 items.
              Each user has rated at least 20 movies.  Users and items are
              numbered consecutively from 1.  The data is randomly
              ordered. This is a tab separated list of 
             user id | item id | rating | timestamp. 
              The time stamps are unix seconds since 1/1/1970 UTC   

 *
 */
public class Rating {
    private int userid;
    private int itemid;
    private int rating;
    private int timestamp;
    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }
    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }
    /**
     * @return the itemid
     */
    public int getItemid() {
        return itemid;
    }
    /**
     * @param itemid the itemid to set
     */
    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }
    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /**
     * @return the timestamp
     */
    public int getTimestamp() {
        return timestamp;
    }
    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

}

