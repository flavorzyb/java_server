#!/bin/sh
APP_PATH=target/Server-1.0.0-jar-with-dependencies.jar
JAVA_OPTS="-Dfile.encoding=UTF8"
java $JAVA_OPTS -jar $APP_PATH
