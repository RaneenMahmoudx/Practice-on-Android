package com.example.a1181375_raneennaqeeti_todo2;

public class boat {
    private int mBoatId ;
    private String mName;
    private String mColor;

    public boat() {
    }
    public boat(int mBoatId, String mName, String mColor)
    {
        this.mBoatId = mBoatId;
        this.mName = mName;
        this.mColor = mColor;

    }


    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getmColor() {
        return mColor;
    }
    public void setmColor(String mColor) {
        this.mColor = mColor;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "\nmBoatId=" + mBoatId +
                "\n, mName='" + mName + '\'' +
                "\n, mColor='" + mColor + '\'' +
                "\n}\n\n";
    }
}

