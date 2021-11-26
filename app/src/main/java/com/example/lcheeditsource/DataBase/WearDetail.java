package com.example.lcheeditsource.DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "WearDetail")
public class WearDetail implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int DetailsCode = 0;

    @NonNull
    private String WearItem;

    // WasgSpec
    final private String wash1 = "95도";
    final private int washCost1 = 100;

    final private String wash2 = "60도";
    final private int washCost2 = 86;

    final private String wash3 = "40도";
    final private int washCost3 = 70;

    final private String wash4 = "약40도";
    final private int washCost4 = 56;

    final private String wash5 = "약30도 중성";
    final private int washCost5 = 42;

    final private String wash6 = "약30도 중성 손세탁";
    final private int washCost6 = 28;

    final private String wash7 = "물안됨";
    final private int washCost7 = 0;

    // Bleaching
    final private String Bleaching1 = "염소산소표백";
    final private int BleachingCost1 = 100;

    final private String Bleaching2 = "염소표백";
    final private int BleachingCost2 = 80;

    final private String Bleaching3 = "염소표백 불가";
    final private int BleachingCost3 = 65;

    final private String Bleaching4 = "산소표백";
    final private int BleachingCost4 = 50;

    final private String Bleaching5 = "산소표백 불가";
    final private int BleachingCost5 = 35;

    final private String Bleaching6 = "염소산소표백 불가";
    final private int BleachingCost6 = 10;

    // Steam
    final private String Steam1 = "210도";
    final private int SteamCost1 = 100;

    final private String Steam2 = "천210도";
    final private int SteamCost2 = 86;

    final private String Steam3 = "160도";
    final private int SteamCost3 = 70;

    final private String Steam4 = "천160도";
    final private int SteamCost4 = 56;

    final private String Steam5 = "120도";
    final private int SteamCost5 = 42;

    final private String Steam6 = "천120도";
    final private int SteamCost6 = 28;

    final private String Steam7 = "다리미안됨";
    final private int SteamCost7 = 0;

    // Dry
    final private String Dry1 = "드라이";
    final private int DryCost1 = 100;

    final private String Dry2 = "석유드라이";
    final private int DryCost2 = 86;

    final private String Dry3 = "전문드라이";
    final private int DryCost3 = 70;

    final private String Dry4 = "드라이불가";
    final private int DryCost4 = 56;

    // Dryer
    final private String Dryer1 = "햇빛건조";

    final private String Dryer2 = "옷걸이그늘";

    final private String Dryer3 = "뉘어서햇빛";

    final private String Dryer4 = "뉘어서그늘";

    final private String Dryer5 = "기계건조";

    final private String Dryer6 = "기계건조불가";

    final private String Dryer7 = "손으로약하게";

    final private String Dryer8 = "손으로불가";

}
