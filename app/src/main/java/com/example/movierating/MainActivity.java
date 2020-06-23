package com.example.movierating;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import database.movieRaterContract;
import database.movieRaterReaderDbHelper;

public class MainActivity extends AppCompatActivity {

    static int dbUserID;
    static int userID;
    movieRaterReaderDbHelper mDbHelper;
    private TextInputEditText e_uname, e_pword;
    private Button signInbtn;
    private CheckBox chkb_rem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        mDbHelper = new movieRaterReaderDbHelper(this);
    }

    private boolean loginValidation(String username, String password) {

        e_uname = this.<TextInputEditText>findViewById(R.id.uname);
        e_pword = this.<TextInputEditText>findViewById(R.id.pword);
        signInbtn = this.<Button>findViewById(R.id.sign_in);
        chkb_rem = this.<CheckBox>findViewById(R.id.checkBox);

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                movieRaterContract.tableEntry._ID,
                movieRaterContract.tableEntry.COLUMN_NAME_USER_NAME,
                movieRaterContract.tableEntry.COLUMN_NAME_PASSWORD};

        String selection = movieRaterContract.tableEntry.COLUMN_NAME_USER_NAME + "=?" + " AND " +
                movieRaterContract.tableEntry.COLUMN_NAME_PASSWORD + "=?";

        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(
                movieRaterContract.tableEntry.TABLE_NAME_USERS,   // The table to query
                projection,            // The columns to return
                selection,                  // The columns for the WHERE clause
                selectionArgs,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);

        int idColumnIndex = cursor.getColumnIndexOrThrow(movieRaterContract.tableEntry._ID);
        int unameColumnIndex = cursor.getColumnIndexOrThrow(movieRaterContract.tableEntry.COLUMN_NAME_USER_NAME);
        int pwordColumnIndex = cursor.getColumnIndexOrThrow(movieRaterContract.tableEntry.COLUMN_NAME_PASSWORD);
        boolean status = false;

        try {
            while (cursor.moveToNext()) {
//                int currentID = cursor.getInt(idColumnIndex);
                String dbCurrentName = cursor.getString(unameColumnIndex);
                String dbCurrentPassword = cursor.getString(pwordColumnIndex);
                if (!username.equalsIgnoreCase(dbCurrentName) || !password.equals(dbCurrentPassword)) {
                    status = false;
//                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT);
                } else if (username.equalsIgnoreCase(dbCurrentName) && password.equals(dbCurrentPassword)) {
                    dbUserID = cursor.getInt(idColumnIndex);
//                    username.compareToIgnoreCase(dbCurrentName);
                    status = true;
//                    Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT);
                }
            }
        } finally {
            cursor.close();
            db.close();
        }
        return status;
    }

    public void openActivity(View view) {
        e_uname = this.<TextInputEditText>findViewById(R.id.uname);
        e_pword = this.<TextInputEditText>findViewById(R.id.pword);

        String userName = e_uname.getText().toString().trim();
        String passWord = e_pword.getText().toString().trim();
//        String userId;
        if (loginValidation(userName, passWord)) {
            userID = dbUserID;

            ProgressDialog progressDialog = ProgressDialog.show(this, "Signing in",
                    "please wait", true);
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Array_List.class);
            startActivity(intent);
            progressDialog.setCancelable(true);
//            progressDialog.cancel();
//            progressDialog.dismiss();
            progressDialog.setIcon(R.drawable.phonenum_bak_icon);
//            Message cannceled = null;
//            progressDialog.setCancelMessage(cannceled);
            e_pword.setText("");
        } else if (userName.equals("") || passWord.equals("")) {
            Toast.makeText(MainActivity.this, "username or password is empty", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Check username or password", Toast.LENGTH_SHORT).show();
        }
    }

    public void openSignUp(View view) {
        Intent intent = new Intent(this, sign_up.class);
        startActivity(intent);
    }

    private void fetchRatingDetails() {
        Array_List<String> ratingList = new Array_List<>();

        Uri uri = Uri.parse("content://com.example.own.PROVIDER");

        String[] projection = {
                movieRaterContract.tableEntry.RATING_ID,
                movieRaterContract.tableEntry.COLUMN_NAME_RATING_MOVIE_NAME,
                movieRaterContract.tableEntry.COLUMN_NAME_RATING_REVIEW,
                movieRaterContract.tableEntry.COLUMN_NAME_RATING_BAR};

        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        ContentResolver contentResolver = getContentResolver();

        Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);

        int idColumnIndex = cursor.getColumnIndexOrThrow(movieRaterContract.tableEntry.RATING_ID);
        int movieNameColumnIndex = cursor.getColumnIndexOrThrow(movieRaterContract.tableEntry.COLUMN_NAME_RATING_MOVIE_NAME);
        int reviewColumnIndex = cursor.getColumnIndexOrThrow(movieRaterContract.tableEntry.COLUMN_NAME_RATING_REVIEW);
        int barColumnIndex = cursor.getColumnIndexOrThrow(movieRaterContract.tableEntry.COLUMN_NAME_RATING_BAR);
        while (cursor.moveToNext()) {
//            int dbIdColumnIndex = cursor.getInt(idColumnIndex);
            String dbCurrentmovieName = cursor.getString(movieNameColumnIndex);
            String dbCurrentreview = cursor.getString(reviewColumnIndex);
            String dbCurrentBar = cursor.getString(barColumnIndex);
        }
    }
}

