package com.sid.rxjavarxandroidcodingwithmitch.frompublisher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sid.rxjavarxandroidcodingwithmitch.R;

import java.io.IOException;

import okhttp3.ResponseBody;


public class Main2Activity extends AppCompatActivity {
    private final String TAG = Main2Activity.class.getSimpleName();
    private TextView tvResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvResponse = (TextView) findViewById(R.id.tvResponse);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.makeQuery().observe(this, new androidx.lifecycle.Observer<ResponseBody>() {
            @Override
            public void onChanged(ResponseBody responseBody) {
                Log.d(TAG, "onChanged: this is a live data response!");
                try {
                    Log.d(TAG, "onChanged: " + responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}