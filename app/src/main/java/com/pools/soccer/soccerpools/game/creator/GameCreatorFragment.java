package com.pools.soccer.soccerpools.game.creator;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pools.soccer.soccerpools.R;
import com.pools.soccer.soccerpools.model.Team;
import com.pools.soccer.soccerpools.util.OttoHelper;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Game creator fragment, exposes UI elements so the user can
 * select the home and guest teams for this match.
 *
 */
public class GameCreatorFragment extends Fragment implements GameCreatorContract.View, TeamRecyclerViewAdapter.OnTeamClickListener {

    private final String TAG = this.getClass().getSimpleName();

    @Bind(R.id.rv_teams)
    RecyclerView rvTeams;

    private GameCreatorContract.Presenter mUserActionListener;
    private TeamRecyclerViewAdapter mAdapter;

    //////////////// life cycle methods //////////

    public GameCreatorFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // register fragment to the bus
        OttoHelper.getInstance().register(this);

        // set listener for presenter callbacks
        mUserActionListener = new GameCreatorPresenterImp(this);

        // as soon as this fragment is created request to get teams for server.
        mUserActionListener.getAllTeams();
    }

    public static GameCreatorFragment newInstance() {
        GameCreatorFragment fragment = new GameCreatorFragment();
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
    public void setTeamsToSpinner(List<Team> teams) {

        rvTeams.setLayoutManager(new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false));
        // TODO: extract this decoration to its own class file, maybe?
        rvTeams.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                final int space = 10;
                outRect.right = space;
                outRect.bottom = space;
            }
        });
        mAdapter = new TeamRecyclerViewAdapter(teams, this, getContext());
        rvTeams.setAdapter(mAdapter);

    }

    int homePosition;
    String homeTeamId;
    String guestTeamId;
    boolean isHomeSelected = false;
    @Override
    public void onClick(Team object, int position) {
        // save position and id of selected item
        if(!isHomeSelected) {
            homePosition = position;
            homeTeamId = object.getId();
            isHomeSelected = true;
        } else {
            guestTeamId = object.getId();
        }

        Log.d(TAG, object.toString());
    }

    ////////////////////////// UI methods from fragment//////////////
    @OnClick(R.id.fab_next)
    public void onFavClicked(View view){
        mAdapter.removeItem(homePosition);
    }

}
