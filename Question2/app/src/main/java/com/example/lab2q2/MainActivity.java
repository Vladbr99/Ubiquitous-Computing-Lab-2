package com.example.lab2q2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.editName);
        EditText password = findViewById(R.id.editPassword);
        EditText phone = findViewById(R.id.editPhone);
        EditText email = findViewById(R.id.editEmail);
        Button submit = findViewById(R.id.buttonSubmit);

        submit.setOnClickListener(v -> {

            String n = name.getText().toString().trim();
            String p = password.getText().toString().trim();
            String ph = phone.getText().toString().trim();
            String em = email.getText().toString().trim();

            // Validate name (letters only)
            if (!n.matches("[A-Za-z ]+")) {
                name.setError("Letters only");
                return;
            }

            // Validate phone (digits only)
            if (!ph.matches("\\d+")) {
                phone.setError("Digits only");
                return;
            }

            // Validate email
            if (!em.contains("@") || !em.contains(".")) {
                email.setError("Invalid email");
                return;
            }

        });
    }
}
