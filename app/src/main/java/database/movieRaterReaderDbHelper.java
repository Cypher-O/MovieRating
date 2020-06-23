package database;

//imports used in this java file

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import com.example.ratingapp.Main3Activity;
//
//import database.movieRaterContract.tableEntry;

/**
 * Database helper for Rating app. Manages database creation and version management.
 */
public class movieRaterReaderDbHelper extends SQLiteOpenHelper {

//    public static final String LOG_TAG = movieRaterReaderDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     **/
    private static final String DATABASE_NAME = "movieRater.db";

    /**
     * version of the database
     **/
    private static final int DATABASE_VERSION = 1;
    // Create a String that contains the SQL statement to create the users table
    private final static String SQL_CREATE_ENTRIES_USERS =
            "CREATE TABLE " + movieRaterContract.tableEntry.TABLE_NAME_USERS + " (" +
                    movieRaterContract.tableEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    movieRaterContract.tableEntry.COLUMN_NAME_USER_NAME + " TEXT NOT NULL," +
                    movieRaterContract.tableEntry.COLUMN_NAME_PASSWORD + " TEXT NOT NULL," +
                    movieRaterContract.tableEntry.COLUMN_NAME_CONFIRM_PASSWORD + " TEXT NOT NULL," +
                    movieRaterContract.tableEntry.COLUMN_NAME_PHONE_NUMBER + " INTEGER NOT NULL," +
                    movieRaterContract.tableEntry.COLUMN_NAME_EMAIL + " TEXT NOT NULL)";

    private static final String SQL_CREATE_ENTRIES_RATING =
            "CREATE TABLE " + movieRaterContract.tableEntry.TABLE_NAME_RATING + " (" +
                    movieRaterContract.tableEntry.RATING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    movieRaterContract.tableEntry.COLUMN_NAME_RATING_MOVIE_NAME + " TEXT NOT NULL," +
                    movieRaterContract.tableEntry.COLUMN_NAME_RATING_REVIEW + " TEXT NOT NULL," +
                    movieRaterContract.tableEntry.USER_ID + " INTEGER," +
                    movieRaterContract.tableEntry.COLUMN_NAME_RATING_BAR + " DECIMAL (10,5))";

    /**
     * Constructs a new instance of {@link movieRaterReaderDbHelper}.
     *
     * @param context
     */
    public movieRaterReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDb) {
        // Execute the SQL statements
        sqLiteDb.execSQL(SQL_CREATE_ENTRIES_USERS);
        sqLiteDb.execSQL(SQL_CREATE_ENTRIES_RATING);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
