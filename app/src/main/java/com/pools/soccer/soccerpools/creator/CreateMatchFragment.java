package com.pools.soccer.soccerpools.creator;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.pools.soccer.soccerpools.R;
import com.pools.soccer.soccerpools.model.Team;
import com.pools.soccer.soccerpools.util.OttoHelper;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Game creator fragment, exposes UI elements so the user can
 * select the home and guest teams for this match.
 */
public class CreateMatchFragment extends Fragment implements MatchContract.View, TeamRecyclerViewAdapter.OnTeamClickListener {

    private final String TAG = this.getClass().getSimpleName();


    @Bind(R.id.rv_teams)
    RecyclerView rvTeams;

    private String homeId;
    private String homeName;

    private MatchContract.Presenter mUserActionListener;
    private TeamRecyclerViewAdapter mAdapter;

    //////////////// life cycle methods //////////

    public CreateMatchFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // register fragment to the bus
        OttoHelper.getInstance().register(this);

        // set listener for presenter callbacks
        mUserActionListener = new MatchPresenterImp(this);

        // as soon as this fragment is created request to get teams for server.
        mUserActionListener.getAllTeams();
    }

    public static CreateMatchFragment newInstance() {
        CreateMatchFragment fragment = new CreateMatchFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onStop() {
        super.onStop();
        OttoHelper.getInstance().unregister(this);
    }


    /////////////////////// View contract implementation///////////////////////
    @Override
    public void setTeamsToAdapter(List<Team> teams) {

        rvTeams.setLayoutManager(new LinearLayoutManager(getContext()));
        // TODO: extract this decoration to its own class file, maybe?
        rvTeams.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int distance = 50;
                outRect.bottom = distance;

                // Add top margin only for the first item to avoid double space between items
                if (parent.getChildLayoutPosition(view) == 0)
                    outRect.top = distance;
            }
        });
        mAdapter = new TeamRecyclerViewAdapter(teams, this, getContext());
        rvTeams.setAdapter(mAdapter);

    }

    @Override
    public void onHomeButtonClicked(final int position, View button) {

        final Team team = mAdapter.getItem(position);
        Snackbar.make(getView(), String.format(getString(R.string.select_home_team_confirmation), team.getName()), Snackbar.LENGTH_INDEFINITE)
                .setAction("CONFIRM", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        homeId = team.getId();
                        homeName = team.getName();
                        mAdapter.updateToVisitor(position);
                        Log.d(TAG, homeId);
                    }
                }).show();


    }

    @Override
    public void onVisitorButtonClicked(final int position, View view) {
        final Team team = mAdapter.getItem(position);
        Snackbar.make(getView(), String.format(getString(R.string.confirm_match), homeName, team.getName()),
                Snackbar.LENGTH_INDEFINITE)
                .setAction("SAVE", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mUserActionListener.createNewGame(homeId, team.getId());
                        Log.d(TAG, homeId+" VS "+team.getId());
                    }
                }).show();
    }

    @Override
    public void onGameCreated() {
        Toast.makeText(getContext(), "GAME CREATED :D", Toast.LENGTH_LONG).show();
    }

    public String getToolbarTitle(){
        return "Create new Match";
    }
}
