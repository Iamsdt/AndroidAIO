package com.blogspot.shudiptotrafder.androidaio.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * AndroidAIO
 * com.blogspot.shudiptotrafder.androidaio.main
 * Created by Shudipto Trafder on 1/3/2017 at 2:50 PM.
 * Don't modify without permission of Shudipto Trafder
 */

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener{

    private ClickListener listener;
    private GestureDetector gestureDetector;

    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView
                                     , final ClickListener listener) {
        this.listener = listener;

        gestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View view = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if (view != null && listener != null){
                    listener.clickLongListener(view,recyclerView.getChildAdapterPosition(view));
                }
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                return super.onDoubleTap(e);
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View view = rv.findChildViewUnder(e.getX(),e.getY());

        if (view != null &&  listener!= null){
            listener.clickListener(view,rv.getChildAdapterPosition(view));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
