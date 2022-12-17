package project;

import java.nio.file.Path;
import run.bach.Composer;
import run.bach.Project;
import run.bach.Tweaks;

public class DemoComposer extends Composer {
  @Override
  public Project createProject() {
    return new Project(
        new Project.Name("demo"),
        new Project.Version("1"),
        new Project.Spaces(
            new Project.Space(
                "main",
                19,
                "demo/demo.Main",
                new Project.DeclaredModule(Path.of("demo/src/main/java")))),
        new Project.Externals());
  }

  @Override
  public Tweaks createTweaks() {
    return new Tweaks(
        call ->
            switch (call.name()) {
              case "javac" -> call.with("--enable-preview").with("-Xlint:-preview");
              case "java" -> call.withTweak(0, java -> java.with("--enable-preview"));
              default -> call;
            });
  }
}
