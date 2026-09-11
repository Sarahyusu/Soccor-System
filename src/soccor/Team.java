/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccor;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author sara
 */
public class Team {
    private String name ;
    private int points ;
    private Coach coach;
    private ArrayList<Player> players ;
    public Team (String name ){
   setName(name);
        this.points = 0;
        this.players = new ArrayList<>(); 
    }
public Team(String name, Coach coach) {
        this(name);
        setCoach(coach);
    }
  public void setCoach(Coach coach){
  if(coach!=null){
      this.coach=coach;
      
  }else{System.out.println("the team should have a coach ");}
  }

    public Coach getCoach(){return coach;}
  
public void addPlayer(Player player) {
    if(player ==null){
        System.out.println("Please Enter The Name Correctly");
    }
    if(players.contains(player)){
        System.out.println("the player is already exist");}
    else{
        players.add(player);}
    }
    
    public void removePlayer(Player player) {
        players.remove(player);}
    
    public void addPoints(int point) {
        if(point>0){
        this.points += point;}
        else{System.out.println("the points should be greater than zero");}
    }
    
   public int getTotalGoals() {
        int total = 0;
        for (Player p : players) {
            total += p.getGoals();
        }
        return total;
    }
   public Player getTopScorer() {
        if (players.isEmpty()) return null;
        Player topScorer = players.get(0);
        for (Player p : players) {
            if (p.getGoals() > topScorer.getGoals()) {
                topScorer = p;
            }
        }return topScorer;
   }
    public ArrayList<Player> getPlayers() {
        return players;
    }
      public String getName() {
        return name;
    }

    public void setName(String name) {
  if (name!=null&& !name.trim().isEmpty()){
        this.name = name;}
  else{System.out.println("please enter the correct name");
    this.name="unknown Team";}
  }
       

    public void setPoints(int points) {
        if(points>=0)
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
    
   
    }

    
   
    
    

