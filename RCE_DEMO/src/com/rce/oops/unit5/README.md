# OOP Through Java (C205) - Unit V programs
Ramachandra College of Engineering | Dept. of Cyber Security

## Import into Eclipse
File > Import > General > Existing Projects into Workspace > Select root directory = this folder (or the ZIP) > Finish.
Run any program: open the file > right-click > Run As > Java Application.
Package = topic number (t57_intro ... t68_jdbc). Every file starts with a comment "Program N".

## Notes
* Program 22 (DeadlockDemo) hangs on purpose - press the red Terminate button.
* Programs 19 (RaceDemo) gives different results on each run.
* GUI (AWT) programs need a desktop (not a headless server).
* JDBC programs 51-52: run college.sql in MySQL, download mysql-connector-j JAR,
  Project > Properties > Java Build Path > Libraries > Add External JARs. Program 53 needs no database.
* Applets (programs 54-58) are in the separate folder "applets" (NOT in src, so the project still builds).
  The Applet API is deprecated and removed in the newest JDKs. Use JDK 8 / 11 / 17 / 21:
      cd applets
      javac Hello.java
      appletviewer Hello.java        (appletviewer is absent from newer JDKs)
  If appletviewer is unavailable, show these as code walk-throughs only.
