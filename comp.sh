 #!/bin/bash
 lang=$1
 input=i$2.txt
 code=$2
 filename=c$code
 # echo $filename
 cp $filename.txt $filename.$lang
 # echo $2> $filename.$lang
 if test "c" = "$lang";
 then
 	gcc -w $filename.$lang < $input -o $filename.out 2> $filename.err
 	if test $? -eq 0; then
 		./$filename.out > $filename.txt
 		cat $filename.txt
 	fi
 fi
 if test "cpp" = "$lang";
 then
 	g++ -w $filename.$lang -o $filename.out 2>$filename.err
 	if test $? -eq 0; then
 		./$filename.out > $filename.txt
 		cat $filename.txt
 	fi
 fi
 if test "java" = "$lang";
 then
 	javac $filename.$lang 2>$filename.err
 	if test $? -eq 0; then
 		java $filename > $filename.txt
 		cat $filename.txt
 	fi
 fi
 if test "py" = "$lang";
 then
 	python $filename.$lang 2>$filename.err >$filename.txt
 	if test $? -eq 0; then
 		cat $filename.txt
 	fi
 fi
 if test "js" = "$lang";
 then
 	node $filename.$lang 2>$filename.err >$filename.txt
 	if test $? -eq 0; then
 		cat $filename.txt
 	fi
 fi
 if test "php" = "$lang";
 then
 	php $filename.$lang 2>$filename.err >$filename.txt
 	if test $? -eq 0; then
 		cat $filename.txt
 	fi
 fi
 if test "sh" = "$lang";
 then
 	sh $filename.$lang 2>$filename.err >$filename.txt
 	if test $? -eq 0; then
 		cat $filename.txt
 	fi
 fi
 if test "rb" = "$lang";
 then
 	ruby $filename.$lang 2>$filename.err >$filename.txt
 	if test $? -eq 0; then
 		cat $filename.txt
 	fi
 fi
