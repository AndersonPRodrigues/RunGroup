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
public class telaInical extends Activity{

    ProgressBar progressBar;
    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);
        progressBar = (ProgressBar)findViewById(R.id.progressBar1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                {
                    progress+=20;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                            if(progress == progressBar.getMax())
                            {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    });

                    try {
                        Thread.sleep(3000);
                    }catch (InterruptedException e){

                    }
                }
            }
        }).start();
    }
}
