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

public class Mypageadminchoice extends BottomSheetDialogFragment {      // BottomSheetDialogFragment를 상속받아 하단 시트 다이얼로그를 구현한다.


    private MypagePageChoiceListener mPageChoiceListner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mypageadminchoice, container, false);

        // 마이페이지 버튼과 상품추가 버튼을 할당
        Button Mypage = v.findViewById(R.id.btn_choiceMyPage);
        Button Itemadd = v.findViewById(R.id.btn_choiceItemAdd);


        // 마이페이지 버튼을 클릭했을때 이벤트
        Mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPageChoiceListner.onButtonClicked(0);      // false 는 마이페이지
                dismiss();
            }
        });

        // 아이템 추가 버튼을 클릭했을때 이벤트
        Itemadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPageChoiceListner.onButtonClicked(1);
                dismiss();
            }
        });

        return v;
    }

    // 기본적으로 이벤트를 전달받으면 해당 java클래스를 호출한 클래스에 값을 반환해줌
    // 해당 java의 경우는 MainActivity.java에 값을 반환
    public interface MypagePageChoiceListener{
        void onButtonClicked(int Page);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            mPageChoiceListner = (MypagePageChoiceListener) context;
        } catch(ClassCastException e){
            // 에러확인
            throw new ClassCastException(context.toString() + "PageChoice");
        }

    }
}
