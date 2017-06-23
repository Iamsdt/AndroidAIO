package com.blogspot.shudiptotrafder.androidaio.string;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.blogspot.shudiptotrafder.androidaio.MainActivity;
import com.blogspot.shudiptotrafder.androidaio.R;
import com.blogspot.shudiptotrafder.androidaio.ShowCodeActivity;

public class StringFormatActivity extends AppCompatActivity {


    //todo string format

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_formate);

        TextView textView = (TextView) findViewById(R.id.stf_second);

        String name = "Run time change";

        textView.setText(getString(R.string.stf,name));

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
            Intent intent = new Intent(this,ShowCodeActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, MainActivity.list[5]);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
