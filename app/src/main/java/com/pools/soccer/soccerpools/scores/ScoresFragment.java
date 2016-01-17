package com.pools.soccer.soccerpools.scores;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pools.soccer.soccerpools.R;
import com.pools.soccer.soccerpools.commons.BaseFragment;
import com.pools.soccer.soccerpools.util.DummyData;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Fragment that shows weekly matches and if available it will
 * expose UI components that let the user create a bet for the match.
 *
 * @author luis.carino
 */
public class ScoresFragment extends BaseFragment {

    @Bind(R.id.rv_games)
    RecyclerView mGamesRecyclerView;

    public ScoresFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_scores, container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ScoresAdapter scoresAdapter = new ScoresAdapter(DummyData.getWeek().getGames());

        mGamesRecyclerView.setHasFixedSize(true);
        mGamesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mGamesRecyclerView.setAdapter(scoresAdapter);

    }
}
