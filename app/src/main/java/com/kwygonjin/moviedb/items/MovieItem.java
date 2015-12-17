package com.kwygonjin.moviedb.items;

/**
 * Created by KwygonJin on 15.12.2015.
 */
public class MovieItem {
    public static final String DATABASE_NAME = "movie_database";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME_MOVIE = "movies";
    public static final String FIELD_MOVIES_TITLE = "movie_title";
    public static final String FIELD_MOVIES_DESC = "movie_desc";
    public static final String FIELD_MOVIES_ID_SQL = "id";

    public static final String TABLE_NAME_GENRE = "genres";
    public static final String FIELD_GENRES_GENRE = "movie_genre";
    public static final String FIELD_GENRES_MOVIE_ID_SQL = "movie_id";
    public static final String FIELD_GENRES_ID_SQL = "id";

    public static final String CREATE_TABLE_MOVIES = "CREATE TABLE " + TABLE_NAME_MOVIE +" ( " +
            FIELD_MOVIES_ID_SQL + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            FIELD_MOVIES_TITLE + " TEXT, "+
            FIELD_MOVIES_DESC + " TEXT) ";

    public static final String CREATE_TABLE_GENRES = "CREATE TABLE " + TABLE_NAME_GENRE +" ( " +
            FIELD_GENRES_ID_SQL + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            FIELD_GENRES_MOVIE_ID_SQL + " INTEGER, "+
            FIELD_GENRES_GENRE + " TEXT) ";

//    public static final String GET_ALL_MOVIES = "SELECT " +
//            "m." + FIELD_MOVIES_TITLE + " , " +
//            "m." + FIELD_MOVIES_DESC + " , " +
//            "m." + FIELD_MOVIES_ID_SQL + " , " +
//            "g." + FIELD_GENRES_GENRE + " , " +
//            "FROM " + TABLE_NAME_MOVIE +"  AS m " +
//            FIELD_MOVIES_TITLE + " , "+
//            FIELD_GENRES_MOVIE_ID_SQL + " INTEGER, "+
//            FIELD_GENRES_GENRE + " TEXT) ";

    private String title;
    private String desc;
    private String genre;
    private long dbId;

    public MovieItem() {
        this.title = "Default movie";
        this.desc = "Default description";
        this.genre = "Default gente";
    }

    public long getDbId() {
        return dbId;
    }

    public void setDbId(long dbId) {
        this.dbId = dbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
