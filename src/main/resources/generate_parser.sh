#!/usr/bin/bash

cd /home/csoria/ws/bizlang/src/main/resources
java -cp /home/csoria/.m2/repository/org/antlr/antlr4/4.1/antlr4-4.1.jar:/home/csoria/.m2/repository/org/antlr/antlr4-runtime/4.1/antlr4-runtime-4.1.jar:/home/csoria/.m2/repository/org/antlr/antlr-runtime/3.5/antlr-runtime-3.5.jar:/home/csoria/.m2/repository/org/antlr/ST4/4.0.7/ST4-4.0.7.jar org.antlr.v4.Tool Bizlang.g4 -o ../java/com/fedex/lac/bizlang/parser -package com.fedex.lac.bizlang.parser