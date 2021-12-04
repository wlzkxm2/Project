package com.example.lcheeditsource;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.internal.ads.zzdmv;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private ArrayList<ItemData> itemdata = new ArrayList<>();
    private Context context;

    // context를 입력받아 intent 이벤트를 실행 가능함
    public RecyclerAdapter(Context context){
        this.context = context;
    }

    
    // 레이아웃을 생성한다.
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlistcardview, parent, false);
        return new ItemViewHolder(v);
    }

    // 레이아웃(뷰홀더) 가 재활용 될때 실행되는 메서드
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // item을 하나 보여주는 함수
        holder.onBind(itemdata.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // context를 선언함으로 써 intent를 사용하게 해줌
                Context context = v.getContext();
                Intent Page;
                Page = new Intent(v.getContext(), goods_comparison.class);
                // 상품의 태그를 전송하여 어떤상품인지를 보여줌
                Page.putExtra("아이템 종류", getItem(position));
                // Login.class를 변경하여 클래스 이동
                Log.v("로그", "포지션" + position + "\n아이템이름 : " + getItem(position));

                context.startActivity(Page);
            }
        });
    }

    // 아이템 개수를 조회 할 수 있다
    @Override
    public int getItemCount() {
        // item의 총갯수
        return itemdata.size();
    }

    public String getItem(int pos){
        return itemdata.get(pos).getItemTag();
    }
    
    // 아이템을 추가한다
    void addItem(ItemData ItemData){
        itemdata.add(ItemData);
    }


    // 추가한 아이템을 지정된 textview나 imageview에 보여주는 역할을 함
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
