package org.wbing.test;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(onClickListener);
    }

    int dX;
    int dY;

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (dX == 0 || dY == 0) {
                int[] location = new int[2];
                findViewById(R.id.text).getLocationOnScreen(location);

                int[] location2 = new int[2];
                findViewById(R.id.button).getLocationOnScreen(location2);

                dX = location2[0] - location[0]+(findViewById(R.id.button).getWidth()-findViewById(R.id.text).getWidth())/2;
                dY = location2[1] - location[1];
            }

            findViewById(R.id.text)
                    .animate()
                    .cancel();

            findViewById(R.id.text)
                    .animate()
                    .setInterpolator(new EaseCubicInterpolator(.19f, .84f, .62f, 1.07f))
                    .yBy(dY)
                    .xBy(dX)
                    .setListener(animatorListener)
                    .setDuration(500)
                    .start();

        }
    };

    int count;

    Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
            findViewById(R.id.text).setY(0);
            findViewById(R.id.text).setX(0);
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            findViewById(R.id.text).setY(0);
            findViewById(R.id.text).setX(0);

            count++;
            ((TextView)findViewById(R.id.button)).setText(String.valueOf(count));

        }

        @Override
        public void onAnimationCancel(Animator animation) {
            findViewById(R.id.text).setY(0);
            findViewById(R.id.text).setX(0);
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            findViewById(R.id.text).setY(0);
            findViewById(R.id.text).setX(0);
        }
    };
}
