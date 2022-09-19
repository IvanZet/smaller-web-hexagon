package net.ivanzykov.outgoing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InCodeRaterTest {

    private InCodeRater inCodeRater;

    @BeforeEach
    void init() {
        inCodeRater = new InCodeRater();
    }

    @ParameterizedTest(name = "[{index}] value: {0}; rate: {1}")
    @MethodSource("provideValueAndRate")
    void rateFor(double value, double rate) {
        assertEquals(rate, inCodeRater.rateFor(value));
    }

    private static Stream<Arguments> provideValueAndRate() {
        return Stream.of(
          Arguments.of(10D, 1.01D),
          Arguments.of(100.0D, 1.5D)
        );
    }
}