package com.hanbit.user.weekendapp2.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.hanbit.user.weekendapp2.R;

public class GuestListActivity extends AppCompatActivity {
    ListView lvGuestList;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_list);


        lvGuestList = (ListView) findViewById(R.id.lv_guestlist);
        service = new MemberServiceImpl_Guest(this);
        lvGuestList.setAdapter(new GuestAdapter(this, service.list()));
    }
}
