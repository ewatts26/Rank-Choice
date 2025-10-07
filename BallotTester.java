import java.util.*;

public class BallotTester {
    public static void main(String[] args) {
        // 5 Ballot objects - 1 0-arg and 4 4-arg
        // Ballot b1 = new Ballot();
        Ballot b2 = new Ballot("A", "B", "C", "D");
        Ballot b3 = new Ballot("A", "C", "B", "D");
        Ballot b4 = new Ballot("B", "A", "C", "D");
        Ballot b5 = new Ballot("B", "A", "C", "D");
        
        // array list containing the 5 ballots
        ArrayList<Ballot> ballots = new ArrayList<>();
        // ballots.add(b1);
        ballots.add(b2);
        ballots.add(b3);
        ballots.add(b4);
        ballots.add(b5);

        // tally object
        Tally t1 = new Tally(ballots);
        
        // count the votes
        t1.countNext();

        // display election results
        System.out.println(t1);
    }
}
