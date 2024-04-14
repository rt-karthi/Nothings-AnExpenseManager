package com.example.nothings;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button login_btn;
    DBHelper dbHelper;
    TextView signup_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.user_name);
        password = findViewById(R.id.user_password);
        login_btn = findViewById(R.id.signin_btn);
        signup_text = findViewById(R.id.signup_txt);
        dbHelper = new DBHelper(this);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkpass = dbHelper.checkuserpassword(user,pass);
                        if(checkpass == true){
                            Toast.makeText(LoginActivity.this, "Sign in Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(LoginActivity.this, "Invalid data", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        });

        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}