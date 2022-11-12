module project {
  requires run.bach;

  provides run.bach.Project.Factory with
      project.Demo;
  provides run.bach.ToolTweak with
      project.EnablePreviewTweak;
}
