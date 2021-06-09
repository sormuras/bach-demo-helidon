import com.github.sormuras.bach.ProjectInfo;
import com.github.sormuras.bach.ProjectInfo.*;

@ProjectInfo(
    tools = @Tools(skip = "jlink"),
    // <editor-fold desc="Libraries - External Modules">
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
    lookupExternals = {
        @Externals(name = Externals.Name.JUNIT, version = "5.8.0-M1"),
        @Externals(name = Externals.Name.SORMURAS_MODULES, version = "2021.06.06"),
    }
    // </editor-fold>
)
module bach.info {
  requires com.github.sormuras.bach;
}
