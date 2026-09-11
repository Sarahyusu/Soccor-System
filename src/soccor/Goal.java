/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccor;

/**
 *
 * @author sara
 */
public class Goal {
    private String matchID ;
 private int minute;
 private Player scorer ;
 private Team team ;
 public Goal (String matchID , int minute, Player scorer,Team team){
 setMatchID(matchID);
 setMinute(minute);
 setScorer(scorer);
  setTeam(team);}
public void setScorer(Player scorer){
if (scorer!= null) {
    this.scorer=scorer;
  this.scorer.scoreGoal();}
else{System.out.println("Error: A goal cannot be recorded without specifying the player who scored.");}
 }
 public Player getScorer(){return scorer;}
    
     public void setMatchID(String matchID) {
        if (matchID != null && !matchID.trim().isEmpty()) {
            this.matchID = matchID;
        } else {
            this.matchID = "Unknown Match";
        }
    }
 public String getMatchID(){return matchID;}
 
    public void setMinute(int minute) {
        if(minute>=1&&minute<=120){
        this.minute = minute;}
       
    }
 public int getMinute(){return minute;}
    
    public void setTeam(Team team) {
        if(team!=null){
        this.team = team;}
        else{System.out.println("The team that scored the goal must be identified.");}
    }

    public Team getTeam(){return team;}

    
@Override
    public String toString() {
        return "Goal{Minute=" + minute + "', Scorer=" + (scorer != null ? scorer.getName() : "N/A") + "}";
    }
}
 
