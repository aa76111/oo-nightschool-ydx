package com.github.aa76111.refactors;

import com.github.aa76111.refactors.enumeration.FruitEnum;
import com.github.aa76111.refactors.farmer.AppleFarmer;
import com.github.aa76111.refactors.farmer.BananaFarmer;

public class FruitGarden {

    public void plant(FruitEnum fruitEnum) {

//        doSomeThing(fruitEnum)

        switch (fruitEnum) {
            case APPLE:
                AppleFarmer appleFarmer = new AppleFarmer();
                appleFarmer.plant();
                appleFarmer.grow();
                appleFarmer.pick();
                break;
            case BANANA:
                BananaFarmer bananaFarmer = new BananaFarmer();
                bananaFarmer.plant();
                bananaFarmer.grow();
                bananaFarmer.pick();
                break;
            default:
                break;
        }
    }
}
