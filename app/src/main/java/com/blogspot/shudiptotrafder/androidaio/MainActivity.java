package com.blogspot.shudiptotrafder.androidaio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.blogspot.shudiptotrafder.androidaio.email.EmailValidationActivity;
import com.blogspot.shudiptotrafder.androidaio.fab.FabActivity;
import com.blogspot.shudiptotrafder.androidaio.main.MainAdapter;
import com.blogspot.shudiptotrafder.androidaio.main.SubjectList;
import com.blogspot.shudiptotrafder.androidaio.manager.AlarmManagerActivity;
import com.blogspot.shudiptotrafder.androidaio.string.StringFormatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainAdapter.ItemClickListener {

    private ArrayList<SubjectList> arrayList;


    private static final String logTag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recyView);

        fillUpArray();

        //initialize adapter
        MainAdapter adapter = new MainAdapter(arrayList, this, this);

        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //setting layout manager
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

    }

    //for option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, ShowCodeActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, "main");
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static final String[] list = {
            "Location", "Email", "Fab", "String Format", "Alarm manager" //5

    };

    private void fillUpArray() {

        arrayList = new ArrayList<>();

        for (int i = list.length; i > 0; i--) {
            SubjectList sub = new SubjectList(list[(list.length) - i]);
            arrayList.add(sub);
            sl(String.valueOf(i));
        }

    }


    @Override
    public void itemClick(int id) {
        switch (id) {
            case 0:
                startActivity(new Intent(this, LocationActivity.class));
            case 1:
                startActivity(new Intent(this, EmailValidationActivity.class));
            case 2:
                startActivity(new Intent(this, FabActivity.class));
            case 3:
                startActivity(new Intent(this, StringFormatActivity.class));
            case 4:
                startActivity(new Intent(this, AlarmManagerActivity.class));

        }
    }

    private static void sl(String string) {
        if (BuildConfig.DEBUG) {
            Log.e(logTag, string);
        }
    }
}
