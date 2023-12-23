package lol.koblizek.inter.api;

/**
 * Represents a Minecraft version supported by Inter.
 */
public enum MinecraftVersion {
    V_1_20_3,
    DEFAULT;

    @Override
    public String toString() {
        if (this == MinecraftVersion.DEFAULT) return super.toString();
        return name().replace('_', '.')
                .substring(2);
    }

    public static MinecraftVersion fromString(String s) {
        if (s == null) return null;
        if (s.equals("DEFAULT")) return DEFAULT;
        return valueOf("V_" + s.replace('.', '_'));
    }
}
