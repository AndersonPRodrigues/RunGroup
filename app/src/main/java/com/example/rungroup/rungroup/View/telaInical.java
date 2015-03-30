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

    ProgressBar progressBar;
    int progressStatus = 0;
    Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Mostrar a tela inicial
        setContentView(R.layout.tela_inicial);
        // Procura o progress bar
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100)
                {
                    progressStatus += 10;
                    handler.post(new Runnable()
                    {
                        public void run()
                        {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                    try
                    {
                        Thread.sleep(200);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                if (progressStatus==100)
                {
                    Intent i = new Intent(telaInical.this, MainActivity.class);
                    startActivity(i);
                }
            }
        }).start();
    }}