package com.example.masroufi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.masroufi.MainActivity.base;
import static com.example.masroufi.MainActivity.myarraylist;

public class addmasroufi extends AppCompatActivity {
 Button b;
 EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmasroufi);

        b = (Button) findViewById(R.id.bouton);
        e1 = (EditText) findViewById(R.id.thing);
        e2 = (EditText) findViewById(R.id.money);

   b.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

        String thing=e1.getText().toString();
        Integer money=Integer.valueOf(e2.getText().toString());

           Date now = new Date();

           DateFormat dateformatter = DateFormat.getDateInstance(DateFormat.SHORT);
           String date = dateformatter.format(now);

           masrouf newmasrouf=new masrouf(thing,date,money);
           base.addmasrouf(newmasrouf);
           Toast.makeText(addmasroufi.this, " ajouté ", Toast.LENGTH_SHORT).show();
           finish();


       }
   });
    }
}
