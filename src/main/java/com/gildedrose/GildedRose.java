package com.gildedrose;

import com.google.common.collect.Range;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Range.closedOpen;
import static com.google.common.collect.Range.openClosed;


public class GildedRose {
    Item[] items;
    final Logger logger = LoggerFactory.getLogger(GildedRose.class);
    //private List<Item> typedItems;
    protected List<Rules> listRules;
    protected List<Rule> SulfurasRules = new ArrayList<>();



    protected List<Rule> backstageRules = new ArrayList<>();
    protected List<Rule> conjuredRules = new ArrayList<>();
    protected List<Rule> redWineRules = new ArrayList<>();
    protected List<Rule> stdRules = new ArrayList<>();

    //protected  RuleDictionary rd;

    public GildedRose(Item[] items) {
        this.items = items;


        defineRules();
        listRules = Arrays.stream(items).map(item -> getRulesFactory(item)).collect(Collectors.toList());

    }


    public void updateQuality() {

        for (Item item : items) {
            getRulesFactory(item).update(item);
        }
    }

    private Rules getRulesFactory(Item item) {


        String itemName;

        if (item.name.startsWith("Conjured ")) {
            itemName = "Conjured";
        } else {
            itemName = item.name;
        }

        switch (itemName) {
            case "Sulfuras, Hand of Ragnaros":
                return RuleDictionary.SULFURAS;

            case "Aged Brie":
                return RuleDictionary.BRIE;

            case "Backstage passes to a TAFKAL80ETC concert":
                return RuleDictionary.BACKSTAGE;

            case "Conjured":
                return RuleDictionary.CONJURED;

            case "Red red wine":
                return RuleDictionary.REDWINE;

            default:

                return RuleDictionary.STDITEM;
        }
    }

    private void defineRules() {

        //Brie




        //Backstage





        //Conjured



        //Redwine



        //Standard



    }



    public Item[] getItems() {
        return items;
    }


/*
    private Item getItemFactory(Item item) {

        Item newItem = new Item(item.name,item.sellIn,item.quality);

        return newItem;
    }
*/
    /*public void updateItemFactory(Item item){

        String itemName;

        if (item.name.startsWith("Conjured ")) {
            itemName = "Conjured";
        }else{
            itemName = item.name;
        }
        switch (itemName){
            case "Sulfuras, Hand of Ragnaros":
                //return  new ItemSulfuras(item.name,item.sellIn,item.quality);


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
    }*/

}



