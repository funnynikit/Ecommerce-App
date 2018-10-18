
package com.winklix.indu.gooni.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCategory {


    private String id;

    private String catId;

    private String sName;

    private String sDisplayno;

    private String sImage;

    private String sgImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSDisplayno() {
        return sDisplayno;
    }

    public void setSDisplayno(String sDisplayno) {
        this.sDisplayno = sDisplayno;
    }

    public String getSImage() {
        return sImage;
    }

    public void setSImage(String sImage) {
        this.sImage = sImage;
    }

    public String getSgImage() {
        return sgImage;
    }

    public void setSgImage(String sgImage) {
        this.sgImage = sgImage;
    }

}
