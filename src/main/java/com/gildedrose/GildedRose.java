package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class GildedRose {
    Item[] items;
    final Logger logger = LoggerFactory.getLogger(GildedRose.class);
    private List<Item> typedItems;


    public GildedRose(Item[] items) {
        this.items = items;
        typedItems = Arrays.stream(items).map(item -> getItemFactory(item)).collect(Collectors.toList());


    }

    /**
     *
     */
    public void updateQuality() {

        int counter = 0;

        for (Item item : items) {

            Item newItem = getItemFactory(item);

            // mise à jour de l'item traité
            newItem.update();

            //réaffectation de l'item à indice courant dans la liste originale
            items[counter] =  newItem;
            counter++;
        }
    }






    private Item getItemFactory(Item item) {

        String itemName;

        if (item.name.startsWith("Conjured ")) {
            itemName = "Conjured";
        }else{
            itemName = item.name;
        }

        switch (itemName){
            case "Sulfuras, Hand of Ragnaros":
               return  new ItemSulfuras(item.name,item.sellIn,item.quality);

            case "Aged Brie":
                return  new ItemBrie(item.name,item.sellIn,item.quality);

            case "Backstage passes to a TAFKAL80ETC concert":
                return new ItemBackStage(item.name,item.sellIn,item.quality);

            case "Conjured":
                return  new ItemConjured(item.name,item.sellIn,item.quality);

            case "Red red wine":
                return  new ItemRedWine(item.name,item.sellIn,item.quality);

            default :
                return  new ItemStd(item.name,item.sellIn,item.quality);
        }

    }


    public Item[] getItems(){
        return items;
    }



}



