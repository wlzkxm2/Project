package com.example.lcheeditsource;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    void addItem(ItemData ItemData){
        itemdata.add(ItemData);
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
        }

        void onBind(ItemData data){
            ItemName.setText(data.getItemName());
            ItemPrice.setText(data.getItemPrice());
            ItemImage.setImageResource(data.getResources());
        }
    }


}
