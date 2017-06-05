package com.lesly.chahuara.loginlp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lesly.chahuara.loginlp3.dao.UserDao;

public class RegisterActivity extends AppCompatActivity {

    EditText first, last, email, mobile, pass, confpass;
    Button save, cancel;
    UserDao db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        first = (EditText) findViewById(R.id.editfirstname);
        last = (EditText) findViewById(R.id.editlastname);
        email = (EditText) findViewById(R.id.editemail);
        mobile = (EditText) findViewById(R.id.editmobileno);
        pass = (EditText) findViewById(R.id.editpassword);
        confpass = (EditText) findViewById(R.id.editconformpassword);

        save = (Button) findViewById(R.id.btnsave);
        cancel = (Button) findViewById(R.id.btncancel);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edfirst = first.getText().toString();
                String edlast = last.getText().toString();
                String edemail = email.getText().toString();
                String edmobile = mobile.getText().toString();
                String edpass = pass.getText().toString();
                String edConf = confpass.getText().toString();
                if(edConf.equals(edpass) ){
                    db = new UserDao(RegisterActivity.this, null, null, 2);
                    RegisterData reg = new RegisterData();
                    reg.setfirstName(edfirst);
                    reg.setlastName(edlast);
                    reg.setEmailId(edemail);
                    reg.setMobNo(edmobile);
                    reg.setPassword(edpass);
                    // db.addregister(reg);
                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Main.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_LONG).show();
                    pass.setText("");
                    confpass.setText("");
                }

            }
        });

    }



}