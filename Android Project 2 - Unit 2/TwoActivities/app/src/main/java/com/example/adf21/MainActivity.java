package com.example.adf21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.adf21.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText messageEditText;
    private TextView replyHeader;
    private TextView replyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageEditText = (EditText) findViewById(R.id.editText_main);
        replyHeader = (TextView) findViewById(R.id.reply_header);
        replyText = (TextView) findViewById(R.id.reply_text);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked");

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        String message = messageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
        }
        if (resultCode == RESULT_OK) {
            String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

            replyHeader.setVisibility(View.VISIBLE);
            replyText.setText(reply);
            replyText.setVisibility(View.VISIBLE);
        }
    }
}
