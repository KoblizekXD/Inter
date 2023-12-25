package lol.koblizek.inter.client;

public abstract class AbstractClient {
    /**
     * Gets the current gui in use.
     *
     * @return the active gui
     */
    public abstract Gui getActiveGui();

    /**
     * Sets the current gui to be used.
     * This will automatically close the previous gui.
     *
     * @param gui the gui to set
     */
    public abstract void setActiveGui(Gui gui);

    /**
     * Gets the input handler, which can be used to handle for
     * certain inputs such as: key presses, mouse clicks etc.
     *
     * @return the input handler
     */
    public abstract InputHandler getInputHandler();

    /**
     * Gets the current frames per second.
     *
     * @return the current frames per second
     */
    public abstract float getFrames();

    /**
     * Closes the client game.
     */
    public abstract void close();

    /**
     * Gets the runtime manager, which can be used to obtain things such as:
     * <ul>
     *     <li>Game arguments</li>
     *     <li>Game options</li>
     *     <li>Window properties(width, height...)</li>
     * </ul>
     *
     * @return the runtime manager
     */
    public abstract RuntimeManager getRuntimeManager();
}
