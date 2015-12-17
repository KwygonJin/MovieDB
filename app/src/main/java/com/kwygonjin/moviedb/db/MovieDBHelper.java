package com.kwygonjin.moviedb.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kwygonjin.moviedb.items.MovieItem;

/**
 * Created by KwygonJin on 15.12.2015.
 */
public class MovieDBHelper  extends SQLiteOpenHelper {
    private Context context;

    public MovieDBHelper(Context context) {
        super(context, MovieItem.DATABASE_NAME, null, MovieItem.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MovieItem.CREATE_TABLE_MOVIES);
        db.execSQL(MovieItem.CREATE_TABLE_GENRES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + MovieItem.CREATE_TABLE_MOVIES);
        db.execSQL("DROP TABLE " + MovieItem.CREATE_TABLE_GENRES);
        onCreate(db);
    }
}
