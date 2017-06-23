package com.blogspot.shudiptotrafder.androidaio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class ShowCodeActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_code);

        webView = (WebView) findViewById(R.id.show_code_webview);

        Intent intent = getIntent();

        String s = intent.getStringExtra(Intent.EXTRA_TEXT);

        String url = null;

        if (s.equals("main")){
            url = "file:///android_res/raw/main.html";

        } else if (s.equals(MainActivity.list[0])){
            url = "file:///android_res/raw/.html";

        } else if (s.equals(MainActivity.list[1])){
            url = "file:///android_res/raw/emailvalidation.html";

        }else if (s.equals(MainActivity.list[2])){
            url = "file:///android_res/raw/.html";

        }else if (s.equals(MainActivity.list[3])){
            url = "file:///android_res/raw/.html";

        }else if (s.equals(MainActivity.list[4])){
            url = "file:///android_res/raw/.html";

        }else if (s.equals(MainActivity.list[5])){
            url = "file:///android_res/raw/stf.html";

        }else if (s.equals(MainActivity.list[6])){
            url = "file:///android_res/raw/.html";

        }else if (s.equals(MainActivity.list[7])){
            url = "file:///android_res/raw/.html";

        }else if (s.equals(MainActivity.list[8])){
            url = "file:///android_res/raw/.html";

        }else if (s.equals(MainActivity.list[9])){
            url = "file:///android_res/raw/.html";

        }else if (s.equals(MainActivity.list[10])){
            url = "file:///android_res/raw/.html";

        }else if (s.equals(MainActivity.list[11])){
            url = "file:///android_res/raw/.html";

        }else if (s.equals(MainActivity.list[12])){
            url = "file:///android_res/raw/.html";

        }

        webView.loadUrl(url);

    }

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
