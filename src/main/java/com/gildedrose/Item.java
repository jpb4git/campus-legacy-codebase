package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

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
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }


    /**
     *
     */
    protected void update(){

    }


    //#3
    /**
     * return a calculate positive number
     * this number will never be more than 50
     *
     * @param quality  current item
     * @param value can be negative or positive
     */
    public void doUpdate(int quality, int value) {

        // #5
        if (Math.signum(value) > 0) {
            quality = Math.min(quality + value, 50);
        } else {
            // #4
           quality = Math.max(quality + value, 0);
        }
            this.setQuality(quality);
        //logger.debug("NewVal :  Item {}, SellIn : {}, Quality : {}", item.name, item.sellIn, item.quality);

    }

}
