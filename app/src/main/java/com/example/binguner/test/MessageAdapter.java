package com.example.binguner.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by binguner on 2018/1/3.
 */

public class MessageAdapter extends ArrayAdapter<Messages> {


    private int resourceId;

    public MessageAdapter(@NonNull Context context, int resource, @NonNull List<Messages> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Messages messages = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.ltextView = view.findViewById(R.id.lmessage);
            viewHolder.rtextView = view.findViewById(R.id.rmessage);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if(messages.getType() == 0){
            viewHolder.ltextView.setVisibility(View.VISIBLE);
            viewHolder.ltextView.setText(messages.getMessage());
            viewHolder.rtextView.setVisibility(View.GONE);
        }else if(messages.getType() == 1){
            viewHolder.rtextView.setVisibility(View.VISIBLE);
            viewHolder.rtextView.setText(messages.getMessage());
            viewHolder.ltextView.setVisibility(View.GONE);
        }
        return view;
    }

    class ViewHolder{
        TextView ltextView;
        TextView rtextView;
    }
}
