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
public class Coach extends Person {

    private String training_Licences;
    private double years_Of_Work;
    private double baseSalary;
    private ArrayList<String> previousTeams;

    public Coach(String training_Licences, double years_Of_Work, double baseSalary, String name, int id, int age) {
        super(name, id, age);
        setTraining_Licences(training_Licences);
        setYears_Of_Work(years_Of_Work);
        setBaseSalary(baseSalary);
        this.previousTeams = new ArrayList<>();
    }

    public void setTraining_Licences(String training_Licences) {
        if (training_Licences != null && !training_Licences.trim().isEmpty()) {
            this.training_Licences = training_Licences;
        } else {
            this.training_Licences = "Unlicensed";
        }
    }

    public String getTraining_Licences() {
        return training_Licences;
    }

    public double getYears_Of_Work() {
        return years_Of_Work;
    }

    public void setYears_Of_Work(double years_Of_Work) {
        if (years_Of_Work >= 0) {
            this.years_Of_Work = years_Of_Work;
        } else {
            System.out.println("not allowed ");
            this.years_Of_Work = 0;
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            this.baseSalary = 0;
        }
    }

    public ArrayList<String> getPreviousTeams() {
        return previousTeams;
    }

    public void setPreviousTeams(ArrayList<String> previousTeams) {
        this.previousTeams = previousTeams;
    }
public double calculateTotalSalary() {
        double bonusPercentage = 0;
        if (this.training_Licences.equalsIgnoreCase("UEFA Pro")) {
            bonusPercentage += 0.50; 
        } else if (this.training_Licences.equalsIgnoreCase("UEFA A")) {
            bonusPercentage += 0.30;
        } else if (this.training_Licences.equalsIgnoreCase("UEFA B")) {
            bonusPercentage += 0.15; 
        }
        if (this.years_Of_Work >= 10) {
            bonusPercentage += 0.20;
        } else if (this.years_Of_Work >= 5) {
            bonusPercentage += 0.10;
        }

        return baseSalary + (baseSalary * bonusPercentage);
    }
public void printCareerSummary() {
        System.out.println("=================================");
        System.out.println("Name of Coach " + getName() + "Coaching training Licence: " + training_Licences);
        System.out.println("experience years:" + years_Of_Work + " years");
        System.out.println("Final Salary" + calculateTotalSalary()+ "$");
        
        System.out.println("Clubs he previously coached");
        if (previousTeams.isEmpty()) {
            System.out.println("there is no previous clubs");
        } else {
            for (int i = 0; i < previousTeams.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + previousTeams.get(i));
            }
        }
        System.out.println("=================================");
    }

    @Override
    public String toString() {
        return "Coach{Name='" + getName() + "', Licence='" + training_Licences + "', Experience=" + years_Of_Work + " years}";
    }

    @Override
    public void setAge(int age) {
        if (age >= 35) {
            this.age = age;
        } else {
            System.out.println("Donot allowed to be soccer coach at this age");
        }
    }

}
