package cn.edu.thu.recommender.bean;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:07:44
 * u.user-- Demographic information about the users; 
 * this is a tab separated list of
 *user id | age | gender | occupation | zip code
 *The user ids are the ones used in the u.data data set.
 *
 */
public class User {
    /**
     * 用户编号
     */
    private int userid;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private String gender;
    /**
     * 职业
     */
    private String occupation;
    /**
     * 邮编
     */
    private String zipcode;
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }
    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }
    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
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

}


