package net.ivanzykov.app;

import net.ivanzykov.incoming.RatingUseCase;
import net.ivanzykov.incoming.Result;

public class RatingApplication implements RatingUseCase {
    private final RatingProvider rater;

    public RatingApplication(RatingProvider rater) {
        this.rater = rater;
    }

    @Override
    public Result rateAndResult(Double value) {
        Double rate = rater.rateFor(value);
        
        return new Result(rate, rate * value);
    }
}
