package com.bit2016.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static final int TIME_LIMIT = 5;
    private Timer timer = new Timer();
    private TextView tvLastTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLastTime = (TextView)findViewById(R.id.textView2);
        timer.schedule(new GameTimerTask(), 1000, 1000);
    }
    private void updateLastTime(int seconds) {
        tvLastTime.setText(""+(TIME_LIMIT - seconds));
    }

    private class GameTimerTask extends TimerTask {
        private int seconds;

        @Override
        public void run() {
            seconds++;

            if(seconds >= TIME_LIMIT) {
                // 타이머 중지
                timer.cancel();
                Log.i("----->", "타이머 정지");

                // 결과 액티비티 호출 startActivity

                // finish()
                finish();
            }

            // UI 변경
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    updateLastTime(seconds);
                }
            });
        }
    }
}
