package com.example.test3;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter<onCreate> extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_image = {
            R.drawable.fertilizer, R.drawable.pesticides, R.drawable.weather

    };
    public String[] slide_headings = {
            "FERTILIZER", "PESTICIDES", "WEATHER"
    };
    public String[] slide_description = {
            "Enter the required values for getting the information about suitable fertilizer ",
            "Enter the required values for getting the information about suitable pesticide ",
            "Enter the required values for getting the information about suitable fertilizer "

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slide_images = (ImageView) view.findViewById(R.id.imageView);
        TextView slide_head = (TextView) view.findViewById(R.id.textView2);
        TextView slide_desc = (TextView) view.findViewById(R.id.textView3);


        slide_images.setImageResource(slide_image[position]);
        slide_head.setText(slide_headings[position]);
        slide_desc.setText(slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }

}
