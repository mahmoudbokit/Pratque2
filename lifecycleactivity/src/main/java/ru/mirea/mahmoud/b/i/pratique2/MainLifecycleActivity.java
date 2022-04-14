package ru.mirea.mahmoud.b.i.pratique2;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import javax.net.ssl.SSLSessionBindingListener;

public class MainLifecycleActivity extends AppCompatActivity {

    private static final String ANS = "answers";
    private ArrayList<Integer> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main_lifecycle);
        Log.i(MainLifecycleActivity.class.getName(), "onCreate");
        load(state);
    }

    public void answer(View view) {
        ((Button) view).setText("X");
        answers.add(view.getId());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MainLifecycleActivity.class.getName(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MainLifecycleActivity.class.getName(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MainLifecycleActivity.class.getName(), "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MainLifecycleActivity.class.getName(), "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(MainLifecycleActivity.class.getName(), "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MainLifecycleActivity.class.getName(), "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(MainLifecycleActivity.class.getName(), "onSaveInstanceState");
        outState.putIntegerArrayList(ANS, answers);
    }
    private void load(Bundle state){
        if (state!=null){
            for (Integer id : state.getIntegerArrayList(ANS)){
                Button button = findViewById(id);
                button.setText("X");
                answers.add(button.getId());
            }
        }
    }

}