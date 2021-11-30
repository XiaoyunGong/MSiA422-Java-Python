import java.util.Scanner;

public class CurrencyConverter {

	public static void main(String[] args) {
		// Ask the user to type the price for one dollar in Japanese yen.
		Scanner sc = new Scanner(System.in);
		double rate = 10, usd, yen;
		int converter = 0;

		while (converter != 3) {

			try {
				System.out.println(
						"If you want to initiate/change the price for one dollar in Japanese yen, please type in 0. (the default is 10)");
				System.out.println("If you want to convert USD to Japenese Yen, please type in 1.");
				System.out.println("If you want to convert Japenese Yen to USD, please type in 2.");
				System.out.println("If you want to exit this program, please type in 3");
				converter = sc.nextInt();

				if (converter == 0) {
					System.out.println("Please type in the price for one dollar in Japanese yen.");
					rate = sc.nextDouble();
				}

				if (converter == 1) {
					System.out.println("Please type in the amount you want to convert");
					usd = sc.nextDouble();
					yen = usd * rate;
					System.out.println(usd + "USD = " + yen + " japenese Yen");
				}

				if (converter == 2) {
					System.out.println("Please type in the amount you want to convert");
					yen = sc.nextDouble();
					usd = yen / rate;
					System.out.println(yen + " japenese Yen = " + usd + "USD");
				}
				
				else {
					System.out.println("invalid input! Type in 0, 1, 2, 3.");
				}
			} catch (Exception e) {
				System.out.println("invalid input!");
				converter = 3;
			}
		}
		sc.close();
		System.out.println("Exited!");
	}

}
