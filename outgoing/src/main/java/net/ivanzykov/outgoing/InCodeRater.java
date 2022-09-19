package net.ivanzykov.outgoing;

import net.ivanzykov.rater.RatingProvider;

public class InCodeRater implements RatingProvider {

    @Override
    public Double rateFor(Double value) {
        double rate = 1.01D;
        if (value >= 100.0D) {
            rate = 1.5D;
        }
        return rate;
    }
}
