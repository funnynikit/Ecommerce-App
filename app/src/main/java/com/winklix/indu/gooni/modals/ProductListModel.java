package com.winklix.indu.gooni.modals;

/**
 * Created by harsh on 02/11/2017.
 */

public class ProductListModel {

    private int prod_img;
    private String prod_name;
    private String prod_prise;

    public ProductListModel() {

    }

    public int getProd_img() {
        return prod_img;
    }

    public void setProd_img(int prod_img) {
        this.prod_img = prod_img;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_prise() {
        return prod_prise;
    }

    public void setProd_prise(String prod_prise) {
        this.prod_prise = prod_prise;
    }
}

