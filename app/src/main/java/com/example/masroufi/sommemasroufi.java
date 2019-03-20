package com.example.masroufi;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import static com.example.masroufi.MainActivity.base;

public class sommemasroufi extends AppCompatActivity {
TextView t1,t2;
long date;
static int somme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sommemasroufi);

        t1 = (TextView) findViewById(R.id.som);
        t2 = (TextView) findViewById(R.id.date);

        t1.setText(Integer.toString(base.total()));

        date = 0;
        try {
            date = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(),0)
                    .firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        // Format the date time
        String dateString = DateFormat
                .format("dd/MM/yyyy   hh:mm:ss", new Date(date))
                .toString();

        t2.setText(dateString);

    }
}
