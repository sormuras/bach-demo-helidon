module project {
  requires run.bach;

  provides run.bach.Composer with
      project.DemoComposer;
}
