package com.gildedrose;

public class ItemConjured extends Item{
    public ItemConjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){
        super.update();

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", name, sellIn, quality);

        if (sellIn < 0) {
            doUpdate( -4);
        } else {
            doUpdate( -2);
        }
    }
}
