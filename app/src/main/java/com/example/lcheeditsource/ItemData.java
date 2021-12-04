package com.example.lcheeditsource;

public class ItemData {
    // 리사이클뷰 즉 아이템 검색시 나오는 데이터를 받는 클래스
    private String ItemName;
    private String ItemPrice;
    private String ItemTag;
    private int Resources;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getResources() {
        return Resources;
    }

    public void setResources(int resources) {
        Resources = resources;
    }

    public String getItemTag() {
        return ItemTag;
    }

    public void setItemTag(String itemTag) {
        ItemTag = itemTag;
    }
}
