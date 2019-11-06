package com.gildedrose;

public class ItemBrie extends Item {

    public ItemBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){

        this.setSellIn(this.getSellIn() -1) ;

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", this.name, this.sellIn, this.quality);

        if(this.getSellIn() < 0){
            doUpdate( 2);
        }else {
            doUpdate( 1);

        }

    }

}
