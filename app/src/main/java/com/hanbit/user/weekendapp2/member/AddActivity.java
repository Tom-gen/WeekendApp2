package com.hanbit.user.weekendapp2.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hanbit.user.weekendapp2.R;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etName, etPhone;
    Button btAdd;
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //get view references
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        btAdd = (Button) findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);

        service = new MemberServiceImpl_Guest(this);
    }

    @Override
    public void onClick(View v) {
//        switch(v.getId()){
//            case R.id.btAdd:
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        MemberBean guest = new MemberBean();
        guest.setName(name);
        guest.setPhone(phone);

        service.add(guest);

//                break;
//        }
    }
}
