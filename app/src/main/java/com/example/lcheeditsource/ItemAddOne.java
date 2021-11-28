package com.example.lcheeditsource;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ItemAddOne extends BottomSheetDialogFragment {

    private ItemAddDoneListener mItemAddDonListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.itemadddone, container, false);

        Button _ItemAddCheackOK = v.findViewById(R.id.btn_Addcheack);
        Button _ItemAddCheackNO = v.findViewById(R.id.btn_AddcheackNo);

        // 아이템을 추가한다고 했을때
        _ItemAddCheackOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemAddDonListener.onButtonClicked(true);
                dismiss();
            }
        });

        _ItemAddCheackNO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemAddDonListener.onButtonClicked(false);
                dismiss();
            }
        });

        return v;
    }

    public interface ItemAddDoneListener{
        void onButtonClicked(Boolean ItemAddQus);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mItemAddDonListener = (ItemAddDoneListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "ItemAdd");
        }
    }
}
