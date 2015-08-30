package nyc.c4q;

/**
 * Created by c4q-Abass on 8/30/15.
 */
import java.util.HashMap;
import java.util.Map;

public class Book {

    private int id;
    private String title;
    private String author;
    private String isbn;
    private String isbn13;
    private String publisher;
    private int publishyear;

    private boolean checkedout;
    private int checkedoutby;
    private int checkoutdateyear;
    private int checkoutdatemonth;
    private int checkoutdateday;
    private int duedateyear;
    private int duedatemonth;
    private int duedateday;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Book(String title){
        this.title = title;
    }

    /**
     *
     * @return
     * The id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     * The isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     * The isbn13
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     *
     * @param isbn13
     * The isbn13
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     *
     * @return
     * The publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher
     * The publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @return
     * The publishyear
     */
    public int getPublishyear() {
        return publishyear;
    }

    /**
     *
     * @param publishyear
     * The publishyear
     */
    public void setPublishyear(int publishyear) {
        this.publishyear = publishyear;
    }

    /**
     *
     * @return
     * The checkedout
     */
    public boolean isCheckedout() {
        return checkedout;
    }

    /**
     *
     * @param checkedout
     * The checkedout
     */
    public void setCheckedout(boolean checkedout) {
        this.checkedout = checkedout;
    }

    /**
     *
     * @return
     * The checkedoutby
     */
    public int getCheckedoutby() {
        return checkedoutby;
    }

    /**
     *
     * @param checkedoutby
     * The checkedoutby
     */
    public void setCheckedoutby(int checkedoutby) {
        this.checkedoutby = checkedoutby;
    }

    /**
     *
     * @return
     * The checkoutdateyear
     */
    public int getCheckoutdateyear() {
        return checkoutdateyear;
    }

    /**
     *
     * @param checkoutdateyear
     * The checkoutdateyear
     */
    public void setCheckoutdateyear(int checkoutdateyear) {
        this.checkoutdateyear = checkoutdateyear;
    }

    /**
     *
     * @return
     * The checkoutdatemonth
     */
    public int getCheckoutdatemonth() {
        return checkoutdatemonth;
    }

    /**
     *
     * @param checkoutdatemonth
     * The checkoutdatemonth
     */
    public void setCheckoutdatemonth(int checkoutdatemonth) {
        this.checkoutdatemonth = checkoutdatemonth;
    }

    /**
     *
     * @return
     * The checkoutdateday
     */
    public int getCheckoutdateday() {
        return checkoutdateday;
    }

    /**
     *
     * @param checkoutdateday
     * The checkoutdateday
     */
    public void setCheckoutdateday(int checkoutdateday) {
        this.checkoutdateday = checkoutdateday;
    }

    /**
     *
     * @return
     * The duedateyear
     */
    public int getDuedateyear() {
        return duedateyear;
    }

    /**
     *
     * @param duedateyear
     * The duedateyear
     */
    public void setDuedateyear(int duedateyear) {
        this.duedateyear = duedateyear;
    }

    /**
     *
     * @return
     * The duedatemonth
     */
    public int getDuedatemonth() {
        return duedatemonth;
    }

    /**
     *
     * @param duedatemonth
     * The duedatemonth
     */
    public void setDuedatemonth(int duedatemonth) {
        this.duedatemonth = duedatemonth;
    }

    /**
     *
     * @return
     * The duedateday
     */
    public int getDuedateday() {
        return duedateday;
    }

    /**
     *
     * @param duedateday
     * The duedateday
     */
    public void setDuedateday(int duedateday) {
        this.duedateday = duedateday;
    }



    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}