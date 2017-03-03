---
layout: default
title: "ND4J: N-Dimensional Arrays for Java"
tagline: "ND4J is a library for N-Dimensional Array Algebra designed for production environments"
---


# Working With Source

You will primarily use Github if you are building these projects from source, or working with our examples. Our [Github repositories for ND4J and Deeplearning4j are here](https://github.com/deeplearning4j/).

Type the following into your command line to verify you have Git.

		git --version 

Install [git](https://git-scm.herokuapp.com/book/en/v2/Getting-Started-Installing-Git) if you do not have it already. 

Then check the list of applications installed on your computer for GitHub. If you don't, set up a [Github account](https://github.com/join). Download GitHub for [Mac](https://mac.github.com/), [Windows](https://windows.github.com/), etc. Once installed, `git clone` ND4J or DL4J by entering these commands into your console:

    git clone https://github.com/deeplearning4j/nd4j
    git clone https://github.com/deeplearning4j/Canova
    git clone https://github.com/deeplearning4j/deeplearning4j

You might also want to clone our examples so you can mess around with ND4J or DL4J's pre-built samples (the version will vary):

    git clone https://github.com/deeplearning4j/dl4j-0.4-examples

Another way to get the source code is by clicking on the "[download ZIP](https://github.com/deeplearning4j/nd4j/archive/master.zip)" button from the [ND4J GitHub page](https://github.com/deeplearning4j/nd4j). Then unzip the file (you can use [7-zip](http://www.7-zip.org/download.html) to do that).

Maven can be used in conjunction with Git to ensure that ND4J, Canova and Deeplearning4j build correctly. To make sure you have the most recent, working version of these libraries, you can *cd* into their root directories and enter the following command into your prompt:

		mvn clean install -DskipTests=true -Dmaven.javadoc.skip=true

Running a `mvn clean install` etc. on ND4J, Canova and Deeplearning4j, in that order, is a good way to get the most recent bug fixes and features. 
