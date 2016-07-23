package com.hanbit.user.weekendapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hanbit.user.weekendapp2.member.JoinActivity;
import com.hanbit.user.weekendapp2.member.LoginActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btJoin, btLogin, btContactCount, btContactList, btAddContact, btFindContact, btUpdateContact, btDeleteContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btJoin = (Button) findViewById(R.id.btJoin);
        btLogin = (Button) findViewById(R.id.btLogin);
        btContactCount = (Button) findViewById(R.id.btContactCount);
        btContactList = (Button) findViewById(R.id.btContactList);
        btAddContact = (Button) findViewById(R.id.btAddContact);
        btFindContact = (Button) findViewById(R.id.btFindContact);
        btUpdateContact = (Button) findViewById(R.id.btUpdateContact);
        btDeleteContact = (Button) findViewById(R.id.btDeleteContact);

//        set onClickListner at each buttons
        btJoin.setOnClickListener(this);
        btLogin.setOnClickListener(this);
        btContactCount.setOnClickListener(this);
        btContactList.setOnClickListener(this);
        btAddContact.setOnClickListener(this);
        btFindContact.setOnClickListener(this);
        btUpdateContact.setOnClickListener(this);
        btDeleteContact.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btJoin:
                Toast.makeText(this, "btJoin", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, JoinActivity.class));
                break;
            case R.id.btLogin:
                Toast.makeText(this, "btLogin", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btContactCount:
                Toast.makeText(this, "btContactCount", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btContactList:
                Toast.makeText(this, "btContactList", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btAddContact:
                Toast.makeText(this, "btAddContact", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btFindContact:
                Toast.makeText(this, "btFindContact", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btUpdateContact:
                Toast.makeText(this, "btUpdateContact", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btDeleteContact:
                Toast.makeText(this, "btDeleteContact", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;

        }

    }
}
