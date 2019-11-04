package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRoseRefactor {
    Item[] items;

    public GildedRoseRefactor(Item[] items) {
        this.items = items;
    }




    public void updateQuality() {
        Logger logger = LoggerFactory.getLogger(GildedRoseRefactor.class);

        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case "Aged Brie":

                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                        items[i].sellIn = items[i].sellIn - 1;
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":

                    int calculateQuality ;

                    //calculateQuality =

                    if (items[i].sellIn > 10) {

                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }else if (items[i].sellIn < 6) {
                            if (((items[i].quality  + 3 ) <=  50)) {
                                items[i].quality = items[i].quality + 3;
                            }else{
                                items[i].quality = 50;
                            }
                    }else if (items[i].sellIn < 11) {
                        if (((items[i].quality  + 2 ) <=  50)) {
                            items[i].quality = items[i].quality + 2;
                        }else{
                            items[i].quality = 50;
                        }
                    }

                    if (items[i].sellIn <= 0) {
                            items[i].quality = 0;
                    }

                    items[i].sellIn = items[i].sellIn - 1;
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    // code block
                    break;
                case "Conjured":
                    if (items[i].quality - 2 >= 0){
                        items[i].quality  = items[i].quality - 2;
                    }else{
                        items[i].quality  = 0;
                    }
                    // code block
                    break;
                default:

                    // passed
                    if (items[i].sellIn <= 0){
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

    private void internalUpdate(){



    }

    public Item[] getItems() {
        return items;
    }
}

