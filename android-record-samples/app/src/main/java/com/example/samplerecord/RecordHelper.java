package com.example.samplerecord;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.util.Log;

public class RecordHelper
{
    public String SAMPLE_RECORD_FILE = null;

//    private MediaPlayer player;
    private MediaRecorder recorder;

    public RecordHelper(String fileName)
    {
        this.SAMPLE_RECORD_FILE = fileName;
    }
    public void recordStart()
    {
        if(SAMPLE_RECORD_FILE == null) return;
        if(this.recorder != null)
        {
            recordStop();
        }
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        recorder.setOutputFile(SAMPLE_RECORD_FILE);
        try
        {
            recorder.prepare();
            recorder.start();
            Log.d("System : ", "녹음이 시작 되었습니다.");
        }catch (Exception e)
        {
            Log.d("Error : ", e.getMessage());
            e.getStackTrace();
        }
    }
    public void recordStop()
    {
        if (recorder == null) return;

        recorder.stop();
        recorder.release();
        recorder = null;
        Log.d("System : ", "녹음이 중지 되었습니다.");
    }
}
