package com.lesly.chahuara.loginlp3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lesly.chahuara.loginlp3.dao.UserDao;

public class Main extends AppCompatActivity {

    EditText user, pass;
    Button login, not_reg;
    UserDao db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.eduser);
        pass = (EditText) findViewById(R.id.edpass);
        login = (Button) findViewById(R.id.login);
        not_reg = (Button) findViewById(R.id.not_reg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new UserDao(Main.this, null, null, 2);
                String userName = user.getText().toString();
                String password = pass.getText().toString();
                String StoredPassword = db.getregister(password);
                if (userName.equals(StoredPassword)) {
                    Toast.makeText(getApplicationContext(), StoredPassword + "Logueado", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(Main.this,Tab.class);
                    i.putExtra("usuario",userName);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "UserName o Pasword incorrecto", Toast.LENGTH_LONG).show();
                    user.setText("");
                    pass.setText("");
                }
            }
        });

        not_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }


//    @Override
//    protected void onResume() {
//
//        list = db.getAllRegister(UserDaoe);
//         //list=((alertv) alert).showAlert();
//        Customlist adapter = new Customlist(Main.this, list);
////            mylistview.setAdapter(adapter);
//
//        if (adapter.getCount() != 0) {
//            mylistview.setAdapter(adapter);
//
//
//        } else {
//            Toast.makeText(MainActivity.this, "No Items Available", Toast.LENGTH_SHORT).show();
//        }
//        super.onResume();
//    }


}