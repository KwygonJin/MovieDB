package com.kwygonjin.moviedb.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kwygonjin.moviedb.items.MovieItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KwygonJin on 15.12.2015.
 */
public class MovieDBManager {
    private MovieDBHelper movieDBHelper;

    public MovieDBManager(Context context) {
        movieDBHelper = new MovieDBHelper(context);
    }

    public long save(MovieItem movieItem) throws IOException {
//        if (contains(movieItem)) {
//            update(movieItem);
//            return movieItem.getIdSQLite();
//        }
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        db.beginTransaction();
        ContentValues cv = new ContentValues();
        cv.put(MovieItem.FIELD_MOVIES_TITLE, movieItem.getTitle());
        cv.put(MovieItem.FIELD_MOVIES_DESC, movieItem.getDesc());

        long _id = db.insert(MovieItem.TABLE_NAME_MOVIE, null, cv);
        if (_id != -1) {
            movieItem.setDbId(_id);

            cv = new ContentValues();
            cv.put(MovieItem.FIELD_GENRES_MOVIE_ID_SQL, _id);
            cv.put(MovieItem.FIELD_GENRES_GENRE, movieItem.getGenre());
            _id = db.insert(MovieItem.TABLE_NAME_GENRE, null, cv);

            if (_id != -1) db.setTransactionSuccessful();
        }
        else throw new IOException();


        db.close();

        return _id;
    }

    public List<MovieItem> getAll() {

        List<MovieItem> movies = new ArrayList<MovieItem>();
        StringBuffer genres = new StringBuffer();
        MovieItem movieItem;

        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.query(MovieItem.TABLE_NAME_MOVIE, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Cursor cursorGenre = db.query(MovieItem.TABLE_NAME_GENRE,
                    null,
                    MovieItem.FIELD_GENRES_MOVIE_ID_SQL + " = ? ",
                    new String[] {cursor.getString(cursor.getColumnIndex(MovieItem.FIELD_MOVIES_ID_SQL))},
                    null, null, null);

            while (cursorGenre.moveToNext()) {
                genres.append(cursorGenre.getString(cursor.getColumnIndex(MovieItem.FIELD_GENRES_GENRE)));
                genres.append("; ");
            }

            movieItem = new MovieItem();
            movieItem.setDbId(cursor.getLong(cursor.getColumnIndex(MovieItem.FIELD_MOVIES_ID_SQL)));
            movieItem.setDesc(cursor.getString(cursor.getColumnIndex(MovieItem.FIELD_MOVIES_DESC)));
            movieItem.setTitle(cursor.getString(cursor.getColumnIndex(MovieItem.FIELD_MOVIES_TITLE)));
            movieItem.setGenre(genres.toString());

        }
        db.close();
        return movies;
    }
}
