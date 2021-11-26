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
     private String wash1 = "95도";
     private int washCost1 = 100;

     private String wash2 = "60도";
     private int washCost2 = 86;

     private String wash3 = "40도";
     private int washCost3 = 70;

     private String wash4 = "약40도";
     private int washCost4 = 56;

     private String wash5 = "약30도 중성";
     private int washCost5 = 42;

     private String wash6 = "약30도 중성 손세탁";
     private int washCost6 = 28;

     private String wash7 = "물안됨";
     private int washCost7 = 0;

    // Bleaching
     private String Bleaching1 = "염소산소표백";
     private int BleachingCost1 = 100;

     private String Bleaching2 = "염소표백";
     private int BleachingCost2 = 80;

     private String Bleaching3 = "염소표백 불가";
     private int BleachingCost3 = 65;

     private String Bleaching4 = "산소표백";
     private int BleachingCost4 = 50;

     private String Bleaching5 = "산소표백 불가";
     private int BleachingCost5 = 35;

     private String Bleaching6 = "염소산소표백 불가";
     private int BleachingCost6 = 10;

    // Steam
     private String Steam1 = "210도";
     private int SteamCost1 = 100;

     private String Steam2 = "천210도";
     private int SteamCost2 = 86;

     private String Steam3 = "160도";
     private int SteamCost3 = 70;

     private String Steam4 = "천160도";
     private int SteamCost4 = 56;

     private String Steam5 = "120도";
     private int SteamCost5 = 42;

     private String Steam6 = "천120도";
     private int SteamCost6 = 28;

     private String Steam7 = "다리미안됨";
     private int SteamCost7 = 0;

    // Dry
     private String Dry1 = "드라이";
     private int DryCost1 = 100;

     private String Dry2 = "석유드라이";
     private int DryCost2 = 86;

     private String Dry3 = "전문드라이";
     private int DryCost3 = 70;

     private String Dry4 = "드라이불가";
     private int DryCost4 = 56;

    // Dryer
     private String Dryer1 = "햇빛건조";

     private String Dryer2 = "옷걸이그늘";

     private String Dryer3 = "뉘어서햇빛";

     private String Dryer4 = "뉘어서그늘";

     private String Dryer5 = "기계건조";

     private String Dryer6 = "기계건조불가";

     private String Dryer7 = "손으로약하게";

     private String Dryer8 = "손으로불가";

    public int getDetailsCode() {
        return DetailsCode;
    }

    public void setDetailsCode(int detailsCode) {
        DetailsCode = detailsCode;
    }

    @NonNull
    public String getWearItem() {
        return WearItem;
    }

    public void setWearItem(@NonNull String wearItem) {
        WearItem = wearItem;
    }

    public String getWash1() {
        return wash1;
    }

    public void setWash1(String wash1) {
        this.wash1 = wash1;
    }

    public int getWashCost1() {
        return washCost1;
    }

    public void setWashCost1(int washCost1) {
        this.washCost1 = washCost1;
    }

    public String getWash2() {
        return wash2;
    }

    public void setWash2(String wash2) {
        this.wash2 = wash2;
    }

    public int getWashCost2() {
        return washCost2;
    }

    public void setWashCost2(int washCost2) {
        this.washCost2 = washCost2;
    }

    public String getWash3() {
        return wash3;
    }

    public void setWash3(String wash3) {
        this.wash3 = wash3;
    }

    public int getWashCost3() {
        return washCost3;
    }

    public void setWashCost3(int washCost3) {
        this.washCost3 = washCost3;
    }

    public String getWash4() {
        return wash4;
    }

    public void setWash4(String wash4) {
        this.wash4 = wash4;
    }

    public int getWashCost4() {
        return washCost4;
    }

    public void setWashCost4(int washCost4) {
        this.washCost4 = washCost4;
    }

    public String getWash5() {
        return wash5;
    }

    public void setWash5(String wash5) {
        this.wash5 = wash5;
    }

    public int getWashCost5() {
        return washCost5;
    }

    public void setWashCost5(int washCost5) {
        this.washCost5 = washCost5;
    }

    public String getWash6() {
        return wash6;
    }

    public void setWash6(String wash6) {
        this.wash6 = wash6;
    }

    public int getWashCost6() {
        return washCost6;
    }

    public void setWashCost6(int washCost6) {
        this.washCost6 = washCost6;
    }

    public String getWash7() {
        return wash7;
    }

    public void setWash7(String wash7) {
        this.wash7 = wash7;
    }

    public int getWashCost7() {
        return washCost7;
    }

    public void setWashCost7(int washCost7) {
        this.washCost7 = washCost7;
    }

    public String getBleaching1() {
        return Bleaching1;
    }

    public void setBleaching1(String bleaching1) {
        Bleaching1 = bleaching1;
    }

    public int getBleachingCost1() {
        return BleachingCost1;
    }

    public void setBleachingCost1(int bleachingCost1) {
        BleachingCost1 = bleachingCost1;
    }

    public String getBleaching2() {
        return Bleaching2;
    }

    public void setBleaching2(String bleaching2) {
        Bleaching2 = bleaching2;
    }

    public int getBleachingCost2() {
        return BleachingCost2;
    }

    public void setBleachingCost2(int bleachingCost2) {
        BleachingCost2 = bleachingCost2;
    }

    public String getBleaching3() {
        return Bleaching3;
    }

    public void setBleaching3(String bleaching3) {
        Bleaching3 = bleaching3;
    }

    public int getBleachingCost3() {
        return BleachingCost3;
    }

    public void setBleachingCost3(int bleachingCost3) {
        BleachingCost3 = bleachingCost3;
    }

    public String getBleaching4() {
        return Bleaching4;
    }

    public void setBleaching4(String bleaching4) {
        Bleaching4 = bleaching4;
    }

    public int getBleachingCost4() {
        return BleachingCost4;
    }

    public void setBleachingCost4(int bleachingCost4) {
        BleachingCost4 = bleachingCost4;
    }

    public String getBleaching5() {
        return Bleaching5;
    }

    public void setBleaching5(String bleaching5) {
        Bleaching5 = bleaching5;
    }

    public int getBleachingCost5() {
        return BleachingCost5;
    }

    public void setBleachingCost5(int bleachingCost5) {
        BleachingCost5 = bleachingCost5;
    }

    public String getBleaching6() {
        return Bleaching6;
    }

    public void setBleaching6(String bleaching6) {
        Bleaching6 = bleaching6;
    }

    public int getBleachingCost6() {
        return BleachingCost6;
    }

    public void setBleachingCost6(int bleachingCost6) {
        BleachingCost6 = bleachingCost6;
    }

    public String getSteam1() {
        return Steam1;
    }

    public void setSteam1(String steam1) {
        Steam1 = steam1;
    }

    public int getSteamCost1() {
        return SteamCost1;
    }

    public void setSteamCost1(int steamCost1) {
        SteamCost1 = steamCost1;
    }

    public String getSteam2() {
        return Steam2;
    }

    public void setSteam2(String steam2) {
        Steam2 = steam2;
    }

    public int getSteamCost2() {
        return SteamCost2;
    }

    public void setSteamCost2(int steamCost2) {
        SteamCost2 = steamCost2;
    }

    public String getSteam3() {
        return Steam3;
    }

    public void setSteam3(String steam3) {
        Steam3 = steam3;
    }

    public int getSteamCost3() {
        return SteamCost3;
    }

    public void setSteamCost3(int steamCost3) {
        SteamCost3 = steamCost3;
    }

    public String getSteam4() {
        return Steam4;
    }

    public void setSteam4(String steam4) {
        Steam4 = steam4;
    }

    public int getSteamCost4() {
        return SteamCost4;
    }

    public void setSteamCost4(int steamCost4) {
        SteamCost4 = steamCost4;
    }

    public String getSteam5() {
        return Steam5;
    }

    public void setSteam5(String steam5) {
        Steam5 = steam5;
    }

    public int getSteamCost5() {
        return SteamCost5;
    }

    public void setSteamCost5(int steamCost5) {
        SteamCost5 = steamCost5;
    }

    public String getSteam6() {
        return Steam6;
    }

    public void setSteam6(String steam6) {
        Steam6 = steam6;
    }

    public int getSteamCost6() {
        return SteamCost6;
    }

    public void setSteamCost6(int steamCost6) {
        SteamCost6 = steamCost6;
    }

    public String getSteam7() {
        return Steam7;
    }

    public void setSteam7(String steam7) {
        Steam7 = steam7;
    }

    public int getSteamCost7() {
        return SteamCost7;
    }

    public void setSteamCost7(int steamCost7) {
        SteamCost7 = steamCost7;
    }

    public String getDry1() {
        return Dry1;
    }

    public void setDry1(String dry1) {
        Dry1 = dry1;
    }

    public int getDryCost1() {
        return DryCost1;
    }

    public void setDryCost1(int dryCost1) {
        DryCost1 = dryCost1;
    }

    public String getDry2() {
        return Dry2;
    }

    public void setDry2(String dry2) {
        Dry2 = dry2;
    }

    public int getDryCost2() {
        return DryCost2;
    }

    public void setDryCost2(int dryCost2) {
        DryCost2 = dryCost2;
    }

    public String getDry3() {
        return Dry3;
    }

    public void setDry3(String dry3) {
        Dry3 = dry3;
    }

    public int getDryCost3() {
        return DryCost3;
    }

    public void setDryCost3(int dryCost3) {
        DryCost3 = dryCost3;
    }

    public String getDry4() {
        return Dry4;
    }

    public void setDry4(String dry4) {
        Dry4 = dry4;
    }

    public int getDryCost4() {
        return DryCost4;
    }

    public void setDryCost4(int dryCost4) {
        DryCost4 = dryCost4;
    }

    public String getDryer1() {
        return Dryer1;
    }

    public void setDryer1(String dryer1) {
        Dryer1 = dryer1;
    }

    public String getDryer2() {
        return Dryer2;
    }

    public void setDryer2(String dryer2) {
        Dryer2 = dryer2;
    }

    public String getDryer3() {
        return Dryer3;
    }

    public void setDryer3(String dryer3) {
        Dryer3 = dryer3;
    }

    public String getDryer4() {
        return Dryer4;
    }

    public void setDryer4(String dryer4) {
        Dryer4 = dryer4;
    }

    public String getDryer5() {
        return Dryer5;
    }

    public void setDryer5(String dryer5) {
        Dryer5 = dryer5;
    }

    public String getDryer6() {
        return Dryer6;
    }

    public void setDryer6(String dryer6) {
        Dryer6 = dryer6;
    }

    public String getDryer7() {
        return Dryer7;
    }

    public void setDryer7(String dryer7) {
        Dryer7 = dryer7;
    }

    public String getDryer8() {
        return Dryer8;
    }

    public void setDryer8(String dryer8) {
        Dryer8 = dryer8;
    }
}
