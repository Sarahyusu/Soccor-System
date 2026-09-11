/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccor;

import java.util.ArrayList;

public class Soccor {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("                     REALISTIC MATCH SIMULATION SYSTEM                    ");
        System.out.println("==========================================================================");

       
        Person[] matchParticipants = new Person[23];

    
        matchParticipants[0] = new Coach("UEFA Pro", 15.0, 60000, "Carlo Ancelotti", 101, 64);
        matchParticipants[1] = new Coach("UEFA Pro", 10.0, 50000, "Xavi Hernandez", 102, 44);

       
        matchParticipants[2]  = new Player("Goalkeeper", 85.0, 1.99, "Thibaut Courtois", 201, 31);
        matchParticipants[3]  = new Player("Defender",   75.0, 1.80, "Dani Carvajal",     202, 32);
        matchParticipants[4]  = new Player("Defender",   78.0, 1.86, "Eder Militao",      203, 26);
        matchParticipants[5]  = new Player("Defender",   82.0, 1.90, "Antonio Rudiger",   204, 30);
        matchParticipants[6]  = new Player("Defender",   73.0, 1.80, "Ferland Mendy",     205, 28);
        matchParticipants[7]  = new Player("Midfielder", 76.0, 1.82, "Federico Valverde",  206, 25);
        matchParticipants[8]  = new Player("Midfielder", 70.0, 1.72, "Luka Modric",       207, 38);
        matchParticipants[9]  = new Player("Midfielder", 75.0, 1.86, "Jude Bellingham",   208, 20);
        matchParticipants[10] = new Player("Forward",    72.0, 1.75, "Rodrygo Goes",      209, 23);
        matchParticipants[11] = new Player("Forward",    73.0, 1.76, "Vinicius Jr",       210, 23);
        matchParticipants[12] = new Player("Forward",    72.0, 1.73, "Brahim Diaz",       211, 24);

        matchParticipants[13] = new Player("Goalkeeper", 80.0, 1.87, "Marc-Andre ter Stegen", 301, 31);
        matchParticipants[14] = new Player("Defender",   72.0, 1.78, "Jules Kounde",         302, 25);
        matchParticipants[15] = new Player("Defender",   81.0, 1.88, "Ronald Araujo",        303, 24);
        matchParticipants[16] = new Player("Defender",   75.0, 1.84, "Andreas Christensen",  304, 27);
        matchParticipants[17] = new Player("Defender",   71.0, 1.86, "Pau Cubarsi",          305, 17);
        matchParticipants[18] = new Player("Midfielder", 74.0, 1.74, "Frenkie de Jong",      306, 26);
        matchParticipants[19] = new Player("Midfielder", 68.0, 1.74, "Pedri Gonzalez",      307, 21);
        matchParticipants[20] = new Player("Midfielder", 70.0, 1.80, "Ilkay Gundogan",      308, 33);
        matchParticipants[21] = new Player("Forward",    68.0, 1.74, "Lamine Yamal",         309, 17);
        matchParticipants[22] = new Player("Forward",    80.0, 1.85, "Robert Lewandowski",   310, 35);

     
        for (Person p : matchParticipants) {
            p.setAge(p.getAge());
        }

        Coach coachReal = (Coach) matchParticipants[0];
        Coach coachBarca = (Coach) matchParticipants[1];

        Team realMadrid = new Team("Real Madrid", coachReal);
        Team barcelona = new Team("FC Barcelona", coachBarca);

        for (int i = 2; i <= 12; i++) {
            realMadrid.addPlayer((Player) matchParticipants[i]);
        }
        for (int i = 13; i <= 22; i++) {
            barcelona.addPlayer((Player) matchParticipants[i]);
        }

        
        System.out.println(" TEAM ROSTERS & POSITIONS");
        System.out.println(" REAL MADRID SQUAD:");
        for (Player p : realMadrid.getPlayers()) {
            System.out.println(" " + p.getName() + " | Position: " + p.getPosition());
        }

        System.out.println(" FC BARCELONA SQUAD:");
        for (Player p : barcelona.getPlayers()) {
            System.out.println(  p.getName() + " | Position: " + p.getPosition());
        }

      
        System.out.println("\n==========================================================================");
        System.out.println(" MATCH LIVE EVENTS & CARDS ISSUED");
        System.out.println("==========================================================================");

        Match match = new Match("M-ELCLASICO", "2026-10-25", realMadrid, barcelona);
       
        match.setHomeTeam(realMadrid);
        match.setAwayTeam(barcelona);

        Player vinicius = (Player) matchParticipants[11];
        Player rudiger = (Player) matchParticipants[5];
        Player araujo = (Player) matchParticipants[15];
        Player lewandowski = (Player) matchParticipants[22];
        Player bellingham = (Player) matchParticipants[9];

        rudiger.receiveCard("YELLOW");
        araujo.receiveCard("YELLOW");
        vinicius.receiveCard("YELLOW");
        araujo.receiveCard("RED");

        Goal g1 = new Goal("M-ELCLASICO", 18, vinicius, realMadrid);
        Goal g2 = new Goal("M-ELCLASICO", 44, lewandowski, barcelona);
        Goal g3 = new Goal("M-ELCLASICO", 76, vinicius, realMadrid);
        Goal g4 = new Goal("M-ELCLASICO", 89, bellingham, realMadrid);

        match.addGoal(g1);
        match.addGoal(g2);
        match.addGoal(g3);
        match.addGoal(g4);

        System.out.println("\n==========================================================================");
        System.out.println("  MATCH FINAL RESULT & SUMMARY  ");
        System.out.println("==========================================================================");

        match.finishMatch();

      
        Player matchTopScorer = null;
        int maxGoals = -1;
        for (Person p : matchParticipants) {
            if (p instanceof Player) {
                Player pl = (Player) p;
                if (pl.getGoals() > maxGoals) {
                    maxGoals = pl.getGoals();
                    matchTopScorer = pl;
                }
            }
        }

        if (matchTopScorer != null && maxGoals > 0) {
            System.out.println("\n Match Top Scorer: " + matchTopScorer.getName() + " (" + maxGoals + " Goals)");
        }

       
        Team winningTeam = match.getWinner();
        if (winningTeam != null) {
            System.out.println("\n WINNING TEAM: " + winningTeam.getName());
            System.out.println("--------------------------------------------------");
            for (Player p : winningTeam.getPlayers()) {
                System.out.println(  p.getName() + " | Goals in Match: " + p.getGoals() + " | Yellow: " + p.getYellowCards() + " | Red: " + p.getRedCards());
            }
            if (winningTeam.getTopScorer() != null) {
                System.out.println(" Team Top Scorer: " + winningTeam.getTopScorer().getName() + " (" + winningTeam.getTopScorer().getGoals() + " Goals)");
            }
        }
    }
}