package com.gildedrose;

public class ItemRedWine extends Item {
    public ItemRedWine(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update(){
        this.setSellIn(this.getSellIn() -1) ;

        logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", this.name, this.sellIn, this.quality);

        if(this.getSellIn() >= 300){
            this.setQuality(this.getQuality() +1 ); // bypass doUpdate with range
        }else if(this.getSellIn() < 0){
            this.setQuality(this.getQuality() -1 ); // bypass doUpdate with range
        }
    }
}
