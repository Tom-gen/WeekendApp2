package com.hanbit.user.weekendapp2.member;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hanbit.user.weekendapp2.R;

import java.util.ArrayList;

public class MemberListActivity extends AppCompatActivity {
    ListView lv_memberlist;
    MemberService service;
    //final String[] selectedId = new String[1];
    String selectedId;

    ArrayList<MemberBean> list = null;
//    ArrayAdapter<MemberBean> adapter = null;
    ListAdapter adapter;
    int selectedPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        service = new MemberServiceImpl(this);
        list = service.list();
//        adapter = new ArrayAdapter<MemberBean>(this, R.layout.activity_member_list, list);
        adapter = new MemberAdapter(this, list);
        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
        lv_memberlist.setAdapter(adapter);
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long id) {
//                MemberAdapter.ViewHolder holder = (MemberAdapter.ViewHolder) v.getTag();
//                holder.tvPhone.getText();
//                Object obj = ;
                MemberBean member = (MemberBean) lv_memberlist.getItemAtPosition(i);
//                selectedId[0] = member.getID();
                selectedId = member.getID();
                Toast.makeText(MemberListActivity.this
                        , "선택한 이름:" + member.getName()
                        , Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(MemberListActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getID());
                startActivity(intent);
            }
        });
        lv_memberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {

                MemberBean member = (MemberBean) lv_memberlist.getItemAtPosition(i);
//                selectedId[0] = member.getID();
                selectedId = member.getID();
                selectedPos = i;
                Toast.makeText(MemberListActivity.this
                        , "선택한 이름:" + member.getName()
                        , Toast.LENGTH_SHORT)
                        .show();
                AlertDialog.Builder alert = new AlertDialog.Builder(MemberListActivity.this).setTitle("삭제")
                        .setMessage("삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                service.delete(selectedId);
//                                service.delete(String.valueOf(selectedPos));
                                list.remove(selectedPos);
                                ((MemberAdapter) adapter).notifyDataSetChanged();
                                dialog.dismiss();

//                                finish();
//                                startActivity(getIntent());
//                                runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        ((MemberAdapter) adapter).notifyDataSetChanged();
//                                    }
//                                });

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //cancle
                            }
                        });
                alert.show();


                return true;
            }
        });
    }
}
