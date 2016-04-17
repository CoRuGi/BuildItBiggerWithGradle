package com.androidnanodegree.cr.jokepresenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class JokePresenter extends AppCompatActivity {

    private static final String newJoke = "com.androidnanodegree.cr.NEW_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_presenter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        TextView jokeTextView = (TextView) findViewById(R.id.joke_text_view);
        String joke = intent.getStringExtra(newJoke);
        if (joke == null) {
            joke = "An unfortunate error occurred. So apparently the joke is on the developer :)";
        }
        if (jokeTextView != null) {
            jokeTextView.setText(joke);
        }
    }

}
