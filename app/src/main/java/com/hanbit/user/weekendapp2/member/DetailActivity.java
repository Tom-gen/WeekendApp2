package com.hanbit.user.weekendapp2.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hanbit.user.weekendapp2.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService service;
    private String id;
    TextView tvID, tvPW, tvName, tvEmail, tvPhone, tvPhoto, tvAddress;
    Button btPhone, btMap, btSms, btUpdate, btList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //get View references
        tvID = (TextView) findViewById(R.id.tvID);
        tvPW = (TextView) findViewById(R.id.tvPW);
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvPhoto = (TextView) findViewById(R.id.tvPhoto);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        btPhone = (Button) findViewById(R.id.btPhone);
        btMap = (Button) findViewById(R.id.btMap);
        btSms = (Button) findViewById(R.id.btSend);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btList = (Button) findViewById(R.id.btList);

        //set user data at each view
        service = new MemberServiceImpl(this);
        id = getIntent().getStringExtra("id");
        MemberBean bean = service.findByID(id);
        if (bean != null) {
            tvID.setText(bean.getID());
            tvPW.setText(bean.getPW());
            tvName.setText(bean.getName());
            tvEmail.setText(bean.getEmail());
            tvPhone.setText(bean.getPhone());
            tvPhoto.setText(bean.getPhoto());
            tvAddress.setText(bean.getAddress());
        }
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btPhone:
                Phone phone = new Phone(this,this);
                phone.directCall(tvPhone.getText().toString());
                break;
            case R.id.btSms:
                break;
            case R.id.btMap:
                break;
            case R.id.btUpdate:
                break;
            case R.id.btList:
                finish();
                break;
        }
    }
}
