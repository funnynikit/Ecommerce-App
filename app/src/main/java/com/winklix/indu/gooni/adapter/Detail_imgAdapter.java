package com.winklix.indu.gooni.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.modals.DetailimgModel;

import java.util.ArrayList;

/**
 * Created by harsh on 02/11/2017.
 */

public class Detail_imgAdapter extends RecyclerView.Adapter<Detail_imgAdapter.ViewHolder> {

    private ArrayList<DetailimgModel> detailimgModels;
    private Context context;

    public Detail_imgAdapter(Context context, ArrayList<DetailimgModel> clothModels) {
        this.context = context;
        this.detailimgModels = clothModels;

    }

    @Override
    public Detail_imgAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detailimg_data, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final DetailimgModel abc = detailimgModels.get(position);

        //Picasso.with(context).load(detailimgModels.get(position).getProd_img()).into(viewHolder.detail_prod_img);
        Picasso.with(context)
                .load(detailimgModels.get(position).getProd_img())
                .placeholder(R.drawable.logocarrt) // can also be a drawable
                .error(R.drawable.logocarrt) // will be displayed if the image cannot be loaded
                .into(viewHolder.detail_prod_img);
    }

    @Override
    public int getItemCount() {
        return detailimgModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView detail_prod_img;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            detail_prod_img = (ImageView)view.findViewById(R.id.detail_prod_img);

            detail_prod_img.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }}