package com.sunh.dayup.android_d4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sunh.dayup.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpwen on 2017/7/19.
 *
 * recyclerView adapter
 */

class MRecyclerAdapter extends RecyclerView.Adapter <MRecyclerAdapter.MyViewHolder>{

    public Context context;
    public List<PicModel>  models;

    public MRecyclerAdapter(Context context) {
        this.context = context;
        models = new ArrayList<>();
        PicModel model = new PicModel();
        model.setImgid(R.drawable.p1);
        PicModel mode2 = new PicModel();
        mode2.setImgid(R.drawable.p1);
        PicModel mode3 = new PicModel();
        mode3.setImgid(R.drawable.p2);
        PicModel mode4 = new PicModel();
        mode4.setImgid(R.drawable.p3);
        PicModel mode5 = new PicModel();
        mode5.setImgid(R.drawable.p4);
        PicModel mode6 = new PicModel();
        mode6.setImgid(R.drawable.p1);
        models.add(model);
        models.add(mode2);
        models.add(mode3);
        models.add(mode4);
        models.add(mode5);
        models.add(mode6);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder =
                new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recyleview_item, null));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setBackgroundResource(models.get(position).getImgid());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }
}
