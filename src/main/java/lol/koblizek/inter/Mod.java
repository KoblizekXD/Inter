package lol.koblizek.inter;

import java.nio.file.Path;

public abstract class Mod {
    public void onEnable() {}
    public void onDisable() {}

    public final Inter getInter() {
        return Inter.getInstance();
    }


    public final Metadata getMetadata() {
        return getInter().getMetadata(this);
    }

    public final Path getDataDirectory() {
        return getInter().getConfigDirectory().resolve(getMetadata().name + "/");
    }

    public record Metadata(String name,
                           String pluginVersion,
                           String gameApi,
                           String description,
                           String author,
                           String entryClass) {
    }
}
