package lol.koblizek.inter.item;

public class ItemStack {

    public ItemStack(Item item, int amount) {

    }

    public static ItemStack of(Item item) {
        return new ItemStack(item, 1);
    }
}
