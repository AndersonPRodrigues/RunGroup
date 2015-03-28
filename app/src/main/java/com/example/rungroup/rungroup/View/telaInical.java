package com.example.rungroup.rungroup.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.rungroup.rungroup.MainActivity;
import com.example.rungroup.rungroup.R;

/**
 * Created by Anderson on 27/03/2015.
 */
public class telaInical extends Activity {
    private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.tela_inicial);

        mProgress = (ProgressBar) findViewById(R.id.progress_bar);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
    }
}