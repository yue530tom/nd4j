---
layout: page
title: "ND4J Backends: How They Work"
description: "Linear Algebra Backends Jblas, Netlib Blas, Jcublas"
---
{% include JB/setup %}

ND4J works atop so-called backends, or linear-algebra libraries, such as Native `nd4j-native` and `nd4j-cuda-7.5` (GPUs), which you can select by pasting the [right dependency into your project's POM.xml file](http://nd4j.org/dependencies.html). 

A Java [ServiceLoader](https://docs.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html), which is baked into the language itself, tells Java that the backend exists. It's not necessary to concern yourself with how ND4J backends load and perform other basic functions, but you can explore [how ND4J loads and selects backends, according to your OS, here](https://github.com/deeplearning4j/nd4j/blob/master/nd4j-context/src/main/java/org/nd4j/linalg/factory/Nd4jBackend.java).

The core configurations for each backend are specified in a properties file. 


![Alt text](../img/nd4j_backend_config.png)

A few more points:

* Regardless of the backend you choose, you use the same ND4J API for everything, including GPUs and distributed systems. 
* You can override all properties in the above file from the command line using *mvn -D$your_parameter_here*.
* **Backend prioritization**: You can include multiple backends on the classpath. If you do, ND4J will run on as many as GPUs as you have available, exhaust them, and then start adding CPUs, allowing you to operate on mixed hardware. 
* C programmers engaged in numerical or scientific computing may ask (with a touch of disdain ;) why we built a Java API over several backends. This architecture allows us to largely abstract away the hardware, while optimizing for it under the hood. Software engineers writing in Java or Scala can build scalable numerical software once, and then deploy on multiple platforms, knowing that we've done the work of lower-level optimization, and that their algorithms will work on servers, desktops and Android phones. Another advantage is that you can build your own backends, test them in isolation, and benefit from a higher-level language. 
