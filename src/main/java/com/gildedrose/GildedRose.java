package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;



public class GildedRose {
    Item[] items;
    final Logger logger = LoggerFactory.getLogger(GildedRose.class);


    public GildedRose(Item[] items) {
        this.items = items;
        // iteration sur les items
    }

    /**
     *
     */
    public void updateQuality() {

        ArrayList<Item> arrItems= new ArrayList<Item>();

        int counter = 0;
        for (Item item : items) {
            //selectItem(item);
            String itemName = item.name;
            if (itemName.startsWith("Conjured ")) {
                itemName = "Conjured";
            }

            Item newItem;
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
                    arrItems.add(newItem);
            }

            newItem.update();
            items[counter] =  newItem;

            counter++;

        }
    }



    public Item[] getItems(){
        return items;
    }



}



