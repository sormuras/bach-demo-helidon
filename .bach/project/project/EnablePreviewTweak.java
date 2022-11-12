package project;

import run.bach.ToolCall;
import run.bach.ToolTweak;

public class EnablePreviewTweak implements ToolTweak {
  @Override
  public ToolCall tweak(ToolCall call) {
    return switch (call.name()) {
      case "javac" -> call.with("--enable-preview").with("-Xlint:-preview");
      case "java" -> call.with(0, java -> java.with("--enable-preview"));
      default -> call;
    };
  }
}
