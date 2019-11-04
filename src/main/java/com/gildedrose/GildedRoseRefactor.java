package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRoseRefactor {
    Item[] items;

    public GildedRoseRefactor(Item[] items) {
        this.items = items;
    }


   /* public void updateQuality() {
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


    }*/

   public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            items[i] = SelectItemByName(items[i]);
        }
    }
   private Item SelectItemByName(Item item){
       if (item.name.contains("Conjured") ){

           int  boundedQuality =  qualityBounded(item.quality,-2);
           item.quality = boundedQuality ;

       }else if (item.name.contains("Sulfuras") ){
        //nothing to do

       }else if (item.name.contains("Aged Brie") ){
           item.quality = qualityBounded(item.quality,1);

       }else if (item.name.contains("Backstage passes") ){
           // date dépassée
           if (item.sellIn <= 0){
               item.quality = qualityBounded(item.quality,-50);
           }else if (item.sellIn >= 0 && item.sellIn < 6   ){
               item.quality = qualityBounded(item.quality,3);
           }else if (item.sellIn > 5 && item.sellIn < 11){
               item.quality = qualityBounded(item.quality,2);
           }else{
               item.quality = qualityBounded(item.quality,1);
           }
        // other  unNamedItems
       }else{
           if (item.sellIn < 0){
               item.quality = qualityBounded(item.quality,-2);
           }else{
               item.quality = qualityBounded(item.quality,-1);
           }

       }

       item  = downSellin(item , 1);
       return item;
   }
    /**
     *
     * @param currentQuality
     * @param QualityMouvment
     * @return
     */
   public int qualityBounded(int currentQuality,int QualityMouvment ){
        int maxQuality = 50;
        int minQuality = 0;
        int tempQuality = currentQuality + QualityMouvment;

        if (tempQuality <= maxQuality && tempQuality >= minQuality){
            return tempQuality;
        }

       return (Integer.signum(tempQuality) <= 0 ?  minQuality : maxQuality );
   }
   private Item downSellin(Item item ,int num){
        item.sellIn = item.sellIn - num;
        return item;
    }



    public Item[] getItems() {
        return items;
    }
}

