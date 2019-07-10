package com.github.aa76111.refactors;

import com.github.aa76111.refactors.enumeration.FruitEnum;

public class Client {
    public static void main(String[] args) {
        Garden garden = new Garden();

        garden.plant(FruitEnum.APPLE);

        garden.plant(FruitEnum.BANANA);
    }
}
