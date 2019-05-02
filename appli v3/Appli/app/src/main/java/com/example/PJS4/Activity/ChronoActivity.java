package com.example.PJS4.Activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appli.R;

import java.util.Locale;

public class ChronoActivity extends AppCompatActivity {

    private long mStartTime;
    private TextView mTextChrono;
    private Button mBtnStop;
    private CountDownTimer mCountDownTimer;
    private long mTimeLeft;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrono);

        mTextChrono = (TextView) findViewById(R.id.textView_time);
        mBtnStop = (Button) findViewById(R.id.button_stop);

        mStartTime = getIntent().getIntExtra("temps_repos",0)*1000;
        mTimeLeft = mStartTime;

        startTimer();

        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeft = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                finish();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeft / 1000) / 60;
        int secondes = (int) (mTimeLeft / 1000) % 60;

        String time = String.format(Locale.getDefault(),"%02d:%02d",minutes,secondes);
        mTextChrono.setText(time);
    }
}
