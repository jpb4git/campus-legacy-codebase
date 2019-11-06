package com.gildedrose;

public class ItemBackStage extends Item {
    public ItemBackStage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){
        this.setSellIn(this.getSellIn() - 1 );

        if (this.getSellIn() > 10) {
            doUpdate(this.getQuality(), 1);
        } else if (this.getSellIn() > 5) {
            doUpdate(this.getQuality(), 2);

        } else if (this.getSellIn()> 0) {
            doUpdate(this.getQuality(), 3);

        } else {
            //#8
            doUpdate(this.getQuality(), -this.getQuality());
        }

    }
}
