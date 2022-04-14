package ru.mirea.mahmoud.b.i.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class MyProgressDialogFragment {
    Context context;
    Dialog dialog;

    public MyProgressDialogFragment(Context context){
        this.context = context;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void  ShowDialog(String title){
        dialog= new Dialog(context);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView TtextView = dialog.findViewById(R.id.textView2);

        TtextView.setText(title);
        dialog.create();
        dialog.show();
    }
    public void HideDialog(){
        dialog.dismiss();
    }
}
