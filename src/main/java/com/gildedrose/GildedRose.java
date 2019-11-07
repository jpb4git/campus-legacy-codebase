package com.gildedrose;

import com.google.common.collect.Range;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class GildedRose {
    Item[] items;
    final Logger logger = LoggerFactory.getLogger(GildedRose.class);
    //private List<Item> typedItems;
    protected List<Rules> listRules;
    protected List<Rule> SulfurasRules = new ArrayList<>();
    protected List<Rule> brieRules = new ArrayList<>();
    protected List<Rule> backstageRules = new ArrayList<>();
    protected List<Rule> conjuredRules = new ArrayList<>();
    protected List<Rule> redWineRules = new ArrayList<>();
    protected List<Rule> stdRules = new ArrayList<>();


    public GildedRose(Item[] items) {
        this.items = items;

        //typedItems = Arrays.stream(items).map(item -> getItemFactory(item)).collect(Collectors.toList());
        defineRules();
        listRules = Arrays.stream(items).map(item -> getRulesFactory(item)).collect(Collectors.toList());

    }

    public void updateQuality() {

        for (Rules rules : listRules) {
            rules.update();
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
                return new Rules(item, SulfurasRules, sellin -> sellin);

            case "Aged Brie":
                return new Rules(item, brieRules, sellin -> sellin -1);

            case "Backstage passes to a TAFKAL80ETC concert":
                return new Rules(item, backstageRules, sellin -> sellin -1);

            case "Conjured":
                return new Rules(item, conjuredRules, sellin -> sellin -1);

            case "Red red wine":
                return new Rules(item, redWineRules, sellin -> sellin -1);

            default:
                return new Rules(item, stdRules, sellin -> sellin -1);
        }
    }

    private void defineRules() {

        //Brie



        Rule BrieRange1 = new Rule(
                Range.openClosed(Integer.MIN_VALUE, 0),
                quality -> Math.min( quality + 2 , 50)) ;


        Rule BrieRange2 = new Rule(
                Range.closedOpen(0, Integer.MAX_VALUE),
                quality -> Math.min(quality + 1,50 )  );

        this.brieRules.add(BrieRange1);
        this.brieRules.add(BrieRange2);

        //Backstage

        Rule Backstage1 = new Rule(
                Range.openClosed(Integer.MIN_VALUE, 0),
                 quality -> 0);

        Rule Backstage2 = new Rule(
                Range.openClosed(0, 5),
                quality -> Math.min(quality + 3 , 50 ));

        Rule Backstage3 = new Rule(
                Range.openClosed(5, 10),
                quality -> Math.min( quality + 2, 50) );

        Rule Backstage4 = new Rule(
                Range.open(10, Integer.MAX_VALUE),
                quality -> Math.min( quality + 1 , 50 ) );


        backstageRules.add(Backstage1);
        backstageRules.add(Backstage2);
        backstageRules.add(Backstage3);
        backstageRules.add(Backstage4);

        //Conjured

        Rule Conjured1 = new Rule(
                Range.open(Integer.MIN_VALUE, 0),
                quality -> Math.max(quality - 4,0) );

        Rule Conjured2 = new Rule(
                Range.closedOpen(0, Integer.MAX_VALUE),
                quality -> Math.max( quality - 2 ,0 ));

        conjuredRules.add(Conjured1);
        conjuredRules.add(Conjured2);


        //Redwine

        Rule Redwine1 = new Rule(
                Range.open(Integer.MIN_VALUE, 0),
                quality -> quality - 1);

        Rule Redwine2 = new Rule(
                Range.closedOpen(0, 300),
                quality -> quality + 0);

        Rule Redwine3 = new Rule(
                Range.closed(300, 600),
                quality -> quality + 1);

        redWineRules.add(Redwine1);
        redWineRules.add(Redwine2);
        redWineRules.add(Redwine3);

        //Standard

        Rule Standard1 = new Rule(
                Range.open(Integer.MIN_VALUE, 0),
                quality ->  Math.max( quality - 2, 0) );

        Rule Standard2 = new Rule(
                Range.closedOpen(0, Integer.MAX_VALUE),
                quality ->  Math.max(quality - 1 , 0));

        stdRules.add(Standard1);
        stdRules.add(Standard2);

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



