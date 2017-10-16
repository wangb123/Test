package org.wbing.test.refreshlayout.view.headers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.wbing.test.refreshlayout.view.ILoadingLayout;
import org.wbing.test.refreshlayout.view.RefreshLayout;
import org.wbing.test.refreshlayout.view.utils.RefreshLayoutIndicator;
import org.wbing.test.refreshlayout.view.utils.RefreshLayoutUIHandlerHook;


/**
 * Created by suitian on 2017/1/3.
 */

public class IdsSnobHeaderView extends LinearLayout implements ILoadingLayout {



    public IdsSnobHeaderView(Context context) {
        this(context, null);
    }

    public IdsSnobHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public void onUIReset(RefreshLayout frame) {
    }

    @Override
    public void onUIRefreshPrepare(RefreshLayout frame) {

    }

    @Override
    public void onUIRefreshPrepared(RefreshLayout frame) {

    }

    @Override
    public void onUIRefreshBegin(RefreshLayout frame) {

    }

    @Override
    public void onUIRefreshComplete(RefreshLayout frame) {

    }

    @Override
    public void onUIPositionChange(RefreshLayout frame, boolean isUnderTouch, byte status, RefreshLayoutIndicator ptrIndicator) {

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(hook);
    }

    private RefreshLayoutUIHandlerHook hook = new RefreshLayoutUIHandlerHook() {

        @Override
        public void run() {

        }
    };
}
