MAINSRC= .src/*.java

default: final
	echo "Compilation finished"	

final: dependencies
	javac -d . ./src/Main.java -classpath ./src:.

dependencies:
	javac -d . ./src/Plateau.java ./src/Joueur.java

test: dependencies
	javac -d . ./test/Test.java

clear:
	rm *.class
