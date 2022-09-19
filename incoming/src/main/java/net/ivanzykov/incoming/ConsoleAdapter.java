package net.ivanzykov.incoming;

import java.util.Scanner;

public class ConsoleAdapter {

    private final RatingUseCase ratingUseCase;
    private final Scanner scanner;

    public ConsoleAdapter(RatingUseCase ratingUseCase, Scanner scanner) {
        this.ratingUseCase = ratingUseCase;
        this.scanner = scanner;
    }

    public void start() {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Enter number to rate.");
            try {
                Double input = Double.parseDouble(scanner.nextLine());

                Result result = ratingUseCase.rateAndResult(input);

                System.out.println(result);

                keepRunning = false;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a number");
            } catch (Exception ex) {
                System.out.println("Unknown error!");
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }
}
