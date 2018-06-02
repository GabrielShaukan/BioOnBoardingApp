package com.example.gabriel.bioonboardingapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private android.widget.TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button nxtBtn;
    private Button prevBtn;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        prevBtn = (Button) findViewById(R.id.prevBtn);
        nxtBtn = (Button) findViewById(R.id.nxtBtn);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //OnClickListeners

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position) {

        mDots = new android.widget.TextView[7];
        mDotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++) {
            mDots[i] = new android.widget.TextView(this);
            mDots[i].setText(android.text.Html.fromHtml("&#8226;"));
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0) {

            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));

        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

            mCurrentPage = position;

            if (position == 0) {

                nxtBtn.setEnabled(true);
                prevBtn.setEnabled(false);
                prevBtn.setVisibility(View.INVISIBLE);

                nxtBtn.setText("Next");
                prevBtn.setText("");

            } else if (position == mDots.length - 1) {
                nxtBtn.setEnabled(true);
                prevBtn.setEnabled(true);
                prevBtn.setVisibility(View.VISIBLE);

                nxtBtn.setText("Finish");
                prevBtn.setText("Back");
            } else {
                nxtBtn.setEnabled(true);
                prevBtn.setEnabled(true);
                prevBtn.setVisibility(View.VISIBLE);

                nxtBtn.setText("Next");
                prevBtn.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
