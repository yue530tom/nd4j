---
layout: cn-default
title: "Downloads"
description: ""
---


To install ND4J, there are a couple of approaches, and more information can be found on the [ND4J website](http://nd4j.org/getstarted.html).

#### Install from Maven Central

1. Search for nd4j in the [Maven Central Repository](http://mvnrepository.com/search?q=nd4j) to find the available nd4j jars.
2. Include the appropriate dependency in your pom.xml.

#### Clone from the GitHub Repo

ND4J is actively developed. You can clone the repository, compile it, and reference it in your project.

Clone the repository:

    $ git clone https://github.com/deeplearning4j/nd4j.git

Compile the project:

    $ cd nd4j
    $ mvn clean install -DskipTests -Dmaven.javadoc.skip=true

Add the local compiled file dependency (choose the module for your backend) to your pom.xml file:

    <dependency>
        <groupId>org.nd4j</groupId>
        <artifactId>nd4j-jblas</artifactId>
        <version>0.0.3.5.5.4-SNAPSHOT</version>
    </dependency>

#### Yum Install / Load RPM (Fedora or CentOS)
Create a yum repo and run yum install to load the Red Hat Package Management (RPM) files. First create the repo file to setup the configuration locally.

    $ sudo vi /etc/yum.repos.d/dl4j.repo

Add the following to the dl4j.repo file:

'''

    [dl4j.repo]

    name=dl4j-repo
    baseurl=http://ec2-52-5-255-24.compute-1.amazonaws.com/repo/RPMS
    enabled=1
    gpgcheck=0
'''

Then run the following command on the dl4j repo packages to install them on your machine:

    $ sudo yum install [package name] -y
    $ sudo yum install nd4j-cli -y # for example

Note, be sure to install the nd4j modules you need first, especially the backend and then install Canova and dl4j.
