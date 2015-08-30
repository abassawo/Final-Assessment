package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ListActivity extends Activity {

    public ListView list;
    private Button orderToggleBtn;
    private Button colorBtn;
    private Context ctx;

    private String TAG = "ListActivity.TAG";

    public void initViews(){
        ctx = getApplicationContext();
        orderToggleBtn = (Button) findViewById(R.id.button_name);
        colorBtn =(Button) findViewById(R.id.button_color);

    }

    public static Person[] PEOPLE = {
        new Person("Hannah",    "Abbott",          House.Hufflepuff),
        new Person("Katie",     "Bell",            House.Gryffindor),
        new Person("Susan",     "Bones",           House.Hufflepuff),
        new Person("Terry",     "Boot",            House.Ravenclaw),
        new Person("Lavender",  "Brown",           House.Gryffindor),
        new Person("Cho",       "Chang",           House.Ravenclaw),
        new Person("Michael",   "Corner",          House.Ravenclaw),
        new Person("Colin",     "Creevey",         House.Gryffindor),
        new Person("Marietta",  "Edgecombe",       House.Ravenclaw),
        new Person("Justin",    "Finch-Fletchley", House.Hufflepuff),
        new Person("Seamus",    "Finnigan",        House.Gryffindor),
        new Person("Anthony",   "Goldstein",       House.Ravenclaw),
        new Person("Hermione",  "Granger",         House.Gryffindor),
        new Person("Angelina",  "Johnson",         House.Gryffindor),
        new Person("Lee",       "Jordan",          House.Gryffindor),
        new Person("Neville",   "Longbottom",      House.Gryffindor),
        new Person("Luna",      "Lovegood",        House.Ravenclaw),
        new Person("Ernie",     "Macmillan",       House.Hufflepuff),
        new Person("Parvati",   "Patil",           House.Gryffindor),
        new Person("Padma",     "Patil",           House.Ravenclaw),
        new Person("Harry",     "Potter",          House.Gryffindor),
        new Person("Zacharias", "Smith",           House.Hufflepuff),
        new Person("Alicia",    "Spinnet",         House.Gryffindor),
        new Person("Dean",      "Thomas",          House.Gryffindor),
        new Person("Fred",      "Weasley",         House.Gryffindor),
        new Person("George",    "Weasley",         House.Gryffindor),
        new Person("Ginny",     "Weasley",         House.Gryffindor),
        new Person("Ron",       "Weasley",         House.Gryffindor)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initViews();

        final FirstNameComparator fComp = new FirstNameComparator();
        final LastNameComparator lComp = new LastNameComparator();

        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor;
        editor = sharedPreferences.edit();

        for (Person x : PEOPLE) {
            x.lastNameFirst = true;
        }

        if(sharedPreferences.getBoolean("lastname_sort_order", true)){
            Arrays.sort(PEOPLE, lComp);
        } else {
            Arrays.sort(PEOPLE, fComp);
        }


        final SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(),R.layout.listitem_member, PEOPLE);
        final HouseAdapter houseAdapter = new HouseAdapter(getApplicationContext(), PEOPLE);




        list = (ListView) findViewById(R.id.list);
        list.setAdapter(new HouseAdapter(getApplicationContext(), PEOPLE));



        orderToggleBtn.setOnClickListener(new View.OnClickListener() {
            boolean lastNameOrder;

            @Override
            public void onClick(View v) {
                Arrays.sort(PEOPLE, lComp); //FIXME

                for (Person x : PEOPLE) {
                    x.toggleLastNameFirst(); //change A,B to B,A
                    lastNameOrder = x.isLastNameFirst();

                }

                if(lastNameOrder){
                    Arrays.sort(PEOPLE, lComp); //FIXME
                    editor.putBoolean("lastname_sort_order", lastNameOrder).commit();
                } else {
                    Arrays.sort(PEOPLE, fComp);
                }
//
////


                list.setAdapter(new HouseAdapter(getApplicationContext(), PEOPLE));
            }
        });

        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(list.getAdapter() == simpleAdapter ){
                list.setAdapter(houseAdapter); //no background
            }
            if(list.getAdapter() == houseAdapter) {
                list.setAdapter(simpleAdapter);
            }

            }
        });

    }

    private class HouseAdapter extends BaseAdapter {


        public HouseAdapter(Context context, Person[] objects) {
            ctx = context;
            PEOPLE = objects;
        }

        @Override
        public int getCount() {
            return PEOPLE.length;
        }

        @Override
        public Person getItem(int position) {
            return PEOPLE[position];
        }

        @Override
        public long getItemId(int position) {
            return PEOPLE[position].geHouse_ID();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(ctx);
            View row;
            if (convertView == null) {
                row = inflater.inflate(R.layout.listitem_member, parent, false);
            } else {
                row = convertView;
            }

            TextView houseTV = (TextView) row.findViewById(R.id.text_house);
            TextView nameTV = (TextView) row.findViewById(R.id.text_name);

            Person person =  getItem(position);
            houseTV.setText(person.getHouse().toString());
            nameTV.setText(person.toString());
            row.setBackgroundResource(person.geHouse_ID());


            return row;
        }


    }

    private class SimpleAdapter extends ArrayAdapter{

        public SimpleAdapter(Context context, int resource, Person[] objects) {
            super(context, resource, objects);
        }
    }

}
