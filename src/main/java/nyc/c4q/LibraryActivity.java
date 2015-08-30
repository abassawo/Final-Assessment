package nyc.c4q;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


public class LibraryActivity extends Activity {

    public EditText inputParameter;
    private MySQLHelper databaseHelper;
    private TextView mainScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        databaseHelper = new MySQLHelper(getApplicationContext());
        mainScreen = (TextView) findViewById(R.id.text_display);

        inputParameter = (EditText) findViewById(R.id.input_parameter);
        List<Book> mBooks = databaseHelper.getAllBooks();

    }

    public void checkOut(int memberId, int bookId) {
        for (Book book : databaseHelper.getAllBooks()){ //get all books that arent currently checked out!*
            //user w/ member ID checks out book w/ bookID: #fixme;
        };

        // TODO This method is called when the member with the given ID checks
        //      out the book with the given ID. Update the system accordingly.
        //      The due date for the book is two weeks from today.
    }

    public boolean checkIn(int memberId, int bookId) {
        // TODO This method is called when the member with the given ID returns
        //      the book with the given ID. Update the system accordingly. If
        //      the member is returning the book on time, return true. If it's
        //      late, return false.

        return false;
    }

    public void button_getMember_onClick(View view) {
        String name = inputParameter.getText().toString();

        // TODO Display member information for the member with the given name.
    }

    public void button_getBook_onClick(View view) {
        String isbn = inputParameter.getText().toString();
        mainScreen.setText("");
        for (Book x : databaseHelper.getBook(isbn, 0)) { //0 is a dummy variable
            mainScreen.append(x.toString());
        }
        // TODO Display book information for the book with the given ISBN.
    }

    public void button_getCheckedOut_onClick(View view) {
        String name = inputParameter.getText().toString();
        mainScreen.setText("");

        // TODO Display a list of books that the member with the given name
        //      currently has checked out, ordered by due date, with the
        //      earliest due first.

        for (Book x :    databaseHelper.getBook(name) ) {
            mainScreen.append(x.toString());
        }


    }

}
