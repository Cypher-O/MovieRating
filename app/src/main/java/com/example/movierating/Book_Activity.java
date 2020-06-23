package com.example.movierating;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import database.movieRaterContract;
import database.movieRaterReaderDbHelper;

public class Book_Activity extends AppCompatActivity {

    movieRaterReaderDbHelper mDbHelper;
    private EditText userReview;
    private RatingBar ratingBar;
    private TextView movie_Title;

    private TextView tvtitle, tvdescript, tvCateg;
    private ImageView img, cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        mDbHelper = new movieRaterReaderDbHelper(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        tvtitle = (TextView) findViewById(R.id.txtTitle);
        tvdescript = (TextView) findViewById(R.id.txtDesript);
        tvCateg = (TextView) findViewById(R.id.txtCat);
        img = (ImageView) findViewById(R.id.bookthumbnail);
        cover = (ImageView) findViewById(R.id.first_img);

        //Receive data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("BookTitle");
        String Category = intent.getExtras().getString("Category");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");
        int image1 = intent.getExtras().getInt("Movie_Cover");

        //setting values
        tvtitle.setText(Title);
        tvCateg.setText(Category);
        tvdescript.setText(Description);
        img.setImageResource(image);
        cover.setImageResource(image1);
    }

    public boolean validateRatingReviews(String review, float rating) {
        if (review.equals("") && rating == 0) {
            Toast.makeText(this, " Rating bar & review fields are empty",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (review.equals("") || rating == 0) {
            Toast.makeText(this, " Rating bar or review fields are empty",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void submitRatingReview(View view) {
        userReview = this.<EditText>findViewById(R.id.review);
        ratingBar = this.<RatingBar>findViewById(R.id.ratingBar);
        movie_Title = this.<TextView>findViewById(R.id.txtTitle);

        String rateReview = userReview.getText().toString().trim();
        float rateBar = ratingBar.getRating();
        String mov_Title = movie_Title.getText().toString().trim();
        int userId = MainActivity.userID;

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        if (validateRatingReviews(rateReview, rateBar)) {
            contentValues.put(movieRaterContract.tableEntry.
                    USER_ID, userId);
            contentValues.put(movieRaterContract.tableEntry.
                    COLUMN_NAME_RATING_REVIEW, rateReview);
            contentValues.put(movieRaterContract.tableEntry.
                    COLUMN_NAME_RATING_MOVIE_NAME, mov_Title);
            contentValues.put(movieRaterContract.tableEntry.
                    COLUMN_NAME_RATING_BAR, rateBar);

            long newRowId = db.insert(movieRaterContract.tableEntry
                    .TABLE_NAME_RATING, null, contentValues);

            if (newRowId == -1) {
                Toast.makeText(this, "Submission failed",
                        Toast.LENGTH_SHORT).show();
            } else if (newRowId >= 0) {
                Toast.makeText(this, "Submitted successful",
                        Toast.LENGTH_SHORT).show();
                userReview.setText("");
                ratingBar.setRating(0);
            }
        } else if (!validateRatingReviews(rateReview, rateBar)) {

        }
    }
}
