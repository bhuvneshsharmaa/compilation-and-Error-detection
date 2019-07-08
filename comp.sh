 #!/bin/bash
 lang=$1
 input=i$2.txt
 code=$2
 filename=c$code
 # echo $filename
 cp $filename.txt ./file/$filename.$lang
 if test "c" = "$lang";
 then
 	gcc -w ./file/$filename.$lang -o ./bin/$filename.out 2> ./error/$filename.err
 	if test $? -eq 0; then
 		./bin/$filename.out > ./output/$filename.txt
 		cat ./output/$filename.txt
 	fi
 fi
 if test "cpp" = "$lang";
 then
 	g++ -w ./file/$filename.$lang -o ./bin/$filename.out 2> ./error/$filename.err
 	if test $? -eq 0; then
 		./bin/$filename.out > ./output/$filename.txt
 		cat ./output/$filename.txt
 	fi
 fi
 if test "java" = "$lang";
 then
 	javac ./file/$filename.$lang 2> ./error/$filename.err
 	if test $? -eq 0; then
 		java ./file/$filename > ./output/$filename.txt
 		cat ./output/$filename.txt
 	fi
 fi
 if test "py" = "$lang";
 then
 	python ./file/$filename.$lang 2> ./error/$filename.err > ./output/$filename.txt
 	if test $? -eq 0; then
 		cat ./output/$filename.txt
 	fi
 fi
 if test "js" = "$lang";
 then
 	node ./file/$filename.$lang 2> ./error/$filename.err >./output/$filename.txt
 	if test $? -eq 0; then
 		cat ./output/$filename.txt
 	fi
 fi
 if test "php" = "$lang";
 then
 	php ./file/$filename.$lang 2> ./error/$filename.err >./output/$filename.txt
 	if test $? -eq 0; then
 		cat ./output/$filename.txt
 	fi
 fi
 if test "sh" = "$lang";
 then
 	sh ./file/$filename.$lang 2> ./error/$filename.err >./output/$filename.txt
 	if test $? -eq 0; then
 		cat ./output/$filename.txt
 	fi
 fi
 if test "rb" = "$lang";
 then
 	ruby ./file/$filename.$lang 2> ./error/$filename.err >./output/$filename.txt
 	if test $? -eq 0; then
 		cat ./output/$filename.txt
 	fi
 fi
