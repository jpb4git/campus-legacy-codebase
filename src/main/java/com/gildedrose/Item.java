package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Item {

    final Logger logger = LoggerFactory.getLogger(GildedRose.class);

    protected String name;

    protected int sellIn;

    protected  int quality;

    //GETTERS SETTERS
    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }



    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return name + ", " + sellIn + ", " + quality;
    }


    /**
     *
     */
    protected void update(){
        minusSellIn();
    }


    //#3
    /**
     * return a calculate positive number
     * this number will never be more than 50
     *
     *
     * @param value can be negative or positive
     */
    protected void doUpdate( int value) {
        int quality;
        // #5
        if (Math.signum(value) > 0) {
            quality = Math.min(this.getQuality() + value, 50);
        } else {
            // #4
           quality = Math.max(this.getQuality() + value, 0);
        }
        this.setQuality(quality);
        logger.debug("DoUpdate NewVal :  Item {}, SellIn : {}, Quality : {}", this.name, this.sellIn, this.quality);

    }

    private void minusSellIn(){
        sellIn--;
    }

}
