# D-Launcher

**D Launcher Plus** — A modern Minecraft Java Edition launcher built **from scratch**.

Inspired by the polished UI of O Launcher Plus / CS Launcher Plus.

[![Build](https://github.com/kiua01/D-Launcher/actions/workflows/build.yml/badge.svg)](https://github.com/kiua01/D-Launcher/actions/workflows/build.yml)

## Tech Stack

| Layer | Technology | Why |
|-------|------------|-----|
| **UI** | Kotlin + Jetpack Compose Desktop | Beautiful declarative UI matching the screenshots |
| **Core** | Kotlin (JVM) | Auth, versions, instances, launching |
| **Native performance** | Rust | Fast downloads, hashing, file ops |
| **Game process** | Java | Official Minecraft launch |

## Features (UI)

- Home with hero banner (“The End awaits…”), Featured News, What’s New, Quick Links, Realms
- Account Type selection (Offline + Microsoft)
- File Manager with left navigation + grid
- Marketplace / Mod Store with categories and install buttons
- Settings with categorized cards
- Top bar with search, notifications, user chip
- Sidebar navigation

## Build with GitHub Actions

The project has a full **GitHub Actions** workflow (`.github/workflows/build.yml`).

- Triggers on every push to `main` and on Pull Requests
- Builds on **Ubuntu**, **Windows** and **macOS**
- Tries to produce native packages (Deb / MSI / DMG) or falls back to Uber JAR
- You can also run it manually: **Actions → Build D-Launcher → Run workflow**

After a successful run you can download the artifacts from the Actions page.

## Local Development

### Prerequisites
- JDK 21+
- (Optional) Rust for the native core

```bash
git clone https://github.com/kiua01/D-Launcher.git
cd D-Launcher
./gradlew :app:run          # Linux / macOS
# or
.\gradlew.bat :app:run      # Windows
```

To create a distributable package:

```bash
./gradlew :app:packageUberJarForCurrentOS
# or platform specific: packageDeb / packageMsi / packageDmg
```

## Project Structure

```
D-Launcher/
├── app/                     # Compose Desktop UI
│   └── src/main/kotlin/com/dlauncher/
│       ├── Main.kt
│       └── ui/
│           ├── theme/
│           ├── navigation/
│           ├── screens/     # Home, Account, FileManager, Marketplace, Settings
│           └── components/
├── core/                    # Shared Kotlin logic
├── core-rust/               # High-performance Rust library
├── .github/workflows/       # CI that builds everything
├── gradle/
├── gradlew / gradlew.bat
└── README.md
```

## Roadmap

1. ✅ UI skeleton matching the screenshots
2. ✅ GitHub Actions multi-platform build
3. ⏳ Offline account + basic instance creation
4. ⏳ Microsoft authentication
5. ⏳ Version & asset downloading
6. ⏳ Fabric / Forge / Quilt support
7. ⏳ Modrinth / CurseForge integration
8. ⏳ File Manager fully functional + skins

## Disclaimer

This is an independent third-party launcher.  
Not affiliated with Mojang or Microsoft.  
You need a legitimate Minecraft Java Edition license to play online.

---

Made for the community. Goal: **100% visual fidelity** to the beautiful launcher style.
