package com.example.ums;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Helper helper;
    SharedPreferenceConfig sharedPreferenceConfig;

    TextView fullName,userName,email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      helper =new Helper(this);
//        sharedPreferenceConfig=new SharedPreferenceConfig(getApplicationContext());



    fullName=findViewById(R.id.full_name);
    userName=findViewById(R.id.user_name);
    email=findViewById(R.id.email);
    phone=findViewById(R.id.phone);

    Intent intent=getIntent();
    int pos=intent.getIntExtra("POSITION",1);

    setData(pos);

    }

    public void setData(int position){
        Cursor cursor= helper.getAll();
        cursor.moveToPosition(position);
        fullName.setText(cursor.getString(0));
        userName.setText(cursor.getString(1));
        email.setText(cursor.getString(2));
        phone.setText(cursor.getString(4));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.option_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if(R.id.logout==item.getItemId()){
//            logout();
//        }else if(R.id.userList==item.getItemId()){
//            listUsers();
//        }else if(R.id.dialog==item.getItemId()){
//            displayInDialog();
//        }
//        return true;
//
//
//    }



}
