import java.util.*; //I needed to import this

/**
 * This class represents a card player.
 *
 * For each card player instance, we should keep track of how many points
 * they earned in the game so far, as well as whether it is their turn or not.
 * Additionally, their hand and bank of cards should be stored in two
 * separate ArrayLists of Card objects.
 *
 * <p>
 * A player's points, turn, and hand of cards should all be declared
 * private fields, whereas the bank of cards should be public, as follows:
 * <p>
 * <code>
 * 		private int points;
 *
 * 		private boolean turn;
 *
 * 		private ArrayList&lt;Card&gt; hand = new ArrayList&lt;Card&gt;();
 *
 * 		public ArrayList&lt;Card&gt; bank = new ArrayList&lt;Card&gt;();
 * </code>
 * <p>
 *
 * Note that the Field Summary section below will only show you public fields,
 * but you must declare all the fields described above in your implementation of
 * this class,
 * including the private fields. You are free to create additional fields if
 * deemed necessary.
 *
 * @param <Card> the type of card used in the game
 */

public class CardPlayer extends GeneralPlayer<Card> {
    private int points;

    private boolean turn;

    private ArrayList<Card> hand = new ArrayList<Card>();

    public ArrayList<Card> bank = new ArrayList<Card>();


    // Constructor
    public CardPlayer() {
        name = "Default Player";
    }

    public CardPlayer(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    // Methods
    public void addToHand(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addToBank(Card card) {
        bank.add(card);
    }

    public ArrayList<Card> getBank() {
        return bank;
    }

    public String handToString() {
        String handString = "";
        handString += "Player" + this.name + " hand has " + hand.size() + " cards: ";
        Iterator<Card> handItr = hand.iterator();
        while (handItr.hasNext()) {

            handString += " " + handItr.next().identifier;
        }
        return handString;
    }

    public String bankToString() {
        String bankString = "";
        bankString += "Player " + this.name + " bank has " + bank.size() + " cards: ";
        Iterator<Card> bankItr = bank.iterator();
        while (bankItr.hasNext()) {
            bankString += " " + bankItr.next().identifier;
        }
        return bankString;
    }

    public Card play() {
        if (hand.isEmpty()) {
            this.setTurn(false);
            return null;
        } else {
            Card playedCard = hand.get(0);
            hand.remove(0);
            this.setTurn(false);
            return playedCard;
        }

    }

}