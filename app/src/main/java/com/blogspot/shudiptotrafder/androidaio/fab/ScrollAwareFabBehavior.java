package com.blogspot.shudiptotrafder.androidaio.fab;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v13.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * AndroidAIO
 * com.blogspot.shudiptotrafder.androidaio.fab
 * Created by Shudipto Trafder on 1/10/2017 at 9:59 PM.
 * Don't modify without permission of Shudipto Trafder
 */

public class ScrollAwareFabBehavior extends FloatingActionButton.Behavior {

    public ScrollAwareFabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       FloatingActionButton child, View directTargetChild,
                                       View target, int nestedScrollAxes) {

        //scrolling axis set to vertical
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout,
                               FloatingActionButton child, View target,
                               int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed,
                dxUnconsumed, dyUnconsumed);


        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            child.hide();

        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE){
            child.show();

        }
    }
}
