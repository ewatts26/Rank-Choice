import java.util.*;

public class Ballot {
    // objects
    private String[] votes;
    private String[] candidates = {"chocolate", "vanilla", "oreo", "mint chip"};

    // no arg contructor - instantiates votes array
    public Ballot() {
        votes = new String[4];
        castVote();
    }

    // 4 arg contrustor - takes in + adds 4 strings to votes array
    public Ballot(String a, String b, String c, String d) {
        votes = new String[4];
        votes[0] = a;
        votes[1] = b;
        votes[2] = c;
        votes[3] = d;
    }

    // castVote()
    public void castVote() {
        ArrayList<String> hold = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Scanner userVote = new Scanner(System.in);
            System.out.println("Type the letter ('A', 'B', 'C', or 'D') that corresponds to your favorite ice cream choice (A = chocolate, B = vanilla, C = oreo, and D = mint chip). Once you pick one, you can not pick it again. ");
            String letter = userVote.nextLine();

            if (letter.equals("A") && (hold.indexOf("A") == -1)) {
                votes[i] = "chocolate";
                hold.add("A");
            } else if (letter.equals("B") && (hold.indexOf("B") == -1)) {
                votes[i] = "vanilla";
                hold.add("B");
            } else if (letter.equals("C") && (hold.indexOf("C") == -1)) {
                votes[i] = "oreo";
                hold.add("C");
            } else if (letter.equals("D") && (hold.indexOf("D") == -1)) {
                votes[i] = "mint chip";
                hold.add("D");
            }
        }
    }

    // getVoteList()
    public String[] getVoteList() {
        return votes;
    }

    // getCandidateList
    public String[] getCandidateList() {
        return candidates;
    }

    // toString() - for votes array
    public String toString() {
        String listOfVotes = "Votes in order of favorite to least favorite: ";
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                listOfVotes += votes[i] + ".";
            } else {
                listOfVotes += votes[i] + ", ";
            }
        }
        return listOfVotes;
    }
}
