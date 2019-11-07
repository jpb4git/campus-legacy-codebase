package com.gildedrose;

import com.google.common.collect.Range;



/* interface Range{
        int quality (int quality);
    }
*/
interface Action{
    int execution(int quality);
}



public class Rule {

    protected Range range;
    protected Action action;

    public Rule(Range range , Action action ) {

        this.range = range;
        this.action = action;

    }
}
