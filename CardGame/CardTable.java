import java.util.*; //I needed to import this

/**
 * This class represents the table where the game is being played.
 *
 * It implements the Table interface and is designed to work with Card and
 * CardPlayer objects.
 *
 * <p>
 * Each table instance must keep track of the cards that players place on the
 * table
 * during the game. The number of places available has a fixed size
 * (<code>NUMBER_OF_PLACES</code>),
 * so we use a regular Java array to represent a CardTable's places field.
 * Each entry in this places array contains
 * the cards that were added to that place, which is a more dynamic structure
 * (we don't know
 * in advance how many cards will be added to this place!).
 * <p>
 * Therefore, each place
 * entry in this array will reference an ArrayList of Card objects.
 * <p>
 * Here is how to declare the array of ArrayLists field <code>places</code>:
 *
 * <p>
 * <code>
 * 		private ArrayList&lt;Card&gt;[] places = new ArrayList[NUMBER_OF_PLACES];
 * </code>
 * <p>
 *
 * Note that the Field Summary section below will only show you public fields,
 * but you must declare the required field places described above, which is
 * private.
 * You are also free to create additional fields in your class implementation,
 * if deemed necessary.
 *
 */

public class CardTable extends Object implements Table<Card, CardPlayer> {

	private ArrayList<Card>[] places = new ArrayList[NUMBER_OF_PLACES];

	int currentPlace = 0;

	public CardTable() {

		places = new ArrayList[NUMBER_OF_PLACES];

		for (int i = 0; i < places.length; i++) {
			places[i] = new ArrayList<Card>();
		}

	}

	public void addCardToPlace(Card card) {
		if (currentPlace > 3) {
			currentPlace = 0;
		}
		places[currentPlace].add(0, card);
		currentPlace++;
	}

	public int[] getPlaces() {
		int[] placesToInt = new int[NUMBER_OF_PLACES];
		for (int i = 0; i < 4; i++) {
			if (places[i].isEmpty()) {
				placesToInt[i] = -1;
			} else if (!places[i].isEmpty()) {
				placesToInt[i] = places[i].get(0).identifier;
			}
		}
		return placesToInt;
	}

	public void checkPlaces(CardPlayer player) {
		currentPlace--;
		if (currentPlace > 3 || currentPlace < 0) {
			currentPlace = 0;
		}

		for (int i = 0; i < 4; i++) {
			if (i == currentPlace) {
				continue;
			} else if (places[currentPlace].isEmpty() || places[i].isEmpty()) {
				continue;
			} else if (places[currentPlace].get(0).getRank() == places[i].get(0).getRank()) {
				System.out.println("Matched ranks: " + places[i].get(0).identifier + " (on table) and "
						+ places[currentPlace].get(0).identifier + " (" + player.name + "'s card)");
				player.setPoints(player.getPoints() + 1);
				player.addToBank(places[currentPlace].get(0));
				player.addToBank(places[i].get(0));
				places[currentPlace].remove(0);
				places[i].remove(0);
			}
		}
		currentPlace++;
	}

}
