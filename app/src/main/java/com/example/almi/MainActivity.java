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

public class MainActivity extends AppCompatActivity {

    EditText inputNumberPhone;
    Button signIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumberPhone = findViewById(R.id.input_number_et);
        signIn = findViewById( R.id.sing_in_btn);

        ActivityResultLauncher<Intent> profileDataResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {


            }
        });


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputNumber = inputNumberPhone.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
                intent.putExtra("textFromMain",inputNumber );
                startActivity(intent);
                     profileDataResult.launch(intent);
            }
        });






    }
}