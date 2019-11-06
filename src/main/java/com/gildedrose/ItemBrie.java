package com.gildedrose;

public class ItemBrie extends Item {

    public ItemBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){

        super.update();

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", name, sellIn, quality);

        if( sellIn < 0){
            doUpdate( 2);
        }else {
            doUpdate( 1);

        }

    }

}
