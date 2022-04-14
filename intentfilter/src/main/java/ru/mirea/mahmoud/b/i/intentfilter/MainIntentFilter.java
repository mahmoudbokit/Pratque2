package ru.mirea.mahmoud.b.i.intentfilter;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;
import static ru.mirea.mahmoud.b.i.intentfilter.R.id.btnView1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
public class MainIntentFilter extends AppCompatActivity {
    private Button myButton1, myButton2, myBtnToast, myBtnNotification, mySendMessage;
    private TextView myTextView1;
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 1;
    private static final  String CHANNEL_ID = "CHANNEL_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent_filter);
        this.myBtnToast = findViewById(R.id.btnToast);
        this.myButton1 = findViewById(btnView1);
        this.myButton2 = findViewById(R.id.btnView2);
        this.myTextView1 = findViewById(R.id.textView);
        this.mySendMessage = findViewById(R.id.btnSend);
        Button button1, button2, button3, button4;
         button1 = this.myButton1;
         button2 = this.myButton2;
         button3 = this.myBtnToast;

         button3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 myTextView1.setText("Vous avez appuiyez sur la touche ");
                 Toast toast = Toast.makeText(MainIntentFilter.this, "Это ординатор",Toast.LENGTH_LONG);
                 toast.setGravity(Gravity.CENTER,0,0);
                 LinearLayout image = (LinearLayout) toast.getView();
                 ImageView imageView = new ImageView(MainIntentFilter.this);
                 imageView.setImageResource(R.drawable.computer);
                 image.addView(imageView,0);
                 toast.show();
             }
         });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri address = Uri.parse("https://www.mirea.ru/");
                Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
                if (openLinkIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(openLinkIntent);
                }else {
                    Log.d("Intent", "Не получается обработать намерение!");
                }
            }
        });
        mySendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
                intent.putExtra(Intent.EXTRA_TEXT, "ФАМИЛИЯ ИМЯ ОТЧЕСТВО");
                startActivity(Intent.createChooser(intent, "МОИ ФИО"));
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "ФАМИЛИЯ ИМЯ ОТЧЕСТВО");
                startActivity(Intent.createChooser(shareIntent, "МОИ ФИО"));
            }
        });

        notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        this.myBtnNotification = findViewById(R.id.btnNotification);
        button4 = this.myBtnNotification;
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainIntentFilter.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationCompat.Builder notificationCompat =
                        new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                                .setAutoCancel(false)
                                .setSmallIcon(R.drawable.computer)
                                .setWhen(System.currentTimeMillis())
                                .setContentIntent(pendingIntent)
                                .setContentTitle("My title")
                                .setContentText("У вас есть новое уведомление")
                                .setPriority(PRIORITY_HIGH);
                createChannelIfNeeded(notificationManager);
                notificationManager.notify(NOTIFY_ID, notificationCompat.build());
            }
        });
    }
    public static void createChannelIfNeeded(NotificationManager manager){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID,
                    NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}