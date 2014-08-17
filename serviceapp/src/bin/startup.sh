#!/bin/sh

APP_HOME=~/serviceapp-1.0-SNAPSHOT

APP_MAINCLASS=org.yywang.App

CLASSPATH=
for i in "$APP_HOME"/lib/*.jar;do
    CLASSPATH="$CLASSPATH":"$i"
done

JAVA_OPTS="-ms512m -mx512m -Xmn256m -Djava.awt.headless=true -XX:MaxPermSize=128m"

java $JAVA_OPTS -classpath $CLASSPATH $APP_MAINCLASS