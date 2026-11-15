package ru.brigclient.module;

public enum Category {
    OPTIMIZATION("Оптимизация", "Optimization"),
    VISUALS("Визуалы", "Visuals"),
    HUD("HUD", "HUD"),
    COSMETICS("Косметика", "Cosmetics"),
    UTILITIES("Утилиты", "Utilities"),
    SETTINGS("Настройки", "Settings");

    private final String displayNameRu;
    private final String displayNameEn;

    Category(String displayNameRu, String displayNameEn) {
        this.displayNameRu = displayNameRu;
        this.displayNameEn = displayNameEn;
    }

    public String getDisplayName() {
        return displayNameRu; // Default Russian as per user request
    }

    public String getDisplayNameEn() {
        return displayNameEn;
    }
}
