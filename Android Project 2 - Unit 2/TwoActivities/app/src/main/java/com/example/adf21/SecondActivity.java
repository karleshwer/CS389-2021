package com.example.adf21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.adf21.extra.REPLY";
    private EditText replyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        replyText = findViewById(R.id.editText_reply);
        textView.setText(message);
        }

        public void launchReply(View view) {
            String reply = replyText.getText().toString();
            Intent replyIntent = new Intent();
            replyIntent.putExtra(EXTRA_REPLY, reply);
            setResult(RESULT_OK, replyIntent);
            finish();
        }
    }
