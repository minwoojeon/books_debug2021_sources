package com.example.samplerecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    RecordHelper recordHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fileName = getExternalCacheDir().getAbsolutePath() + "/" + "test.mp4";
        recordHelper = new RecordHelper(fileName);

        Button btnRecordStart = findViewById(R.id.btnRecordStart);
        Button btnRecordStop = findViewById(R.id.btnRecordStop);

        btnRecordStart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_BUTTON_PRESS)
                    recordHelper.recordStart();
                return false;
            }
        });
        btnRecordStop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_BUTTON_PRESS)
                    recordHelper.recordStop();
                return false;
            }
        });
    }
}