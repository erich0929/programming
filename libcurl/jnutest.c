#include <stdio.h>
#include <stdlib.h>
#include <curl/curl.h>

int main(void)
{
	curl_global_init (CURL_GLOBAL_ALL);
	CURL* myhandler = curl_easy_init ();
/*
	curl_easy_setopt (myhandler, CURLOPT_USERAGENT, "Mozilla/5.0");
	curl_easy_setopt (myhandler, CURLOPT_AUTOREFERER, 1);
	curl_easy_setopt (myhandler, CURLOPT_FOLLOWLOCATION, 1);
	curl_easy_setopt (myhandler, CURLOPT_COOKIEJAR, "cookie.txt");
*/
	curl_easy_setopt (myhandler, CURLOPT_URL, "http://ichart.finance.yahoo.com/table.csv?s=068400.KS&a=07&b=1&c=2011&d=07&e=10&f=2011&g=d&ignore=.csv");
/*	char* data = "id=74114&password=/^\s*$/djnu0";
	curl_easy_setopt (myhandler, CURLOPT_POSTFIELDS, data);
	curl_easy_perform (myhandler);
	
	curl_easy_setopt (myhandler, CURLOPT_URL, "http://lib.jnu.ac.kr/myloan/list");
	curl_easy_setopt (myhandler, CURLOPT_COOKIEFILE, "cookie.txt");
	curl_easy_perform (myhandler);
*/
	curl_easy_perform (myhandler);
	curl_easy_cleanup (myhandler);
	return 0;
}
