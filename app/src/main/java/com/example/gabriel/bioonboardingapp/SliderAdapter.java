package com.example.gabriel.bioonboardingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    public  int[] slide_Img = {
            R.drawable.photo,
            R.drawable.android,
            R.drawable.c_logo,
            R.drawable.circuit_board,
            R.drawable.coding,
            R.drawable.folder,
            R.drawable.karaoke,
            R.drawable.playstation
    };

    public String[] slide_Headings = {
            "Gabriel Shaukan",
            "Android",
            "C++",
            "Electrical Engineering",
            "Code",
            "Frontend Web Development",
            "Sing",
            "Games"
    };

    public String[] slide_Desc = {
            "I'm a 21 year old electrical engineering student in my 4th semester at the Karlsruhe Institute of Technology. I like to code, design UI, sing, and play games. I am still figuring out what I am doing with my life. But hey, nice to meet you!",
            "I became interested in android development around a month ago. Since than I have learned a little bit of Java and created simple apps with Thunkable and Android Studio, including this OnBoarding about me app.",
            "C++ is a language that has been extensively used during my studies. As an electrical engineer C++ is the way we communicate with hardware. Some of the things I have done include creating the software for an ADC sensor of a segway and programming LEDs on a simple circuit board.",
            "Electronic devices and computers have always fascinated me since I was little, math and science have also been something I loved. In electrical engineering I get to work with those things and more.",
            "Programming has always been a passion  of mine and I have been coding since I was 17 years old. I think that software is the future and a very powerful tool, only today can someone change the world with only a computer and an idea.",
            "In my spare time I learned the fundamentals of frontend web development and it has become a hobby of mine. Some projects include simple games, a painting app and an profile website for a startup.",
            "I love to sing and some people say that I sound kind of good too. Been playing in bands since middle school as a guitarist and vocalist. This is the more artistic side of me bar UI design and such.",
            "The love of my life video games. I love games, they take me to another world where all my worries go away. I have been playing games ever since i could turn on a computer and I'm pretty good at them. Games design is also something i find very interesting and would love to work on in tbe future."
    };

    @Override
    public int getCount() {
        return slide_Headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImg = (ImageView) view.findViewById(R.id.slideImg);
        TextView slideHeading = (TextView) view.findViewById(R.id.slideHeading);
        TextView slideDesc = (TextView) view.findViewById(R.id.slideDesc);

        slideImg.setImageResource(slide_Img[position]);
        slideHeading.setText(slide_Headings[position]);
        slideDesc.setText(slide_Desc[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);

    }
}
