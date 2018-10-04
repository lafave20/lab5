package edu.up.cs371.soccer_application;

import android.util.Log;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 * 
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    //create hashmap to store palyers and their info/stats
    HashMap<String, SoccerPlayer> playerHashMap = new HashMap<String, SoccerPlayer>();

    @Override
	public boolean addPlayer(String firstName, String lastName,
			int uniformNumber, String teamName) {

        String playerKey = firstName + " ## " + lastName;


        if( playerHashMap.containsKey(playerKey)) {
            return false;   //returns false if player is already in map
        }
        else {
                //not already in the database, create a SoccerPlayer
            SoccerPlayer newPlayer = new SoccerPlayer( firstName, lastName, uniformNumber, teamName);
            playerHashMap.put( playerKey , newPlayer);
                return true;
            }








    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {

        String playerKey = firstName + " ## " + lastName;


        if( playerHashMap.containsKey(playerKey)) {
            //player was found -> removes then returns true
            playerHashMap.remove( playerKey);

            return true;

            //remove and return true
        }
        else {
            //not in the database cannot remove
            return false;
        }




    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
	public SoccerPlayer getPlayer(String firstName, String lastName) {

        String playerKey = firstName + " ## " + lastName;

        if( playerHashMap.containsKey(playerKey)) {
            return playerHashMap.get(playerKey);   //returns the SP it finds at the key in the map
        }
        else {
            //nothing is there at this key
            return null;
        }

    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {

        String playerKey = firstName + " ## " + lastName;

        if( playerHashMap.containsKey(playerKey)) {
        SoccerPlayer goalScorer = (SoccerPlayer) playerHashMap.get(playerKey);
        goalScorer.bumpGoals();
        return true;
        }
        else{return false;}

    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */





    @Override
    public boolean bumpAssists(String firstName, String lastName) {
       String playerKey = firstName + " ## " + lastName;

        if( playerHashMap.containsKey(playerKey)) {
        SoccerPlayer goalScorer = (SoccerPlayer) playerHashMap.get(playerKey);
        goalScorer.bumpAssists();
        return true;
        }
        else{return false;}
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String playerKey = firstName + " ## " + lastName;

        if( playerHashMap.containsKey(playerKey)) {
        SoccerPlayer goalScorer = (SoccerPlayer) playerHashMap.get(playerKey);
        goalScorer.bumpShots();
        return true;
        }
        else{return false;}
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String playerKey = firstName + " ## " + lastName;

        if( playerHashMap.containsKey(playerKey)) {
        SoccerPlayer goalScorer = (SoccerPlayer) playerHashMap.get(playerKey);
        goalScorer.bumpSaves();
        return true;
        }
        else{return false;}
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
       String playerKey = firstName + " ## " + lastName;

        if( playerHashMap.containsKey(playerKey)) {
        SoccerPlayer goalScorer = (SoccerPlayer) playerHashMap.get(playerKey);
        goalScorer.bumpFouls();
        return true;
        }
        else{return false;}
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String playerKey = firstName + " ## " + lastName;

        if( playerHashMap.containsKey(playerKey)) {
        SoccerPlayer goalScorer = (SoccerPlayer) playerHashMap.get(playerKey);
        goalScorer.bumpYellowCards();
        return true;
        }
        else{return false;}
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
       String playerKey = firstName + " ## " + lastName;

        if( playerHashMap.containsKey(playerKey)) {
        SoccerPlayer goalScorer = (SoccerPlayer) playerHashMap.get(playerKey);
        goalScorer.bumpRedCards();
        return true;
        }
        else{return false;}
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
	public int numPlayers(String teamName) {

        if (teamName == null)
            {
                return playerHashMap.size();//counts players on all teams
            }
           int count = 0;
            for ( SoccerPlayer onTeamPlayer : playerHashMap.values() )
                {
                    if ( onTeamPlayer.getTeamName().equals(teamName))//checks to see if player is on selected team
                        {
                            count++;//counts players on selected team
                        }
                }
            return count;
	}

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
	// get the nTH player
	@Override
    public SoccerPlayer playerNum(int idx, String teamName) {

	    ArrayList<SoccerPlayer> teamArray = new ArrayList();

	    for ( SoccerPlayer onTeamPlayer : playerHashMap.values() )
                {
                   if (teamName == null) //look for nth palyer in whole database
                       {
                teamArray.add(onTeamPlayer);
                        }

                    else if ( onTeamPlayer.getTeamName().equals(teamName))//checks to see if player is on selected team
                        {
                            teamArray.add(onTeamPlayer);//adds player to end of ArrayList
                        }

                 }
                 if( idx < teamArray.size( ))
                     {
                     return teamArray.get(idx);
                     }
	            else
	            {
	            return null;
	            }
}


    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
	// read data from file
    @Override
	public boolean readData(File file) {
        return file.exists();
	}

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
	// write data to file
    @Override
	public boolean writeData(File file) {

        try {

            PrintWriter printWriter = new PrintWriter(file);
            for (SoccerPlayer onTeamPlayer : playerHashMap.values()) {
                for (int i = 0; i < 11; i++) {
                    printWriter.println(logString(onTeamPlayer.getFirstName()+"" ));
                    printWriter.println(logString(onTeamPlayer.getLastName()+"" ));
                    printWriter.println(logString( onTeamPlayer.getUniform()+"" ));
                    printWriter.println(logString(onTeamPlayer.getTeamName()+"" ));

                    printWriter.println(logString(onTeamPlayer.getGoals()+"" ));
                    printWriter.println(logString(onTeamPlayer.getAssists()+"" ));
                    printWriter.println(logString(onTeamPlayer.getShots()+"" ));
                    printWriter.println(logString(onTeamPlayer.getSaves()+"" ));
                    printWriter.println(logString(onTeamPlayer.getRedCards()+"" ));
                    printWriter.println(logString(onTeamPlayer.getYellowCards()+"" ));
                    printWriter.println(logString(onTeamPlayer.getFouls()+"" ));

                }
            }
            return true;
        }
        catch (java.io.FileNotFoundException error1)
        {
            return false;

        }
	}

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
	// return list of teams
    @Override
	public HashSet<String> getTeams() {
        return new HashSet<String>();
	}

}
