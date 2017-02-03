---
layout: cn-default
title: "ND4J：为Java编写的N维数组"
tagline: "ND4J是为生产环境设计的多维数组代数库"
redirect_from: /zh-index
---

{% include JB/setup %}

ND4J和ND4S是JVM的科学计算库，并为生产环境设计，亦即例程运行速度快，RAM要求低。

**主要特点**

* 多用途**多维数组**对象
* 多平台功能，包括GPU
* 线性代数和信号处理功能

由于易用性上存在的缺口，Java、[Scala](http://nd4j.org/scala.html)和[Clojure](https://github.com/whilo/clj-nd4j)编程人员无法充分利用NumPy或Matlab等数据分析方面最强大的工具。Breeze等其他库则不支持[多维数组或张量](../tensor)，而这却是深度学习和其他任务的关键。ND4J和ND4S正得到国家级实验室的使用，以完成气候建模等任务。这类任务要求完成计算密集的模拟运算。  

ND4J在开源、分布式、支持GPU的库内，为JVM带来了符合直觉的、Python编程人员所用的科学计算工具。在结构上，ND4J与[SLF4J](http://www.slf4j.org/)相似。ND4J让生产环境下的工程师能够轻松将算法和界面移植到Java和Scala体系内的其他库内。

[点此立刻开始体验](../zh-getstarted.html)，或继续阅读下文。

### ND4J/ND4S具体细节

* 通过Jblas和Netlib Blas，实现通过CUDA和Native对GPU的支持。
* 在安卓上进行部署。
* 与Hadoop和Spark集成。
* [ND4S的API](https://github.com/deeplearning4j/nd4s)模仿Numpy的语义。

### 代码示例

创建2x2多维数组：

    INDArray arr1 = Nd4j.create(new float[]{1,2,3,4},new int[]{2,2});
    System.out.println(arr1);

输出：

    [[1.0 ,3.0]
    [2.0 ,4.0]
    ]

通过就地运算新增标量：

    arr1.addi(1);
    System.out.println(arr1);

各元素均加1：

    [[2.0 ,4.0]
    [3.0 ,5.0]
    ]

创建第二个数组（_arr2_）并将其加入第一个（_arr1_）

    INDArray arr2 = ND4j.create(new float[]{5,6,7,8},new int[]{2,2});
    arr1.addi(arr2);
    System.out.println(arr1);

输出：

    [[7.0 ,11.0]
    [9.0 ,13.0]
    ]

您已对ND4J有所了解。[现在请亲自体验](../zh-getstarted.html)。
