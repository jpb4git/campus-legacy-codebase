package com.gildedrose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

/*
    public void updateQuality() {
        Logger logger = LoggerFactory.getLogger(GildedRose.class);
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                        logger.info("Test  : other");
                    }
                    if (items[i].name.contains("Conjured") && !items[i].name.contains("Like Conjured") && items[i].quality > 0) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            // soit brie or Backstage soit conjured Items
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

                    if (items[i].name.equals("Conjured Mana Cake")){
                        items[i].quality = items[i].quality + 2;
                        if (items[i].quality > 50) {
                            items[i].quality = 50;
                        }
                        items[i].sellIn = items[i].sellIn - 1;
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
/*
        for (int i = 0; i < items.length; i++) {
            logger.info("loop : " + i);

            switch (items[i].name) {
                case "Aged Brie":
                    logger.info(items[i].name + " | " + items[i].quality + " | " + items[i].sellIn );
                    items[i].sellIn = items[i].sellIn - 1;
                    if (items[i].quality < 50) {
                        logger.info("aged < 50 passed");
                        logger.info("quality was : " + items[i].quality );
                        items[i].quality = items[i].quality + 1;
                        logger.info("quality now : " + items[i].quality );

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
                    logger.info("conjured data ");
                    logger.info("before " +  items[i].name + " | " + items[i].quality + " | " + items[i].sellIn );
                    if (items[i].quality - 2 >= 0){
                        items[i].quality  = items[i].quality - 2;
                    }else{
                        items[i].quality  = 0;
                    }

                    items[i].sellIn = items[i].sellIn - 1;

                    logger.info(" after " +  items[i].name + " | " + items[i].quality + " | " + items[i].sellIn );
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

            logger.info("quality now : " + items[i].quality );
        }
*/


    public void updateQuality() {
        Logger logger = LoggerFactory.getLogger(GildedRose.class);
        logger.info("Array test sended length : " + items.length );
        for (int i = 0; i < items.length; i++) {
            logger.info("Item before : " + items[i].name  + " Ql :" + items[i].quality  + " | sellIn :  " + items[i].sellIn);
            items[i] = SelectItemByName(items[i]);
            logger.info("Item after : "+ items[i].name  +" Ql :" + items[i].quality  + " | sellIn :  " + items[i].sellIn);
        }
    }
    private Item SelectItemByName(Item item){

        Logger logger = LoggerFactory.getLogger(GildedRose.class);

        // Sellin decrease in all cases
        item  = downSellin(item , 1);


        if (item.name.startsWith("Conjured") ){
            logger.info("conjured");
            item.quality = qualityBounded(item.quality,-2);

        }else if (item.name.contains("Sulfuras") ){

            //nothing to do with quality

            // but we have to cancel the day sellIn decrease
            /**
             correctif :
                la méthode downSellin était placée  en fin de méthode
                donc réduisait le sellin dans tous les cas de figure.
                elle est placée, maintenant en début de cycle
                nous devons annuler cette action dans ce cas particulier de Sulfuras
                qui est flaggé  :  GMSFDLM                "God Mode Static Final De La Mort"
             */
             item.sellIn++;


        }else if (item.name.contains("Brie") ){

            //logger.info("Brie before : Ql  : " + item.quality  + " | sellIn :  " + item.sellIn);
            // date perimée brie double sa perte de qualité.
            /**
             *
              (all product )  - At the end of each day our system lowers both values for every item

              - "Aged Brie" actually increases in Quality the older it gets

             */
            item.quality = qualityBounded(item.quality, 1); // à tester ce matin
            logger.info("brie after : Ql  : " + item.quality  + " | sellIn :  " + item.sellIn);



        }else if (item.name.contains("Backstage passes") ){
            // date dépassée
            logger.info("backstage :");

            // add one quality in all case.
            item.quality = qualityBounded(item.quality,1);

            if (item.sellIn < 0){ // date depassée ql à 0
                item.quality = qualityBounded(item.quality,-50);

            }

            // date  5
            if (item.sellIn >= 0 && item.sellIn < 6   ){
                item.quality = qualityBounded(item.quality,2);

            }

            // date 10
            if (item.sellIn > 5  && item.sellIn < 11){
                item.quality = qualityBounded(item.quality,1);
            }


        // Red win Case
        } else if (item.name.contains("Red red wine")) {
            logger.info("Win Spotted");

            // 0 to 300 do nothing

            // 300 to 600  add quality
            if ( item.sellIn >= 300 && item.sellIn <= 600) {
                item.quality++ ; // don't care about 50 limitation (bypass qualityBounded method )

            // <  0 decrease quality
            }else if ( item.sellIn < 0) {
                item.quality--; // don't care about 50 limitation (bypass qualityBounded method )
            }

        }

        else{
            logger.info("other foo ");

            /*if (item.sellIn < 0){ //
                item.quality = qualityBounded(item.quality,-2);
            }else{
                item.quality = qualityBounded(item.quality,-1);
            }
            */
            // on decrease la qualité
            item.quality = qualityBounded(item.quality,-1);
        }

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

        if (tempQuality < 0) {
             tempQuality = minQuality;
        }
        if (tempQuality > 50 ) {
             tempQuality = maxQuality;
        }

        return tempQuality;



    }
    private Item downSellin(Item item ,int num){
        item.sellIn = item.sellIn - num;
        return item;
    }






    public Item[] getItems() {
        return items;
    }
}