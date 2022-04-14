package ru.mirea.mahmoud.b.i.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyDateDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar dateCalender = Calendar.getInstance();
        int year = dateCalender.get(Calendar.YEAR);
        int month = dateCalender.get(Calendar.MONTH);
        int day = dateCalender.get(Calendar.HOUR_OF_DAY);
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener)
                getActivity(), year, month, day);
    }
}
