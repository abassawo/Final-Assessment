package nyc.c4q;

import java.util.Comparator;

public class Person {
    public String firstName;
    public String lastName;
    public long house_ID;

    public boolean isLastNameFirst() {
        return lastNameFirst;
    }

    public boolean lastNameFirst = false;

    public void toggleLastNameFirst() {
        if(this.lastNameFirst){
            this.lastNameFirst = false;
        } else if (!lastNameFirst){
            this.lastNameFirst = true;
        }
    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public House getHouse() {
        return house;
    }

    public int geHouse_ID(){
        switch (this.getHouse()){   //maybe colors can correspond to these id values.
            case Gryffindor: {
                return R.color.gryffindor_red;
            }

            case Hufflepuff: {
                return R.color.hufflepuff_yellow;
            }

            case Ravenclaw: {
                return R.color.ravenclaw_blue;
            }

            case Slytherin: {
                return R.color.slytherin_green;
            }

            default: break;
            }

        return -1;



    }

    public House house;

    public Person(String firstName, String lastName, House house) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.house     = house;
        lastNameFirst = false;
    }

    @Override
    public String toString() {
        if(lastNameFirst){
            return (this.lastName + " " + this.firstName);
        } else {
            return (this.firstName + " , " + this.lastName);
        }

    }



}
