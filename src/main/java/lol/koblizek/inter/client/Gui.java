package lol.koblizek.inter.client;

public abstract class Gui {
    public boolean isOverlay() {
        return this instanceof Overlay;
    }

    public boolean isInventory() {
        return false; // TODO: implement
    }

    public abstract String getTitle();
    public abstract Gui getPrevious();
}
