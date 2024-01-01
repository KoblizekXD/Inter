package lol.koblizek.inter.test;

import lol.koblizek.inter.Mod;
import lol.koblizek.inter.client.event.ClientRenderEvent;
import lol.koblizek.inter.event.Hook;

public class Main extends Mod {
    @Override
    public void onEnable() {
        getInter().getEventManager().addHook(ClientRenderEvent.class, event -> {
            event.getRenderer().renderText("Hello world!", 1, 1);
            return Hook.TypedResult.PASS;
        });
    }
}
