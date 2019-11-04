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
                    items[i].sellIn = items[i].sellIn - 1;
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                        if (items[i].sellIn < 0){
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }

                    break;
                case "Backstage passes to a TAFKAL80ETC concert":



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
                    // code block
                    break;
                case "Conjured Mana Cake":
                    if (items[i].quality - 2 >= 0){
                        items[i].quality  = items[i].quality - 2;
                    }else{
                        items[i].quality  = 0;
                    }
                    items[i].sellIn--;
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

