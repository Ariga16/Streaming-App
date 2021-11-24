package com.dacasa.streamingapp.portfolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dacasa.streamingapp.R;

import java.util.List;

class portfolioAdapter extends RecyclerView.Adapter<portfolioAdapter.PortfolioViewHolder> {

    List<portfolioItem> mdata;

    public portfolioAdapter(List<portfolioItem> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public PortfolioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_portfolio,parent,false);
        return new PortfolioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioViewHolder holder, int position) {

        holder.tvPosition.setText(String.valueOf(position));

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class PortfolioViewHolder extends RecyclerView.ViewHolder {

        TextView tvPosition;

        public PortfolioViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPosition = itemView.findViewById(R.id.item_port_text);

        }
    }

}
