
package com.winklix.indu.gooni.modals;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {


    private String id;

    private String cname;

    private String displayno;

    private String cImage;

    private String gImage;

    private ArrayList<SubCategory> subCategory = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDisplayno() {
        return displayno;
    }

    public void setDisplayno(String displayno) {
        this.displayno = displayno;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }

    public String getgImage() {
        return gImage;
    }

    public void setgImage(String gImage) {
        this.gImage = gImage;
    }

    public ArrayList<SubCategory> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(ArrayList<SubCategory> subCategory) {
        this.subCategory = subCategory;
    }
}
