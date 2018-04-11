#!/bin/bash

javac -d logger/bin/ $(find logger/src -name *.java)
javac -cp logger/bin/ -d banking/bin/ $(find banking/src -name *.java)
javac -cp logger/bin/:banking/bin -d testframework/bin/ $(find testframework/src -name *.java)
