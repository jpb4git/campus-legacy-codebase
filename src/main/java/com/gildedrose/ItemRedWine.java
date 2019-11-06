package com.gildedrose;

public class ItemRedWine extends Item {
    public ItemRedWine(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){
        super.update();

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", name, sellIn, quality);

        if(sellIn >= 300){
            quality++; // bypass doUpdate with range
        }else if(this.getSellIn() < 0){
            quality--; // bypass doUpdate with range
        }
    }
}
