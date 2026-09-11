/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccor;

import java.util.ArrayList;

/**
 *
 * @author sara
 */
public class Match {
 private String matchID ;
 private boolean played ;
 private String matchDate;
private  Team homeTeam;
private Team  awayTeam;
private Team winner;
private ArrayList <Goal> goals ;
public Match(String matchID, String matchDate, Team homeTeam, Team awayTeam) {
        setMatchID(matchID);
        setMatchDate(matchDate);
        setHomeTeam(homeTeam);
        setAwayTeam(awayTeam);
        this.played = false;
        this.goals = new ArrayList<>();
        this.winner = null; 
    }
public boolean isPlayed() {
        if ( played){
            System.out.println("the match played successfully");
            
        }else {
            System.out.println("the match donot played");
}
  return played ;      
}
 
public void setMatchID(String matchID) {
        if (matchID != null && !matchID.trim().isEmpty()) {
            this.matchID = matchID;
        } else {
            this.matchID = "MATCH_000";
        }
    }
    public String getMatchID() {return matchID;}
    
    public void setMatchDate(String matchDate) {
        if (matchDate != null && !matchDate.trim().isEmpty()) {
            this.matchDate = matchDate;
        } else {
            this.matchDate = "DMY";
        }
    }
    public String getMatchDate(){return matchDate;}
    
public void setHomeTeam(Team homeTeam) {
        if (homeTeam != null) {
            this.homeTeam = homeTeam;
        } else {
            System.out.println("should there a Hometeam");
    }
}
    public Team getHomeTeam() {
        return homeTeam;
    }
public void setAwayTeam(Team awayTeam) {
        if (awayTeam != null) {
            this.awayTeam = awayTeam;
        } else {
            System.out.println("should there a awayteam");
    }
}
    public Team getAwayTeam() {
        return awayTeam;
    }
    public void addGoal(Goal goal) {
        if(played){
            System.out.println("the match already played");}
        if(goals!=null && goal.getScorer()!=null){
        this.goals.add(goal);
        goal.getScorer().scoreGoal();
        System.out.println("Goal for " + goal.getScorer().getName() + " in the " + goal.getMinute() + "the minute");}
        else{System.out.println(" Invalid Goal data");}
    }
    public int getGoalsScoredBy(Team team) {
        int count = 0;
        for (Goal g : goals) {
            if (g.getTeam() != null && g.getTeam().getName().equalsIgnoreCase(team.getName())) {
                count++;
            }
        }
        return count;
    }
    public void finishMatch() {
        if (played) {
            System.out.println(" The match has already been played.");
            return;
        }
        if (homeTeam == null || awayTeam == null) {
        System.out.println("Cannot finish match: Home or Away team is missing!");
        return;
    }

        this.played = true;

        for (Player p : homeTeam.getPlayers()) { p.playMatch(); }
        for (Player p : awayTeam.getPlayers()) { p.playMatch(); }
        int homeGoals = getGoalsScoredBy(homeTeam);
        int awayGoals = getGoalsScoredBy(awayTeam);

    
        System.out.println(" final Results: " + homeTeam.getName() + " [" + homeGoals + " - " + awayGoals + "] " + awayTeam.getName());

      
        if (homeGoals > awayGoals) {
            this.winner = homeTeam;
            homeTeam.addPoints(3); 
            System.out.println("the winner is " + homeTeam.getName() );
        } else if (awayGoals > homeGoals) {
            this.winner = awayTeam;
            awayTeam.addPoints(3); 
            System.out.println("the winner is" + awayTeam.getName() + " ");
        } else {
            this.winner = null; 
            homeTeam.addPoints(1); 
            awayTeam.addPoints(1);
            System.out.println("The match ended in a draw!(One point for each team)");}
    }
 public Team getWinner() { return winner; }

    public ArrayList<Goal> getGoals() { return goals; }
}
   
   


