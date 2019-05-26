package com.example.threadexample;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import static java.lang.Thread.sleep;


/**
 * Cette activité démontre le fonctionnement d'un Thread.
 * En particulier son lancement et sa terminaison
 */
public class MainActivity extends AppCompatActivity {
    private int mCounter;
    private TextView mText;
    private boolean keepRunning;
    private Thread mThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.tv);

            mThread = new Thread(new Runnable() {
                public void run() {
                    Log.i("THREAD", "Thread Started");
                    while (true) {
                        try {
                            sleep(1000);
                        } catch (InterruptedException ie) {
                        }
                        mCounter++;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mText.setText(String.valueOf(mCounter));
                            }
                        });
                    }
                }
            });

            mThread.start();

    }

}
