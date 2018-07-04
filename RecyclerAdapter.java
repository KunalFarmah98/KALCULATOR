package com.example.kunalfarmah.kalculator;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    ArrayList<RecylcerList> vals = RecylcerList.getlist();


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            txt = (TextView) itemView.findViewById(R.id.text);
            img = (ImageView) itemView.findViewById(R.id.img);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View Recycle = LayoutInflater.from(parent.getContext()).inflate(R.layout.recylcer_view_skeleton,parent,false);


        ViewHolder holder = new ViewHolder(Recycle);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



        RecylcerList obj = vals.get(position);

        TextView txt = holder.txt;
        txt.setText(obj.get_Text());

        ImageView img = holder.img;
        img.setBackgroundResource(obj.get_image());

    }

    @Override
    public int getItemCount() {
        return vals.size();
    }



}
