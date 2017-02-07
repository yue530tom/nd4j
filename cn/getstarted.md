---
layout: cn-default
title: "ND4J：为Java编写的N维数组"
tagline: "ND4J是为生产环境设计的多维数组代数库"
---

{% include JB/setup %}

# ND4J入门

为了使用ND4J ，您的电脑或将计算机上需要安装了以下这些个工具：

1. [Java](http://nd4j.org/zh-getstarted.html#java)
2. [Github](http://nd4j.org/zh-getstarted.html#github)
3. [Maven](http://nd4j.org/zh-getstarted.html#maven)
4. [Java IDE](http://nd4j.org/zh-getstarted.html#ide)
5. [下一步](http://nd4j.org/zh-getstarted.html#next)

整个安装过程可能需要一个小时左右，这将取决于您的网络速度。在这个教程里，通过利用一些简单的例子，您将会学习到ND4J如何运行。

<iframe width="750" height="560" src="//www.youtube.com/embed/D0TrW9ht2Qo" frameborder="0" allowfullscreen=""></iframe>

## <a name="java">Java</a>

### 什么是Java

[Java](https://zh.wikipedia.org/wiki/Java)是我们的首选编程语言。

## 为什么您需要Java

Java将会帮您把您的代码转换成机器代码，让您可以在服务器，计算机或电脑和移动电话上跨平台工作。

### 您是否安装了Java

测试您的Java版本（也测试您是否拥有Java） ，通过键入以下文本到命令行：

    java -version

ND4J需要Java 7 才能执行，因此，如果您有较旧的Java版本，您需要安装一个新的。

### 安装

如果您的计算机（电脑）上没有安装Java 7，请到这里下载 Java开发工具包（ [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) ）。 Java的下载方法将因不同的操作系统而异。对于较新的苹果操作系统，您会看到在在第一行的文件提及Mac OS X（每一次的更新的，jdk-7U后的数字将增加）。您讲会看到类似以下的文本：

        Mac OS X x64 185.94 MB -  jdk-7u67-macosx-x71.dmg

## <a name="github">Github</a>

### 什么是Github

[Github](https://zh.wikipedia.org/wiki/GitHub)是基于互联网的的一个分布式的版本控制系统。GitHub可以托管各种git库，并提供一个web界面，但与其它像 SourceForge或Google Code这样的服务不同，GitHub的独特卖点在于从另外一个项目进行分支的简易性。（点击此处查看现有的开放源代码软件的托管设施之间的比较） 。

### 为什么您需要Github

如果您只想使用ND4J库，您就不需要GitHub，Maven将会处理.jar文件。但是，如果您想对ND4J或DeepLearning4J项目作出贡献，我们十分欢迎您向我们报告当中出现错误。（我们十分感谢那些已经对这个项目作出贡献的人）。

### 您是否安装了Github

您只是检查你安装的程序。

### 安装

您只需要到GitHub上下载的Mac ，Windows等复制ND4J文件，输入以下的指令到您的终端（ Mac）或Git Shell（ Windows）中：

        git clone https://github.com/deeplearning4j/nd4j

## <a name="maven">Maven</a>

### 什么是Maven

[Maven](https://zh.wikipedia.org/wiki/Apache_Maven)是一个能自动构建Java项目（除其他事项外）的工具 ，它能知道并帮您下载最新版本的图书馆（ ND4J .jar文件）到您的计算机或电脑，让您随时准备引用。

### 为什么您需要Maven

只要一个命令，Maven可以让您同时安装ND4J和Deeplearning4j这两个项目。此外，它具有一个集成开发环境：Integrated Development Environment（ IDE ），我们将会在接下来的指示中要求您安装Maven。如果您很清楚的知道一切如何运作，您直接可以不需要通过Maven的模式进行调整，您直接通过我们的下载页面绕过它。

### 您是否安装了Maven

如果想要查看Maven是否的安装在您的计算机或电脑上，只要输入以下的文本到命令行：

        mvn --version

### 安装

点击这里查看如何安装[Maven](https://maven.apache.org/download.cgi)。

根据适用于您的操作系统的说明，例如基于UNIX操作系统（ Linux，Solaris和Mac OS X），然后下载包含Maven的最新稳定版本的压缩文件。

如果您想要开发ND4J，只要git 复制（git clone）此软件（如上所述） ，并运行ND4J目录中的Maven命令：

        mvn clean install -DskipTests=true -Dmaven.javadoc.skip=true

## <a name="ide">Java IDE</a>

### 什么是 Java IDE

您可以利用集成开发环境：[Integrated Development Environment（ IDE）](https://zh.wikipedia.org/wiki/%E9%9B%86%E6%88%90%E5%BC%80%E5%8F%91%E7%8E%AF%E5%A2%83)来编辑，调试，以及建立源代码。在这里，我们建议您安装的Java版本，GitHub和Maven都会帮您处理您的依赖值。请访问我们的依赖值网页以便学习如何能用简单、轻松的方法来更改依赖值。

### 为什么您需要Java IDE

因为您想要建立一个完善的发展环境，以便让您能全心全意编辑您的代码。

### 您是否安装了Java IDE

您只需检查您的安装的程序。

### 安装

我们推荐[IntelliJ](https://www.jetbrains.com/idea/download/) ，同时它也是免费的，我们只需要社区版（Community Edition）的就可以了。

如果您喜欢， ND4J也可以在[Eclipse](http://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html)或[Netbeans](http://wiki.netbeans.org/MavenBestPractices)使用。

现在您可以简单的通过[IntelliJ](https://zh.wikipedia.org/wiki/IntelliJ_IDEA)来导入ND4J项目（或者通过Eclipse或 Netbeans）。

## <a name="next">下一步</a>

现在，您应该可以开始准备运行我们引用文档中的例子。我们建议您启动您的IDE，然后加载ND4J项目，并打开示例子目录。右键单击其中一个示例子目录然后在下拉菜单中选择“运行”。如果一切安装都被正确，您应该看到程序输出的数字。在右侧窗口中，您也可以开始检查或探索这些代码。

一旦您熟悉了这些例子，您可以更改POM文件中的依赖值。[请点击这里学习如何改变依赖值](http://nd4j.org/dependencies.html)。

如果您有任何疑问或意见，[坛联系我们](mailto:help@skymind.io)。

相关链接:

* [ND4J](http://nd4j.org/zh-index)项目和[Github](https://github.com/SkymindIO/nd4j)上库。
* [DeepLearning4J](http://deeplearning4j.org/zh-index.html)项目和[Github](https://github.com/SkymindIO/deeplearning4j)上库。
