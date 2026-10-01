package com.example.lab2q2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Validation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_validation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String name = getIntent().getStringExtra("NAME");

        int validationCode =
                getIntent().getIntExtra("VALIDATION_CODE", -1);

        EditText code = findViewById(R.id.editCode);
        Button validate = findViewById(R.id.buttonValidate);
        TextView result = findViewById(R.id.textResult);

        validate.setOnClickListener(v -> {

            String enteredCode = code.getText().toString().trim();

            if (enteredCode.isEmpty()) {
                code.setError("Enter validation code");
                return;
            }

            int userCode = Integer.parseInt(enteredCode);

            if (userCode == validationCode) {
                result.setText(
                        "Thank you " + name + ", your request is being processed"
                );
            } else {
                code.setError("Incorrect validation code");
            }
        });
    }
}