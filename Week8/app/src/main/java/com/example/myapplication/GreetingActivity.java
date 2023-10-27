package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {
    private String fullName ;
    private String message ;
    private TextView textViewMessage;
    private Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.greeting_activity);
        this.buttonBack = (Button) this.findViewById(R.id.button_back);
        this.textViewMessage = (TextView) this.findViewById(R.id.textView_message);

        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

        Intent intent = this.getIntent();
        this.fullName = intent.getStringExtra("fullName");
        this.message = intent.getStringExtra("message");
        this.textViewMessage.setText(this.message);
    }

    public void goBack() {
        this.onBackPressed();
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        String feedback = "Ok, Hello " + this.fullName + ". How are you?";
        data.putExtra("feedback", feedback);

        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }
}