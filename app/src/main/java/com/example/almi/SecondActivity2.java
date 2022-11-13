package com.example.almi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class SecondActivity2 extends AppCompatActivity {
    TextView yourNumberTextView;
    TextView numberTextView;
    EditText codeEditText;
    Button submitBtn;
    Button generateRandomNumberBtn;
    TextView yourCodeTextView;
    TextView dataTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        codeEditText = findViewById(R.id.code_et);
        numberTextView = findViewById(R.id.number_tv);
        submitBtn = findViewById(R.id.submit_btn);
        generateRandomNumberBtn = findViewById(R.id.generate_code_btn);
        dataTextView = findViewById(R.id.data_tv);



        ActivityResultLauncher<Intent> profileData = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {


            }

        });
        Intent intent = getIntent();
        String textFromMain =intent.getStringExtra("textFromMain");
        numberTextView.setText(textFromMain);
        generateRandomNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                dataTextView.setText(String.valueOf(random.nextInt(999999)));
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (codeEditText.getText().toString().equals(dataTextView.getText())) {
                    Intent intent = new Intent(SecondActivity2.this, ThirdActivity2.class);
                    startActivity(intent);
                    String number = numberTextView.getText().toString();
                    intent.putExtra("key",number);
                    setResult(RESULT_OK, intent);
                    Toast.makeText(getApplicationContext(), "yes", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "no", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}