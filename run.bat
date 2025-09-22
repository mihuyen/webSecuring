@echo off
echo Setting up environment variables...
set "JAVA_HOME=C:\Program Files\Java\jdk-22"
set "M2_HOME=D:\K1N1\gs-securing-web\apache-maven-3.9.11-bin\apache-maven-3.9.11"
set "PATH=%JAVA_HOME%\bin;%M2_HOME%\bin;%PATH%"

echo Checking Java version...
java -version
echo.

echo Checking Maven version...
call "%M2_HOME%\bin\mvn.cmd" -version
echo.

echo Running Spring Boot application...
call "%M2_HOME%\bin\mvn.cmd" clean spring-boot:run
pause
