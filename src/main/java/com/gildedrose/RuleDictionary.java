
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


    /**
     *  retur na decrement value byt One
     * @return
     */
    private static Rules.ActionSellin defaultSellInDecrement() {
        return sellin -> sellin - 1;
    }

    /**
     * return the sellin (getters)
     * @return
     */
    private static Rules.ActionSellin staticSellIn() {
        return sellin -> sellin;
    }

    /**
     * increment the quality in  ]inf -> 50]
     * @param i
     * @return
     */
    private static Action incrementQuality(int i) {
        return quality -> Math.min(quality + i, 50);
    }

    public RuleDictionary() {

    }



}
