package com.winklix.indu.gooni.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.winklix.indu.gooni.R;
import com.winklix.indu.gooni.activities.ProdDescActivity;
import com.winklix.indu.gooni.modals.OfferModel;

import java.util.ArrayList;

/**
 * Created by harsh on 29/01/2018.
 */

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {

    private ArrayList<OfferModel> offerModels;
    private Context context;

    public OfferAdapter(Context context, ArrayList<OfferModel> offerModels) {
        this.context = context;
        this.offerModels = offerModels;

    }

    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offer_data, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final OfferModel abc = offerModels.get(position);

        viewHolder.offer_prize_tv.setText(abc.getProd_name());
        viewHolder.offer_prod_name_tv.setText(abc.getProd_prise());
        //Picasso.with(context).load(offerModels.get(position).getProd_img()).into(viewHolder.offer_prod_img);
        Picasso.with(context)
                .load(offerModels.get(position).getProd_img())
                .placeholder(R.drawable.logocarrt) // can also be a drawable
                .error(R.drawable.logocarrt) // will be displayed if the image cannot be loaded
                .into(viewHolder.offer_prod_img);
    }

    @Override
    public int getItemCount() {
        return offerModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView offer_prod_img;
        public TextView offer_prize_tv,offer_prod_name_tv;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            offer_prod_img = (ImageView)view.findViewById(R.id.offer_prod_img);
            offer_prize_tv = (TextView) view.findViewById(R.id.offer_prize_tv);
            offer_prod_name_tv = (TextView)view.findViewById(R.id.offer_prod_name_tv);

            offer_prod_img.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            //int id = view.getId();
            Intent intent = new Intent(context, ProdDescActivity.class);
            context.startActivity(intent);
        }
    }}