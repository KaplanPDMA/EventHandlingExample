package com.kaplan.pdma.eventhandlingexample;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.StatusTextView);
        final TextView TimingRemaining = (TextView) findViewById(R.id.TimeRemaining);
        Button button = (Button) findViewById(R.id.MyButton);
        button.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            Boolean done = false;

            CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {

                public void onTick(long millisUntilFinished) {
                    TimingRemaining.setText(""+ (millisUntilFinished/1000) +"s");
                }

                public void onFinish() {
                    done = true;
                    textView.setText("You had clicked " + count + " times in 10s");
                    TimingRemaining.setText("Time's up");
                }
            };

            @Override
            public void onClick(View view) {
                if(!done) {
                    if(count == 0) {
                        countDownTimer.start(); //start on first click
                    }

                    textView.setText("clicked " + (++count) + " times");
                }
            }
        });

    }
}
