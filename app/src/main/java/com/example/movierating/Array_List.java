package com.example.movierating;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Array_List<S> extends AppCompatActivity {
    List<Book> firstBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        String Alita = "an Alien that defeated her superiors";

        firstBook = new ArrayList<>();
        firstBook.add(new Book("Alita", "Action", "Description Book", R.drawable.alita, R.drawable.alita_cover2));
        firstBook.add(new Book("Bird Box", "Sci - Fi", "Description Book", R.drawable.bird_box, R.drawable.bg_forall));
        firstBook.add(new Book("Dark Phoenix", "Sci - Fi", "Description Book", R.drawable.new_dark_phoenix, R.drawable.polar));
        firstBook.add(new Book("Pet Semetary", "Horror", "Description Book", R.drawable.pet_sematary, R.drawable.polar));
        firstBook.add(new Book("Shazam", "Action", "Description Book", R.drawable.shazam, R.drawable.polar));
        firstBook.add(new Book("Us", "Horror", "Description Book", R.drawable.us, R.drawable.polar));
        firstBook.add(new Book("Five Feet Apart", "Drama", "Description Book", R.drawable.five_feet, R.drawable.polar));
        firstBook.add(new Book("Aquaman", "Action", "Description Book", R.drawable.aquaman, R.drawable.polar));
        firstBook.add(new Book("Triple Frontier", "Action", "Description Book", R.drawable.triple_frontier, R.drawable.polar));
        firstBook.add(new Book("Polar", "action", "Description Book", R.drawable.polar, R.drawable.triple_frontier));
        firstBook.add(new Book("John Wick", "Action", "Description Book", R.drawable.john_wick_3, R.drawable.polar));
        firstBook.add(new Book("Godzilla", "Action", "Description Book", R.drawable.godzilla_king_of_the_monsters, R.drawable.polar));
//        firstBook.add(new Book("Aladdin", "Drama", "Description Book", R.drawable.aladdin));
//        firstBook.add(new Book("Endgame", "Action", "Description Book", R.drawable.avengers_endgame));
//        firstBook.add(new Book("Joker", "Action", "Description Book", R.drawable.joker));
//        firstBook.add(new Book("Lion King", "Animation", "Description Book", R.drawable.lion_king));
//        firstBook.add(new Book("Booksmart", "Comedy", "Description Book", R.drawable.booksmart));
//        firstBook.add(new Book("FWMF", "Drama", "Description Book", R.drawable.fwmf));
//        firstBook.add(new Book("Mortal Engines", "Action", "Description Book", R.drawable.mortal_engines));
//        firstBook.add(new Book("Sonic", "Animation", "Description Book", R.drawable.sonic));
//        firstBook.add(new Book("Night School", "Drama", "Description Book", R.drawable.night_school));
//        firstBook.add(new Book("Toy Story", "Animation", "Description Book", R.drawable.toy_story_four));
//        firstBook.add(new Book("Spiderman ITSV", "Animation", "Description Book", R.drawable.spiderman_into_the_spiderverse));
//        firstBook.add(new Book("TDDD", "Horror", "Description Book", R.drawable.tddd));
//        firstBook.add(new Book("Hobbs & Shaw", "Action", "Description Book", R.drawable.hobbsandshaw));
//        firstBook.add(new Book("Escape Room", "Adventure", "Description Book", R.drawable.escape_room));
//        firstBook.add(new Book("Hellboy", "Horror", "Description Book", R.drawable.hellboy));
//        firstBook.add(new Book("Spiderman FFH", "Categorie Book", "Description Book", R.drawable.spideyimaxhomeimax_thumb));
//        firstBook.add(new Book("Frozen", "Animation", "Description Book", R.drawable.frozen2));
//        firstBook.add(new Book("Captain Marvel", "Sci - Fi", "Description Book", R.drawable.captin_marvel));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, firstBook);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(recyclerViewAdapter);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}