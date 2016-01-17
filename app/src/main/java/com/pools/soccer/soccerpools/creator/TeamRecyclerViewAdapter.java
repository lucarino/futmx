package com.pools.soccer.soccerpools.creator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pools.soccer.soccerpools.R;
import com.pools.soccer.soccerpools.model.Team;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Recycler View adapter used to shown a list of cards that contains information about teams.
 *
 * @author luis.carino
 */
public class TeamRecyclerViewAdapter extends RecyclerView.Adapter<TeamRecyclerViewAdapter.ViewHolder> {


    private List<Team> mDataSet;
    private static OnTeamClickListener mClickListener;
    private static Context mContext;

    // Allows to remember the last item shown on screen
    private int lastPosition = -1;

    public TeamRecyclerViewAdapter(List<Team> mDataSet, OnTeamClickListener listener, Context context) {
        this.mDataSet = mDataSet;
        mClickListener = listener;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_team_card_row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = mDataSet.get(position);
        holder.tvTeamName.setText(team.getName());
        holder.ivTeam.setImageDrawable(getResourceByName(team.getImageId()));
        holder.isVisitor = team.isVisitor();
        holder.position = position;
        if(holder.isVisitor){
            holder.btnHome.setVisibility(View.GONE);
            holder.btnVisitor.setVisibility(View.VISIBLE);
        }

        holder.tvTeamName.setTag(holder);



    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.cv_team)
        CardView cvTeam;
        @Bind(R.id.tv_team_card_name)
        TextView tvTeamName;
        @Bind(R.id.iv_team_card_image)
        ImageView ivTeam;
        @Bind(R.id.button_team_card_home)
        Button btnHome;
        @Bind(R.id.button_team_card_visitor)
        Button btnVisitor;
        int position;
        boolean isVisitor = false;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            btnHome.setOnClickListener(this);
            btnVisitor.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_team_card_home:
                    mClickListener.onHomeButtonClicked(position, v);
                    break;
                case R.id.button_team_card_visitor:
                    mClickListener.onVisitorButtonClicked(position, v);
                    break;
                default:
                    break;
            }

        }
    }

    public interface OnTeamClickListener {
        void onHomeButtonClicked(int position, View view);

        void onVisitorButtonClicked(int position, View view);
    }

    private Drawable getResourceByName(String name) {
        final String TYPE = "drawable";
        Resources resources = mContext.getResources();
        final int resourceId = resources.getIdentifier(name, TYPE,
                mContext.getPackageName());
        return resources.getDrawable(resourceId);
    }

    public Team getItem(int location) {
        return mDataSet.get(location);
    }

    public void updateToVisitor(int position){
        mDataSet.remove(position);
        for(Team t : mDataSet){
            t.setIsVisitor(true);
        }
        this.notifyDataSetChanged();
    }

}
