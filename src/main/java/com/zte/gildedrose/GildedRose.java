package com.zte.gildedrose;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class GildedRose
{

    public static void main(String[] args)
    {
        System.out.println("OMGHAI!");

        GildedRose app = new GildedRose();

        List<Item> items = ImmutableList.of(
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras,Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6));

        app.Updatequality(items);
    }

    //    一般商品 品质下降
//    陈年布里干酪 Aged Brie 品质上升 <50
//
//    一般商品 品质 小于 50
//    萨弗拉斯 Sulfuras 品质不会下降  = 80
//    剧院后台通行证 Backstage passes 品质上升 <10 quality+2 <5 quality+3   0 quality=0
    public void Updatequality(List<Item> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            final Item item = items.get(i);
            final String productName = item.getName();
            if (!productName.equals("Aged Brie") && !productName.equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                if (item.getQuality() > 0)
                {
                    if (!productName.equals("Sulfuras,Hand of Ragnaros"))
                    {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
            } else
            {
                if (item.getQuality() < 50)
                {
                    item.setQuality(item.getQuality() + 1);

                    if (productName.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!productName.equals("Sulfuras,Hand of Ragnaros"))
            {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0)
            {
                if (!productName.equals("Aged Brie"))
                {
                    if (!productName.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                        if (item.getQuality() > 0)
                        {
                            if (!productName.equals("Sulfuras,Hand of Ragnaros"))
                            {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else
                    {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                } else
                {
                    if (item.getQuality() < 50)
                    {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }
}

