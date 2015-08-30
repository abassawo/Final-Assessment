package nyc.c4q;

/**
 * Created by c4q-Abass on 8/30/15.
 */import java.util.HashMap;
import java.util.Map;

public class Member {

    private int id;
    private String name;
    private int dobMonth;
    private int dobDay;
    private int dobYear;
    private String city;
    private String state;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */

    public Member(String name){
        this.name = name;
    }
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
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The dobMonth
     */
    public int getDobMonth() {
        return dobMonth;
    }

    /**
     *
     * @param dobMonth
     * The dob_month
     */
    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }

    /**
     *
     * @return
     * The dobDay
     */
    public int getDobDay() {
        return dobDay;
    }

    /**
     *
     * @param dobDay
     * The dob_day
     */
    public void setDobDay(int dobDay) {
        this.dobDay = dobDay;
    }

    /**
     *
     * @return
     * The dobYear
     */
    public int getDobYear() {
        return dobYear;
    }

    /**
     *
     * @param dobYear
     * The dob_year
     */
    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(String state) {
        this.state = state;
    }



    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
