package com.gildedrose;

public class ItemSulfuras extends Item {
    public ItemSulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){
        //nothing
        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", name, sellIn, quality);
    }
}
