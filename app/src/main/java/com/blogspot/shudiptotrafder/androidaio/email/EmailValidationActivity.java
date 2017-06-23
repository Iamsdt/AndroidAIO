package com.blogspot.shudiptotrafder.androidaio.email;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blogspot.shudiptotrafder.androidaio.MainActivity;
import com.blogspot.shudiptotrafder.androidaio.R;
import com.blogspot.shudiptotrafder.androidaio.ShowCodeActivity;

import java.util.regex.Pattern;

/**
 * AndroidAIO
 * Created by Shudipto Trafder on 1/10/2017
 */

public class EmailValidationActivity extends AppCompatActivity {

    EditText address,subject,mess;
    Button button;

    // TODO: 6/23/2017 post about email validation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_validation);

        address = (EditText) findViewById(R.id.email_address);
        subject = (EditText) findViewById(R.id.email_subject);
        mess = (EditText) findViewById(R.id.email_body);
        button = (Button) findViewById(R.id.email_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add = address.getText().toString().trim();
                String sub = subject.getText().toString().trim();
                String body = mess.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL,"shudiptotrafder@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT,sub);
                intent.putExtra(Intent.EXTRA_TEXT,body);

                if (validEmailAddress(add)){
                    startActivity(Intent.createChooser(intent,"Sending email vi ..."));
                } else {
                    Snackbar.make(v, "Use valid email address", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });
    }

    private boolean validEmailAddress(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
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
            intent.putExtra(Intent.EXTRA_TEXT, MainActivity.list[1]);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
