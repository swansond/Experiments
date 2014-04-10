import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class ComputeMain {

	static ComputeData data;
	static Scanner input; 
	static int numItems;
	static int currentCost;

	public static void main(String[] args) {
		data = new ComputeData();
		input = new Scanner(System.in);
		numItems = 0;
		currentCost = 0;
		Timer time = new Timer();
		TimerTask job = new IncrementJob();
		time.scheduleAtFixedRate(job, 0, 1000);
		while (true) {
			gameTurn();
		}
	}

	private static void gameTurn() {
		System.out.println("Current rate: " + data.rate);
		System.out.println("Buy a booster item?");
		System.out.println("The next one will cost: " + currentCost);
		System.out.println("Type y for yes or n for no");
		String decision = input.nextLine();
		synchronized(data) {
			if ("y".equals(decision)) {
				if (data.banked >= currentCost) {
					data.banked -= currentCost;
					numItems += 1;
					data.rate += 1;
					currentCost *= 1.2;
					if (currentCost == 0) {
						currentCost++;
					}
					System.out.println("You now have " + numItems);
				} else {
					System.out.println("You don't have enough money!");
				}
			}
		}
	}
}
