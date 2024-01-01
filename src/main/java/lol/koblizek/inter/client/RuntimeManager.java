package lol.koblizek.inter.client;

import java.io.File;

public abstract class RuntimeManager {
    public abstract String getArgs();
    public abstract void exit();
    public abstract void exit(int status);
    public abstract void crash();
    public abstract File getGameDirectory();
    public abstract String getVMArguments();
    public abstract File getVMDirectory();
}
