package com.example.kholoud.app;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.spark.submitbutton.SubmitButton;

public class LitterActivity extends AppCompatActivity {

    FloatingActionButton floatingBtn;
    EditText typeBuilding ,phone,numberbags,littertype;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litter);


        //    EditText typeBuilding ,phone,numberbags,littertype;

        floatingBtn =(FloatingActionButton )findViewById(R.id.floatingActionButton);

        typeBuilding=(EditText)findViewById(R.id.et_type);
        phone =(EditText)findViewById(R.id.et_phone);
        numberbags= (EditText)findViewById(R.id.et_numbags);
        littertype = (EditText)findViewById(R.id.et_typebags);


        SubmitButton  submitbutton = (SubmitButton)findViewById(R.id.submitButton);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typeBuildingval = typeBuilding.getText().toString();
                String phoneval = phone.getText().toString();
                String numbagsval = numberbags.getText().toString();
                String litterTypeval = littertype.getText().toString();

                InfoLitterSaved infoLitterSaved =new InfoLitterSaved(typeBuildingval,phoneval,numbagsval,litterTypeval);

                FirebaseDatabase.getInstance().getReference("Litter Data").setValue(infoLitterSaved)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if(task.isSuccessful())
                                {
                                    Toast.makeText(LitterActivity.this,R.string.DataSaved ,Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(LitterActivity.this,R.string.DatanotSaved ,Toast.LENGTH_SHORT).show();

                                }
                            }
                        });




            }
        });



        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentHome = new Intent(LitterActivity.this,ConnectUsActivity.class);
                startActivity(IntentHome);

            }
        });

    }



}
