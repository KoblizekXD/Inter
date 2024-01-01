package lol.koblizek.inter.client.event;

import lol.koblizek.inter.client.render.CommonRenderer;

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
