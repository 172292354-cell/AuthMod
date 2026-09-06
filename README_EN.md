AuthMod — Player Login & Registration for Forge 1.20.1

The first server-side authentication mod for Forge 1.20.1 with `/register` and `/login`.

> This fork adds Chinese localization on top of the original AuthMod, which only supported English and Russian.

[English](README_EN.md) | [简体中文](README.md)

---

## Features
- `/register <password>` — register a new account
- `/login <password>` — log in
- `/changepassword <old> <new>` — change your own password
- Full lockdown until authenticated:
  - Cannot move
  - Cannot break/place blocks
  - Cannot drop/pickup items
  - All commands blocked except `/login` and `/register`
  - Chat disabled
- Passwords are hashed with PBKDF2-HMAC-SHA256
- Brute-force protection: temporary lockout after failed attempts
- No OP required

---

## v1.0.1 Changelog

**Added: Simplified Chinese language support (zh_cn)**

v1.0.0 only supported two languages: English and Russian. The mod would automatically switch based on the client's language setting, but had no Chinese translation.

v1.0.1 adds full Simplified Chinese localization. Key changes:

| Item | v1.0.0 | v1.0.1 |
|------|--------|--------|
| Languages | English, Russian | English, Russian, **Chinese** |
| Chinese clients | Shown in English or Russian | **Shown in Simplified Chinese** |
| Config language option | `ru`, `en` only | Added `zh` / `zh_cn` |

Chinese-speaking players will see Chinese prompts automatically with no extra configuration needed. To force Chinese regardless of client language, set `language = "zh"` in the config file.

---

## Installation
1. Download the desired version from [Releases](https://github.com/172292354-cell/AuthMod/releases)
   - v1.0.1 (recommended) — includes Chinese support
   - v1.0.0 — English and Russian only
2. Place the jar in your server's `mods/` folder
3. Set `spawn-protection=0` in `server.properties`
4. Start the server

> New player → sees `/register` prompt
> Returning player → sees `/login` prompt

---

## Configuration
The config file `config/authmod-server.toml` is created on first run:

```toml
[auth]
    minPasswordLength = 6        # Minimum password length (4–64)
    maxLoginAttempts = 3         # Failed attempts before lockout (1–100)
    lockoutSeconds = 60          # Lockout duration in seconds (1–3600)
    language = "auto"           # Language: auto (client language), zh, en, or ru
```

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
4. The JAR appears at `build/libs/authmod-1.0.1.jar`

---

## License
This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

## Acknowledgements
This is a fork of the original [AuthMod](https://github.com/d-society1/AuthMod) by [d-society1](https://github.com/d-society1), also available on [CurseForge](https://www.curseforge.com/minecraft/mc-mods/forgeguardauth).

## Author
- Original: [d-society1](https://github.com/d-society1)
- This fork: [172292354-cell](https://github.com/172292354-cell)