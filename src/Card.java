public class Card {
	
	private String value;
	private String suit;
	
	public Card(String value, String suit) {
		this.value = value;
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		return this.value + " of " +this.suit;
	}
	
	@Override
	public boolean equals(Object o) {
		Card newCard = (Card) o;
		if(this.value == newCard.value && this.suit == newCard.suit) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(this.value + this.suit);
	}
	
	public int getValue() {
		if(this.value.equals("Jack")) {
			return 10;
		}else if(this.value.equals("Queen")) {
			return 10;
		}else if(this.value.equals("King")) {
			return 10;
		}else if(this.value.equals("Ace")) {
			return 1;
		}
		return Integer.parseInt(this.value);
	}
	

}
