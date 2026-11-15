package ru.brigclient.module.setting;

public class ColorSetting extends Setting<Integer> {
    // ARGB int

    public ColorSetting(String name, String description, int defaultValue) {
        super(name, description, defaultValue);
    }

    public int getRed() {
        return (getValue() >> 16) & 0xFF;
    }

    public int getGreen() {
        return (getValue() >> 8) & 0xFF;
    }

    public int getBlue() {
        return getValue() & 0xFF;
    }

    public int getAlpha() {
        return (getValue() >> 24) & 0xFF;
    }

    public void setRGB(int r, int g, int b) {
        setValue((getAlpha() << 24) | (r << 16) | (g << 8) | b);
    }

    public void setARGB(int a, int r, int g, int b) {
        setValue((a << 24) | (r << 16) | (g << 8) | b);
    }
}
