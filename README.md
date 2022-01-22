# RealtimeProcessingWithStorm

This project shows how to handle streaming data such as IoT environments, and is under the Apache 2.0 license.

```bash
$ sudo mvn clean install compile package dependency:copy-dependencies
$ cd target/classes
$ java -cp ../RealTimeProcessing-1.0-SNAPSHOT.jar com.dolbomdream.RealTimeRanking
```

Current error

```bash
Exception in thread "main" java.lang.NoClassDefFoundError: twitter4j/Query
        at com.dolbomdream.RealTimeRanking.main(RealTimeRanking.java:12)
Caused by: java.lang.ClassNotFoundException: twitter4j.Query
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
        ... 1 more
```