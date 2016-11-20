package com.power2sme.fsme.finansme;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.codetail.animation.ViewAnimationUtils;

public class IntroActivity extends AppCompatActivity {
    ViewPager viewPager;
    CustomSwipePagerAdapter adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        final View myView = findViewById(R.id.activity_intro);
        myView.post(new Runnable() {
            @Override
            public void run() {
                int cx = myView.getWidth() / 2;
                int cy = myView.getHeight() / 2;

// get the final radius for the clipping circle
                float finalRadius = (float) Math.hypot(cx, cy);

// create the animator for this view (the start radius is zero)
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
                anim.setInterpolator(new FastOutSlowInInterpolator());
                anim.setDuration(500);
                anim.start();
            }
        });
        viewPager = (ViewPager) findViewById(R.id.intro_view_pager);
        adaptor = new CustomSwipePagerAdapter(this);
        viewPager.setAdapter(adaptor);
    }

    public class CustomSwipePagerAdapter extends PagerAdapter{
        private Context context;
        private LayoutInflater inflator;
        private int[] images = {R.drawable.apply_loan_hover,R.drawable.credit_e_hover,R.drawable.credit_d_hover,R.drawable.credit_repay_hover};
        private String[] title = {"1 Apply For Loan ","2 Credit Evaluation ","3 Credit Disbursement ","4 Credit Repayment "};
        public CustomSwipePagerAdapter(Context  context){
            this.context = context;
            inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==(FrameLayout)object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = inflator.inflate(R.layout.intro_view_pager_view,container,false);
            Log.d("intro", "instantiateItem: ");
            ImageView img = (ImageView) v.findViewById(R.id.intro_img);
            TextView tv = (TextView) v.findViewById(R.id.intro_title);
            img.setImageResource(images[position]);
            tv.setText(title[position]);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((FrameLayout)object);
        }
    }
}
