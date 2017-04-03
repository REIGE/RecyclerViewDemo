package com.reige.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by REIGE
 * Date :2017/4/3.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private OnRvItemClick mOnRvItemClick;
    private Context mContext;
    String[] strings;

    public MyAdapter(Context ctx, String[] strings, OnRvItemClick onRvItemClick) {
        mContext = ctx;
        this.mOnRvItemClick = onRvItemClick;
        this.strings = strings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.textView)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        public void setData(int position) {

            textView.setText("position" + position);
        }

        @Override
        public void onClick(View view) {
            if (mOnRvItemClick != null)
                mOnRvItemClick.onItemClick(view, getAdapterPosition());
        }

    }


    /**
     * item点击接口
     */
    public interface OnRvItemClick {
        void onItemClick(View v, int position);
    }
}
