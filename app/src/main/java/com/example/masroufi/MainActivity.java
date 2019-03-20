package com.example.masroufi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public static DBadapter base;
ListView masarif;
public static masroufadapter madapter ;
public static ArrayList<masrouf> myarraylist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        masarif = (ListView) findViewById(R.id.liste);

        base=new DBadapter(this);
        myarraylist=new ArrayList<masrouf>();
        myarraylist=base.affichermasrouf();

        madapter=new masroufadapter(this,R.layout.masroufi_item,myarraylist);
        masarif.setAdapter(madapter);

        masarif.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(MainActivity.this).setTitle("delete masrouf").setMessage("SUR!! you haven't spent this money?").setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        base.removemasrouf(myarraylist.get(position).getThing());
                        myarraylist=base.affichermasrouf();

                        madapter=new masroufadapter(MainActivity.this,R.layout.masroufi_item,myarraylist);
                        masarif.setAdapter(madapter);

                    }
                }).setNegativeButton(android.R.string.no,null).setIcon(android.R.drawable.ic_dialog_alert).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.addmasroufi:
                Intent intent=new Intent(this,addmasroufi.class);
                startActivity(intent);
                return true;
            case R.id.somme:
                Intent intent1=new Intent(this,sommemasroufi.class);
                startActivity(intent1);


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        myarraylist=base.affichermasrouf();
        madapter=new masroufadapter(this,R.layout.masroufi_item,myarraylist);
        masarif.setAdapter(madapter);

    }
}
