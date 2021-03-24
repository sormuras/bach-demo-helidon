import com.github.sormuras.bach.ProjectInfo;
import com.github.sormuras.bach.ProjectInfo.*;

@ProjectInfo(
    tools = @Tools(skip = "jlink"),
    // <editor-fold desc="Libraries - External Modules">
    lookupExternal = {
        // Netty
        @External(via = "io.netty:netty-buffer:4.1.60.Final", module = "io.netty.buffer"),
        @External(via = "io.netty:netty-codec-http2:4.1.60.Final", module = "io.netty.codec.http2"),
        @External(via = "io.netty:netty-codec-http:4.1.60.Final", module = "io.netty.codec.http"),
        @External(via = "io.netty:netty-codec-socks:4.1.60.Final", module = "io.netty.codec.socks"),
        @External(via = "io.netty:netty-codec:4.1.60.Final", module = "io.netty.codec"),
        @External(via = "io.netty:netty-common:4.1.60.Final", module = "io.netty.common"),
        @External(via = "io.netty:netty-handler-proxy:4.1.60.Final", module = "io.netty.handler.proxy"),
        @External(via = "io.netty:netty-handler:4.1.60.Final", module = "io.netty.handler"),
        @External(via = "io.netty:netty-resolver:4.1.60.Final", module = "io.netty.resolver"),
        @External(via = "io.netty:netty-transport:4.1.60.Final", module = "io.netty.transport"),
        // OpenTracing
        @External(via = "io.opentracing:opentracing-api:0.33.0", module = "io.opentracing.api"),
        @External(via = "io.opentracing:opentracing-noop:0.33.0", module = "io.opentracing.noop"),
        @External(via = "io.opentracing:opentracing-util:0.33.0", module = "io.opentracing.util"),
        // Jakarta 1
        @External(via = "jakarta.annotation:jakarta.annotation-api:1.3.5", module = "java.annotation"),
        // MP API
        @External(via = "org.eclipse.microprofile.config:microprofile-config-api:1.4", module = "microprofile.config.api"),
        @External(via = "org.eclipse.microprofile.health:microprofile-health-api:2.2", module = "microprofile.health.api"),
        @External(via = "org.eclipse.microprofile.metrics:microprofile-metrics-api:2.3.2", module = "microprofile.metrics.api"),
        // Jakarta 2
        @External(via = "org.glassfish:jakarta.json:1.1.6", module = "java.json"),
        // Snakes and Dragons
        @External(via = "org.yaml:snakeyaml:1.27", module = "org.yaml.snakeyaml"),
    },
    lookupExternals = {
        @Externals(name = Externals.Name.JUNIT, version = "5.8.0-M1"),
        @Externals(name = Externals.Name.SORMURAS_MODULES, version = "2021.03"),
    }
    // </editor-fold>
)
module bach.info {
  requires com.github.sormuras.bach;
}
