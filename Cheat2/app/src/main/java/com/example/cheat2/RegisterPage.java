package com.example.cheat2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText passwordTxt, usernameTxt, confPasswordTxt;
    TextView passwordLbl, usernameLbl, registerLbl;
    Button btnRegister;
    RadioButton maleBtn, femaleBtn;
    CheckBox agreeBtn;
    RadioGroup genderGroup;
    Spinner nationalSpinner;
    DatePicker datePicker;
    Switch switchColor;
    String[] country = { "-None-", "India", "USA", "China", "Japan", "Indonesia"};

    public void init(){
        passwordTxt = findViewById(R.id.passwordTxt);
        usernameTxt = findViewById(R.id.usernameTxt);
        passwordLbl = findViewById(R.id.passwordLbl);
        usernameLbl = findViewById(R.id.usernameLbl);
        registerLbl = findViewById(R.id.registerLbl);
        btnRegister = findViewById(R.id.btnRegister);
        confPasswordTxt = findViewById(R.id.confPasswordTxt);
        maleBtn = findViewById(R.id.maleBtn);
        femaleBtn = findViewById(R.id.femaleBtn);
        agreeBtn = findViewById(R.id.agreeBtn);
        genderGroup = findViewById(R.id.genderGroup);
        nationalSpinner = findViewById(R.id.nationalSpinner);
        datePicker = findViewById(R.id.datePicker);
        switchColor = findViewById(R.id.switchColor);
    }

    public boolean checkAllValidation(){
        if(passwordTxt.getText().toString().equals("") || usernameTxt.getText().toString().equals("") ){
            Toast.makeText(this, "All input field must not be empty!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!confPasswordTxt.getText().toString().equals(passwordTxt.getText().toString())){
            confPasswordTxt.setError("Must be the same as password!");
            return false;
        }else if(!(maleBtn.isChecked() || femaleBtn.isChecked())){
            Toast.makeText(this, "Gender must be selected!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!agreeBtn.isChecked()){
            Toast.makeText(this, "You must agree to term and conditions!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!nationalSpinner.getSelectedItem().equals("-None-")){
            Toast.makeText(this, "You must pick your nationality!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        init();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "Selected Date: "+ datePicker.getDayOfMonth()+"/"+
                                (datePicker.getMonth() + 1)+"/"+datePicker.getYear(), Toast.LENGTH_SHORT).show();

//                if(checkAllValidation()){
//                    Toast.makeText(view.getContext(), "Register Success!", Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(RegisterPage.this, MainActivity.class);
//                  startActivity(i);
//                }
            }
        });

        nationalSpinner.setOnItemSelectedListener(this);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nationalSpinner.setAdapter(arrayAdapter);

        switchColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchColor.isChecked()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getItemAtPosition(i).equals("-None-")){

        }else{
            Toast.makeText(getApplicationContext(),country[i] , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}