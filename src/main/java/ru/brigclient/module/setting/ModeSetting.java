package ru.brigclient.module.setting;

import java.util.Arrays;
import java.util.List;

public class ModeSetting extends Setting<String> {
    private final List<String> modes;

    public ModeSetting(String name, String description, String defaultValue, String... modes) {
        super(name, description, defaultValue);
        this.modes = Arrays.asList(modes);
        if (!this.modes.contains(defaultValue) && !this.modes.isEmpty()) {
            setValue(this.modes.get(0));
        }
    }

    public List<String> getModes() {
        return modes;
    }

    public void cycle() {
        int idx = modes.indexOf(getValue());
        setValue(modes.get((idx + 1) % modes.size()));
    }

    public boolean is(String mode) {
        return getValue().equalsIgnoreCase(mode);
    }
}
