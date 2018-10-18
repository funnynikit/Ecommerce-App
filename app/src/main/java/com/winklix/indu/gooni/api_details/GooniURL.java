package com.winklix.indu.gooni.api_details;

/**
 * Created by android on 5/14/2018.
 */

public class GooniURL {

    //base url
    final static String mBaseUrl = "http://103.27.233.206/goonidemo/";
    //Gooni urls
    public static final String LOGIN = mBaseUrl + "Auth/login";
    public static final String SIGNUP = mBaseUrl + "Auth/register";
    public static final String OTP = mBaseUrl + "Auth/sendotp";
    public static final String homecategory = mBaseUrl + "ProductList/homecategory";
    public static final String MENUITEMS = mBaseUrl + "ProductList/menuItems";
    public static final String BEST_SELLING = mBaseUrl + "ProductList/bestselling";


}
