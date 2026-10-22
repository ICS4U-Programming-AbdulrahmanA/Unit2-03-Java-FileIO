#!/usr/bin/env sh
set -eu

java -jar ./linter/checkstyle.app -c /sun_checks.xml ./*.java
