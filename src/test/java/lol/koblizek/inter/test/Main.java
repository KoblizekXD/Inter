package lol.koblizek.inter.test;

import lol.koblizek.inter.Mod;

public class Main extends Mod {
    @Override
    public void onEnable() {
        if (getInter().getEnvironment().isClient()) {
            getInter().getClient().getActiveGui();
        }
    }
}
