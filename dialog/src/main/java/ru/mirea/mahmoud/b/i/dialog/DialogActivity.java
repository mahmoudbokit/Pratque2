package ru.mirea.mahmoud.b.i.dialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class DialogActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    MyProgressDialogFragment myProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button button = findViewById(R.id.btnProgress);
        Button button1 = findViewById(R.id.btnTimePicker);
        Button button2 = findViewById(R.id.btnDatePicker);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new MyDateDialogFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new MyTimeDialogFragment();
                timePicker.show(getSupportFragmentManager(), "Time Picker");
            }
        });

        myProgressDialog = new MyProgressDialogFragment(this);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                myProgressDialog.ShowDialog("ProgressDialog");

            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day_of_month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day_of_month);

        String cDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textView = (TextView) findViewById(R.id.textViewTimePicker);
        textView.setText(cDateString);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour_of_day, int minute) {
        TextView textView = (TextView) findViewById(R.id.textViewTimePicker);
        textView.setText("Time is "+hour_of_day+"hours "+minute+"minutes");

    }

    public void onClickShowDialog(View view) {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }
    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }
}