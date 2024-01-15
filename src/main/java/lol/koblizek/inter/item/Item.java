package lol.koblizek.inter.item;

import lol.koblizek.inter.Inter;
import lol.koblizek.inter.core.Identifiable;
import lol.koblizek.inter.core.Key;

public class Item implements Identifiable {
    private final Key key;

    public Item(Key key) {
        this.key = key;
    }

    public final ItemStack getDefaultStack() {
        return ItemStack.of(this);
    }

    private static Item copyVanilla(String name) {
        Key k = new Key("minecraft", name);
        return new VanillaItem(k);
    }

    @Override
    public Key getKey() {
        return key;
    }

    private static final class VanillaItem extends Item {
        public VanillaItem(Key key) {
            super(key);
        }

        @Override
        public void onUse() {
            Inter.getSystemLogger()
                    .warn("Attempted to call onUse() on vanilla item {} which is not allowed",
                            getClass().getSimpleName());
        }
    }

    public static final class Listing {
        public static final Item AIR = copyVanilla("air");
        public static final Item STONE = copyVanilla("stone");
    }

    public void onUse() {}
}
