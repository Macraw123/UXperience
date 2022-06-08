package com.example.cheat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText passwordTxt, usernameTxt;
    TextView passwordLbl, usernameLbl, registerLbl;
    Button btnLogin;

    public void init(){
        passwordTxt = findViewById(R.id.passwordTxt);
        usernameTxt = findViewById(R.id.usernameTxt);
        passwordLbl = findViewById(R.id.passwordLbl);
        usernameLbl = findViewById(R.id.usernameLbl);
        registerLbl = findViewById(R.id.registerLbl);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public boolean checkLogin(){
        if(passwordTxt.getText().toString().equals("") || usernameTxt.getText().toString().equals("") ){
            Toast.makeText(this, "All input field must not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!usernameTxt.getText().toString().equals("admin")){
            Toast.makeText(this, "Login user must be admin!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLogin()){
                    Toast.makeText(view.getContext(), "Good To go!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, HomePage.class);
                    startActivity(i);
                }
            }
        });


        registerLbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterPage.class);
                startActivity(i);
            }
        });
    }
}