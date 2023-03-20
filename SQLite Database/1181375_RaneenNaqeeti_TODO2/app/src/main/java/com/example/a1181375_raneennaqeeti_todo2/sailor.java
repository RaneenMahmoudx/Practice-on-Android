package com.example.a1181375_raneennaqeeti_todo2;

public class sailor {
    private int mSailorId;
    private int mBoatId ;
    private String mName;
    private String mNationality;

    public sailor() {
    }
    public sailor(int mSailorId, int mBoatId, String mName, String mNationality)
    {
        this.mSailorId = mSailorId;
        this.mBoatId = mBoatId;
        this.mName = mName;
        this.mNationality= mNationality;

    }

    public int getmBoatId() {
        return mBoatId;
    }
    public void setmBoatId(int mBoatId) {
        this.mBoatId = mBoatId;
    }
    public String getmName() {
        return mName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }
    public String getmNationality() {
        return mNationality;
    }
    public void setmNationality(String mNationality) {
        this.mNationality = mNationality;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "\nmSailorId=" + mSailorId +
                "\nmBoatId=" + mBoatId +
                "\n, mName='" + mName + '\'' +
                "\n, mNationality='" + mNationality + '\'' +
                "\n}\n\n";
    }
}