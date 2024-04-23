# 🛫 Bach + Helidon

This project is based on the [Helidon SE Quickstart Guide](https://helidon.io/docs/latest/se/guides/quickstart).

## Prelude

- Install [JDK](https://jdk.java.net) 22 or later
- Clone this repository with submodules

## Build

Build this project with Bach.

```shell
java @build
```
## Run via Java Launcher

Run on the module-path.

On Linux/MacOS:

```shell
java --module-path .bach/out/main/modules:lib --module demo/demo.Main
```

On Windows:

```shell
java --module-path .bach\out\main\modules;lib --module demo/demo.Main
```

```text
[...]
INFO: Helidon SE 4.0.7 features: [Config, Encoding, Media, WebServer]
Apr 22, 2024 11:52:39 PM io.helidon.webserver.ServerListener start
INFO: [0x0eed1446] http://0.0.0.0:8080 bound for socket '@default'
Apr 22, 2024 11:52:39 PM io.helidon.webserver.LoomServer startIt
INFO: Started all channels in 30 milliseconds. 338 milliseconds since JVM startup. Java 22+36-2370
WEB server is up! http://localhost:8080/simple-greet
```

## Run via Custom Runtime Image

- Linux/Mac
```shell script
.bach/out/main/image/bin/demo
```

- Windows
```shell script
.bach\out\main\image\bin\demo
```

For further actions, consult the [Helidon SE Quickstart Guide](https://helidon.io/docs/latest/#/se/guides/02_quickstart).

Hit `CTRL+c` to exit the process.
