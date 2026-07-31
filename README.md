AuthMod — Player Login & Registration for Forge 1.20.1

The first server-side authentication mod for Forge 1.20.1 with `/register` and `/login`.

[English](README.md) | [简体中文](README_zh-CN.md)

---

## Features
- /register <password> — register (min 4 characters)
- /login <password> — login
- Full lockdown until authenticated:
  - Can't move
  - Can't break/place blocks
  - Can't drop/pickup items
- Saves passwords in authmod_data.json
- No OP required
- Works with FTB Essentials (`/tpa`, /home, etc.)

---

## Installation
1. Download authmod-1.0.0.jar from [Releases](https://github.com/172292354-cell/AuthMod/releases)
2. Place it in the mods folder on the server
3. Set spawn-protection=0 in server.properties
4. Start the server

> New player → sees /register  
> Returning player → sees /login

---

## Compatibility
- Minecraft 1.20.1
- Forge 47.4.0+
- Server-side only — clients without the mod can join

---

## Building from Source
1. Install Java 17
2. Clone the repository
3. Run `gradle build`
4. Find the JAR in `build/libs/`

---

## License
This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

## Acknowledgements
This is a fork of the original [AuthMod](https://github.com/d-society1/AuthMod) by [d-society1](https://github.com/d-society1), also available on [CurseForge](https://www.curseforge.com/minecraft/mc-mods/forgeguardauth).

## Author
- Original: [d-society1](https://github.com/d-society1)
- This fork: [172292354-cell](https://github.com/172292354-cell)