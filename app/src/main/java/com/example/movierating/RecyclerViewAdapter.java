package com.example.movierating;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    private final Context mcontext;
    private final List<Book> mData;

    public RecyclerViewAdapter(Context mcontext, List<Book> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }


    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mcontext);
        view = mInflater.inflate(R.layout.cardview_item_book, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {

        holder.tv_book_title.setText(mData.get(position).getTitle());
//        holder.tv_category.setText(mData.get(position).getCategory());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mcontext, Book_Activity.class);

                //inserting data into the book activity
                intent.putExtra("BookTitle", mData.get(position).getTitle());
                intent.putExtra("Category", mData.get(position).getCategory());
                intent.putExtra("Description", mData.get(position).getDescription());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());
                intent.putExtra("Movie_Cover", mData.get(position).getMovie_Cover());

                //start the activity
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title, tv_category;
        ImageView img_book_thumbnail, img_cover;
        CardView cardView;

        public myViewHolder(View itemView) {
            super(itemView);

            tv_book_title = itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail = itemView.findViewById(R.id.book_img_id);
            tv_category = itemView.findViewById(R.id.txtCat);
            cardView = itemView.findViewById(R.id.cardview_id);
            img_cover = itemView.findViewById(R.id.first_img);

        }
    }
}
