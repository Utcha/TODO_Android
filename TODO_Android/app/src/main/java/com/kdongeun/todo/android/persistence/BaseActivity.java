package com.kdongeun.todo.android.persistence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kdongeun.todo.android.R;

import static android.transition.Visibility.MODE_IN;
import static android.transition.Visibility.MODE_OUT;

/**
 * Created by kdongeun on 11/29/2017.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    protected ViewGroup container;

    public void setContainer(ViewGroup container) {
        this.container = container;
    }

    /**
     * Toast
     */
    //TODO : SNACK BAR 추가
    @UiThread
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @UiThread
    public void showToast(String message, int duration) {
        Toast.makeText(this, message, duration).show();
    }

    /**
     * Preferences
     */

    protected String getPreference(String key){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        return pref.getString(key, "");
    }

    protected void savePreference(String key, int value) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);

        editor.commit();
    }

    protected void savePreference(String key, boolean value) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);

        editor.commit();
    }

    protected void savePreference(String key, String value) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);

        editor.commit();
    }

    public void moveToActivity(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
    }

    public void finishOK() {
        setResult(RESULT_OK);
        finish();
    }

    public void finishOK(Intent intent) {
        setResult(RESULT_OK, intent);
        finish();
    }
}
