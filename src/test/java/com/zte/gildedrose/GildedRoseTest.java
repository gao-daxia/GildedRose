package com.zte.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GildedRoseTest
{
    @Test
    public void foo()
    {
        GildedRose app = getGildedRose("foo", 0, 0);

        app.updateQuality();

        assertEquals("foo", app.getItems()[0].getName());
    }

    @Test
    public void should_common_product_both_quality_and_sellIn_dec_by_1_when_no_overdue_and_quality_gt_0() throws Exception
    {
//        List<Item> items = ImmutableList.of(
//                new Item("+5 Dexterity Vest", 10, 20),
//                new Item("Aged Brie", 2, 0),
//                new Item("Elixir of the Mongoose", 5, 7),
//                new Item("Sulfuras,Hand of Ragnaros", 0, 80),
//                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
//                new Item("Conjured Mana Cake", 3, 6)
//        );

        GildedRose app = getGildedRose("foo", 10, 20);

        app.updateQuality();

        assertThat(app.getItems()[0].getQuality(), is(19));
        assertThat(app.getItems()[0].getSellIn(), is(9));
    }

    @Test
    public void should_common_product_quality_not_change_and_sellIn_dec_by_1_when_no_overdue_and_quality_eq_0() throws Exception
    {
        GildedRose app = getGildedRose("foo", 10, 0);

        app.updateQuality();

        assertThat(app.getItems()[0].getQuality(), is(0));
        assertThat(app.getItems()[0].getSellIn(), is(9));
    }

    @Test
    public void should_common_product_quality_dec_by_2_when_overdue_and_quality_gt_0() throws Exception
    {
        GildedRose app = getGildedRose("foo", 0, 20);

        app.updateQuality();

        assertThat(app.getItems()[0].getQuality(), is(18));
        assertThat(app.getItems()[0].getSellIn(), is(-1));
    }

    @Test
    public void should_common_product_quality_not_change_when_overdue_and_quality_eq_0() throws Exception
    {
        GildedRose app = getGildedRose("foo", 0, 0);

        app.updateQuality();

        assertThat(app.getItems()[0].getQuality(), is(0));
        assertThat(app.getItems()[0].getSellIn(), is(-1));
    }
    
    private GildedRose getGildedRose(String productName, int sellIn, int quality)
    {
        Item[] items = new Item[]{new Item(productName, sellIn, quality)};
        return new GildedRose(items);
    }
}