#!/bin/sh

echo "  x--------------------------x "
echo "  |        - RushHour -      | "
echo "  |        Projet Java       | "
echo "  |        2015 - 2016       | "
echo "  |                          | "
echo "  |      Cordier Olivier     | "
echo "  x--------------------------x "
echo " "

REP=RushHourProject

creerJavadoc(){
	javadoc -d RushHourProject/javadoc -sourcepath RushHourProject/RushHour/src -subpackages g42442.rushhour:g42442.view:g42442.model

}

creerRepEtClone(){
	mkdir $REP
	git clone https://gitlab.com/esi-javl-pbt-20152016/rushhour-o-cordier.git $REP
	mkdir $REP/game
	#mkdir $REP/lib
}

compilation(){
	echo "Compilation des fichiers..."

	javac -d RushHourProject/game RushHourProject/RushHour/src/g42442/rushhour/Main.java
	javac -d RushHourProject/game RushHourProject/RushHour/test/g42442/model/BoardTest.java   
	javac -d RushHourProject/game RushHourProject/RushHour/test/g42442/model/CarTest.java
	javac -d RushHourProject/game RushHourProject/RushHour/test/g42442/model/PositionTest.java
	javac -d RushHourProject/game RushHourProject/RushHour/test/g42442/model/RushHourGameTest.java
	jar xf RushHourProject/RushHour/resources/json-simple-1.1.1.jar
	mv org RushHourProject/game
	rm -Rf META-INF
	mkdir RushHourProject/game/g42442/rushhour/json
	cp RushHourProject/RushHour/src/g42442/rushhour/json/*.json RushHourProject/game/g42442/rushhour/json
	cp RushHourProject/RushHour/MANIFEST.MF RushHourProject
	
	jar cvfm RushHourProject/rushHour.jar RushHourProject/MANIFEST.MF -C RushHourProject/game/ .
}	
test(){
	echo "Test Junit … "

	java org.junit.runner.JUnitCore g42442.model.BoardTest >> $REP/rushHourTestResults.txt 
	java org.junit.runner.JUnitCore g42442.model.CarTest >> $REP/rushHourTestResults.txt
	java org.junit.runner.JUnitCore g42442.model.PositionTest >> $REP/rushHourTestResults.txt
	java org.junit.runner.JUnitCore g42442.model.RushHourGameTest >> $REP/rushHourTestResults.txt
	
}
commands(){
	REP=RushHourProject
	rm -Rf $REP
		creerRepEtClone
		if [ $? -eq 0 ]; then
    			echo  "clonage du projet à partir de GITLAB : OK " >> $REP/rushHourTestResults.txt
			 
		else
  			echo "clonage du projet à partir de GITLAB : NOK " >> $REP/rushHourTestResults.txt
			 
	
		fi
		
		compilation
		if [ $? -eq 0 ]; then
    			echo "compilation du projet : OK " >> $REP/rushHourTestResults.txt
			echo " " 
		else
  			echo "compilation du projet : NOK " >> $REP/rushHourTestResults.txt
			 
	
		fi
		creerJavadoc
		if [ $? -eq 0 ]; then
    			echo "compilation JAVADOC : OK " >> $REP/rushHourTestResults.txt
			 
		else
  			echo "compilation JAVADOC : NOK " >> $REP/rushHourTestResults.txt
			 
	
		fi
		test
		if [ $? -eq 0 ]; then
    			echo "test JUnit : OK " >> $REP/rushHourTestResults.txt
			echo " " 
		else
  			echo "test JUnit : NOK " >> $REP/rushHourTestResults.txt
			 
	
		fi
		
		echo "Voulez vous exécuter le jeux maintenant O/N : "
		read ouinon
		if [ "$ouinon" = "o" ] || [ "$ouinon" = "o" ];then
			java -XX:-UseCompressedClassPointers g42442.rushhour.Main
		elif [ "$ouinon" = "n" ] || [ "$ouinon" = "N" ]; then
			echo " ************* "
			echo " * Aurevoir! * "
			echo " ************* "
		else
			echo "Il fallait taper O ou N! pas $ouinon … Aurevoir! " 
			echo " "
		fi
}


export CLASSPATH=$CLASSPATH:./RushHourProject/RushHour/src:./RushHourProject/RushHour/resources/json-simple-1.1.1.jar:./RushHourProject/RushHour/resources/junit-4.12.jar:./RushHourProject/RushHour/resources/hamcrest-core-1.3.jar:./RushHourProject/game



if [ -e "$REP" ]; then 
	echo " ***************************************** "
	echo " * Le répertoire $REP existe! * "
	echo " ***************************************** "
	echo " "
	echo "Voulez vous le supprimer et faire un clone du projet depuis GITLAB O/N : "
	read ouinon
	if [ "$ouinon" = "o" ] || [ "$ouinon" = "O" ];then
		commands
	elif [ "$ouinon" = "n" ] || [ "$ouinon" = "N" ]; then
		echo "Le répertoire n'a pas été supprimé! Aurevoir! "
		echo " "
	else
		echo "Il fallait taper O ou N! pas $ouinon … Aurevoir! " 
		echo " "
	fi
else 
	echo " *********************************************** "
	echo " * Le répertoire $REP n'existe pas! * "
	echo " *********************************************** "
	echo " "
	echo "Voulez vous le créer et cloner le projet depuis GITLAB O/N : "
	read ouinon
	if [ "$ouinon" = "o" ] || [ "$ouinon" = "O" ];then
		commands
	elif [ "$ouinon" = "n" ] || [ "$ouinon" = "N" ]; then
		echo "Le répertoire n'a pas été supprimé! Aurevoir! "
		echo " "	
	else
		echo "Il fallait taper O ou N! pas $ouinon … Aurevoir! " 
		echo " "
	fi

fi


	