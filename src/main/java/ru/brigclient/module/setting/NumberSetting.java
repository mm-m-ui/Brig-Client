package ru.brigclient.module.setting;

public class NumberSetting extends Setting<Double> {
    private final double min;
    private final double max;
    private final double step;

    public NumberSetting(String name, String description, double defaultValue, double min, double max, double step) {
        super(name, description, defaultValue);
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public double getMin() { return min; }
    public double getMax() { return max; }
    public double getStep() { return step; }

    @Override
    public void setValue(Double value) {
        double clamped = Math.max(min, Math.min(max, value));
        // Snap to step
        clamped = Math.round(clamped / step) * step;
        super.setValue(clamped);
    }

    public float getFloat() {
        return getValue().floatValue();
    }

    public int getInt() {
        return getValue().intValue();
    }
}
