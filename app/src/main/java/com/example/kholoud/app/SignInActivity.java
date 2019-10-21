package com.example.kholoud.app;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Pair;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btRegister;
    TextView tvLogin;

 private   EditText EmailID;
 private   EditText Password;
 FirebaseAuth mFirebaseAuth;
  private   Button btnSignIn;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btRegister  = findViewById(R.id.btRegister);
        tvLogin     = findViewById(R.id.tvLogin);
        EmailID = findViewById(R.id.etEmail);
        Password =findViewById(R.id.etPassword);
        btnSignIn =findViewById(R.id.btLogin);
        mFirebaseAuth =FirebaseAuth.getInstance();

        btRegister.setOnClickListener(this);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser =mFirebaseAuth.getCurrentUser();

                if(mFirebaseUser != null ) {
                    Toast.makeText(SignInActivity.this, "You Are Logged in. ", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(SignInActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(SignInActivity.this, "Please Log in  ", Toast.LENGTH_SHORT).show();

                }

            }
        };

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EmailView = EmailID.getText().toString();
                String PassView = Password.getText().toString();
                if(EmailView.isEmpty()) {
                    EmailID.setError("Please Enter Email. ");
                    EmailID.requestFocus();

                }
                else if (PassView.isEmpty())
                {
                    Password.setError("Please Enter Valid pass ");
                    Password.requestFocus();
                }

                else if (PassView.isEmpty() && EmailView.isEmpty())
                {
                    Toast.makeText(SignInActivity.this,"Fields Are Empty !",Toast.LENGTH_SHORT).show();
                }
                else if (!(PassView.isEmpty() && EmailView.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(EmailView,PassView).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){

                                Toast.makeText(SignInActivity.this,"Log in Error !, Please Try again . ",Toast.LENGTH_SHORT).show();

                            }
                            else {
                                Intent IntentHome = new Intent(SignInActivity.this,MainActivity.class);
                                startActivity(IntentHome);
                            }
                        }
                    });

                }
                else
                {
                    Toast.makeText(SignInActivity.this,"Error occurred ! ",Toast.LENGTH_SHORT).show();


                }

            }
        });






















    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v==btRegister){
            Intent a = new Intent(SignInActivity.this, RegisterActivity.class);
            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View,String> (tvLogin,"login");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SignInActivity.this,pairs);
            startActivity(a,activityOptions.toBundle());
        }
    }










    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }


}


