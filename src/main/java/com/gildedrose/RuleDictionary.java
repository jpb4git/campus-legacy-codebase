
package com.gildedrose;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Range.*;

public class RuleDictionary {



    public static final Rules BRIE = Rules.of(

            defaultSellInDecrement(),
            new Rule(
                    upTo(0, BoundType.CLOSED),
                    incrementQuality(2)),
            new Rule(
                    downTo(0, BoundType.OPEN),
                    incrementQuality(1))
    );



    public static final Rules BACKSTAGE  = Rules.of(

            defaultSellInDecrement(),
            new Rule(
                    openClosed(Integer.MIN_VALUE, 0),
                    quality -> 0),

            new Rule(
                    openClosed(0, 5),
                    quality -> Math.min(quality + 3 , 50 )),

            new Rule(
                    openClosed(5, 10),
                    quality -> Math.min( quality + 2, 50) ),


            new Rule(
                    Range.open(10, Integer.MAX_VALUE),
                    quality -> Math.min( quality + 1 , 50 ) )
    );


    public static final Rules CONJURED = Rules.of(

            defaultSellInDecrement(),

            new Rule(
                    Range.open(Integer.MIN_VALUE, 0),
                    quality -> Math.max(quality - 4,0) ),
            new Rule(
                closedOpen(0, Integer.MAX_VALUE),
                quality -> Math.max( quality - 2 ,0 ))
    );

    public static final Rules REDWINE  = Rules.of(
      defaultSellInDecrement(),
            new Rule(
                    Range.open(Integer.MIN_VALUE, 0),
                    quality -> quality - 1),
            new Rule(
                    closedOpen(0, 300),
                    quality -> quality + 0),
            new Rule(
                    Range.closed(300, 600),
                    quality -> quality + 1)
    );


    public static final Rules SULFURAS = Rules.of(
            staticSellIn()
    );



    public static final Rules STDITEM = Rules.of(
            defaultSellInDecrement(),
            new Rule(

                Range.open(Integer.MIN_VALUE, 0),
                quality ->  Math.max( quality - 2, 0) ),

            new Rule(

            closedOpen(0, Integer.MAX_VALUE),
            quality ->  Math.max(quality - 1 , 0))
    );






    private static Rules.ActionSellin defaultSellInDecrement() {
        return sellin -> sellin - 1;
    }
    private static Rules.ActionSellin staticSellIn() {
        return sellin -> sellin;
    }

    private static Action incrementQuality(int i) {
        return quality -> Math.min(quality + i, 50);
    }


    public List<List<Rule>> MasterRules = new ArrayList<>();

    public RuleDictionary() {

    }

    public void addRuleList(List<Rule> lRule) {
        MasterRules.add(lRule);
    }

    private void init() {
        //Brie

        /*

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
    */
    }
}
