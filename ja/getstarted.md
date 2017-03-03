---
layout: default
title: ND4Jのフルインストール
---
* <a href="getstarted">ND4Jのフルインストール</a>
* <a href="tensor">テンソルとND4J</a>
* <a href="userguide">ND4Jユーザーガイド</a>
* <a href="about">ND4Jとは</a>

# ND4Jのフルインストール

このインストールは複数の段階の手順に従って行います。質問やコメント等は、是非、[Gitter Live Chat](https://gitter.im/deeplearning4j/deeplearning4j)でお聞かせください。弊社のスタッフがお手伝いいたします。恥ずかしがる必要は全くありません。いつでも気軽にご連絡ください。

ND4J、DL4Jを開始するには、以下をお読みください。

1. [必要なもの](#prereq)
3. [統合開発環境](#ide)
4. [新しいND4Jのプロジェクト](#nd4j)
5. [開発ツール](#devtools)
6. [GPUs](#gpu)
7. [次のステップ](#next-steps)

Deeplearning4jは、プロのJava開発者向けのオープンソースプロジェクトで、製品展開、IntellijなどのIDE、Mavenのような自動ビルドツールなどに精通した方々を対象としています。既にこれらのツールをお持ちの方には、弊社のツールは、非常に役に立ちます。

## <a id="prereq"> 必要なもの </a>

システム設定の必要条件:

* [Java 7、またはそれ以降のバージョン](#java)
* [Maven 3.2.5、またはそれ以降のバージョン](#maven)

オプショナル:

* [GPU用のCuda 7](http://docs.nvidia.com/cuda/index.html#axzz3dlfIdQjP)
* [Scala 2.10.x](#scala)
* [Windows](#windows)
* [Github](#github)

## <a id="java">Java 7、またはそれ以降のバージョン</a>

Javaは、主要なインターフェース、そしてND4Jのネットワーキング言語です。何千ものノードを使ったクラウドベースの配信システムからローメモリーのモノのインターネット（Iot：Internet of Things）に至るまで様々なものに使用されているからです。「いったん作成すれば、あちこちで実行できる」言語なのです。

使用しているJavaのバージョン名を調べるには（またはJavaがインストールされているかを調べるには）、以下のコマンドを入力してください。
```
java -version
```
Java 7がインストールされていない場合は、Java開発キットを[こちら](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)からダウンロードしてください。最近のMacの場合、最初のラインのファイルに、Mac OS X （jdk-7uの後の数字はアップデートを行うごとに増えます）の情報を入れます。
		「Mac OS X x64 185.94 MB -  jdk-7u79-macosx-x75.dmg」のようになります。

## <a id="maven">Maven</a>

MavenはJavaのプロジェクトの自動ビルドツール（Mavenのその他の用途は[こちら](http://maven.apache.org/what-is-maven.html)）です。最新バージョンのND4J、そしてDL4Jのプロジェクトライブラリ（.jar files）を見つけ、自動でダウンロードします。これらのリポジトリは、[Maven Central](https://search.maven.org/#search%7Cga%7C1%7Cnd4j)にあります。

Javaプログラマーでない方々のためのさらに詳細にわたるMavenガイドも準備しましたので、[こちら](http://deeplearning4j.org/maven.html)をお読みください。 Mavenだと、ND4JとDeeplearning4jのプロジェクトの両方が簡単にインストールできます。IntelliJなどのような統合開発環境（IDE）を使うのには最適です。

お手持ちの機器にMavenがインストールされているか、またはどのバージョンのMavenがインストールされているかを調べるには以下のコマンドラインを入力してください。
```
mvn --version
```
最新のMavenがインストールされていない場合は、最新のものにアップデートしてください。（これが書かれた現時点では`3.3.x`が最新です。）Mavenのインストールの方法については、[こちら](https://maven.apache.org/download.cgi)をお読みください。Mavenの最新で安定したバージョンの入った圧縮ファイルをダウンロードしてください。

![Alt text](../img/maven_downloads.png)

同じページの下部で、お使いのオペレーティングシステムのガイドに従ってください。例）*「Unixベースオペレーティングシステム（Linux、 Solaris、Mac OS X）」*　以下のようになります。

![Alt text](../img/maven_OS_instructions.png)

## <a id="ide">統合開発環境:IntelliJ</a>

統合開発環境([IDE](http://encyclopedia.thefreedictionary.com/integrated+development+environment))を使用すると、APIを使用し、クリックするだけで自分のネットワークが作成できます。統合開発環境には、**IntelliJ**を使うことをお勧めします。IntelliJだと、インストールしたJavaのバージョンで使うことができ、[Maven](#maven)を使って依存関係を扱うことができるからです。

IntelliJのフリーコミュニティーサイトでは、[こちら](https://www.jetbrains.com/idea/download/)でインストレーションのガイドを提供しています。弊社では、IntelliiJの方をお勧めしていますが、他にも[Eclipse](http://books.sonatype.com/m2eclipse-book/reference/creating-sect-importing-projects.html)や[Netbeans](http://wiki.netbeans.org/MavenBestPractices)が人気のある統合開発環境です。EclipseでND4J/DL4Jパッケージをインストールするには、[こちら](https://depiesml.wordpress.com/2015/08/26/dl4j-gettingstarted/)のガイドをお読みください。

## <a id="nd4j">新しいND4Jプロジェクトをはじめましょう</a>

IntelliJに新規のND4Jプロジェクトを作成するには、IntelliJの開始画面で「Open Project（プロジェクトを開く）」をクリックするか、File（ファイル）/Open（開く）タブをクリックし、「nd4j」を選びます。Githubからソースファイルをクローンした場合、ディレクトリは、IntelliJからアクセス可能です。

IntelliJに新規のND4Jプロジェクトを作成するには、正しいdependencyを、該当するプロジェクトのPOM.xmlファイルにペーストしてください。これらすべてが正しく実行されれば、Mavenが自動でND4Jを構築します。正しい依存関係をPOMファイルにペーストすることにより、ND4Jがインストールできます。他にインストールしなければならないものはありません。

`maven-archetype-quickstart`を選びます。

![Alt text](../img/new_maven_project.png)

こちらは、Mavenを使ったIntelliJの新規プロジェクト作成ウイザード画面です。まずは自分のグループ名とアーティファクト名を付けてください。

![Alt text](../img/maven2.png)

次の画面の「Next（次へ）」をクリックし、その次の画面で、自分のプロジェクト名（例えば「ND4J-test」）を入れ、「Finish（終了）」をクリックします。次に、IntelliJの新規NND4JプロジェクトのルートにあるPOM.xmlにアクセスします。

必要な依存関係を挿入してPOMファイルを更新させます。必要な依存関係は、CPUやGPUによって異なります。

CPUのデフォルト設定のバックエンドは、x86ですが、これはNetlib-blasに強く依存しています。YPOMの`<dependencies> ... </dependencies>` とあるところに、以下のようにペーストします。
```xml
<dependency>
 <groupId>org.nd4j</groupId>
 <artifactId>nd4j-native</artifactId>
 <version>${nd4j.version}</version>
</dependency>
```
ND4Jのバージョンは、ここでは、変数となります。IPOMの少し上にある別のライン`<properties> ... </properties>`を指します。nd4jのバージョンを指定したもので、以下のようになります。
```xml
<nd4j.version>0.4.0</nd4j.version>
```
*dl4jのバージョンも0.4.0、DataVecのバージョンは0.4.0。*

バージョン番号は、新しいリリースが出るにつれて変わります。Maven Centralにある最新のバージョンを忘れずに[こちら](https://search.maven.org/#search%7Cga%7C1%7Cnd4j)でチェックするようにしてください。正しいdependencyとnd4jバージョンをペーストすれば、Mavenが自動的に必要なライブラリをインストールし、ND4Jを実行させることができます。

バックエンドがx86である必要はありません。GPUとの関係で、Jcublasに切り替えても大丈夫です。このことは、弊社の[依存関係](../dependencies.html)のページで、より上級レベルの設定変更についてとともにご説明しています。また、このページでは、ライブラリの[最新バージョン](http://search.maven.org/#search%7Cga%7C1%7Cnd4j)について説明しています。

もうこれで、IntelliJで新規のJavaファイルを作成し、ND4JのAPIを線形代数の計算に使い始めることができます。

新規のIntellijプロジェクトごとに、App.javaファイルを開き、**public static void main( String[] args )**の後に表示される波括弧内にコードを入れてください。

正しいパッケージがインポートされなかったため、クラスの多くは赤色で表示されます。しかし、IntelliJは、これらのパッケージを自動的にファイルのトップに追加します。パッケージを自動ロードさせるには、お使いのOSに基づいて、適切なホットキーを調べてください。

（最初の手順については、弊社の[イントロダクション](http://nd4j.org/introduction.html)をお読みください。IntelliJ のND4Jには、**オートコンプリート**機能があるため、どの文字のコマンドを入れても、その文字が含まれるすべてのND4Jコマンドのリストを表示させてくれます。）

## <a id="github">GitHub & Source</a>

Githubは、ウェブベースの[Revision Control System](http://en.wikipedia.org/wiki/Revision_control)で、オープンソースプロジェクトの[事実上のホスト](http://opensource.com/life/12/11/code-hosting-comparison)です。

ND4Jのコミッターになるつもりはない方、または最新のアルファバージョンが必要ない方は、[Maven Central](https://search.maven.org/#search%7Cga%7C1%7Cdeeplearning4j)から最も安定したバージョンである0.4-rc1.xをダウンロードすることをお勧めいたします。JARファイルは、[Maven Central](https://search.maven.org/#search%7Cga%7C1%7Cnd4j)から直接ダウンロードすることができます。あるいは、弊社の[ソース](http://nd4j.org/source)をご参照ください。

## <a id="scala">Scala</a>

ND4Jと連動させるためにScalaをインストールする必要はありません。[ND4S](https://github.com/deeplearning4j/nd4s)という名のリポジトリに[Scala API](http://nd4j.org/scala.html)があるからです。

Scalaは、マルチパラダイムの言語です。Java仮想マシンで実行できる強い静的型システムです。このようにして、Scalaには、SchemeやHaskellに似た機能的プログラム機能やJavaのようなオブジェクト指向プログラミング機能があり、プログラムが簡易になる構造になっています。ScalaをJavaライブラリと連動させて使用することができます。Scalaに書かれたニューラルネットワークのexampleが複数あり、Sparkの実装に必要になっています。

お手持ちの機器にScalaがインストールされているか、またはどのバージョンのScalaがインストールされているかを調べるには以下のコマンドラインを入力してください。
```
scala -version
```
Scalaをインストールするには、[Scalaダウンロードページ](http://www.scala-lang.org/download/2.10.4.html)にアクセスしてください。ND4Jは、Scala 2.10.4との互換性があり、Scalaには後方互換性がありません。[Homebrew](http://brew.sh/)では、Macのユーザーのために、Scalaをインストールするためのガイドを提供しています。コマンドの`brew install scala`を使用すると、最新のバージョン`2.11.x`が入手できます。Homebrewを使ってScala 2.10.xをインストールするには、[こちら](https://github.com/ofishel/hb-scala-2.10.4)をお読みください。

IntelliJのプラグインによってScalaを使用することができます。（IntelliJにプラグインを追加するには、タブの`IntelliJ IDEA`/`Preferences`/`IDE Setting`/`Plugins`/へ行き、Scalaを探します。）

## <a id="datavec">DataVec</a>

[Canova](https://github.com/deeplearning4j/DataVec)は、機械学習ツールとして弊社が構築した一般的なベクトル化ライブラリです。生のデータを使用可能なベクターフォーマットである*svmLight*、 *libsvm*、*ARFF*などにベクトル化するため、弊社のニューラルネットワークに使用できます。Canovaは、ND4Jに必要ではありませんが、Deeplearning4jニューラルネットワークにデータをロードするのに役立ちます。

### Canovaをインストールしましょう

Mavenで、ND4Jに使用したものと同じ手順にしたがって[DataVec](https://github.com/deeplearning4j/DataVec)をインストールしてください。[Maven](#maven)は、必ず最新バージョンを入手するようにしてください。弊社が現在使用しているバージョンは、0.4.1-SNAPSHOTです。

### Deeplearning4jをインストールしましょう

ND4Jに使ったものと同じ方法で、POMのプロパティセクションにハード・コード化されたバージョンを使い、バージョン変数を各依存性に入れて、Deeplearning4jのバージョンを指定する必要があります。

POMに追加するDL4Jの依存性は、プロジェクトの性質によって異なります。

以下のコア依存性に加えて、コマンドラインインターフェイスに`deeplearning4j-cli`をインストールしたり、Hadoopや Sparkと並行させて使用するために、`deeplearning4j-scaleout`をインストールしたい方もおられるかもしれません。<!--A full list can be seen by searching for *deeplearning4j* on Maven Central.-->
```xml
<dependency>
 <groupId>org.deeplearning4j</groupId>
 <artifactId>deeplearning4j-core</artifactId>
 <version>${deeplearning4j.version}</version>
</dependency>
```
Deeplearning4jをインストールするための詳細情報は、[DL4Jをはじめましょう](http://deeplearning4j.org/gettingstarted.html)をお読みください。

## <a id="devtools">OSX, Windows & Linux用のC言語開発ツール</a>

あるND4J依存関係をWindows、Linux OSにコンパイルするには、gccなどC言語の開発ツールが必要です。お手持ちの機器に*gcc*がインストールされているかを調べるには、ターミナルやコマンドプロンプトにコマンドの`gcc -v`を実行してください。

###OSX

[アップル開発ツールXcode](https://developer.apple.com/xcode/downloads/)の一部のバージョンは、*gcc*をインストールしてくれます。gccがまだインストールされていない場合は、コマンドプロンプトに`brew install gcc`と入力してください。

### <a id="open"> OpenBlas </a>

`native`のバックエンドにあるネイティブライブラリが使用できるかを調べるには、システムパスに`/opt/OpenBLAS/lib`が必要になります。その後、以下のコマンドをプロンプトに入れてください。
```
sudo cp libopenblas.so liblapack.so.3
sudo cp libopenblas.so libblas.so.3
```
これを追加し、[Spark](http://deeplearning4j.org/spark)がOpenBlasで使用できるようにしました。

OpenBlasが正常に動作しない場合は、以下の手順に従ってください。

* Openblasがインストールされていれば、これを削除します。
* コマンドの`sudo apt-get remove libopenblas-base`を実行します。
* OpenBLASの開発版をダウンロードします。
* `git clone git://github.com/xianyi/OpenBLAS`
* `cd OpenBLAS`
* `make FC=gfortran`
* `sudo make PREFIX=/usr/local/ install`
* **Linux**の場合、シンボリックリンクの`libblas.so.3`や `liblapack.so.3`が`LD_LIBRARY_PATH`に存在しないか再度確認します。もし、存在しなければ、`/usr/lib`にリンクを追加してください。以下のようにして設定できます。（-sにより、リンクがシンボリックになります。）
```
ln -s TARGET LINK_NAME
// 解釈: ln -s "to-here" <- "from-here"
```
* "from-here"は、まだ存在しないシンボリックリンクを作成したものです。StackOverflowのシンボリックリンク作成方法ガイドがありますので、[こちら](https://stackoverflow.com/questions/1951742/how-to-symlink-a-file-in-linux)をお読みください。「Linux man page」は、[こちら](http://linux.die.net/man/1/ln)をお読みください。
* 最後に統合開発環境を再起動します。
* ネイティブのBlasをCentos 6で作動させるための詳細は、[こちらのCentos 6](https://gist.github.com/jarutis/912e2a4693accee42a94)をお読みください。

 **Ubuntu**（15.10）のOpenBlasについてのガイドは、[こちら](http://pastebin.com/F0Rv2uEk)をお読みください。OpenBlasを動作させるには、その他、以下を実行する必要があるかもしれません。
```
cd OpenBLAS
make FC=gfortran
sudo make PREFIX=/usr/local/ install

sudo ln -s libopenblas.so libblas.so.3
sudo ln -s libopenblas.so liblapack.so.3
```
**Windows**にOpenBlasをインストールするには、[こちらのファイル](https://www.dropbox.com/s/6p8yn3fcf230rxy/ND4J_Win64_OpenBLAS-v0.2.14.zip?dl=1)をダウンロードしてください。ダウンロードしたファイルを`C:/BLAS`などの場所で解凍してください。最後に、そのディレクトリを、お使いのシステムの環境変数`PATH`に追加してください。

### <a id="windows"> Windows </a>

Windowsをご使用の場合、[Visual Studio Community 2013、またはそれ以降](https://www.visualstudio.com/en-us/products/visual-studio-community-vs.aspx)（無料）をインストールする必要があります。そのパスをPATH環境変数に手動で追加する必要があります。パスは以下のようになります。`C:\Program Files (x86)\Microsoft Visual Studio 12.0\VC\bin`

コマンドプロンプトに`cl`と入力してください。`.dll`ファイルが足りないというメッセージが表示されることがあります。VS/IDEフォルダーがパスに入っていることを確認してください（上記をご参照ください）。If your CMD returns usage info for `cl`, then it's in the right place.

Visual Studioを使用する場合は、

* `\bin\`（`cl.exe`用などに）を指すように、環境変数`PATH`を設定する。
* ND4Jに`mvn clean install`を実行する前に、環境を設定するために`vcvars32.bat`（binにあります）を実行してみてください（ヘッダーをあちこちにコピーする手間が省けます）。
* `vcvars32`は一時的かもしれないので、ND4Jの`mvn install`を実行するたびに`vcvars32`を実行する必要があるかもしれません。
* Visual Studio 2015をインストールし、 PATH変数を設定した後、 ヘッダーファイルをコピーしなくて済むよう、`vcvars32.bat`を実行し、環境変数（INCLUDE、LIB、LIBPATH）を正しく設定する必要があります。しかし、バッチファイルをエキスプローラから実行すると、一時的なものであるため適切に設定されていません。そこで、`mvn install`と同じコマンドプロンプト画面から、`vcvars32.bat`を実行すると、すべての環境変数が正しく設定されます。
* 以下のように設定してください。
```
INCLUDE = C:\Program Files (x86)\Microsoft Visual Studio 12.0\VC\include
LIB = "C:\Program Files (x86)\Microsoft Visual Studio 12.0\VC\lib"
//これにより、.lib filesへリンクできます。^^
```		
* Visual Studioで、C++もクリックしてください。これでデフォルト設定でなくなります。
（*また、[Java CPP](https://github.com/bytedeco/javacpp)のinclude pathは、常にWindowsで動作するとは限りません。これを解決する1つの方法はVisual Studioのincludeディレクトリーからヘッダーファイルを取り、それらをJavaがインストールされたJava Run-Time Environment（JRE）のincludeディレクトリーに入れることです。これにより`standardio.h`などのファイルに影響が出ます。*）
* Git、IntelliJ 、Mavenでexampleのインストールガイドは、弊社の[クイックスタート](http://deeplearning4j.org/quickstart.html#walk)をお読みください
* [こちら](http://avulanov.blogspot.cz/2014/09/howto-to-run-netlib-javabreeze-in.html)では、Windows 64プラットフォームでどのようにしてdllを入手するかを解説しています。
* dllライブラリをダウンロードし、Java binフォルダ（例えば、 `C:\prg\Java\jdk1.7.0_45\bin`）に入れてください。
* ライブラリの`netlib-native_system-win-x86_64.dll`は、
`libgcc_s_seh-1.dll
libgfortran-3.dll
libquadmath-0.dll
libwinpthread-1.dll
libblas3.dll
liblapack3.dll`に依存します。
* （`liblapack3.dll`や`libblas3.dll`は、`libopeblas.dll`の名前を変えたコピーです。）
* コンパイルしたライブラリは、[sourceforge](http://sourceforge.net/projects/mingw-w64/files/Toolchains%20targetting%20Win64/Automated%20Builds/)や[OpenBLAS](http://www.openblas.net/)、[Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22netlib-native_system-win-x86_64%22)からダウンロードできます。

###Linux

Linuxの場合、UbuntuやCentosのユーザーは、2つの異なる手順にしたがう必要があります。

###Ubuntu

Ubuntuの場合、最初に以下を入力します。
```
sudo apt-get update
```
次に、このコマンドのバージョンを実行する必要があります。
```
sudo apt-get install linux-headers-$(uname -r) build-essential
```
`$(uname -r)`は、お使いのLinuxのバージョンによって異なります。Linuxのバージョンを調べるには、ターミナルの新しいウインドウを開き、以下のコマンドを入れてください。
```
uname -r
```
すると、結果が`3.2.0-23-generic`などのように表示されます。 どのような結果が表示されたとしても、それをスクリプトの最初の行に`$(uname -r)`が表示された場所にコピー＆ペーストします。それから、1スペースを入れ、`build-essential`と入力してください。タイプミスには注意してください。タブを押して任意のコマンドを完了させてください。

###CentOS

ルートユーザーとして、ターミナル（または、sshセッション）に以下のコマンドを入れてください。
```
yum groupinstall 'Development Tools'
```
その後、ターミナルで様々な処理、インストールが実行されます。例えば、*gcc*がインストールされているかを調べるには、以下のコマンドを実行してください。
```
gcc --version
```
完全ガイドは、[こちら](http://www.cyberciti.biz/faq/centos-linux-install-gcc-c-c-compiler/)をお読みください。

## <a id="gpu"> GPU </a>

Jcublasバックエンドを追加することについてのガイドは、[こちら](../gpu_native_backends.html)をお読みください。CUDAのバージョン5.5、6.0、6.5、7に対応いたしております。

いったんGPUでニューラルネットワークのトレーニングを開始した後、GPUがどのくらいちゃんと動作しているかモニターしたい場合は、様々な方法があります。

* [Nvidia compiler（NVCC）](http://docs.nvidia.com/cuda/cuda-compiler-driver-nvcc/)がクラスパス(`src/main/resources`)にあることを確認してください。カーネルをオンザフライでコンパイルします。
* [Nvidia System Management Interface（SMI）](https://developer.nvidia.com/nvidia-system-management-interface)をインストールします。出力結果で`Java`を探してください。

## <a id="next">次のステップ</a>

[example](introduction.html)を実行させる準備が整いました。お使いの統合開発環境を起動し、ND4Jのプロジェクトをロードし、exampleのサブディレクトリを開きます。IntelliJウインドウの左側のファイルツリーからexampleを見つけ、その上で右クリックをし、ドロップダウンメニューで「Run（実行）」を意味する緑色の矢印を選択します。

すべてが正常にインストールされれば、プログラムの出力結果として、IntelliJウィンドウの下部に数字が表示されます。実験を始めるには、これらのexampleをサンドボックスとして使用してください。  

examplesに慣れてくると、POMファイルで定義された依存関係を変更してみるといいでしょう。依存関係の変更方法は、[こちら](gpu_native_backends.html)をお読みください。

## 役に立つリンク

* [ND4J Maven Repository](http://mvnrepository.com/artifact/org.nd4j)
* [DeepLearning4j.org](http://deeplearning4j.org/)
* [DeepLearning4j Maven Repository](http://mvnrepository.com/artifact/org.deeplearning4j)
