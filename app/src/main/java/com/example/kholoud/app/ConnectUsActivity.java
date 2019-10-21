package com.example.kholoud.app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConnectUsActivity extends AppCompatActivity {

    EditText etto,etmessage,etsubject;
    Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_us);
        etto=(EditText)findViewById(R.id.et_to);
        etmessage=(EditText)findViewById(R.id.et_message);
        etsubject=(EditText)findViewById(R.id.et_subject);
        btnsend=(Button)findViewById(R.id.btn_send);
        etto.setText("kholoudsayed621@gmail.com");

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+etto.getText().toString()));
intent.putExtra(Intent.EXTRA_SUBJECT,etsubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etmessage.getText().toString());
                startActivity(intent);


            }
        });



    }
}
