/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Schedule {
    private List<Team> teams;
    private List<Match> matches;

    public Schedule() {
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

   
    public void addTeam(Team team) {
        if (team != null && !teams.contains(team)) {
            teams.add(team);
        } else {
System.out.println("The team is invalid or already exists in the table!");        }
    }

    
    public void addMatch(Match match) {
        if (match != null && !matches.contains(match)) {
            matches.add(match);
        } else {
System.out.println(" The match is invalid or already added!");        }
    }

  
    public void updateStatistics() {
      
        for (Team team : teams) {
            team.setPoints(0);
        }

    
        for (Match match : matches) {
            if (match.isPlayed()) {
              
                int homeGoals = match.getGoalsScoredBy(match.getHomeTeam());
                int awayGoals = match.getGoalsScoredBy(match.getAwayTeam());

                if (homeGoals > awayGoals) {
                    match.getHomeTeam().addPoints(3);
                } else if (awayGoals > homeGoals) {
                    match.getAwayTeam().addPoints(3);
                } else {
                    match.getHomeTeam().addPoints(1);
                    match.getAwayTeam().addPoints(1);
                }
            }
        }
    }

    
    public void displayResultsTable() {
       
        updateStatistics();

   
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                if (t2.getPoints() != t1.getPoints()) {
                    return Integer.compare(t2.getPoints(), t1.getPoints()); 
                }
                return Integer.compare(t2.getTotalGoals(), t1.getTotalGoals()); 
            }
        });
System.out.println("\n=======================================================");
        System.out.println("               League Standings Table                   ");
        System.out.println("=======================================================");
        System.out.printf("%-5s | %-20s | %-8s | %-12s%n", "Rank", "Team Name", "Points", "Total Goals");
        System.out.println("-------------------------------------------------------");
     
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            System.out.printf("%-5d | %-20s | %-8d | %-12d%n",
                    (i + 1),
                    team.getName(),
                    team.getPoints(),
                    team.getTotalGoals());
        }
        System.out.println("=======================================================\n");
    }

 
    public List<Team> getTeams() { return teams; }
    public List<Match> getMatches() { return matches; }
}