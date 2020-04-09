import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private ArrayList<String> values = new ArrayList<String>();
	private ArrayList<String> suits = new ArrayList<String>();
	private Random random = new Random();
	
	
	public void generateDeck() {
		
		//adds values to values and suits lists
		List<String> valueList = Arrays.asList("Ace", "2", "3","4", "5", "6","7", "8", "9","10", "Jack", "Queen","King");
		List<String> suitList = Arrays.asList("Diamonds", "Spades", "Clubs", "Hearts");
		values.addAll(valueList);
		suits.addAll(suitList);
		
		//adding card objects to deckOfCards arraylist
		int i = 1;
		while(i<=52){
            Card card = new Card(values.get(random.nextInt(13)), suits.get(random.nextInt(4)));
            if (!deckOfCards.contains(card)) {
                deckOfCards.add(card);
                i++;
            }else{

            }
        }
	}
	
	public void printDeck() {
		for(Card c : deckOfCards) {
			System.out.println(c);
		}
	}
	
	public int deckSize() {
		return deckOfCards.size();
	}
	
	public Card draw() {
		Card card = deckOfCards.get(0);
		deckOfCards.remove(0);
		return card;
	}
	
	public void shuffle() {
		Collections.shuffle(deckOfCards);
	}
}
