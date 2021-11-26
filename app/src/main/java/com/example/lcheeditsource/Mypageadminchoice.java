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

public class Mypageadminchoice extends BottomSheetDialogFragment {

    private MypagePageChoiceListener mPageChoiceListner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mypageadminchoice, container, false);

        Button Mypage = v.findViewById(R.id.btn_choiceMyPage);
        Button Itemadd = v.findViewById(R.id.btn_choiceItemAdd);

        Mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPageChoiceListner.onButtonClicked(0);      // false 는 마이페이지
                dismiss();
            }
        });

        Itemadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPageChoiceListner.onButtonClicked(1);
                dismiss();
            }
        });

        return v;
    }

    public interface MypagePageChoiceListener{
        void onButtonClicked(int Page);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            mPageChoiceListner = (MypagePageChoiceListener) context;
        } catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "PageChoice");
        }

    }
}
