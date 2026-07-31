AuthMod — Minecraft Forge 1.20.1 登录认证模组

首个支持 Forge 1.20.1 的服务端登录认证模组，提供 `/register`（注册）和 `/login`（登录）命令。

[English](README.md) | 简体中文

---

## 功能特性
- `/register <密码>` — 注册账号（密码至少4个字符）
- `/login <密码>` — 登录账号
- 未认证前完全锁定：
  - 无法移动
  - 无法破坏/放置方块
  - 无法丢弃/拾取物品
- 密码保存在 authmod_data.json
- 无需管理员权限
- 兼容 FTB Essentials（支持 `/tpa`、`/home` 等命令）

---

## 安装方法
1. 从 [Releases](https://github.com/172292354-cell/AuthMod/releases) 下载 authmod-1.0.0.jar
2. 将文件放入服务器的 mods 文件夹
3. 在 server.properties 中设置 `spawn-protection=0`
4. 启动服务器

> 新玩家 → 看到 /register 提示
> 老玩家 → 看到 /login 提示

---

## 游戏内提示
玩家进入服务器后会看到中文提示：

```
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
登录验证

请输入：
   /login <密码>  或
   /register <密码>

(至少4个字符)
▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬
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
