package com.gildedrose;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Rules{

    /**
     *
     *
     * @param actionSellin
     * @param rules
     * @return
     */
    public static Rules of( ActionSellin actionSellin, Rule... rules) {
        // return the  constructor result with a copy
        return new Rules(ImmutableList.copyOf(rules), actionSellin);
    }

    private List<Rule> listRules;
    protected ActionSellin actionSellin;


    interface ActionSellin{
        int execution(int sellin);
    }




    public Rules(List<Rule> listRules, ActionSellin actionSellin) {
        this.listRules = listRules;
        this.actionSellin = actionSellin;

    }

    /**
     *
     * @param item
     * @return
     */
    public Item update(Item item){

        item.sellIn = actionSellin.execution(item.sellIn);
        int tempSellin = item.sellIn;

        for (Rule rule: listRules) {

            /**
             *
             * test if tempSellin is in existing rule.range
             * and apply change to temp
             *
             */
            if (rule.range.contains(tempSellin)){

               item.quality =  rule.action.execution(item.quality);

            }
        }


        return item;
    }
}
