#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar Lexico.jflex
echo "STARTING CUP COMPILING"
java -jar java-cup-11b.jar -parser Sintactico -symbols sym Sintactico.cup