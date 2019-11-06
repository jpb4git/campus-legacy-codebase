package com.gildedrose;

public class ItemStd extends Item {



    public ItemStd(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    protected void update(){

        this.minusSellIn();

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", this.name, this.sellIn, this.quality);
        // #2
        if (this.getSellIn() < 0) {
            //#3
           doUpdate( -2);
        } else {
           doUpdate( -1);
        }
        // #2

    }




}
