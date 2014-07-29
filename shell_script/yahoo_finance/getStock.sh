#!/bin/sh	

while read line
do

symbol=`echo "$line" | awk 'BEGIN {FS="\t"}; {print $1}'`
code=`echo "$line" | awk 'BEGIN {FS="\t"}; {printf "%s.KS", $2}'`

symbol=`echo $symbol | sed 's/ /_/g'`
echo $symbol
echo $code

curl --header 'Host: ichart.finance.yahoo.com' --header 'User-Agent: Mozilla/5.0' --header 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8' 'http://ichart.finance.yahoo.com/table.csv?s='$code'&a=00&b=4&c=1900&d=02&e=10&f=2014&g=d&ignore=.csv' -o ~/다운로드/STOCKDATA/$symbol.csv

done < ~/문서/stock/krx.csv
