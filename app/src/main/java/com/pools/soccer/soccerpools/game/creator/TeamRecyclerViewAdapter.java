package com.pools.soccer.soccerpools.game.creator;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pools.soccer.soccerpools.R;
import com.pools.soccer.soccerpools.model.Team;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lucarino on 1/16/16.
 */
public class TeamRecyclerViewAdapter extends RecyclerView.Adapter<TeamRecyclerViewAdapter.ViewHolder> {


    private List<Team> mDataSet;
    private static OnTeamClickListener mClickListener;
    private static Context mContext;

    public TeamRecyclerViewAdapter(List<Team> mDataSet, OnTeamClickListener listener, Context context) {
        this.mDataSet = mDataSet;
        mClickListener = listener;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_recycler_row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = mDataSet.get(position);
        holder.buttonName.setText(team.getName());
        holder.team = team;
        holder.position = position;
        holder.buttonName.setTag(holder);

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.button_team_name)
        Button buttonName;
        Team team;
        boolean isSelected = false;
        int position;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            buttonName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                buttonName.setBackground(mContext.getDrawable(R.drawable.team_button_selected));
            } else {
                buttonName.setBackground(mContext.getResources().getDrawable(R.drawable.team_button_selected));
            }
            mClickListener.onClick(team, position);
        }
    }

    public interface OnTeamClickListener {
        void onClick(Team object, int position);
    }

    public void removeItem(int position){
        if (position >= 0 && position < mDataSet.size()){
            mDataSet.remove(position);
            notifyDataSetChanged();
        }
    }

}
