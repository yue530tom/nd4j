---
layout: default
title: "Architecture"
description: "ND4J's API, Buffer and Backends"
---


## ND4J's APIs, Buffers and Backends

ND4J provides users with Java and [Scala](http://nd4j.org/scala.html) APIs, but other parts of the architecture are less visible. 

The APIs are essentially wrappers for different versions of BLAS (Basic Linear Algebra Subprograms), including Jblas, Netlib-blas and Jcublas, all of which backends can be specified in the [dependencies of your POM file](http://nd4j.org/dependencies.html). 

BLAS implements low-level routines for operations such as vector addition, scalar multiplication, dot products, linear combinations, and matrix multiplication, which can be called from ND4J's APIs. ND4J's higher-level operations include convolutions, fast Fourier transforms, various loss functions, transforms such as sigmoid or tanh, and reductions.

In addition to BLAS versions and BLAS wrappers, ND4J relies on a [data buffer](https://en.wikipedia.org/wiki/Data_buffer), which stores arrays and raw bytes, and sends them to be processed by BLAS. This storage abstraction layer is implemented slightly differently by each backend to adapt to the requirements of, say, distributed GPUs and other hardware.

![Alt text](../img/nd4j_architecture.png) 

For a Power Point overview of ND4J's architecture, please see this [presentation on Slide Share](http://www.slideshare.net/agibsonccc/nd4-j-slidespptx). 
