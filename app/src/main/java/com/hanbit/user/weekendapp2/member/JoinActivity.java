package com.hanbit.user.weekendapp2.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.user.weekendapp2.MainActivity;
import com.hanbit.user.weekendapp2.R;

public class JoinActivity extends Activity implements View.OnClickListener {

    EditText etID, etPW, etName, etEmail, etPhone, etPhoto, etAddress;
    Button btSend, btHome;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etPhoto = (EditText) findViewById(R.id.etPhoto);
        etAddress = (EditText) findViewById(R.id.etAddress);
        btSend = (Button) findViewById(R.id.btSend);
        btHome = (Button) findViewById(R.id.btHome);
//        tvResult = (TextView) findViewById(R.id.tvResult);

        btSend.setOnClickListener(this);
        btHome.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btSend:
                MemberService service = new MemberServiceImpl(this);
                MemberBean bean = new MemberBean();
                bean.setID(etID.getText().toString());
                bean.setPW(etPW.getText().toString());
                bean.setName(etName.getText().toString());
                bean.setEmail(etEmail.getText().toString());
                bean.setPhone(etPhone.getText().toString());
                bean.setPhoto(etPhoto.getText().toString());
                bean.setAddress(etAddress.getText().toString());

                service.join(bean);
                startActivity(new Intent(this, LoginActivity.class));
//                String result = service.join(bean);
//
//                tvResult.setText(result);
                break;
            case R.id.btHome:
                startActivity(new Intent(this, MainActivity.class));
                break;

        }
    }
}
