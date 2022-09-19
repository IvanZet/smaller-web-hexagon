package net.ivanzykov.rater;

import net.ivanzykov.incoming.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RatingApplicationTest {

    @Mock
    private RatingProvider ratingProvider;

    @Test
    void rateAndResult() {
        // Prepare input
        Double value = 5.0D;

        // Mock not yet implemented dependency
        Double rate = 1.1D;
        when(ratingProvider.rateFor(value)).thenReturn(rate);

        // Instantiate SUT
        var ratingApplication = new RatingApplication(ratingProvider);

        assertEquals(new Result(rate, rate * value), ratingApplication.rateAndResult(value));
    }
}