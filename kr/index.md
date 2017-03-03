---
layout: default
title: "ND4J: Java를 위한 N 차원 배열 (N-Dimensional Arrays)"
description:
---
* <a href="index">ND4J: Java를 위한 N 차원 배열 (N-Dimensional Arrays)</a>
* <a href="getstarted">ND4J 전체 설치</a>
* <a href="dependencies">디펜던시(Dependencies)</a>

ND4J는 JVM를 위한 과학 컴퓨팅 라이브러리 입니다. 리서치 도구로서보다는 생산 환경에서 사용되고자 만들어졌고 이는 최소 RAM 요건으로도 빨리 실행되도록 설계 되었슴을 의미합니다.

### 주요 특징:

* 다목적 N 차원 배열 객체
* GPU를 포함한 멀티플랫폼 기능
* 선형 대수학 및 신호 처리 기능

유용성 차이가 [NumPy](http://www.numpy.org) 또는 [Matlab](http://www.mathworks.com)과 같이, 데이터 분석에서 가장 강력한 도구들로부터 Java, [Scala](http://nd4j.org/scala.html) 및 Clojure 프로그래머들을 분류해 왔습니다. 한 때 Python 커뮤니티에 제한되었던 직관적인 과학 컴퓨팅 도구들은  이제 ND4J로 인해 오픈소스이며, 배포되고, JVM 상에서 GPU와 통합 되었습니다.

[SLF4J](http://www.slf4j.org)를 생각해 보십시오. 이제 [Theano](http://deeplearning.net/software/theano/)가 내장된 NumPy를 상상하십시오. 그것이 ND4J입니다. 이것은 생산 환경에 있는 엔지니어들에게 Java와 Scala 에코시스템에서 그들의 알고리즘을 이동하고 다른 라이브러리들과 인터페이스 하는 쉬운 방법을 제공합니다.

[시작하시려면 여기를 클릭하시거나](http://nd4j.org/kr-getstarted.html) 계속 읽어주십시오.

### ND4J 특성(Specifics)

* Jblas 및 Netblas Blas를 통한 CUDA 및 네이티브(Native)를 통해 GPU를 지원합니다.
* 이 모두가 통합 인터페이스에 포함되어 있습니다.
* 그 API는 Numpy, Matlab 및 scikit-learn의 의미론(semantics)를 모방합니다.

### 코드 예제

2 × 2 NDarray를 생성하십시오:
```java
INDArray arr1 = Nd4j.create(new float[]{1,2,3,4},new int[]{2,2});
System.out.println(arr1);
```
### 산출(Output)
```java
[[1.0 ,3.0]
[2.0 ,4.0]
]
```
인플레이스 오퍼레이션와 함께 scalar 추가:
```java
arr1.addi(1);
System.out.println(arr1);
```
각 요소는 하나씩 증가 합니다.
```java
[[2.0 ,4.0]
[3.0 ,5.0]
]
```
두 번째 배열 (arr2)을 생성해 첫 번째 배열 (arr1)에 추가 하십시오:
```java
INDArray arr2 = ND4j.create(new float[]{5,6,7,8},new int[]{2,2});
arr1.addi(arr2);
System.out.println(arr1);
```
### 산출:
```java
[[7.0 ,11.0]
[9.0 ,13.0]
]
```
모두 이해 하셨습니다. [이제 시작하도록 하겠습니다](http://nd4j.org/kr-getstarted.html).
