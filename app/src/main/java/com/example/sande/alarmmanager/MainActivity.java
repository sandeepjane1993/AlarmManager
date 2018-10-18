package com.example.sande.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =findViewById(R.id.editText);
        button = findViewById(R.id.button);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(editText.getText().toString());
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,123,
                        i,0);// sleeps until event occurs
                alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(time*1000),pendingIntent);

            }
        });
    }
}
