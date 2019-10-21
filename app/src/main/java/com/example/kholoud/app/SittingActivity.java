package com.example.kholoud.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SittingActivity extends AppCompatActivity {
CardView cardme;
    CardView cardshare;
    CardView cardabout;
    CardView cardExit;
    CardView cardConnect;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolsitting);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");


        cardshare =(CardView)findViewById(R.id.ShareCard);
        cardshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });

        cardExit =(CardView)findViewById(R.id.ExitCard);

        cardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent h = new Intent(SittingActivity.this,SignInActivity.class);
                startActivity(h);
            }
        });



        cardabout =(CardView)findViewById(R.id.AboutAsCard);

        cardabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent t= new Intent(SittingActivity.this,AboutAsActivity.class);
                startActivity(t);

            }
        });

        cardConnect=(CardView)findViewById(R.id.connectusCard);
        cardConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a= new Intent(SittingActivity.this,ConnectUsActivity.class);
                startActivity(a);

            }
        });



    }
}
