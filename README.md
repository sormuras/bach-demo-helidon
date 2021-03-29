# 🛫 Bach + Helidon

This project is based on the [Helidon SE Quickstart Guide](https://helidon.io/docs/latest/#/se/guides/02_quickstart).

## Build

Build this project with Bach.

- Install [JDK](https://jdk.java.net) 16 or later
- Clone this repository
- On Windows call `.bach\bin\bach build`, on Linux/MacOS `.bach/bin/bach build`

> Note: Due to automatic modules being present, `jlink` is [disabled](https://github.com/sormuras/bach-helidon/blob/29e8181e10cdad1cdeb2002a9514f506ab2c806a/.bach/bach.info/module-info.java#L5) at the moment.
> Once all dependences are Java modules, `jlink` will be used to create a custom runtime image.
> See [#1] for details.

## Run

Run on the module-path.

On Windows:

`java --module-path .bach\workspace\modules;.bach\external-modules --module com.github.sormuras.bach.helidon`

On Linux/MacOS:

`java --module-path .bach/workspace/modules:.bach/external-modules --module com.github.sormuras.bach.helidon`

```
[...]
INFO: Helidon SE 2.2.1 features: [Config, Health, Metrics, WebServer]
[...]
INFO: Channel '@default' started: [id: 0xdb5c3d99, L:/[0:0:0:0:0:0:0:0]:56096]
WEB server is up! http://localhost:56096/greet
```

> Note: Running via custom runtime image is not supported, yet.
> See [#1] for details.

For further actions, consult the [Helidon SE Quickstart Guide](https://helidon.io/docs/latest/#/se/guides/02_quickstart).

Hit `CTRL+c` to exit the process.

## From Maven Archetype to Java Module Names

In order to generate this project's source files, the `mvn -U archetype:generate [...]` command was executed in a temporary directory.

The following [Maven command](https://twitter.com/sormuras/status/1005918580670697473) was used to find out the names of Java modules for all dependencies:

```shell
mvn compile org.apache.maven.plugins:maven-dependency-plugin:3.1.1:resolve
```

It yielded:

```text
[INFO] --- maven-dependency-plugin:3.1.1:resolve (default-cli) @ helidon-quickstart-se ---
[INFO]
[INFO] The following files have been resolved:
[INFO]    io.helidon.webserver:helidon-webserver:jar:2.2.1:compile -- module io.helidon.webserver
[INFO]    io.helidon.common:helidon-common-reactive:jar:2.2.1:compile -- module io.helidon.common.reactive
[INFO]    io.helidon.common:helidon-common-mapper:jar:2.2.1:compile -- module io.helidon.common.mapper
[INFO]    io.helidon.common:helidon-common:jar:2.2.1:compile -- module io.helidon.common
[INFO]    io.helidon.common:helidon-common-http:jar:2.2.1:compile -- module io.helidon.common.http
[INFO]    io.helidon.media:helidon-media-common:jar:2.2.1:compile -- module io.helidon.media.common
[INFO]    io.helidon.config:helidon-config:jar:2.2.1:compile -- module io.helidon.config
[INFO]    io.helidon.common:helidon-common-media-type:jar:2.2.1:compile -- module io.helidon.common.media.type
[INFO]    io.helidon.common:helidon-common-key-util:jar:2.2.1:compile -- module io.helidon.common.pki
[INFO]    io.helidon.common:helidon-common-configurable:jar:2.2.1:compile -- module io.helidon.common.configurable
[INFO]    io.opentracing:opentracing-util:jar:0.33.0:compile -- module io.opentracing.util [auto]
[INFO]    io.opentracing:opentracing-api:jar:0.33.0:compile -- module io.opentracing.api [auto]
[INFO]    io.opentracing:opentracing-noop:jar:0.33.0:compile -- module io.opentracing.noop [auto]
[INFO]    io.helidon.tracing:helidon-tracing-config:jar:2.2.1:compile -- module io.helidon.tracing.config
[INFO]    io.netty:netty-codec-http:jar:4.1.58.Final:compile -- module io.netty.codec.http [auto]
[INFO]    io.netty:netty-common:jar:4.1.58.Final:compile -- module io.netty.common [auto]
[INFO]    io.netty:netty-transport:jar:4.1.58.Final:compile -- module io.netty.transport [auto]
[INFO]    io.netty:netty-codec:jar:4.1.58.Final:compile -- module io.netty.codec [auto]
[INFO]    io.netty:netty-codec-http2:jar:4.1.58.Final:compile -- module io.netty.codec.http2 [auto]
[INFO]    io.netty:netty-handler:jar:4.1.58.Final:compile -- module io.netty.handler [auto]
[INFO]    io.netty:netty-resolver:jar:4.1.58.Final:compile -- module io.netty.resolver [auto]
[INFO]    io.helidon.media:helidon-media-jsonp:jar:2.2.1:compile -- module io.helidon.media.jsonp
[INFO]    org.glassfish:jakarta.json:jar:1.1.6:compile -- module java.json [auto]
[INFO]    io.helidon.config:helidon-config-yaml:jar:2.2.1:compile -- module io.helidon.config.yaml
[INFO]    org.yaml:snakeyaml:jar:1.27:compile -- module org.yaml.snakeyaml [auto]
[INFO]    jakarta.annotation:jakarta.annotation-api:jar:1.3.5:compile -- module java.annotation [auto]
[INFO]    io.helidon.health:helidon-health:jar:2.2.1:compile -- module io.helidon.health
[INFO]    io.helidon.fault-tolerance:helidon-fault-tolerance:jar:2.2.1:compile -- module io.helidon.faulttolerance
[INFO]    org.eclipse.microprofile.health:microprofile-health-api:jar:2.2:compile -- module microprofile.health.api (auto)
[INFO]    io.helidon.webserver:helidon-webserver-cors:jar:2.2.1:compile -- module io.helidon.webserver.cors
[INFO]    io.helidon.health:helidon-health-checks:jar:2.2.1:compile -- module io.helidon.health.checks
[INFO]    io.helidon.health:helidon-health-common:jar:2.2.1:compile -- module io.helidon.health.common
[INFO]    io.helidon.metrics:helidon-metrics:jar:2.2.1:compile -- module io.helidon.metrics
[INFO]    io.helidon.config:helidon-config-mp:jar:2.2.1:compile -- module io.helidon.config.mp
[INFO]    io.helidon.common:helidon-common-service-loader:jar:2.2.1:compile -- module io.helidon.common.serviceloader
[INFO]    org.eclipse.microprofile.config:microprofile-config-api:jar:1.4:compile -- module microprofile.config.api (auto)
[INFO]    org.eclipse.microprofile.metrics:microprofile-metrics-api:jar:2.3.2:compile -- module microprofile.metrics.api (auto)
[INFO]    org.junit.jupiter:junit-jupiter-api:jar:5.7.0:test -- module org.junit.jupiter.api
[INFO]    org.apiguardian:apiguardian-api:jar:1.1.0:test -- module org.apiguardian.api
[INFO]    org.opentest4j:opentest4j:jar:1.2.0:test -- module org.opentest4j
[INFO]    org.junit.platform:junit-platform-commons:jar:1.7.0:test -- module org.junit.platform.commons
[INFO]    io.helidon.webclient:helidon-webclient:jar:2.2.1:test -- module io.helidon.webclient
[INFO]    io.helidon.common:helidon-common-context:jar:2.2.1:compile -- module io.helidon.common.context
[INFO]    io.netty:netty-buffer:jar:4.1.58.Final:compile -- module io.netty.buffer [auto]
[INFO]    io.netty:netty-handler-proxy:jar:4.1.58.Final:test -- module io.netty.handler.proxy [auto]
[INFO]    io.netty:netty-codec-socks:jar:4.1.58.Final:test -- module io.netty.codec.socks [auto]
```

This information was (manually) transformed into Bach's Module Lookup annotations:

```java
lookupExternal = {
    // Netty
    @External(module = "io.netty.buffer", via = "io.netty:netty-buffer:4.1.60.Final"),
    @External(module = "io.netty.codec.http2", via = "io.netty:netty-codec-http2:4.1.60.Final"),
    @External(module = "io.netty.codec.http", via = "io.netty:netty-codec-http:4.1.60.Final"),
    @External(module = "io.netty.codec.socks", via = "io.netty:netty-codec-socks:4.1.60.Final"),
    @External(module = "io.netty.codec", via = "io.netty:netty-codec:4.1.60.Final"),
    @External(module = "io.netty.common", via = "io.netty:netty-common:4.1.60.Final"),
    @External(module = "io.netty.handler.proxy", via = "io.netty:netty-handler-proxy:4.1.60.Final"),
    @External(module = "io.netty.handler", via = "io.netty:netty-handler:4.1.60.Final"),
    @External(module = "io.netty.resolver", via = "io.netty:netty-resolver:4.1.60.Final"),
    @External(module = "io.netty.transport", via = "io.netty:netty-transport:4.1.60.Final"),
    // OpenTracing
    @External(module = "io.opentracing.api", via = "io.opentracing:opentracing-api:0.33.0"),
    @External(module = "io.opentracing.noop", via = "io.opentracing:opentracing-noop:0.33.0"),
    @External(module = "io.opentracing.util", via = "io.opentracing:opentracing-util:0.33.0"),
    // Jakarta 1
    @External(module = "java.annotation", via = "jakarta.annotation:jakarta.annotation-api:1.3.5"),
    // MP API
    @External(module = "microprofile.config.api", via = "org.eclipse.microprofile.config:microprofile-config-api:1.4"),
    @External(module = "microprofile.health.api", via = "org.eclipse.microprofile.health:microprofile-health-api:2.2"),
    @External(module = "microprofile.metrics.api", via = "org.eclipse.microprofile.metrics:microprofile-metrics-api:2.3.2"),
    // Jakarta 2
    @External(module = "java.json", via = "org.glassfish:jakarta.json:1.1.6"),
    // Snakes and Dragons
    @External(module = "org.yaml.snakeyaml", via = "org.yaml:snakeyaml:1.27"),
},
```

With that mapping (from a module name to a Maven artifact hosted at Maven Central) in place, Bach is able to download external modules and build this modular Java project.
The project-defining module looks like:

```java
module com.github.sormuras.bach.helidon {
  requires java.json;
  requires java.logging;
  requires io.helidon.webserver;
  requires io.helidon.media.jsonp;
  requires io.helidon.metrics;
  requires io.helidon.health;
  requires io.helidon.health.checks;
}
```

That's it.

This root module declaration and the module lookup configuration suffices to build a modular Java project.

[#1]: https://github.com/sormuras/bach-helidon/issues/1
