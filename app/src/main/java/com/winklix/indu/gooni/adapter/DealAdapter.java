package com.winklix.indu.gooni.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.modals.DealModel;

import java.util.ArrayList;

/**
 * Created by harsh on 02/11/2017.
 */

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.ViewHolder> {

    private ArrayList<DealModel> clothModels;
    private Context context;

    public DealAdapter(Context context, ArrayList<DealModel> clothModels) {
        this.context = context;
        this.clothModels = clothModels;

    }

    @Override
    public DealAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.deal_data, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final DealModel abc = clothModels.get(position);

        viewHolder.deal_prize_tv.setText(abc.getProd_name());
        viewHolder.deal_prod_name_tv.setText(abc.getProd_prise());
       // Picasso.with(context).load(clothModels.get(position).getProd_img()).into(viewHolder.deal_prod_img);
        Picasso.with(context)
                .load(clothModels.get(position).getProd_img())
                .placeholder(R.drawable.logocarrt) // can also be a drawable
                .error(R.drawable.logocarrt) // will be displayed if the image cannot be loaded
                .into(viewHolder.deal_prod_img);
    }

    @Override
    public int getItemCount() {
        return clothModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder   {

        ImageView deal_prod_img;
       public TextView deal_prize_tv,deal_prod_name_tv;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            deal_prod_img = (ImageView)view.findViewById(R.id.deal_prod_img);
            deal_prize_tv = (TextView) view.findViewById(R.id.deal_prize_tv);
            deal_prod_name_tv = (TextView)view.findViewById(R.id.deal_prod_name_tv);

        }
    }}