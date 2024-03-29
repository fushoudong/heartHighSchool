package com.bupt.heartarea.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bupt.heartarea.R;
import com.bupt.heartarea.bean.Result;
import com.bupt.heartarea.bean.Result2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by jiangzehui on 16/11/5.
 */
public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LayoutInflater inflaters;
    Context context;
    List<Result2.NewsBean> list;
    private OnItemClickLitener mOnItemClickLitener;
    private OnLoadListener mOnLoadListener;
    private boolean isFooterView = true;
    final int NOFOOT = 1;
    final int YESFOOT = 2;
    View footView;

    private static final String img_head = "http://tnfs.tngou.net/img";

    public NewsRecyclerViewAdapter(Context context, List<Result2.NewsBean> list) {
        isFooterView = false;
        inflaters = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
    }

    public NewsRecyclerViewAdapter(Context context, List<Result2.NewsBean> list, View footView) {
        isFooterView = true;
        inflaters = LayoutInflater.from(context);
        this.list = list;
        this.footView = footView;
        this.context = context;
    }


    public void setList(List<Result2.NewsBean> list) {

        this.list = list;
        notifyDataSetChanged();
    }

    public int getListSize() {
        return this.list.size();
    }

    public void addList(List<Result2.NewsBean> list) {
        if (list.size() > 0) {
            for (Result2.NewsBean dataBean : list) {
                this.list.add(dataBean);
            }
            notifyDataSetChanged();
        }

    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public void setOnLoadListener(OnLoadListener mOnLoadListener) {
        this.mOnLoadListener = mOnLoadListener;
    }


    public void setFooterView(boolean footerView) {
        isFooterView = footerView;
    }

    @Override
    public int getItemViewType(int position) {
        if (isFooterView) {
            if (position == (list.size())) {
                return YESFOOT;
            } else {
                return NOFOOT;
            }
        } else {
            return NOFOOT;
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case YESFOOT:
                holder = new MyHolder_foot(footView);
                break;

            case NOFOOT:
                holder = new MyHolder(inflaters.inflate(R.layout.item_recyclerview_news, parent, false));
                break;
        }


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof MyHolder) {
            MyHolder holder1 = (MyHolder) holder;

            holder1.setTitle(list.get(position).getTitle());
//            long time = list.get(position).getTime();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = new Date(time);
//            String time_str = dateFormat.format(date);
            String time_str = list.get(position).getDate();
            holder1.setDate(time_str);
            holder1.setImg(list.get(position).getThumbnail_pic_s());
            if (mOnItemClickLitener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnItemClickLitener.onItemClick(view, position);
                    }
                });
            }
        }


    }

    @Override
    public int getItemCount() {
        return isFooterView ? list.size() + 1 : list.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_title, tv_date;
        ImageView iv;

        public MyHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }

        public void setTitle(String title) {
            if (null == tv_title) return;
            tv_title.setText(title + "\n");

        }

        public void setDate(String date) {
            if (null == tv_date) return;
            tv_date.setText(date);
        }

        public void setImg(String imgUrl) {
            if (null == iv) return;
            Glide.with(context).load(imgUrl).centerCrop().placeholder(R.mipmap.ic_mr).crossFade().into(iv);
        }


    }

    class MyHolder_foot extends RecyclerView.ViewHolder {


        public MyHolder_foot(View itemView) {
            super(itemView);

        }
    }


    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }


    public interface OnLoadListener {
        void onLoad();
    }


}
