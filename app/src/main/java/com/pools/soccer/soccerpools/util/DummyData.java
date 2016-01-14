package com.pools.soccer.soccerpools.util;

import com.pools.soccer.soccerpools.model.Bet;
import com.pools.soccer.soccerpools.model.Game;
import com.pools.soccer.soccerpools.model.Score;
import com.pools.soccer.soccerpools.model.Team;
import com.pools.soccer.soccerpools.model.Week;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucarino on 1/13/16.
 */
public class DummyData {

    public static Week getWeek(){
        Week week = new Week();
        List<Game> games = new ArrayList<>();
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());
        games.add(getGame());

        week.setGames(games);
        return week;
    }

    public static Game getGame(){
        Game game = new Game();
        game.setGuest(new Team("Pumas", "puma"));
        game.setHome(new Team("Cruz Azul", "cruzAzul"));
        game.setScore(new Score(2, 0));
        game.setBet(new Bet());
        return game;
    }

}
