package nyc.c4q;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c4q-Abass on 8/30/15.
 */
public class MySQLHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Table name
    private static final String BOOKS_DB = "books_db";
    private static final String MEMBERS_DB = "members.db";

    private static final String MEMBERS_COLUMN_ID = "id";
    private static final String MEMBERS_COLUMN_NAME =  "name";
    private static final String MEMBERS_COLUMN_DOB_MONTH = "month";
    private static final String MEMBERS_COLUMN_DOB_DAy = "day";
    private static final String MEMBERS_COLUMN_DOB_YEAR = "year";
    private static final String MEMBER_COLUMN_CITY = "city";
    private static final String MEMBERS_COLUMN_STATE = "state";


    // Column names for books
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";

    private static final String COLUMN_ISBN = "isbn";
    private static final String COLUMN_ISBN_13 = "isbn_13";
    private static final String PUBLISHER = "publisher";
    private static final String PUBLISH_YEAR = "publish_year";

    private static final String CHECKED_OUT = "checked_out";
    private static final String CHECKOUT_DATE_YEAR = "checkout_date_year";
    private static final String CHECKOUT_DATE_MONTH = "checkout_date_month";
    private static final String CHECKOUT_DATE_DAY = "checkout_date_day";
    private static final String DUE_DATE_YEAR = "duedate_year";
    private static final String DUE_DATE_MONTH = "duedate_month";
    private static final String DUE_DATE_DAY = "duedate_day";

    public MySQLHelper(Context context){
        super(context, BOOKS_DB, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + BOOKS_DB + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + COLUMN_TITLE + " TEXT UNIQUE NOT NULL,"
                        + COLUMN_AUTHOR + "TEXT NOT NULL,"
                        + COLUMN_ISBN + "TEXT UNIQUE NOT NULL"
                        + COLUMN_ISBN_13 + "TEXT UNIQUE NOT NULL"
                        + PUBLISHER + "TEXT NOT NULL"
                        + PUBLISH_YEAR + "INTEGER NOT NULL"
                        + CHECKED_OUT
                        + CHECKOUT_DATE_YEAR
                        + CHECKOUT_DATE_MONTH
                        + CHECKOUT_DATE_DAY
                        + DUE_DATE_YEAR
                        + DUE_DATE_MONTH
                        + DUE_DATE_DAY + "LONG NOT NULL,"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // simple database upgrade operation:
        // 1) drop the old table
        db.execSQL("DROP TABLE IF EXISTS " + BOOKS_DB);

        // 2) create a new database
        onCreate(db);
    }

    public List<Book> getBook(String title){
        List<Book> books = new ArrayList();
        for (Book x : getAllBooks()){
            if(x.getTitle() == title){
                books.add(x);
            }
        }
        return books;
    }

    public List<Member> getMembers(String memberName){
        List<Member> members = new ArrayList();
        for (Member x : getAllMembers()){
            if(x.getName() == memberName){
                members.add(x);
            }
        }
        return members;
    }

    public List<Book> getBook(String isbn, int dummy_parameter){
        List<Book> books = new ArrayList();
        for (Book x : getAllBooks()){
            if(x.getIsbn() == isbn){
                books.add(x);
            }
        }
        return books;
    }

    public List<Book> getAllBooks() {
        // initialize the list
        List<Book> items = new ArrayList<Book>();

        // obtain a readable database
        SQLiteDatabase db = getReadableDatabase();

        // send query
        Cursor cursor = db.query(COLUMN_TITLE, new String[] {
                        COLUMN_TITLE,
                        COLUMN_AUTHOR},
                null, null, null, null, null, null); // get all rows

        if (cursor != null) {
            // add items to the list
            for(cursor.moveToFirst(); cursor.isAfterLast() == false; cursor.moveToNext()) {
                items.add(new Book(cursor.getString(0)));
            }

            // close the cursor
            cursor.close();
        }

        // close the database connection
        db.close();

        // return the list
        return items;
    }


    public List<Member> getAllMembers() {
        // initialize the list
        List<Member> members = new ArrayList<Member>();

        // obtain a readable database
        SQLiteDatabase db = getReadableDatabase();

        // send query
        Cursor cursor = db.query(MEMBERS_COLUMN_NAME, new String[] {
                      },
                null, null, null, null, null, null); // get all rows

        if (cursor != null) {
            // add items to the list
            for(cursor.moveToFirst(); cursor.isAfterLast() == false; cursor.moveToNext()) {
                members.add(new Member(cursor.getString(0)));
            }

            // close the cursor
            cursor.close();
        }

        // close the database connection
        db.close();

        // return the list
        return members;
    }



}
