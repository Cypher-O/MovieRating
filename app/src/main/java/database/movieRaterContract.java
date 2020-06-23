package database;

import android.provider.BaseColumns;

// To prevent someone from accidentally instantiating the contract class,
// make the constructor private.
public final class movieRaterContract {

    // Create a String that contains the SQL statement to create the movies table
//    public static final String SQL_CREATE_ENTRIES_MOVIES =
//            "CREATE TABLE " + movieRaterContract.tableEntry.TABLE_NAME_MOVIES + " (" +
//                    movieRaterContract.tableEntry.COLUMN_NAME_MOVIE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//                    movieRaterContract.tableEntry.COLUMN_NAME_MOVIE_NAME + " TEXT," +
//                    movieRaterContract.tableEntry.COLUMN_NAME_MOVIE_CATEGORY_NAME + " TEXT," +
//                    movieRaterContract.tableEntry.COLUMN_NAME_MOVIE_DESCRIPTION_NAME + " TEXT)";
//    // Create a String that contains the SQL statement to create the rating table
//    public static final String SQL_CREATE_ENTRIES_RATING =
//            "CREATE TABLE " + movieRaterContract.tableEntry.TABLE_NAME_RATING + " (" +
//                    movieRaterContract.tableEntry.COLUMN_NAME_RATING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT)";

    private movieRaterContract() {

    }

    /* Inner class that defines the table contents */
    public final static class tableEntry implements BaseColumns {
        // Users Table
        public final static String TABLE_NAME_USERS = "users";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME_USER_NAME = "username";
        public final static String COLUMN_NAME_PASSWORD = "password";
        public final static String COLUMN_NAME_CONFIRM_PASSWORD = "confirmpassword";
        public final static String COLUMN_NAME_PHONE_NUMBER = "phonenumber";
        public final static String COLUMN_NAME_EMAIL = "emailaddress";

        //        // Movies Table
        public static final String TABLE_NAME_MOVIES = "movies";
        public static final String MOVIE_ID = BaseColumns._ID;
        public static final String COLUMN_NAME_MOVIE_NAME = "movieName";
        public static final String COLUMN_NAME_MOVIE_CATEGORY_NAME = "movieCategory";
        public static final String COLUMN_NAME_MOVIE_DESCRIPTION_NAME = "movieDescription";
        //
//        // Rating Table
        public static final String TABLE_NAME_RATING = "rating";
        public static final String RATING_ID = BaseColumns._ID;
        public static final String USER_ID = "getuserId";
        public static final String COLUMN_NAME_RATING_MOVIE_NAME = "ratingmoviename";
        public static final String COLUMN_NAME_RATING_REVIEW = "ratingreview";
        //        public static final String COLUMN_NAME_RATING_THUMBNAIL = "ratingmov_thumb";
        public static final String COLUMN_NAME_RATING_BAR = "ratingbar";
//        public static final String COLUMN_NAME_MOVIE_CATEGORY_NAME = "movieCategory";
    }


//    private static final String SQL_CREATE_ENTRIES_USERS =
//            "CREATE TABLE " + tableEntry.TABLE_NAME_USERS + " (" +
//                    tableEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY, AUTOINCREMENT" +
//                    tableEntry.COLUMN_NAME_FIRST_NAME + " TEXT," +
//                    tableEntry.COLUMN_NAME_LAST_NAME + " TEXT," +
//                    tableEntry.COLUMN_NAME_USER_NAME + " TEXT," +
//                    tableEntry.COLUMN_NAME_PASSWORD + " TEXT," +
//                    tableEntry.COLUMN_NAME_EMAIL + " TEXT)";
//
//    private static final String SQL_CREATE_ENTRIES_MOVIES =
//            "CREATE TABLE " + tableEntry.TABLE_NAME_MOVIES + " (" +
//                    tableEntry.COLUMN_NAME_MOVIE_ID + " INTEGER PRIMARY KEY, AUTOINCREMENT" +
//                    tableEntry.COLUMN_NAME_MOVIE_NAME + " TEXT," +
//                    tableEntry.COLUMN_NAME_MOVIE_CATEGORY_NAME + " TEXT," +
//                    tableEntry.COLUMN_NAME_MOVIE_DESCRIPTION_NAME + " TEXT)";
//
//    private static final String SQL_CREATE_ENTRIES_RATING =
//            "CREATE TABLE " + tableEntry.TABLE_NAME_RATING + " (" +
//                    tableEntry.COLUMN_NAME_RATING_ID + " INTEGER PRIMARY KEY, AUTOINCREMENT)";
}