import com.github.sormuras.bach.Bach;
import com.github.sormuras.bach.external.Maven;
import java.util.List;

class build {
  public static void main(String... args) {
    try (var bach = new Bach(args)) {
      var grabber =
          bach.grabber(
              build::locateHelidonModule,
              build::locateMicroProfileModule,
              build::locateNettyModule,
              build::locateOpenTracingModule,
              build::locateOtherModule);

      var builder = bach.builder().conventional("com.github.sormuras.bach.helidon");
      builder.grab(grabber, "java.json",
          "io.helidon.webserver",
          "io.helidon.media.jsonp",
          "io.helidon.metrics",
          "io.helidon.health",
          "io.helidon.health.checks");
      builder.compile(javac -> javac.with("--module-version", "1"));
    }
  }

  static String locateHelidonModule(String module) {
    if (!module.startsWith("io.helidon")) return null;
    var version = "2.4.0";
    return switch (module) {
      case "io.helidon.common.pki" -> Maven.central(
          "io.helidon.common", "helidon-common-key-util", version);
      case "io.helidon.faulttolerance" -> Maven.central(
          "io.helidon.common", "helidon-common-service-loader", version);
      case "io.helidon.common.serviceloader" -> Maven.central(
          "io.helidon.fault-tolerance", "helidon-fault-tolerance", version);
      case "io.helidon.metrics.serviceapi" -> Maven.central(
          "io.helidon.metrics", "helidon-metrics-service-api", version);
      case "io.helidon.servicecommon.rest" -> Maven.central(
          "io.helidon.service-common", "helidon-service-common-rest", version);
      default -> {
        var group = String.join(".", List.of(module.split("\\.")).subList(0, 3));
        var artifact = module.substring(3).replace('.', '-');
        yield Maven.central(group, artifact, version);
      }
    };
  }

  static String locateMicroProfileModule(String module) {
    return switch (module) {
      case "microprofile.config.api" -> Maven.central(
          "org.eclipse.microprofile.config", "microprofile-config-api", "1.4");
      case "microprofile.health.api" -> Maven.central(
          "org.eclipse.microprofile.health", "microprofile-health-api", "2.2");
      case "microprofile.metrics.api" -> Maven.central(
          "org.eclipse.microprofile.metrics", "microprofile-metrics-api", "2.3.2");
      default -> null;
    };
  }

  static String locateNettyModule(String module) {
    if (!module.startsWith("io.netty")) return null;
    var version = "4.1.60.Final";
    var artifact = module.substring(3).replace('.', '-');
    return Maven.central("io.netty", artifact, version);
  }

  static String locateOpenTracingModule(String module) {
    if (!module.startsWith("io.opentracing")) return null;
    var version = "0.33.0";
    var artifact = module.substring(3).replace('.', '-');
    return Maven.central("io.opentracing", artifact, version);
  }

  static String locateOtherModule(String module) {
    return switch (module) {
      case "java.annotation" -> Maven.central(
          "jakarta.annotation", "jakarta.annotation-api", "1.3.5");
      case "java.json" -> Maven.central("org.glassfish", "jakarta.json", "1.1.6");
      case "org.yaml.snakeyaml" -> Maven.central("org.yaml", "snakeyaml", "1.27");
      default -> null;
    };
  }
}
