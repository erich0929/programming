#!/bin/sh 

while read line 
do	
	code=`echo "$line" | awk 'BEGIN {FS="\t"}; {printf "%s.KS", $2}'`
	echo "$code"
done < ~/문서/stock/krx.csv


