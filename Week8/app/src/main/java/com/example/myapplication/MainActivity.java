package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.SearchEvent;
import android.view.View;

import androidx.core.view.MenuItemCompat;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 69;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Button buttonSendMessage;
    private EditText editTextFullName;
    private TextView textFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.editTextFullName = (EditText) this.findViewById(R.id.editText_fullName);
        this.buttonSendMessage = (Button) this.findViewById(R.id.button_sendMessage);
        this.textFeedback = (TextView) this.findViewById(R.id.textView_feedback);
        this.buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    public void sendMessage() {
        String fullName = this.editTextFullName.getText().toString();
        String message = "Hello mother fcker!";

        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("fullName", fullName);
        intent.putExtra("message", message);

        this.startActivityForResult(intent, MY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE) {
            String feedback = data.getStringExtra("feedback");
            this.textFeedback.setText(feedback);
        } else {
            this.textFeedback.setText("!?");
        }
    }

}