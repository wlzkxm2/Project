package com.example.lcheeditsource;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.internal.ads.zzdmv;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private ArrayList<ItemData> itemdata = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlistcardview, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // item을 하나 보여주는 함수
        holder.onBind(itemdata.get(position));
    }

    @Override
    public int getItemCount() {
        // item의 총갯수
        return itemdata.size();
    }

    public ItemData getItem(int position){
        return itemdata.get(position);
    }

    void addItem(ItemData ItemData){
        itemdata.add(ItemData);
    }

    // 커스텀 리스너 인터페이스
    public interface OnItemClickListener
    {
        void onItemClick(ItemViewHolder holder, View v, int pos);
    }

    private OnItemClickListener mListener;

    // 어댑터 내부 커스텀 리스터 정의
    // OnItemClickListener 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mListener = listener;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView ItemName;
        private TextView ItemPrice;
        private ImageView ItemImage;

        ItemViewHolder(View itemView) {
            super(itemView);

            ItemName = itemView.findViewById(R.id.cardv_ItemName);
            ItemPrice = itemView.findViewById(R.id.cardv_ItemPrice);
            ItemImage = itemView.findViewById(R.id.cardv_Itemimage);

            // 아이템 클릭시 이벤트 처리
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int ItemPosition = getAdapterPosition();
                    if(ItemPosition != RecyclerView.NO_POSITION){
                        mListener.onItemClick(ItemViewHolder.this, v, ItemPosition);
                    }
                }
            });
        }

        void onBind(ItemData data){
            ItemName.setText(data.getItemName());
            ItemPrice.setText(data.getItemPrice());
            ItemImage.setImageResource(data.getResources());
        }
    }


}
