package com.gildedrose;

public class ItemBrie extends Item {

    public ItemBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){

        this.setSellIn(this.getSellIn() -1) ;

         /*
                if (item.sellIn < 0) {
                    //#3
                    update(item, 2);
                } else {
                    update(item, 1);
                }
                */

        if(this.getSellIn() < 0){
            doUpdate(this.getQuality(), 2);
        }else {
            doUpdate(this.getQuality(), 1);

        }

    }

}
