package com.winklix.indu.gooni.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.activities.SubCategoriesActivity;
import com.winklix.indu.gooni.modals.Category;
import com.winklix.indu.gooni.modals.MoreProdModel;

import java.util.ArrayList;

/**
 * Created by harsh on 02/11/2017.
 */

public class More_ProdAdapter extends RecyclerView.Adapter<More_ProdAdapter.ViewHolder> {

    private ArrayList<Category> moreProdModels;
    private Context context;

    public More_ProdAdapter(Context context, ArrayList<Category> moreProdModels)
    {
        this.context = context;
        this.moreProdModels = moreProdModels;

    }

    @Override
    public More_ProdAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.more_data, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        final Category abc = moreProdModels.get(position);

        viewHolder.cat_name.setText(abc.getCname());
        Log.e("GRYR","FF:"+abc.getCname());
        Log.e("GRYR","FF:"+moreProdModels.size());

        viewHolder.cat_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String catId=abc.getId();
                Intent intent= new Intent(context, SubCategoriesActivity.class);
                intent.putExtra("mypos",String.valueOf(position));
                context.startActivity(intent);

            }
        });

        Picasso.with(context)
                .load(moreProdModels.get(position).getcImage())
                .placeholder(R.drawable.logocarrt) // can also be a drawable
                .error(R.drawable.logocarrt) // will be displayed if the image cannot be loaded
                .into(viewHolder.cat_img);
    }

    @Override
    public int getItemCount() {
        return moreProdModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder   {

        ImageView cat_img;
       public TextView cat_name;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            cat_img = (ImageView)view.findViewById(R.id.cat_img);
            cat_name = (TextView) view.findViewById(R.id.cat_name);



        }
    }}