package com.example.kholoud.app;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
CurvedBottomNavigationView bottomNavigationView;
VectorMasterView feb1,feb2,feb3;
RelativeLayout lin_id;
PathModel outline;
    Animation frombutton, fromtop;

    ImageView LocationSign;
    ImageView   imagesend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //******************************************************************
        bottomNavigationView =(CurvedBottomNavigationView )findViewById(R.id.bottom_nav);
        feb1=(VectorMasterView)findViewById(R.id.feb1);
        feb2=(VectorMasterView)findViewById(R.id.feb2);
        feb3=(VectorMasterView)findViewById(R.id.feb3);
        lin_id=(RelativeLayout)findViewById(R.id.lin_id);
        bottomNavigationView.inflateMenu(R.menu.main_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        LocationSign= (ImageView)findViewById(R.id.LocationSignImage);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.bounce);
        LocationSign.setAnimation(fromtop);

        imagesend =(ImageView)findViewById(R.id.ImageSend);



        imagesend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Animation animation=  AnimationUtils.loadAnimation(MainActivity.this,R.anim.bounce);
                imagesend.startAnimation(animation);
                Intent IntentHome = new Intent(MainActivity.this,LitterActivity.class);
                startActivity(IntentHome);

            }
        });


        LocationSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation=  AnimationUtils.loadAnimation(MainActivity.this,R.anim.mixed_anim);
                LocationSign.startAnimation(animation);
                Intent IntentHome = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(IntentHome);

            }
        });
//************************************************************************

    }

    public void showMyLocation(View view) {
        startActivity(new Intent(getApplicationContext(),MapsActivity.class));
    }




















































































    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {





        switch (item.getItemId()){


            case R.id.action_event:
                //Toast.makeText(this,"click to Events&Articles",Toast.LENGTH_SHORT).show();
                draw(6);
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                feb1.setVisibility(View.VISIBLE);
                feb2.setVisibility(View.GONE);
                feb3.setVisibility(View.GONE);
                Intent intent1 = new Intent(MainActivity.this,EventActivity.class);
                startActivity(intent1);

                drawAnimation(feb1);
                break;


            case R.id.action_Profile:
               // Toast.makeText(this,"click to Litter",Toast.LENGTH_SHORT).show();
                draw(2);
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                feb1.setVisibility(View.GONE);
                feb2.setVisibility(View.VISIBLE);
                feb3.setVisibility(View.GONE);
Intent intent2 = new Intent(MainActivity.this,MainActivity.class);
startActivity(intent2);

                drawAnimation(feb2);
                break;

            case R.id.action_sitting:
               // Toast.makeText(this,"click to Sitting",Toast.LENGTH_SHORT).show();
                draw();
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                feb1.setVisibility(View.GONE);
                feb2.setVisibility(View.GONE);
                feb3.setVisibility(View.VISIBLE);
                Intent intent3 = new Intent(MainActivity.this,SittingActivity.class);
                startActivity(intent3);
                drawAnimation(feb3);
                break;










        }

        return true;
    }

    /*****************************************/
    private void draw() {

bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth*10/12)
-(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)
-(bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);



        bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth*10/12,bottomNavigationView.CURVE_CIRCLE_RADIUS
                +(bottomNavigationView.CURVE_CIRCLE_RADIUS/4));




        bottomNavigationView.mSecondCurveStartPoint=bottomNavigationView.mFirstCurveEndPoint;


        bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth*10/12)
                +(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)+(bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);



        bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x+
                bottomNavigationView.CURVE_CIRCLE_RADIUS+(bottomNavigationView.CURVE_CIRCLE_RADIUS/4),
                bottomNavigationView.mFirstCurveStartPoint.y);





        bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x-
                        (bottomNavigationView.CURVE_CIRCLE_RADIUS*2)+bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mFirstCurveEndPoint.y);




// second



        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x
                        +(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)-bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mSecondCurveStartPoint.y);




        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x-
                (bottomNavigationView.CURVE_CIRCLE_RADIUS+(bottomNavigationView.CURVE_CIRCLE_RADIUS/4)),bottomNavigationView.mSecondCurveEndPoint.y);










    }
    private void drawAnimation(final VectorMasterView feb1) {




outline=feb1.getPathModelByName("outline");
outline.setStrokeColor(Color.WHITE);
outline.setTrimPathEnd(0.0f);

        final ValueAnimator valueAnimator= ValueAnimator.ofFloat(0.0f,1.0f );
        valueAnimator.setDuration(1000);

valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    @Override
    public void onAnimationUpdate(ValueAnimator animation) {

outline.setTrimPathEnd((float)animation.getAnimatedValue());

feb1.update();


    }
});


valueAnimator.start();










    }
    private void draw(int i) {

    bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth/i)
     -(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)-(bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);



    bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth/i,bottomNavigationView.CURVE_CIRCLE_RADIUS
    +(bottomNavigationView.CURVE_CIRCLE_RADIUS/4));





    bottomNavigationView.mSecondCurveStartPoint=bottomNavigationView.mFirstCurveEndPoint;

    bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth/i)
            +(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)+(bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);





    bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x+
                    bottomNavigationView.CURVE_CIRCLE_RADIUS+ (bottomNavigationView.CURVE_CIRCLE_RADIUS/4),
            bottomNavigationView.mFirstCurveStartPoint.y);




    bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x-
            (bottomNavigationView.CURVE_CIRCLE_RADIUS*2)+bottomNavigationView.CURVE_CIRCLE_RADIUS,
            bottomNavigationView.mFirstCurveEndPoint.y);




// second



        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x
                +(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)-bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mSecondCurveStartPoint.y);




        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x-
                (bottomNavigationView.CURVE_CIRCLE_RADIUS+(bottomNavigationView.CURVE_CIRCLE_RADIUS/4)),bottomNavigationView.mSecondCurveEndPoint.y);













    }
    /*****************************************/


}
