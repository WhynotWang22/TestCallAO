package com.whynotquang.testcallao.Adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;
import com.whynotquang.testcallao.Model.Ao;
import com.whynotquang.testcallao.R;

import java.text.DecimalFormat;
import java.util.List;

public class AoAdapter extends RecyclerView.Adapter<AoAdapter.Viewholder> {

    List<Ao> aoList;
    Context context;

    public AoAdapter(List<Ao> aoList, Context context) {
        this.aoList = aoList;
        this.context = context;
    }

    @NonNull
    @Override
    public AoAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_recyc,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AoAdapter.Viewholder holder, int position) {
       Ao ao = aoList.get(position);
       holder.tv_name.setText(ao.getTitle());
       DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
       holder.tv_price.setText("Gía:" +decimalFormat.format(ao.getPrice())+ "Đ");
//        Glide
//                .with(context)
//                .load(ao.getImg())
//                .centerCrop()
//                .placeholder(R.drawable.fullnae)
//                .into(holder.img_aopolo);
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.fullnae)
                .error(R.drawable.fullnae);
        Glide.with(context).load(ao.getImg().get(0)).apply(options).into(holder.img_aopolo);


    }

    @Override
    public int getItemCount() {
        return aoList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_price;
        ImageView img_aopolo;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            img_aopolo = itemView.findViewById(R.id.img_aopolo);
        }
    }
}
