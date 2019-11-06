package com.gildedrose;

public class ItemConjured extends Item{
    public ItemConjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){
        this.setSellIn(this.getSellIn() -1) ;
        if (this.sellIn < 0) {
            doUpdate(this.getQuality(), -4);
        } else {
            doUpdate(this.getQuality(), -2);
        }
    }
}
