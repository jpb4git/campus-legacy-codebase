package com.gildedrose;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class GildedRoseTest {

    //Regular Names

    //#1
    /*@Test
    void foo_decrease_Sellin_All_Day() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
    }*/


    @Test
    void decrease_Sellin_And_Quality_By_One_Each_Day() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //#2
    @Test
    void decrease_Quality_Twice_On_Negative_SellIn() {
        Item[] items = new Item[] { new Item("foo", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-2);
        assertThat(app.items[0].quality).isEqualTo(8);
    }


    @Test
    void decrease_Quality_Twice_On_Negative_SellIn_One() {
        Item[] items = new Item[] { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(0);
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void decrease_Quality_Twice_On_Negative_SellIn_Zero() {
        Item[] items = new Item[] { new Item("foo", 0, 10) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //#3
    @Test
    void Quality_Never_Negative_1() {
        Item[] items = new Item[] { new Item("foo", 10, 0) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(0);
    }


    @Test
    void Quality_Never_Negative_2() {
        Item[] items = new Item[] { new Item("foo", -1, 0) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-2);
        assertThat(app.items[0].quality).isEqualTo(0);
    }
    ///////////////////////////////////////////////////////////////////////////////////
    //#4
    @Test
    void AgedBrie_Quality_Up_Sellin_Positive() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    void AgedBrie_Quality_Up_Sellin_Negative() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 10) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-2);
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //#5
    @Test
    void Item_Quality_Never_More_Than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 49) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(50);
    }
    @Test
    void Item_Quality_Never_More_Than_50_Bis() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //#6
    @Test
    void Legendary_Item() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 49) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(10);
        assertThat(app.items[0].quality).isEqualTo(49);
    }


    ///////////////////////////////////////////////////////////////////////////////////
    //#7
    @Test
    void Backstage_Passed_10_days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(42);
    }

    @Test
    void Backstage_Passed_5_days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(4);
        assertThat(app.items[0].quality).isEqualTo(43);
    }
    @Test
    void Backstage_Passed_over_10_days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 40) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(11);
        assertThat(app.items[0].quality).isEqualTo(41);
    }
    ///////////////////////////////////////////////////////////////////////////////////
    //#8
    @Test
    void Backstage_Passed_drop() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(0);
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //#9
    @Test
    void Conjured_Items_SellIn_Negative_Degrade2() {
        Item[] items = new Item[] { new Item("Conjured Stuff", 10, 30) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(28);
    }

    @Test
    void Conjured_Items_SellIn_Negative_Degrade4() {
        Item[] items = new Item[] { new Item("Conjured Stuff", 0, 30) }; // zero
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].sellIn).isEqualTo(-1);
        assertThat(app.items[0].quality).isEqualTo(26);
    }
    ///////////////////////////////////////////////////////////////////////////////////
    //#10
    @Test
    void Red_Wine_increase_Quality_600_to_300 () {
        int quality = 10;
        int sellIn = 600;

        Item[] items = new Item[] { new Item("Red red wine", sellIn, quality) };

        GildedRose app = new GildedRose(items);
        //int age = 0;
        for(int age = 0; age <= sellIn; age++){

            if(age <=300){
                assertThat(app.items[0].quality).isEqualTo(quality+age);

            }else if(age <= 600){

                assertThat(app.items[0].quality).isEqualTo(quality+300);

            }else{

                assertThat(app.items[0].quality).isEqualTo(quality + 300 - (age - 600));
            }
            app.updateQuality();
        }

    }
}
