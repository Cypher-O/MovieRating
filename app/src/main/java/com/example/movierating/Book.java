package com.example.movierating;

public class Book {
    private String Title;
    private String Category;
    private String Description;
    private int Thumbnail;
    private int Movie_Cover;

    public Book(String title, String category, String description, int thumbnail, int movie_Cover) {
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
        Movie_Cover = movie_Cover;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public int getMovie_Cover() {
        return Movie_Cover;
    }

    public void setMovie_Cover(int movie_Cover) {
        Movie_Cover = movie_Cover;
    }
}
