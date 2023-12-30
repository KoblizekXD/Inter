package lol.koblizek.inter.client.render;

import java.awt.*;

public interface CommonRenderer extends ICommonTextUtil {
    default void renderText(String text, int x, int y, Color color) {
        renderText(text, x, y, color, false);
    }
    default void renderText(String text, int x, int y) {
        renderText(text, x, y, Color.WHITE);
    }
    void renderText(String text, int x, int y, Color color, boolean shadow);

    void drawRect(int x, int y, int width, int height, Color color);

    default void renderTextWithBackground(String text, int x, int y, Color color, Color bg) {
        renderText(text, x, y, color);
        drawRect(x - 1, y - 1, getStringWidth(text) + 2, 10, bg);
    }
}
