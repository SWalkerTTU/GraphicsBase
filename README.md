# GraphicsBase

This NetBeans project allows for users of the [Exposure Java curriculum](http://schram.org/) to continue using its Graphics Labs after support for Applets is dropped from Java. It does this by requiring a "paint" object method in a student's lab Java class that takes a single java.awt.Graphics parameter. The student's class is connected to the GraphicsPanel via the externalClass variable that takes the fully-qualified name of the student's Java class as its value. The "paint" method is then invoked by reflection. GraphicsPanel provides a 1000x650 drawing context, following Schram's standard Applet size.
