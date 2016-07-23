package com.hanbit.user.weekendapp2.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.user.weekendapp2.MainActivity;
import com.hanbit.user.weekendapp2.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    EditText etID, etPW;
    Button btLogin, btHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);

        btLogin = (Button) findViewById(R.id.btSend);
        btHome = (Button) findViewById(R.id.btHome);

        btLogin.setOnClickListener(this);
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

                if (service.login(bean)) {
                    Toast.makeText(this, "환영합니다", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "가입하세요", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btHome:
                startActivity(new Intent(this, MainActivity.class));
                break;

        }
    }
}
