package com.example.movierating;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import database.movieRaterContract;
import database.movieRaterReaderDbHelper;

public class sign_up extends AppCompatActivity {

    movieRaterReaderDbHelper mDbHelper;
    private TextInputEditText uname, pword, cpword, p_num, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        mDbHelper = new movieRaterReaderDbHelper(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

//    private void hideKeyboardFrom(View view){
//        InputMethodManager imm = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//    }

    private boolean validateName(String user_input, String pword_input, String c_pwor_input) {
        if (user_input.length() < 5 || pword_input.length() < 5 || c_pwor_input.length() < 5) {
            uname.setError("character should be > 5");
            pword.setError("character should be > 5");
            cpword.setError("character should be > 5");
//            Toast.makeText(this, "all fields cannot be less than five", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validateUserInput(String user_inp, String pword_inp, String pnum_inp, String email_inp) {
        if (user_inp.equals("") && pword_inp.equals("") && pnum_inp.equals("") && email_inp.equals("")) {
            Toast.makeText(this, " All fields are empty",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (user_inp.equals("") || pword_inp.equals("") || pnum_inp.equals("") || email_inp.equals("")) {
            Toast.makeText(this, " one or more fields are empty",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validtePassword(String pword_input, String cpword_input) {
        if (!pword_input.equals(cpword_input)) {
            Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    public void register(View view) {
        uname = this.<TextInputEditText>findViewById(R.id.username);
        pword = this.<TextInputEditText>findViewById(R.id.pword);
        cpword = this.<TextInputEditText>findViewById(R.id.c_pword);
        p_num = this.<TextInputEditText>findViewById(R.id.p_no);
        email = this.<TextInputEditText>findViewById(R.id.email_ad);

        String username = uname.getText().toString().trim();
        String password = pword.getText().toString().trim();
        String confirmpassword = cpword.getText().toString().trim();
        String phone_num = p_num.getText().toString().trim();
        String emailAddress = email.getText().toString().trim();

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        if (validateUserInput(username, password, phone_num, emailAddress) == true
                && validtePassword(password, confirmpassword) == true && validateName
                (username, password, confirmpassword) == true) {
            contentValues.put(movieRaterContract.tableEntry.
                    COLUMN_NAME_USER_NAME, username);
            contentValues.put(movieRaterContract.tableEntry.
                    COLUMN_NAME_PASSWORD, password);
            contentValues.put(movieRaterContract.tableEntry.
                    COLUMN_NAME_CONFIRM_PASSWORD, confirmpassword);
            contentValues.put(movieRaterContract.tableEntry.
                    COLUMN_NAME_PHONE_NUMBER, phone_num);
            contentValues.put(movieRaterContract.tableEntry.
                    COLUMN_NAME_EMAIL, emailAddress);

//        if (uname.getText().equals("") || pword.getText().equals("") || cpword.getText().equals("")
//                || p_num.getText().equals("") || email.getText().equals("")) {
//            Toast.makeText(this, " one or more fields are empty",
//                    Toast.LENGTH_SHORT).show();
//        }
            long newRowId = db.insert(movieRaterContract.tableEntry
                    .TABLE_NAME_USERS, null, contentValues);

            db.close();

            if (newRowId == -1) {
                Toast.makeText(this, "Registration failed",
                        Toast.LENGTH_SHORT).show();
            } else if (newRowId >= 0) {
                Toast.makeText(this, "Registration successful",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Array_List.class);
                startActivity(intent);
                uname.setText("");
                pword.setText("");
                cpword.setText("");
                p_num.setText("");
                email.setText("");
            }
        } else if (validateUserInput(username, password, phone_num, emailAddress) == false
                && validtePassword(password, confirmpassword) == false &&
                validateName(username, password, confirmpassword) == false) {
        }
    }
}
