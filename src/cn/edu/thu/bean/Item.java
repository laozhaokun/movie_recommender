package cn.edu.thu.bean;
/**
 * @author zhf 
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年6月9日 上午10:10:11
 */

/**
 * u.item-- Information about the items (movies); this is a tab separated
              list of
              movie id | movie title | release date | video release date |
              IMDb URL | unknown | Action | Adventure | Animation |
              Children's | Comedy | Crime | Documentary | Drama | Fantasy |
              Film-Noir | Horror | Musical | Mystery | Romance | Sci-Fi |
              Thriller | War | Western |
              The last 19 fields are the genres, a 1 indicates the movie
              is of that genre, a 0 indicates it is not; movies can be in
              several genres at once.
              The movie ids are the ones used in the u.data data set.
1|Toy Story (1995)|01-Jan-1995|
|http://us.imdb.com/M/title-exact?Toy%20Story%20(1995)
|0|0|0|1|1|1|0|0|0|0|0|0|0|0|0|0|0|0|0
 *
 */
public class Item {
    private int itemid;
    private String movieTitle;
    private String releaseDate;//video release date
    private String imdbURL;
    private int action;
    private int adventure;
    private int animation;
    private int children;
    private int comedy;
    private int crime;
    private int documentary;
    private int drama;
    private int fantasy;
    private int filmnoir;
    private int horror;
    private int musical;
    private int mystery;
    private int romance;
    private int scifi;
    private int thriller;
    private int war;
    private int western;
    /**
     * @return the movieTitle
     */
    public String getMovieTitle() {
        return movieTitle;
    }
    /**
     * @return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }
    /**
     * @return the imdbURL
     */
    public String getImdbURL() {
        return imdbURL;
    }
    /**
     * @return the action
     */
    public int getAction() {
        return action;
    }
    /**
     * @return the adventure
     */
    public int getAdventure() {
        return adventure;
    }
    /**
     * @return the animation
     */
    public int getAnimation() {
        return animation;
    }
    /**
     * @return the children
     */
    public int getChildren() {
        return children;
    }
    /**
     * @return the comedy
     */
    public int getComedy() {
        return comedy;
    }
    /**
     * @return the drama
     */
    public int getDrama() {
        return drama;
    }
    /**
     * @return the fantasy
     */
    public int getFantasy() {
        return fantasy;
    }
    /**
     * @return the filmnoir
     */
    public int getFilmnoir() {
        return filmnoir;
    }
    /**
     * @return the horror
     */
    public int getHorror() {
        return horror;
    }
    /**
     * @return the musical
     */
    public int getMusical() {
        return musical;
    }
    /**
     * @return the mystery
     */
    public int getMystery() {
        return mystery;
    }
    /**
     * @return the romance
     */
    public int getRomance() {
        return romance;
    }
    /**
     * @return the scifi
     */
    public int getScifi() {
        return scifi;
    }
    /**
     * @return the thriller
     */
    public int getThriller() {
        return thriller;
    }
    /**
     * @return the war
     */
    public int getWar() {
        return war;
    }
    /**
     * @return the western
     */
    public int getWestern() {
        return western;
    }
    /**
     * @param movieTitle the movieTitle to set
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    /**
     * @param imdbURL the imdbURL to set
     */
    public void setImdbURL(String imdbURL) {
        this.imdbURL = imdbURL;
    }
    /**
     * @param action the action to set
     */
    public void setAction(int action) {
        this.action = action;
    }
    /**
     * @param adventure the adventure to set
     */
    public void setAdventure(int adventure) {
        this.adventure = adventure;
    }
    /**
     * @param animation the animation to set
     */
    public void setAnimation(int animation) {
        this.animation = animation;
    }
    /**
     * @param children the children to set
     */
    public void setChildren(int children) {
        this.children = children;
    }
    /**
     * @param comedy the comedy to set
     */
    public void setComedy(int comedy) {
        this.comedy = comedy;
    }
    /**
     * @param drama the drama to set
     */
    public void setDrama(int drama) {
        this.drama = drama;
    }
    /**
     * @param fantasy the fantasy to set
     */
    public void setFantasy(int fantasy) {
        this.fantasy = fantasy;
    }
    /**
     * @param filmnoir the filmnoir to set
     */
    public void setFilmnoir(int filmnoir) {
        this.filmnoir = filmnoir;
    }
    /**
     * @param horror the horror to set
     */
    public void setHorror(int horror) {
        this.horror = horror;
    }
    /**
     * @param musical the musical to set
     */
    public void setMusical(int musical) {
        this.musical = musical;
    }
    /**
     * @param mystery the mystery to set
     */
    public void setMystery(int mystery) {
        this.mystery = mystery;
    }
    /**
     * @param romance the romance to set
     */
    public void setRomance(int romance) {
        this.romance = romance;
    }
    /**
     * @param scifi the scifi to set
     */
    public void setScifi(int scifi) {
        this.scifi = scifi;
    }
    /**
     * @param thriller the thriller to set
     */
    public void setThriller(int thriller) {
        this.thriller = thriller;
    }
    /**
     * @param war the war to set
     */
    public void setWar(int war) {
        this.war = war;
    }
    /**
     * @param western the western to set
     */
    public void setWestern(int western) {
        this.western = western;
    }
    /**
     * @return the crime
     */
    public int getCrime() {
        return crime;
    }
    /**
     * @param crime the crime to set
     */
    public void setCrime(int crime) {
        this.crime = crime;
    }
    /**
     * @return the documentary
     */
    public int getDocumentary() {
        return documentary;
    }
    /**
     * @param documentary the documentary to set
     */
    public void setDocumentary(int documentary) {
        this.documentary = documentary;
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
    
    

}

