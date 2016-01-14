package com.pools.soccer.soccerpools.scores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.pools.soccer.soccerpools.R;
import com.pools.soccer.soccerpools.model.Game;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lucarino on 1/13/16.
 */
public class ScoresAdapter extends RecyclerView.Adapter<ScoresAdapter.ViewHolder> {


    private List<Game> mDataSet;

    public ScoresAdapter(List<Game> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_row_item, parent, false);

       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.checkBoxHome.setText(mDataSet.get(position).getHome().getName());
        holder.checkBoxGuest.setText(mDataSet.get(position).getGuest().getName());

        holder.checkBoxGuest.setSelected(mDataSet.get(position).getBet().isGuest());
        holder.checkBoxHome.setSelected(mDataSet.get(position).getBet().isHome());
        holder.checkBoxTie.setSelected(mDataSet.get(position).getBet().isTie());


        holder.checkBoxHome.setTag(holder);
        holder.checkBoxGuest.setTag(holder);
        holder.checkBoxTie.setTag(holder);

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.checkBoxHome)
        RadioButton checkBoxHome;

        @Bind(R.id.checkBoxGuest)
        RadioButton checkBoxGuest;

        @Bind(R.id.checkBoxTie)
        RadioButton checkBoxTie;

        @Bind(R.id.rg_score)
        RadioGroup scoreGroup;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }


}
