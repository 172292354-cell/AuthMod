AuthMod — Minecraft Forge 1.20.1 登录认证模组

首个支持 Forge 1.20.1 的服务端登录认证模组，提供 `/register`（注册）和 `/login`（登录）命令。

> 本项目基于原模组进行了中文汉化，将游戏内所有提示文本翻译为中文，方便国内玩家使用。
>
> **版本说明：** v1.0.0 包含中文版 README，但游戏内语言仅支持英文和俄文。v1.0.1 新增简体中文（zh_cn）完整翻译，中文客户端玩家可直接看到中文提示。

[English](README_EN.md) | 简体中文

---

## 功能特性
- `/register <密码>` — 注册账号
- `/login <密码>` — 登录账号
- `/changepassword <旧密码> <新密码>` — 修改自己的密码
- 未认证前完全锁定：
  - 无法移动
  - 无法破坏/放置方块
  - 无法丢弃/拾取物品
  - 无法使用命令（除 /login 和 /register）
  - 聊天被禁用
- 密码使用 PBKDF2-HMAC-SHA256 哈希存储，防止明文泄露
- 连续登录失败后自动临时锁定，防暴力破解
- 无需管理员权限

---

## v1.0.1 更新说明

v1.0.0 仅提供英文版 README，游戏内提示仍为英文或俄文（由客户端语言自动决定），不支持中文。

v1.0.1 新增了完整的简体中文翻译，具体变化如下：

| 项目 | v1.0.0 | v1.0.1 |
|------|--------|--------|
| 支持语言 | 英文、俄文 | 英文、俄文、**中文** |
| 中文玩家显示 | 英文或俄文（由客户端语言决定） | **简体中文** |
| 配置强制语言 | 仅支持 `ru`、`en` | 新增 `zh` / `zh_cn` |

对于使用中文客户端的玩家，v1.0.1 会直接显示中文提示，无需任何额外配置。若需要强制使用中文（即使客户端语言不是中文），可在配置文件中设置 `language = "zh"`。

---

## 安装方法
1. 从 [Releases](https://github.com/172292354-cell/AuthMod/releases) 下载对应版本的 jar 文件
   - v1.0.1（推荐）— 含中文支持
   - v1.0.0 — 仅含英文、俄文
2. 将文件放入服务器的 `mods` 文件夹
3. 在 `server.properties` 中设置 `spawn-protection=0`
4. 启动服务器

> 新玩家 → 看到 `/register` 提示
> 老玩家 → 看到 `/login` 提示

---

## 游戏内提示（中文）
玩家进入服务器后会看到如下提示：

```
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
身份验证

请输入：
   /login <密码>  或
   /register <密码>

(密码至少 %s 个字符)
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
```

---

## 配置文件
首次运行后在 `config/authmod-server.toml` 中生成：

```toml
[auth]
    minPasswordLength = 6        # 密码最小长度（4–64）
    maxLoginAttempts = 3         # 失败尝试上限（1–100）
    lockoutSeconds = 60          # 锁定持续时间（秒，1–3600）
    language = "auto"           # 语言：auto（自动）/ zh（中文）/ en（英文）/ ru（俄文）
```

---

## 兼容性
- Minecraft 1.20.1
- Forge 47.4.0+
- 仅服务端 — 客户端无需安装此模组即可加入

---

## 从源码构建
1. 安装 Java 17
2. 克隆仓库
3. 运行 `gradle build`
4. 在 `build/libs/` 目录中找到生成的 JAR 文件

---

## 开源协议
本项目基于 [MIT 协议](LICENSE) 开源。

## 致谢
本项目 Fork 自 [d-society1](https://github.com/d-society1) 的 [AuthMod](https://github.com/d-society1/AuthMod) 原项目，原项目同时发布于 [CurseForge](https://www.curseforge.com/minecraft/mc-mods/forgeguardauth)。

## 作者
- 原项目作者：[d-society1](https://github.com/d-society1)
- 本 Fork 维护者：[172292354-cell](https://github.com/172292354-cell)