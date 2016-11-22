@echo off

set PROC_PARAM=--base %cd%/../../src/main/java/ db_info.xml --bean %cd%/beans.xsl --access %cd%/access.xsl --accessclass --clear

rem set JAVA_HOME=%ProgramFiles%/java/jdk --package org.c3s.test.db
set LIBS=e:/projects/java/c3s/generators/target
rem set LIBS=c:/projects/alezeyz/otherj/gen/target
set LANG=en_US.utf8

set CLASSPATH=%LIBS%/dbgenerator.jar
set curdir=%cd%
setlocal enabledelayedexpansion
cd %LIBS%/lib
set mycp=
for /r %%i In (*) DO set mycp=!mycp!;%%i
cd %curdir%

set JAVA_ARGS=-server -XX:+HeapDumpOnOutOfMemoryError -Xmx512m -Dfile.encoding=UTF-8
set JAVA_ARGS=%JAVA_ARGS% -cp %classpath%%mycp%

d:\java\x64\jdk8\bin\java.exe %JAVA_ARGS% org.c3s.tools.db.DbTools %PROC_PARAM%

pause
