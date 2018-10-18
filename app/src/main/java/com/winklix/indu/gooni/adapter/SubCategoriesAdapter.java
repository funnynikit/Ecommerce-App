package com.winklix.indu.gooni.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.activities.SubCategoriesActivity;
import com.winklix.indu.gooni.modals.Category;
import com.winklix.indu.gooni.modals.MoreProdModel;
import com.winklix.indu.gooni.modals.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class SubCategoriesAdapter extends BaseAdapter
{
    private ArrayList<SubCategory> subCategory;
    SubCategoriesActivity subCategoriesActivity;
    public SubCategoriesAdapter(SubCategoriesActivity subCategoriesActivity, ArrayList<SubCategory> subCategory) {

        this.subCategory=subCategory;
        this.subCategoriesActivity=subCategoriesActivity;
    }

    @Override
    public int getCount() {
        return subCategory.size();
    }

    @Override
    public Object getItem(int i)
    {
        return subCategory.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(subCategoriesActivity);
        view = inflater.inflate(R.layout.subcat_item, viewGroup, false);
        ImageView cat_img = (ImageView)view.findViewById(R.id.sub_cat_img);
        TextView cat_name = (TextView) view.findViewById(R.id.sub_cat_name);
        cat_name.setText(subCategory.get(i).getSName());

        return view;
    }

  /*  private ArrayList<SubCategory> subCategory;
    private Context context;
  //  String mypos;

    SubCategoriesActivity subCategoriesActivity;

 *//*   public SubCategoriesAdapter(Context context, ArrayList<Category> moreProdModels, String mypos) {
        this.context = context;
        this.moreProdModels = moreProdModels;
        this.mypos=mypos;

    }
*//*
    public SubCategoriesAdapter(SubCategoriesActivity subCategoriesActivity, ArrayList<SubCategory> subCategory) {

      this.subCategory=subCategory;
      this.subCategoriesActivity=subCategoriesActivity;


    }

    @Override
    public SubCategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.subcat_item, viewGroup, false);
        return new SubCategoriesAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SubCategoriesAdapter.ViewHolder viewHolder, final int position) {

       // final Category abc = moreProdModels.get(position);

        viewHolder.cat_name.setText(subCategory.get(position).getSName());
        Log.e("GFT","GTT:"+subCategory.get(position).getSName());
      *//*  viewHolder.cat_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("GRY","FF:"+position);
                Intent intent= new Intent(context, SubCategoriesActivity.class);
                intent.putExtra("mypos",String.valueOf(position));
                context.startActivity(intent);

            }
        });*//*

       *//* Picasso.with(context)
                .load(moreProdModels.get(position).getCat_img())
                .placeholder(R.drawable.logocarrt) // can also be a drawable
                .error(R.drawable.logocarrt) // will be displayed if the image cannot be loaded
                .into(viewHolder.cat_img);*//*
    }

    @Override
    public int getItemCount() {
        return subCategory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder   {

        ImageView cat_img;
        public TextView cat_name;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            cat_img = (ImageView)view.findViewById(R.id.sub_cat_img);
            cat_name = (TextView) view.findViewById(R.id.sub_cat_name);



        }
    }*/
}

