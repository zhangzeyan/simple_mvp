package com.simple.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by zhangzeyan on 16/10/18.
 */

public class UserDataAdapter extends BaseAdapter {

    private Context context;
    private List<UserBean> userBeanList;

    public UserDataAdapter(Context context, List<UserBean> userBeanList) {
        this.context = context;
        this.userBeanList = userBeanList;
    }

    @Override
    public int getCount() {
        return userBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return userBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        UserBean userBean = userBeanList.get(position);
        Holder holder;
        if (convertView == null){
            convertView =  LayoutInflater.from(context).inflate(R.layout.activity_normal_list_item,null);
            holder = new Holder();
            holder.logoImg = (ImageView) convertView.findViewById(R.id.logoImg);
            holder.nameTxt = (TextView) convertView.findViewById(R.id.nameTxt);
            holder.ageTxt = (TextView) convertView.findViewById(R.id.ageTxt);
            holder.sexTxt = (TextView) convertView.findViewById(R.id.sexTxt);
            holder.isStudentTxt = (TextView) convertView.findViewById(R.id.isStudentTxt);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }
        Glide.with(context).load(userBean.getImg()).into(holder.logoImg);
        holder.nameTxt.setText("姓名："+userBean.getName());
        holder.ageTxt.setText("年龄："+userBean.getAge());
        holder.sexTxt.setText("性别："+ (userBean.getSex()==1 ?"男":"女"));
        holder.isStudentTxt.setText(userBean.isStudent()?"学生":"非学生");
        return convertView;
    }


    class Holder{
        ImageView logoImg;
        TextView nameTxt;
        TextView ageTxt;
        TextView sexTxt;
        TextView isStudentTxt;
    }
}
