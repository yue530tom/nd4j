---
layout: default
title:
description: "GPU Compatibility for NVIDIA CUDA"
---

# ND4J Cuda Backends for GPUs

You can choose GPUs or native CPUs for your backend linear algebra operations by changing the dependencies in ND4J's POM.xml file. Your selection will affect both ND4J and [Deeplearning4j](http://deeplearning4j.org). Check our [dependencies page](dependencies.html) for instructions on configuring your POM.xml file.

We support Cuda 7.5 and 8.0 at the moment. If you have CUDA v7.5 or Cuda v8.0 installed, then you need to define the _artifactId_ like this:
```xml
<dependency>
 <groupId>org.nd4j</groupId>
 <artifactId>nd4j-cuda-7.5</artifactId>
 <version>${nd4j.version}</version>
</dependency>
```
You can replace the `<artifactId> ... </artifactId>`, depending on your preference:
```
nd4j-cuda-$CUDA_VERSION (where CUDA_VERSION is one of 7.5 or 8.0)
```
That's it.

If you have several GPUs, but your system is forcing you to use just one, there's a solution. Just add `CudaEnvironment.getInstance().getConfiguration().allowMultiGPU(true);` as first line of your `main()` method.

Check the NVIDIA guides for instructions on setting up CUDA on  [Linux](http://docs.nvidia.com/cuda/cuda-getting-started-guide-for-linux/), [Windows](http://docs.nvidia.com/cuda/cuda-getting-started-guide-for-microsoft-windows/), and [OSX](http://docs.nvidia.com/cuda/cuda-getting-started-guide-for-mac-os-x/).
