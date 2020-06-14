package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;

import java.util.concurrent.ConcurrentHashMap;

//定期的処理①　メソッドの使用宣言
public class MainActivity extends AppCompatActivity implements Chronometer.OnChronometerTickListener {

    int i = 0; //表示回数のカウント

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //スタート
    public void onStart(View v) {
        ((Chronometer) findViewById(R.id.c)).setBase(SystemClock.elapsedRealtime());
        ((Chronometer) findViewById(R.id.c)).start();

        //定期的処理③ 処理スタート
        ((Chronometer) findViewById(R.id.c)).setOnChronometerTickListener(this);


    }

    public void onStop(View v) {
        ((Chronometer) findViewById(R.id.c)).stop();
        ((ImageView) findViewById(R.id.iv)).setImageResource(R.drawable.cat0);
    }

    public void onReset(View v) {
        ((Chronometer) findViewById(R.id.c)).setBase(SystemClock.elapsedRealtime());
        ((ImageView) findViewById(R.id.iv)).setImageResource(R.drawable.cat3);
    }

    //定期的処理②　約一秒ごとに実行する具体的な処理
    @Override
    public void onChronometerTick(Chronometer chronometer) {
        i++;
        if (i % 2 == 0) {
            ((ImageView) findViewById(R.id.iv)).setImageResource(R.drawable.cat1);
        } else {
            ((ImageView) findViewById(R.id.iv)).setImageResource(R.drawable.cat2);
        }
    }

}