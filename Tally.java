import java.util.*;

public class Tally {
    // objects
    private ArrayList<Ballot> allBallots;
    private int[] tallies;
    private int roundNum = 0;
    private ArrayList<String> eliminated = new ArrayList<>();
    private String winner;
    private double percent;

    // 1 arg constructor
    public Tally(ArrayList<Ballot> allBallots) {
        this.allBallots = allBallots;
        this.tallies = new int[4];
    }

    // countNext()
    public void countNext() {
        for (int i = 0; i < allBallots.size(); i++) {
            String temp = allBallots.get(i).getVoteList()[roundNum];
            if ((temp.equals("A")) && !(eliminated.contains("A"))) {
                tallies[0] += 1;
            } else if ((temp.equals("B")) && !(eliminated.contains("B"))) {
                tallies[1] += 1;
            } else if ((temp.equals("C")) && !(eliminated.contains("C"))) {
                tallies[2] += 1;
            } else if ((temp.equals("D")) && !(eliminated.contains("D"))) {
                tallies[3] += 1;
            }
        }
        
        if (!isMajority()) {
            roundNum++;
            countNext();
        } else {

        }
    }
    

    // isMajority()
    public boolean isMajority() {
        // max
        double max = 0.0;
        double total = 0.0;
        int index = 0;
        for (int i = 0; i < tallies.length; i++) {
            if (tallies[i] > max) {
                max = tallies[i];
                index = i;
            }
            total += tallies[i];
        }
        percent = max / total;
        if (percent > 0.5) {
            switch(index) {
                case 0:
                winner = "chocolate";
                break;
                case 1:
                winner = "vanilla";
                break;
                case 2:
                winner = "oreo";
                break;
                case 3:
                winner = "mint chip";
                break;
            }
            return true;
        }
        
        // min
        int min = tallies[0];
        for (int i = 0; i < tallies.length; i++) {
            if (tallies[i] < tallies[min]) {
                min = i;
            }
        }
        
        switch(min) {
            case 0:
            eliminated.add("A");
            break;
            case 1:
            eliminated.add("B");
            break;
            case 2:
            eliminated.add("C");
            break;
            case 3:
            eliminated.add("D");
            break; 
        }
        return false;
    }

    // toString()
    public String toString() {
        String str = "The winner is " + winner + ". The number of counting rounds is " + (roundNum + 1) + ". The percent of votes they recieve is " + (percent * 100) + ".";
        return str;
    }
}
