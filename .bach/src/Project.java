import run.bach.Bach;
import run.bach.workflow.Builder;
import run.bach.workflow.Structure.DeclaredModule;
import run.bach.workflow.Structure.Space;
import run.bach.workflow.Workflow;

record Project(Workflow workflow) implements Builder {
  public static void main(String... args) {
    Project.ofCurrentWorkingDirectory().build();
  }

  static Project ofCurrentWorkingDirectory() {
    var folders = Bach.Folders.ofCurrentWorkingDirectory();
    var demo = folders.root("demo");
    var main =
        new Space("main")
            .with(
                new DeclaredModule(demo, demo.resolve("src/main/java/module-info.java"))
                    .withResourcePath(demo.resolve("src/main/resources")));
    var workflow = Workflow.of(folders).with(main);
    return new Project(workflow);
  }
}
