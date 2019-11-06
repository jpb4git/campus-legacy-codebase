package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;
    final Logger logger = LoggerFactory.getLogger(GildedRose.class);


    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     *
     */
    public void updateQuality() {


        for (Item item : items) {
            selectItem(item);


        }
    }

    public void selectItem(Item item) {

        // #1
        item.sellIn--;
        String itemName = item.name;
        if (itemName.startsWith("Conjured ")) {
            itemName = "Conjured";
        }
        logger.info("New Log");
        logger.debug("Item {}, SellIn : {}, Quality : {}", itemName, item.sellIn, item.quality);

        switch (itemName) {
            //#4
            case "Aged Brie":
                update(item, 1);
                break;
            //#6
            case "Sulfuras, Hand of Ragnaros":
                item.sellIn++;
                break;
            //#7
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.sellIn > 10) {
                    update(item, 1);
                } else if (item.sellIn > 5) {
                    update(item, 2);
                } else if (item.sellIn > 0) {
                    update(item, 3);
                } else {
                    //#8
                    update(item, -item.quality);
                }
                break;
            //#9
            case "Conjured":
                if (item.sellIn < 0) {
                    //#3
                    update(item, -4);
                } else {
                    update(item, -2);
                }
                break;

            //#10
            case "Red red wine":
                if(item.sellIn >= 300){
                    update(item, 1);
                }else if(item.sellIn < 0){
                    update(item, -1);
                }
                break;

            default:

                // #2
                if (item.sellIn < 0) {
                    //#3
                    update(item, -2);
                } else {
                    update(item, -1);
                }
                // #2
        }

    }
    //#3
    /**
     * return a calculate positive number
     * this number will never be more than 50
     *
     * @param item  current item
     * @param value can be negative or positive
     */
    public void update(Item item, int value) {

        // #5
        if (Math.signum(value) > 0 && item.name != "Red red wine") {
            item.quality = Math.min(item.quality + value, 50);
        } else {
            // #4
            item.quality = Math.max(item.quality + value, 0);
        }
        logger.debug("New Quality : {}", item.quality);


    }


    public Item[] getItems(){
        return items;
    }

}



