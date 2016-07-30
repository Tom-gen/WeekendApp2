package com.hanbit.user.weekendapp2.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hanbit.user.weekendapp2.R;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-07-16.
 */
public class Adapter extends BaseAdapter {
    private static ArrayList<Person> list;
    private LayoutInflater inflater;
    private int[] photos = {
            R.drawable.cupcake, R.drawable.donut
            , R.drawable.eclair, R.drawable.froyo
            , R.drawable.gingerbread, R.drawable.honeycomb
            , R.drawable.icecream, R.drawable.jellybean
            , R.drawable.kitkat, R.drawable.lollipop
    };

    public Adapter(Context context, ArrayList<Person> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        ViewHolder2 holder;

        if (v == null) {
            v = inflater.inflate(R.layout.person, null);
            holder = new ViewHolder2();
            holder.setName((TextView) v.findViewById(R.id.name));
            holder.setEmail((TextView) v.findViewById(R.id.email));
            holder.setPhoneNo((TextView) v.findViewById(R.id.phoneNo));
            holder.setPhoto((ImageView) v.findViewById(R.id.photo));

            v.setTag(holder);
        } else {
            holder = (ViewHolder2) v.getTag();
        }

        Person person = list.get(i);
        holder.getName().setText(person.getName());
        holder.getEmail().setText(person.getEmail());
        holder.getPhoneNo().setText(person.getPhoneNo());
        holder.getPhoto().setImageResource(photos[person.getIdxPhoto()]);

        return v;
    }
}
