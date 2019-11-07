package com.gildedrose;

import java.util.List;

public class Rules{

    private Item    item;
    private List<Rule> listRules;
    protected ActionSellin actionSellin;


    interface ActionSellin{
        int execution(int sellin);
    }




    public Rules(Item item, List<Rule> listRules, ActionSellin actionSellin) {
        this.item = item;
        this.listRules = listRules;
        this.actionSellin = actionSellin;

    }

    public Item update(){

        item.sellIn = actionSellin.execution(item.sellIn);
        int tempSellin = item.sellIn;

        for (Rule rule: listRules) {

            if (rule.range.contains(tempSellin)){
                //PROBABLE BUG
               item.quality =  rule.action.execution(item.quality);

            }
        }


        return item;
    }
}
