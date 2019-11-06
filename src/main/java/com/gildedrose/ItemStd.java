package com.gildedrose;

public class ItemStd extends Item {



    public ItemStd(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    protected void update(){

        this.sellIn--;

        // #2
        if (this.getSellIn() < 0) {
            //#3
           doUpdate(this.quality, -2);
        } else {
           doUpdate(this.quality, -1);
        }
        // #2

    }




}
