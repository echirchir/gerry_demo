package com.simpledeveloper.superclick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AppCompatButton goBackToPreviousActivity = (AppCompatButton) findViewById(R.id.go_back);
        TextView counterStats = (TextView) findViewById(R.id.counter);

        Intent intent = getIntent();

        int countTotalFromLastActivity = intent.getExtras().getInt("counter");

        counterStats.setText("" + countTotalFromLastActivity);

        goBackToPreviousActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(returnIntent);
            }
        });
    }

}
