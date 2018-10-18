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
import com.winklix.indu.gooni.modals.SellingModel;

import java.util.ArrayList;

/**
 * Created by android on 4/17/2018.
 */

public class Best_Sell_Adapter extends RecyclerView.Adapter<Best_Sell_Adapter.ViewHolder> {

    private ArrayList<SellingModel> sellingModels;
    private Context context;

    public Best_Sell_Adapter(Context context, ArrayList<SellingModel> sellingModels) {
        this.context = context;
        this.sellingModels = sellingModels;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offer_data, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final SellingModel abc = sellingModels.get(position);

        viewHolder.offer_prize_tv.setText(abc.getProd_name());
        viewHolder.offer_prod_name_tv.setText(abc.getProd_prise());

        Picasso.with(context)
                .load(sellingModels.get(position).getProd_img())
                .placeholder(R.drawable.logocarrt) // can also be a drawable
                .error(R.drawable.logocarrt) // will be displayed if the image cannot be loaded
                .into(viewHolder.offer_prod_img);
    }

    @Override
    public int getItemCount() {
        return sellingModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder   {

        ImageView offer_prod_img;
        public TextView offer_prod_name_tv,offer_prize_tv;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            offer_prod_img = (ImageView)view.findViewById(R.id.offer_prod_img);
            offer_prize_tv = (TextView) view.findViewById(R.id.offer_prize_tv);
            offer_prod_name_tv = (TextView)view.findViewById(R.id.offer_prod_name_tv);

        }
    }}