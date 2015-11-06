package com.zte.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GildedRoseTest
{
    @Test
    public void should_update_common_product_quality() throws Exception
    {
        GildedRose app = new GildedRose();

//        List<Item> items = ImmutableList.of(
//                new Item("+5 Dexterity Vest", 10, 20),
//                new Item("Aged Brie", 2, 0),
//                new Item("Elixir of the Mongoose", 5, 7),
//                new Item("Sulfuras,Hand of Ragnaros", 0, 80),
//                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
//                new Item("Conjured Mana Cake", 3, 6)
//        );

        final Item item = new Item("+5 Dexterity Vest", 10, 20);

        app.updatequality(item);

        assertThat(item.getQuality(), is(19));
        assertThat(item.getSellIn(), is(9));
    }
}