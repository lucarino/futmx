package com.pools.soccer.soccerpools.util;

import com.parse.ParseObject;
import com.pools.soccer.soccerpools.model.Bet;
import com.pools.soccer.soccerpools.model.Game;
import com.pools.soccer.soccerpools.model.Team;
import com.pools.soccer.soccerpools.model.Week;
import com.pools.soccer.soccerpools.service.GameDAO;
import com.pools.soccer.soccerpools.service.TeamDAO;

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
        game.setGuest(new Team("sdasd","Pachuca", "pachuca"));
        game.setHome(new Team("asdas","Dorados", "dorados"));
        game.setBet(new Bet());
        return game;
    }

    public GameDAO getGameDao(){
        GameDAO game = new GameDAO();
        TeamDAO teamDAO = new TeamDAO();
        teamDAO.setName("UNAM");
        game.setHome(teamDAO);
        return game;
    }


    public static String UNAM = "UNAM";
    public static String TOLUCA = "Toluca";
    public static String LEON = "Leon";
    public static String JAGUARES = "Jaguares";
    public static String NUEVO_LEON = "UANL";
    public static String PUEBLA = "Puebla";
    public static String VERACRUZ = "Veracruz";
    public static String MONTERREY = "Monterrey";
    public static String MORELIA = "M. Morelia";
    public static String QUERETARO = "Queretaro";
    public static String PACHUCA = "Pachuca";
    public static String GUADALAJARA = "Guadalajara";
    public static String CRUZ_AZUL = "Cruz Azul";
    public static String ATLAS = "Atlas";
    public static String SANTOS = "S. Laguna";
    public static String TIJUANA = "Tijuana";
    public static String DORADOS = "Dorados";



    private static String[] teams = {"UNAM", "Toluca", "Leon", "Jaguares", "America", "UANL",
            "Puebla", "Veracruz", "Monterrey","M. Morelia",
            "Queretaro","Pachuca","Guadalajara","Cruz Azul",
            "Atlas", "S. Laguna", "Tijuana", "Dorados"};

    public static String[] getTeams() {
        return teams;
    }


    public void createGame(String homeKEy, String guestKey){


    }

    public void createTeamsInTheCloud(String[] teams) {
        for (int i = 0; i < teams.length; i++) {
            ParseObject mObject = new ParseObject("Team");
            mObject.put("name", DummyData.getTeams()[i]);
            mObject.put("imageId", i + 1);
            mObject.saveInBackground();
        }
    }
}
