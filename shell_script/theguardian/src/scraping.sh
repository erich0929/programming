#!/bin/bash	
lynx --dump "http://www.theguardian.com/" | awk '/http/{print $2}' > link.txt

#echo "http://m.guardian.co.uk/world?m.cam=www" > linkalone.txt
count=0;
while read line
do
let count++
url="$line"
echo "$count. $line"
lynx --source --dump "$url" > main_source.html
hxnormalize -x main_source.html | hxselect "#article-header h1" > main_header.html
main_header=`lynx --dump main_header.html  | sed 's/^\s*//g' | sed '/^\s*$/d'`".html"
content=`hxnormalize -x main_source.html | hxselect "#article-body-blocks"`
#echo "$main_header"
if [ "$main_header" != ".html" -a "$content" != "" ]
then
	main_header="/home/erich0929/programming/shell_script/theguardian/scrap/""$main_header"
	echo "" > "$main_header"
	echo "<p>Title : </p>" >> "$main_header"
	hxnormalize -x main_source.html | hxselect "#main-article-info" >> "$main_header"
	echo "<p>Contributor : </p>" >> "$main_header"
	hxnormalize -x main_source.html | hxselect ".contributor" >> "$main_header"
	echo "<p>Public Date : </p>" >> "$main_header"
	hxnormalize -x main_source.html | hxselect ".publication time" >> "$main_header"
	echo "<p>Content : </p>" >> "$main_header"
	hxnormalize -x main_source.html | hxselect "#article-body-blocks" >> "$main_header"
	#lynx --dump "$main_header"
fi
done < link.txt
