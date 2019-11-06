package com.gildedrose;

public class ItemConjured extends Item{
    public ItemConjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){

        this.minusSellIn();

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", this.name, this.sellIn, this.quality);

        if (this.sellIn < 0) {
            doUpdate( -4);
        } else {
            doUpdate( -2);
        }
    }
}
