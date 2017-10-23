package com.example.mgigena.recievefromapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(intent.getType() != null){
            if(intent.getType().indexOf("image/") != -1){
                //If it is an image, do something
            }else if(intent.getType().equals("text/plain")){
                String message = bundle.getString(Intent.EXTRA_TEXT);
                mTextView.setText(message);

                Intent result = new Intent("com.example.RESULT_ACTION",Uri.parse("content://result_uri"));
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        }
    }
}
