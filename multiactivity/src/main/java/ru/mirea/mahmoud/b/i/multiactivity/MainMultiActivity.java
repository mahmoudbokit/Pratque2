package ru.mirea.mahmoud.b.i.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMultiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_multi);

    }

    public void onClickNewActivity(View view) {
        /*Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);*/

        Intent intent = new Intent(MainMultiActivity.this, SecondActivity.class);
        intent.putExtra("key", "MIREA - ФАМИЛИЯ ИМЯ ОТЧЕТСВО СТУДЕНТА");
        startActivity(intent);
        TextView  textView = (TextView) findViewById(R.id.textView);
        String text = (String) getIntent().getSerializableExtra("Key");
        textView.setText(text);
    }
}