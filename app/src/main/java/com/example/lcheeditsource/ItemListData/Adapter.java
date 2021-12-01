package com.example.lcheeditsource.ItemListData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lcheeditsource.ItemListView;
import com.example.lcheeditsource.R;

import java.util.ArrayList;

// 리사이클뷰 구현을 위한 어댑터
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ItemListData> itemListData;

    public Adapter(Context context, ArrayList<ItemListData> ItemList){
        this.context = context;
        this.itemListData = ItemList;
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.itemlistcardview, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        ItemListData itemlist = itemListData.get(position);
        holder.ItemName.setText(itemlist.getItemName());
        holder.ItemPrice.setText(itemlist.getItemprice());
        holder.ItemImage.setImageResource(itemlist.getImageResourceID());

    }

    @Override
    public int getItemCount() {
        return itemListData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView ItemName, ItemPrice;
        ImageView ItemImage;


        public ViewHolder(@NonNull View itemView){
            super(itemView);

            ItemName = itemView.findViewById(R.id.edit_cardViewItemName);
            ItemPrice = itemView.findViewById(R.id.edit_cardViewItemPrice);
            ItemImage = itemView.findViewById(R.id.img_cardViewItemImage);
        }

    }
}
