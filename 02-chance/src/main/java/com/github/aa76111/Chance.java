package com.github.aa76111;

public class Chance {
    private double fraction;
    private final double ONE = 1;

    public Chance(double fraction) {
        this.fraction = fraction;
    }

    public Chance not() {
        return new Chance(ONE - fraction);
    }

    public Chance and(Chance aC) {
        return new Chance(fraction * aC.fraction);
    }

    public Chance or(Chance aC) {
        return new Chance((fraction + aC.fraction) - and(aC).fraction);
    }

    public Chance xor(Chance aC) {
        return new Chance(fraction * (aC.not().fraction) + (not().fraction) * aC.fraction);
    }
}
