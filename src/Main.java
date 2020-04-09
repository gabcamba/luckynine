import java.util.Scanner;

public class Main {
	
	static Deck deck = new Deck();
	static int userPoints = 0;
	static int aiPoints = 0;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		deck.generateDeck();

		while(deck.deckSize()>3) {
			print("************************************************************");
			//draw procedure for computer
			Card aiCard1 = deck.draw();
			Card aiCard2 = deck.draw();
			
			//draw procedure for user
			print("Your cards: ");
			Card card1 = deck.draw();
			Card card2 = deck.draw();
			print(card1 +" / " +card2);
			
			//calculate total value of hand
			int userTotal = total(card1.getValue(), card2.getValue());
			print("Your total: " +userTotal);
			
			//ask user if he wants to draw again
			System.out.print("Draw again? [y/n] [x] to quit: ");
			String in = scanner.nextLine();
			
			//input handlers
			if(in.equalsIgnoreCase("y")) {
				Card card = deck.draw();
				print("-----------------------------------");
				print("Your new card: " +card);
				
				//calculate new total
				int newTotal = total(card.getValue(), userTotal);
				print("Your new total: " +newTotal);
				
				//display computer hand
				print("-----------------------------------");
				print("Computer's cards: " +aiCard1 +" / " +aiCard2);
				int aiTotal = total(aiCard1.getValue(), aiCard2.getValue());
				print("Computer total: " +aiTotal);
				
				//compare user total vs computer total
				if(newTotal > aiTotal) {
					userPoints++;
					print("You won!" +"[Computer: " +aiPoints +" | User: " +userPoints +"]");
				}else if(newTotal < aiTotal) {
					aiPoints++;
					print("Computer won! " +"[Computer: " +aiPoints +" | User: " +userPoints +"]");
				}else {
					print("Draw!");
				}
				
			}else if(in.equalsIgnoreCase("x")) {
				break;
			}else if(in.equalsIgnoreCase("n")) {
				print("-----------------------------------");
				print("Computer's cards: " +aiCard1 +" / " +aiCard2);
				int aiTotal = total(aiCard1.getValue(), aiCard2.getValue());
				print("Computer total: " +aiTotal);
				
				//compare user total vs computer total
				if(userTotal > aiTotal) {
					userPoints++;
					print("You won!" +"[Computer: " +aiPoints +" | User: " +userPoints +"]");
				}else if(userTotal < aiTotal) {
					aiPoints++;
					print("Computer won! " +"[Computer: " +aiPoints +" | User: " +userPoints +"]");
				}else {
					print("Draw!");
				}
			}else if(in.equalsIgnoreCase("s")) {
				deck.shuffle();
				print("Deck Shuffled!");
			}
			
		}
		summary();
		
	}
	
	public static int total(int val1, int val2) {
		int total = val1 + val2;
		if(total > 9 && total < 20) {
			return total - 10;
		}
		
		if(total == 20) {
			return 0;
		}
		return total;
	}
	
	public static void print(String string) {
		System.out.println(string);
	}
	
	public static void summary() {
		print("*******************************************");
		print("GAME SUMMARY:");
		print("Computer points: " +aiPoints);
		print("Your points: " +userPoints);
		
		if(aiPoints>userPoints) {
			print("Computer won!");
		} else if(aiPoints<userPoints) {
			print("You won!");
		}else {
			print("Draw!");
		}
		System.out.println("*******************************************");
	}
}
