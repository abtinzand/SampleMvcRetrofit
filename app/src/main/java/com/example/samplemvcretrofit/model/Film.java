package com.example.samplemvcretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Film {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("poster")
    private String poster;

    @SerializedName("year")
    private String year;

    @SerializedName("country")
    private String country;

    @SerializedName("imdb_rating")
    private String imdb_rating;

    @SerializedName("genres")
    private String[] genres;

    @SerializedName("images")
    private String[] images;


    public Film(String title, String poster, String year, String imdb_rating) {
        this.title = title;
        this.poster = poster;
        this.year = year;
        this.imdb_rating = imdb_rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(String imdb_rating) {
        this.imdb_rating = imdb_rating;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
