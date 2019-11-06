package com.gildedrose;

public class ItemStd extends Item {



    public ItemStd(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    protected void update(){

        super.update();

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", name, sellIn, quality);
        // #2
        if (sellIn < 0) {
            //#3
           doUpdate( -2);
        } else {
           doUpdate( -1);
        }
        // #2

    }




}
