package com.gildedrose;

public class ItemBackStage extends Item {
    public ItemBackStage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){
        this.setSellIn(this.getSellIn() - 1 );

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", this.name, this.sellIn, this.quality);
        if (this.getSellIn() > 10) {
            doUpdate( 1);
        } else if (this.getSellIn() > 5) {
            doUpdate( 2);

        } else if (this.getSellIn()> 0) {
            doUpdate( 3);

        } else {
            //#8
            doUpdate( -this.getQuality());
        }

    }
}
