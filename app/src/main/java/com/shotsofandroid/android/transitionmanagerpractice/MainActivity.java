package com.shotsofandroid.android.transitionmanagerpractice;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.shotsofandroid.android.transitionmanagerpractice.databinding.ActivityMainBinding;

public class MainActivity
        extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setInstance(this);
    }

    int state = 0;
    public void switchViews() {
        TransitionManager.beginDelayedTransition(mBinding.container, new AutoTransition());
        /*View v1 = mBinding.container.getChildAt(0);
        mBinding.container.removeViewAt(0);
        mBinding.container.addView(v1, 1);*/
        /*if (mBinding.v1.getVisibility() == View.VISIBLE) {
            mBinding.v1.setVisibility(View.GONE);
            mBinding.c21.setVisibility(View.VISIBLE);
        } else {
            mBinding.v1.setVisibility(View.VISIBLE);
            mBinding.c21.setVisibility(View.GONE);
        }*/
        if (state == 0) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(60, ViewGroup.LayoutParams.MATCH_PARENT);
            mBinding.c1.setLayoutParams(params);
            mBinding.c1.setGravity(Gravity.CENTER_VERTICAL);
            mBinding.c2.setGravity(Gravity.CENTER);
            state = 1;
        } else {
            state = 0;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 1;
            mBinding.c1.setLayoutParams(params);
            mBinding.c1.setGravity(Gravity.CENTER_VERTICAL);
            mBinding.c2.setGravity(Gravity.CENTER_VERTICAL);
        }
    }
}
