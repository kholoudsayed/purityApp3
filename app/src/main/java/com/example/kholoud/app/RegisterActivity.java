package com.example.kholoud.app;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.lang.reflect.Member;

public class RegisterActivity extends AppCompatActivity {
    static int PReqCode = 1;
    FirebaseDatabase database;
    DatabaseReference ref;
    static int REQUESCODE = 1;
    Uri pickedImgUri;
    private RelativeLayout rlayout;
    private Animation animation;
    private Menu menu;


    private EditText Email, Password, Phone, username;
    private Button Register_Btn;
    ImageView User_Image;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        rlayout = findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        rlayout.setAnimation(animation);


        Email = findViewById(R.id.etEmail);
        Password = findViewById(R.id.etPassword);
        username = findViewById(R.id.etUsername);
        Register_Btn = findViewById(R.id.btLogin);
        database = FirebaseDatabase.getInstance();





       mAuth = FirebaseAuth.getInstance();



        Register_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String email = Email.getText().toString();
                final String pass = Password.getText().toString();
                final String UsrNam = username.getText().toString();

                if(email.isEmpty()) {
                    Email.setError("Please Enter Email. ");
                    Email.requestFocus();

                }
                else if (pass.isEmpty())
                {
                    Password.setError("Please Enter Valid pass ");
                    Password.requestFocus();
                }

                else if (UsrNam.isEmpty())
                {
                    username.setError("Please Enter Valid pass ");
                    username.requestFocus();
                }
                else if (pass.isEmpty() && email.isEmpty() &&UsrNam.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this,"Fields Are Empty !",Toast.LENGTH_SHORT).show();
                }
                else if (!(pass.isEmpty() && email.isEmpty()  &&UsrNam.isEmpty())) {
                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this,"Sign Up Unsuccessful ! , Please Try Again.",Toast.LENGTH_SHORT).show();


                            }else {
                                startActivity( new Intent(RegisterActivity.this,MainActivity.class));

                            }
                        }
                    });

                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Error occurred ! ",Toast.LENGTH_SHORT).show();

                }
            }
        });





        User_Image = findViewById(R.id.photoReg);
        User_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= 22) {
                    CheckAndReguestForPremession();
                } else {
                    OpenGallery();
                }
            }
        });


    }




    private void UpdateUserInfo(final String usrNam, Uri pickedImgUri, final FirebaseUser currentUser) {

        StorageReference mStorage = FirebaseStorage.getInstance().getReference().child("users_photos");
        final StorageReference imageFilePath = mStorage.child(pickedImgUri.getLastPathSegment());
        imageFilePath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {


                        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder().setDisplayName(usrNam).setPhotoUri(uri).build();


                        currentUser.updateProfile(profileUpdate).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Register Complete ", Toast.LENGTH_SHORT).show();


                                    updateUI();

                                }
                            }
                        });


                    }
                });


            }
        });


    }

    private void updateUI() {

        Intent t = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(t);
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null) {
            pickedImgUri = data.getData();
            User_Image.setImageURI(pickedImgUri);
        }


    }

    private void CheckAndReguestForPremession() {
        int result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result != PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {


                Toast.makeText(RegisterActivity.this, "Please Accept for required Permission ", Toast.LENGTH_SHORT).show();


            } else {


                ActivityCompat.requestPermissions(RegisterActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PReqCode);
            }


        } else {
            OpenGallery();
}


    }

    private void OpenGallery() {

        Intent galleryintent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryintent.setType("image/*");
        startActivityForResult(galleryintent, REQUESCODE);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

