# Inter  
Simple to use, multiplatform Minecraft API.  
By modders, for modders! Our target is to make modding easier for everyone.  

## Example
This is an example of how Inter API should be used.
```java
public class Example extends Mod {
    @Override
    public void onEnable() {
        Inter inter = getInter();
        if (inter.getEnvironment().isClient()) {
            // Client api is available here
            AbstractClient client = inter.getClient();
            // Draw fps counter 1 pixel from top left corner
            inter.getEventManager().addHook(OverlayRenderEvent.class, event -> {
                client.getActiveGui().overlay().renderText(client.getFrames(), 1, 1);
            });
        }
    }
}
```