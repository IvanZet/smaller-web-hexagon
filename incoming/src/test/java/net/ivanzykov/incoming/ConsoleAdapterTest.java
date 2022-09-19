package net.ivanzykov.incoming;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsoleAdapterTest {

    private ConsoleAdapter consoleAdapter;

    private static ByteArrayOutputStream outContent;

    @Mock
    private RatingUseCase ratingUseCase;
    @Mock
    private Scanner scanner;

    @BeforeAll
    static void initAll() {
        // Overtake printing to the console
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }


    @BeforeEach
    void init() {
        consoleAdapter = new ConsoleAdapter(ratingUseCase, scanner);
    }

    @Test
    void start() {
        String valueString = "10";
        when(scanner.nextLine()).thenReturn(valueString);

        double valueDouble = Double.parseDouble(valueString);
        double rate = 1.01D;
        var result = new Result(rate, rate * valueDouble);
        when(ratingUseCase.rateAndResult(valueDouble)).thenReturn(result);

        consoleAdapter.start();

        assertTrue(outContent.toString().contains(result.toString()));
    }
}