package com.gildedrose;

public class ItemBackStage extends Item {
    public ItemBackStage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){
        super.update();

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", name, sellIn, quality);
        if (sellIn > 10) {
            doUpdate( 1);
        } else if (sellIn > 5) {
            doUpdate( 2);

        } else if (sellIn > 0) {
            doUpdate( 3);

        } else {
            //#8
            doUpdate( -quality);
        }

    }
}
