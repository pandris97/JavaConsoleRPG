#!/bin/bash

find . -name "*.class" -type f -delete
cd src
javac Main.java
java Main
find . -name "*.class" -type f -delete
