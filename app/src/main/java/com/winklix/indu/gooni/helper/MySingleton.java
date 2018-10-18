package com.winklix.indu.gooni.helper;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.winklix.indu.gooni.modals.Category;

import java.util.ArrayList;

/**
 * Created by android on 5/15/2018.
 */
public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;
    public static ArrayList<Category> arralist_MenuItemsList=new ArrayList<Category>();

    private MySingleton(Context context){
        // Specify the application context
        mContext = context;
        // Get the request queue
        mRequestQueue = getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context){
        // If Instance is null then initialize new Instance
        if(mInstance == null){
            mInstance = new MySingleton(context);
        }
        // Return MySingleton new Instance
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        // If RequestQueue is null the initialize new RequestQueue
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }

        // Return RequestQueue
        return mRequestQueue;
    }

    public<T> void addToRequestQueue(Request<T> request){
        // Add the specified request to the request queue
        getRequestQueue().add(request);
    }

    public static ArrayList<Category> getArralist_MenuItemsList() {
        return arralist_MenuItemsList;
    }

    public static void setArralist_MenuItemsList(ArrayList<Category> arralist_MenuItemsList) {
        MySingleton.arralist_MenuItemsList = arralist_MenuItemsList;
    }
}
