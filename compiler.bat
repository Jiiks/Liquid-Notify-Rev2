@ECHO OFF
GOTO :start
:start
ECHO --------------------------------------------------------
ECHO --------------------------------------------------------
ECHO     TLNotify Revision 2 Compiler by Jiiks@TL.net      
ECHO Please read compiler_README.txt if you have any problems
ECHO           Requires Java SE Development Kit 
ECHO --------------------------------------------------------
ECHO      Want to develop compiler for other systems?       
ECHO        Send an email to jiiks@windowslive.com          
ECHO --------------------------------------------------------
ECHO --------------------------------------------------------
SET /P ANSWER=Compile application(Y/N)?
if /i {%ANSWER%}=={y} (goto :yes)
if /i {%ANSWER%}=={yes} (goto :yes)
if /i {%ANSWER%}=={n} (goto :no)
if /i {%ANSWER%}=={no} (goto :no)
ECHO Invalid input :(
PAUSE
GOTO :start
:yes
SET /P ANSWER=Are you sure, there might be gazillion errors(Y/N)?
if /i {%ANSWER%}=={y} (goto :jdk)
if /i {%ANSWER%}=={yes} (goto :jdk)
if /i {%ANSWER%}=={n} (goto :no)
if /i {%ANSWER%}=={no} (goto :no)
ECHO Invalid input :(
PAUSE
GOTO :yes
:yes2
ping 127.0.0.1 -n 2 -w 1000 > NUL
ECHO Creating bin
IF EXIST "bin" RMDIR /S /Q "bin" > NUL
MKDIR "bin"
ECHO Compiling
javac -classpath ;lib\substance.jar;lib\trident.jar;lib\commons.jar;lib\jcalendar.jar;lib\kefirbb.jar;lib\miglayout.jar;lib\jl.jar -sourcepath src\com\ln\gui\About.java src\com\ln\gui\*.java src\com\ln\methods\*.java src\com\ln\*.java -d bin\
ECHO Creating jar
jar cvfm TLNotifyRev2.jar resources/MANIFEST.MF -C bin . com
ECHO All done, unless there were errors :(
PAUSE
exit /b 1
:no
ECHO Good for you :)
PAUSE
exit /b 1

:jdk
ECHO You so brave ;)
ping 127.0.0.1 -n 2 -w 1000 > NUL
ECHO Looking for JDK
SET KEY_NAME=HKLM\SOFTWARE\JavaSoft\Java Development Kit
FOR /F "tokens=3" %%A IN ('REG QUERY "%KEY_NAME%" /v CurrentVersion 2^>NUL') DO SET jdkv=%%A
SET jdk=

IF DEFINED jdkv (
FOR /F "skip=2 tokens=2*" %%A IN ('REG QUERY "%KEY_NAME%\%jdkv%" /v JavaHome 2^>NUL') DO SET jdk=%%B
) ELSE (
FOR /F "tokens=*" %%G IN ('DIR /B "%ProgramFiles%\Java\jdk*"') DO SET jdk=%%G
)

SET jdk=%jdk%\bin
SET javac="%jdk%\javac.exe"

IF NOT EXIST %javac% (
javac -version 2>NUL
IF "%ERRORLEVEL%" NEQ "0" GOTO :notfound
) ELSE (
GOTO :setpath
)
GOTO :notfound

:notfound
ECHO JDK is not installed, download and install it from:
ECHO http://www.oracle.com/technetwork/java/javase/downloads/index.html
SET /P ANSWER=Launch in browser(Y/N)?
if /i {%ANSWER%}=={y} (goto :browser)
if /i {%ANSWER%}=={yes} (goto :browser)
if /i {%ANSWER%}=={n} (goto :exit)
if /i {%ANSWER%}=={no} (goto :exit)
PAUSE
EXIT /b 1

:setpath
SET PATH=%jdk%;%PATH%
GOTO :yes2

:browser
SET /P ANSWER=Choose browser(Firefox/Chrome/Ie/Safari/Opera/Netscape).
if /i {%ANSWER%}=={Firefox} (goto :firefox)
if /i {%ANSWER%}=={firefox} (goto :firefox)
if /i {%ANSWER%}=={Chrome} (goto :chrome)
if /i {%ANSWER%}=={chrome} (goto :chrome)
if /i {%ANSWER%}=={Ie} (goto :ie)
if /i {%ANSWER%}=={ie} (goto :ie)
if /i {%ANSWER%}=={Safari} (goto :safari)
if /i {%ANSWER%}=={safari} (goto :safari)
if /i {%ANSWER%}=={Opera} (goto :opera)
if /i {%ANSWER%}=={opera} (goto :opera)
if /i {%ANSWER%}=={Netscape} (goto :netscape)
if /i {%ANSWER%}=={netscape} (goto :netscape)
ECHO Invalid input :(
GOTO :browser


:firefox
start firefox.exe http://www.oracle.com/technetwork/java/javase/downloads/index.html
EXIT /b 1

:chrome
start chrome.exe http://www.oracle.com/technetwork/java/javase/downloads/index.html
EXIT /b 1

:ie
start iexplore.exe http://www.oracle.com/technetwork/java/javase/downloads/index.html
EXIT /b 1

:safari
start safari.exe http://www.oracle.com/technetwork/java/javase/downloads/index.html
EXIT /b 1

:opera
start opera.exe http://www.oracle.com/technetwork/java/javase/downloads/index.html
EXIT /b 1

:netscape
start netscape.exe http://www.oracle.com/technetwork/java/javase/downloads/index.html
EXIT /b 1

:exit
ECHO Bye :)
PAUSE
EXIT /b 1
