package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }




    public void updateQuality() {

        /*
        Logger logger = LoggerFactory.getLogger(GildedRose.class);
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;

                        logger.info("Test  : other");
                    }
                }
            // soit brie or Backstage
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        logger.info("Test  : backstage");
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
            //------------------------
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            //-------------------------
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
*/
        Logger logger = LoggerFactory.getLogger(GildedRoseRefactor.class);
        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case "Aged Brie":
                    logger.info(items[i].name + " | " + items[i].quality + " | " + items[i].sellIn );
                    items[i].sellIn = items[i].sellIn - 1;
                    if (items[i].quality < 50) {
                        logger.info("aged < 50 passed");
                        items[i].quality = items[i].quality + 1;
                        if (items[i].sellIn < 0){
                            logger.info("aged  selling < 0 passed");
                            if (items[i].quality < 50) {
                                logger.info("aged < 50 passed");
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    logger.info(items[i].name + " | " + items[i].quality + " | " + items[i].sellIn );
                    if (items[i].sellIn > 10) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }

                    }else if (items[i].sellIn < 6) {
                        items[i].quality = items[i].quality + 3;
                    }else if (items[i].sellIn < 11) {
                        items[i].quality = items[i].quality + 2;
                    }


                    items[i].quality = items[i].quality > 50 ? 50 : items[i].quality;


                    if (items[i].sellIn <= 0) {
                        items[i].quality = 0;
                    }
                    items[i].sellIn = items[i].sellIn - 1;
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    logger.info(items[i].name + " | " + items[i].quality + " | " + items[i].sellIn );
                    // code block
                    break;
                case "Conjured Mana Cake":
                    logger.info(items[i].name + " | " + items[i].quality + " | " + items[i].sellIn );
                    if (items[i].quality - 2 >= 0){
                        items[i].quality  = items[i].quality - 2;
                    }else{
                        items[i].quality  = 0;
                    }
                    items[i].sellIn = items[i].sellIn - 1;
                    // code block
                    break;
                default:
                    logger.info(items[i].name + " | " + items[i].quality + " | " + items[i].sellIn );
                    // passed
                    if (items[i].sellIn <= 0){
                        logger.info(" foo default ");
                        if (items[i].quality - 2 >= 0 ){
                            items[i].quality = items[i].quality - 2;

                            logger.info("foo_date_Has_Passed_And_Quality_Never_Negativ  :");
                        }else{

                        }


                    }else{
                        logger.info("foo_decrease_Sellin_All_Day");
                        logger.info("foo_decrease_Quality_All_Day");

                        items[i].quality = items[i].quality -1;
                        items[i].sellIn  = items[i].sellIn - 1;
                    }
            }
        }
    }

    public Item[] getItems() {
        return items;
    }
}