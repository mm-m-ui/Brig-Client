package ru.brigclient.module;

import org.lwjgl.glfw.GLFW;
import ru.brigclient.module.impl.cosmetics.*;
import ru.brigclient.module.impl.hud.*;
import ru.brigclient.module.impl.optimization.*;
import ru.brigclient.module.impl.utilities.*;
import ru.brigclient.module.impl.visuals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Central manager for all modules.
 * To add a new module: create class extending Module, then add instance in init().
 */
public class ModuleManager {

    private final List<Module> modules = new ArrayList<>();

    public void init() {
        // === OPTIMIZATION ===
        register(new PotatoMode());
        register(new FastChunkEngine());
        register(new NoRender());

        // === VISUALS ===
        register(new FullBright());
        register(new CustomSky());
        register(new TimeChanger());
        register(new FogControl());
        register(new ChinaHat());
        register(new TargetESP());
        register(new JumpCircles());
        register(new Trails());
        register(new CustomHitboxes());
        register(new NameTags());
        register(new SeeInvisible());
        register(new ViewModel());

        // === HUD ===
        register(new Watermark());
        register(new TargetHUD());
        register(new PotionHUD());
        register(new InventoryHUD());
        register(new CooldownsHUD());
        register(new CustomCrosshair());

        // === COSMETICS ===
        register(new Capes());
        register(new Hats());

        // === UTILITIES ===
        register(new PvPItemHighlighter());
        register(new TotemTracker());

        System.out.println("[BrigClient] Registered " + modules.size() + " modules.");
    }

    private void register(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getModulesByCategory(Category category) {
        return modules.stream()
                .filter(m -> m.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Module getModuleByName(String name) {
        return modules.stream()
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Module> search(String query) {
        return modules.stream()
                .filter(m -> m.matchesSearch(query))
                .collect(Collectors.toList());
    }

    public void onTick() {
        for (Module module : modules) {
            if (module.isEnabled()) {
                module.onTick();
            }
            // Keybind toggle
            if (module.getKeyBind() != -1) {
                // Simple check - in real use better use KeyBinding
                // Placeholder: handled via ClickGUI binding
            }
        }
    }

    public void onRender2D(float tickDelta) {
        for (Module module : modules) {
            if (module.isEnabled()) {
                module.onRender2D(tickDelta);
            }
        }
    }

    public void onRender3D(float tickDelta) {
        for (Module module : modules) {
            if (module.isEnabled()) {
                module.onRender3D(tickDelta);
            }
        }
    }
}
