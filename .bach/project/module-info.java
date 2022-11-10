@run.bach.Project.Info(targetsJava = 19)
module project {
  requires run.bach;

  provides run.bach.ToolTweak with
      project.EnablePreviewTweak;
}
