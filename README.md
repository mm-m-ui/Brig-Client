# Brig Client

Modern modular utility client for **Minecraft 1.21.11** (Fabric).

## Features

- **Modular architecture** — easy to add new modules
- **ClickGUI** (Right Shift) with search, categories, LMB toggle / RMB settings
- Optimization, Visuals, HUD, Cosmetics, Utilities modules
- Theme system (accent colors)
- Works on any launcher including offline / non-licensed

## Requirements

- Java 21
- Minecraft 1.21.11
- Fabric Loader ≥ 0.18.4
- Fabric API 0.141.1+1.21.11

## Build

```bash
./gradlew build
```

Jar appears in `build/libs/`.

## Development

Add a new module:

1. Create class extending `Module`
2. Register it in `ModuleManager.init()`

## License

MIT
