package com.simpledeveloper.superclick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private AppCompatButton mAddToCounter;
    private AppCompatButton mResetCounter;
    private AppCompatButton mSwitchActivity;
    private TextView mCounter;
    private int counterTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAddToCounter   = (AppCompatButton) findViewById(R.id.addCounter);
        mResetCounter   = (AppCompatButton) findViewById(R.id.resetCounter);
        mSwitchActivity = (AppCompatButton) findViewById(R.id.switchActivity);
        mCounter        = (TextView) findViewById(R.id.counter);

        mAddToCounter.setOnClickListener(this);
        mResetCounter.setOnClickListener(this);
        mSwitchActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addCounter:
                counterTotal++;
                mCounter.setText(""+ counterTotal);
                break;
            case R.id.resetCounter:
                counterTotal = 0;
                mCounter.setText(""+counterTotal);
                break;
            case R.id.switchActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("counter", counterTotal);
                startActivity(intent);
                break;
        }
    }
}
