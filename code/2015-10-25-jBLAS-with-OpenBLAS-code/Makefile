export OPENBLAS_NUM_THREADS=3

test: MyTest.class
	java -cp "jars/*:." MyTest

MyTest.class: MyTest.java
	javac -cp 'jars/*' MyTest.java

