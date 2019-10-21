package com.example.kholoud.app;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {


    private ViewPager mslidViewPager;
    private LinearLayout BotsLinear;
    private SliderAdapter sliderAdapter;
    private TextView []dots;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarevent);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        mslidViewPager =(ViewPager) findViewById(R.id.slidViewPager);
        BotsLinear =(LinearLayout)findViewById(R.id.dotsLayout);
        sliderAdapter= new SliderAdapter(this);

        mslidViewPager.setAdapter(sliderAdapter);
        addindecators();


    }



    public  void  addindecators(){

dots =new  TextView[23];
for(int i =0;i<dots.length;i++)
{
    dots[i]=new TextView(this);
    dots[i].setText(Html.fromHtml("&#8226;"));
    dots[i].setTextSize(35);
    dots[i].setTextColor(getResources().getColor(R.color.colorWhite));
    BotsLinear.addView((dots[i]));
}

    }















}
