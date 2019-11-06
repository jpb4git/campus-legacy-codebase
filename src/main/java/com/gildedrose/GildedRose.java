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

        int counter = 0;
        Item newItem;


        for (Item item : items) {

            String itemName = item.name;
            // on récupère conjured
            if (itemName.startsWith("Conjured ")) {
                itemName = "Conjured";
            }


            switch (itemName){
                case "Sulfuras, Hand of Ragnaros":
                    newItem  = new ItemSulfuras(item.name,item.sellIn,item.quality);
                    break;
                case "Aged Brie":
                    newItem  = new ItemBrie(item.name,item.sellIn,item.quality);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    newItem  = new ItemBackStage(item.name,item.sellIn,item.quality);
                    break;
                case "Conjured":
                    newItem  = new ItemConjured(item.name,item.sellIn,item.quality);
                    break;
                case "Red red wine":
                    newItem  = new ItemRedWine(item.name,item.sellIn,item.quality);
                    break;
                default :
                    newItem  = new ItemStd(item.name,item.sellIn,item.quality);
            }

            // mise à jour de l'item traité
            newItem.update();
            //réaffectation de l'item à indice courant dans la liste originale
            items[counter] =  newItem;
            counter++;
        }
    }



    public Item[] getItems(){
        return items;
    }



}



