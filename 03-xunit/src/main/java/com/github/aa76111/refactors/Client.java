package com.github.aa76111.refactors;

import com.github.aa76111.refactors.enumeration.FruitEnum;

public class Client {
    public static void main(String[] args) {
        FruitGarden garden = new FruitGarden();

        garden.plant(FruitEnum.APPLE);

        garden.plant(FruitEnum.BANANA);
    }
}
