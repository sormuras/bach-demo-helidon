package project;

import run.bach.ToolCall;
import run.bach.ToolTweak;

public class EnablePreviewTweak implements ToolTweak {
  @Override
  public ToolCall tweak(ToolCall call) {
    return switch (call.name()) {
      case "javac" -> call.with("--enable-preview")
          .with("-encoding", "UTF-8")
          .with("-parameters")
          .with("-Xlint:-preview");
      case "java" -> call.with(0, it -> it.with("--enable-preview"));
      default -> call;
    };
  }
}
