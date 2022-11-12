package project;

import run.bach.Bach;
import run.bach.DeclaredModule;
import run.bach.Project;

public class Demo implements Project.Factory {
  @Override
  public Project createProject(Bach bach) {
    return new Project(
        new Project.Name("demo"),
        new Project.Version("1"),
        new Project.Spaces(
            new Project.Space("main")
                .withTargetsJava(19)
                .withModules(DeclaredModule.of("demo", "demo/src/main/java/module-info.java"))
                .withLauncher("demo/demo.Main")),
        new Project.Externals());
  }
}
