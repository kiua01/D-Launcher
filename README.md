# D-Launcher

**D Launcher** — A modern, beautiful Minecraft Java Edition launcher built **from scratch**.

Inspired by the polished UI of O Launcher Plus / CS Launcher Plus (the screenshots you provided).

## Tech Stack

| Layer              | Technology                          | Why |
|--------------------|-------------------------------------|-----|
| **UI**             | Kotlin + Jetpack Compose Desktop   | Beautiful, declarative, native performance, perfect for the 100% matching modern UI |
| **Core Logic**     | Kotlin Multiplatform / JVM         | Shared business logic, version management, account handling |
| **Performance / Native** | Rust (via UniFFI / JNI)        | Fast file I/O, downloads, hashing, process management |
| **Game Launch**    | Java (subprocess + classpath)      | Official way Minecraft expects to be launched |
| **Auth**           | Microsoft OAuth2 + Xbox Live        | Proper online accounts + offline support |
| **Mod Support**    | Fabric / Forge / Quilt loaders     | Full modding ecosystem |

## Planned Features (matching the screenshots)

- **Home** – Hero banner ("The End awaits..."), Play Now, Featured News, What's New
- **Installations** – Multiple instances / profiles
- **Skins** – Skin browser & editor
- **Marketplace / Mod Store** – Browse, search, install mods (CurseForge / Modrinth integration)
- **File Manager** – Full Minecraft directory browser (`.minecraft`, mods, resourcepacks, shaderpacks, screenshots, etc.)
- **Account** – Offline Account + Microsoft Account (recommended)
- **Settings** – General, Minecraft, Performance, Downloads, Launcher Appearance, Experimental, Control Customization
- **Realms** support
- Beautiful Nether-themed backgrounds & glassmorphism UI

## Project Structure

```
D-Launcher/
├── app/                          # Compose Desktop application
│   └── src/main/kotlin/
│       └── com/dlauncher/
│           ├── Main.kt
│           ├── ui/
│           │   ├── theme/
│           │   ├── screens/
│           │   │   ├── HomeScreen.kt
│           │   │   ├── AccountScreen.kt
│           │   │   ├── FileManagerScreen.kt
│           │   │   ├── MarketplaceScreen.kt
│           │   │   ├── SettingsScreen.kt
│           │   │   └── ...
│           │   └── components/
│           └── navigation/
├── core/                         # Shared Kotlin logic
│   └── src/main/kotlin/
│       └── com/dlauncher/core/
│           ├── auth/
│           ├── version/
│           ├── instance/
│           ├── download/
│           └── launch/
├── rust-core/                    # High-performance Rust library
│   ├── Cargo.toml
│   └── src/
│       ├── lib.rs
│       ├── download.rs
│       ├── hash.rs
│       └── fs.rs
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Getting Started (Development)

### Prerequisites
- JDK 21+
- Kotlin 2.0+
- Rust (stable)
- Android Studio / IntelliJ IDEA with Compose plugin (recommended)

### Build & Run

```bash
./gradlew :app:run
```

## Roadmap

1. **Phase 1** – UI skeleton matching every screen from the provided screenshots (Home, Account, File Manager, Marketplace, Settings)
2. **Phase 2** – Offline account + basic instance creation + game launch (vanilla)
3. **Phase 3** – Microsoft authentication
4. **Phase 4** – Full version + asset downloading
5. **Phase 5** – Modrinth / CurseForge integration + Fabric/Forge
6. **Phase 6** – File Manager fully functional + skins + performance options
7. **Phase 7** – Polish, auto-updates, Realms, etc.

## Disclaimer

This is an independent third-party launcher.  
It is **not** affiliated with Mojang or Microsoft.  
You must own a legitimate Minecraft Java Edition license to play online.

---

Made with ❤️ for the community.  
UI design goal: **100% visual fidelity** to the beautiful O Launcher Plus style you showed.
