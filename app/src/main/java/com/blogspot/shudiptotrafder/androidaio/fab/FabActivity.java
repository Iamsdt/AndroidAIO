package com.blogspot.shudiptotrafder.androidaio.fab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import com.blogspot.shudiptotrafder.androidaio.R;

/**
 * AndroidAIO
 * Created by Shudipto Trafder on 1/10/2017
 */

public class FabActivity extends AppCompatActivity {

    //NestedScrollView scrollView;

    // TODO: 6/23/2017 fix fab scroll
    // TODO: 6/23/2017 post about scroll view with fab hide

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);



        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabActivity);

//        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY > oldScrollY){
//                    if (fab.isShown()){
//                        fab.hide();
//
//                    } else {
//                        fab.show();
//                    }
//                }
//            }
//        });

    }
}
