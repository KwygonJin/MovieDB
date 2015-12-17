package com.kwygonjin.moviedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.kwygonjin.moviedb.db.MovieDBManager;
import com.kwygonjin.moviedb.items.MovieItem;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickAddNew(View view) {
        EditText et;
        MovieItem movieItem = new MovieItem();

        et = (EditText)findViewById(R.id.et_title);
        if (et != null)
            if (et.getText() != null)
                movieItem.setTitle(et.getText().toString());

        et = (EditText)findViewById(R.id.et_desc);
        if (et != null)
            if (et.getText() != null)
                movieItem.setDesc(et.getText().toString());

        et = (EditText)findViewById(R.id.et_genre);
        if (et != null)
            if (et.getText() != null)
                movieItem.setGenre(et.getText().toString());

        MovieDBManager movieDBManager = new MovieDBManager(MainActivity.this);
        try {
            movieDBManager.save(movieItem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
