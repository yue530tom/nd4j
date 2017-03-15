#!/usr/bin/env bash

set -euo pipefail

pkgs="native cuda-7.5 cuda-8.0"

for pkg in $pkgs
do
	pushd libnd4j-$pkg-java
	sbt debian:package-bin
	cp target/*.deb ../
	sbt clean
	popd
done

