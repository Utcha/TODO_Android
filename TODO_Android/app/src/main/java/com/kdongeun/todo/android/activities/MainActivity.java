package com.kdongeun.todo.android.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kdongeun.todo.android.R;
import com.kdongeun.todo.android.persistence.BaseActivity;

public class MainActivity extends BaseActivity{

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
