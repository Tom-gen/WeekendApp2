package com.hanbit.user.weekendapp2.member;

import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Member;
import java.util.List;

/**
 * Created by 1027 on 2016-07-09.
 */
public interface MemberService {
    /*create : insert new member info into DB*/
    public void join(MemberBean bean);

    /*add contact info into db*/
    public void add(Member bean);

    /*read : check Member's id/pw are correct*/
    public Boolean login(MemberBean bean);

    public int count();

    public List<MemberBean> list();

    public MemberBean findByID(String id);

    public List<MemberBean> findByName(SQLiteDatabase db, String name);

    /*update*/
    public void update(MemberBean bean);

    /*delete*/
    public void delete(MemberBean bean);

}
