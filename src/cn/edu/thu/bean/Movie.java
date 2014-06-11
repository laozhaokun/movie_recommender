package cn.edu.thu.bean;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:09:10
 */
public class Movie {
	private int id;
	private String title;// 电影名
	private double avgrating;// 平均评分
	private int nbratings;// 评分次数
	private double score;//预测值;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the avgrating
	 */
	public double getAvgrating() {
		return avgrating;
	}

	/**
	 * @param avgrating
	 *            the avgrating to set
	 */
	public void setAvgrating(double avgrating) {
		this.avgrating = avgrating;
	}

	/**
	 * @return the nbratings
	 */
	public int getNbratings() {
		return nbratings;
	}

	/**
	 * @param nbratings
	 *            the nbratings to set
	 */
	public void setNbratings(int nbratings) {
		this.nbratings = nbratings;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
