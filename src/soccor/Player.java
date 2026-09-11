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
public class Player extends Person  {
   private String position ;
   private int goals ;
   private int matchesPlayed;
   private double weight ;
    private double height;
    private int yellowCards;
    private int redCards;

public Player ( String position ,double weight , double height ,String name ,int id, int age){
    super(name,id,age);
setPosition(position);
this.weight= weight;
this.height=height;
this.goals=0;
this.matchesPlayed=0;
this.redCards=0;
this.yellowCards=0;
}

public void scoreGoal() {
    this.goals++;
    System.out.println("players Name:"+getName()+ "player Id: "+getId()+ "player Goals:" +this.goals);
}
 public int getGoals(){return goals;}
    public void setPosition(String position) {
        if(position != null && ! position.trim().isEmpty()){
        this.position = position;}
        else{this.position="Unknown";}
    }
    public String getPosition(){return position;}
    
    public void setWeight_kg(double weight) {
        if(weight>40&&weight<110){ this.weight = weight;}
        else {System.out.println("An healthy weight for the player.");} 
    }

    public double getWeight(){return weight;}

    public void setHeight_M(double height) {
        if(height>1.0&&height<2.5){this.height = height;}
        else{System.out.println("Unreasonable length");}
    }

    public double getHeight(){return height;}
    
public void playMatch() {
        this.matchesPlayed++;
}

    public int getMatchesPlayed(){return matchesPlayed;}

public void receiveCard(String cardType) {
        if (cardType.equalsIgnoreCase("YELLOW")) {
            this.yellowCards++;
        } else if (cardType.equalsIgnoreCase("RED")) {
            this.redCards++;
        }
    }

    public int getYellowCards(){return yellowCards;}

    public int getRedCards(){return redCards;}

  public double calculateBMI() {
        return weight / (height * height);
    }
  public String getFitnessStatus() {
        double bmi = calculateBMI();
        if (bmi < 18.5) return "Underweight";
        else if (bmi >= 18.5 && bmi <= 24.9) return "Ideal Fitness";
        else return "Overweight";
    }
    public void printPlayerProfile() {
        System.out.println("\n=================================");
        
        System.out.println("player name: " + getName() + " his position " + position);
        System.out.println("Player Age " + getAge() + " his Height " + height + "m" + " his Weight " + weight + "kg");
        System.out.println(" (BMI): " +  calculateBMI() + " [" + getFitnessStatus() + "]");
        System.out.println("Cards " + yellowCards + " yellow cards " + redCards + " red cards");
   
        System.out.println("\n=================================");
    }  
    @Override
    public void setAge(int age) {
       if (age>=15&&age<=45){this.age=age;}else {System.out.println("not allowed to blay Matches at this Age");}
    }
    @Override
    public String toString() {
        return "Player{Name='" + getName() + "', Position='" + position + "', Goals=" + goals + "}";
    }
}

