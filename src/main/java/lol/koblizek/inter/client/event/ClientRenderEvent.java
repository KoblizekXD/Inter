package lol.koblizek.inter.client.event;

import lol.koblizek.inter.client.render.CommonRenderer;

/**
 * Event called when a Minecraft's game renderer is called.
 * <p>
 *     Can be used to render custom things on screen.
 * </p>
 */
public class ClientRenderEvent extends ClientEvent {
    private final CommonRenderer renderer;

    public ClientRenderEvent(CommonRenderer backport) {
        super();
        this.renderer = backport;
    }

    public CommonRenderer getRenderer() {
        return renderer;
    }
}
