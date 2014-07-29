#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include <curl/curl.h>

static size_t write_data(void *ptr, size_t size, size_t nmemb, void *stream)
{
	int written = fwrite(ptr, size, nmemb, (FILE *)stream);
	return written;
}

int main(void)
{
	CURL *curl_handle;
	static const char *headerfilename = "head.txt";
	FILE *headerfile;
	static const char *bodyfilename = "body.txt";
	FILE *bodyfile;

	curl_global_init(CURL_GLOBAL_ALL);

	/* init the curl session */
	curl_handle = curl_easy_init();

	/* set URL to get */
	curl_easy_setopt(curl_handle, CURLOPT_URL, "localhost:8080/servlet/excel.jsp");

	/* no progress meter please */
	curl_easy_setopt(curl_handle, CURLOPT_NOPROGRESS, 1L);

	/* send all data to this function  */
	curl_easy_setopt(curl_handle, CURLOPT_WRITEFUNCTION, write_data);

	/* open the files */
	headerfile = fopen(headerfilename,"w");
	if (headerfile == NULL) {
		curl_easy_cleanup(curl_handle);
		return -1;
	}
	bodyfile = fopen(bodyfilename,"w");
	if (bodyfile == NULL) {
		curl_easy_cleanup(curl_handle);
		return -1;
	}

	/* we want the headers to this file handle */
	curl_easy_setopt(curl_handle,   CURLOPT_WRITEDATA, headerfile);

	/*
	 *    * Notice here that if you want the actual data sent anywhere else but
	 *       * stdout, you should consider using the CURLOPT_WRITEDATA option.  */
	curl_easy_setopt(curl_handle,CURLOPT_FOLLOWLOCATION,1);
	/* get it! */
	curl_easy_perform(curl_handle);

	/* close the header file */
	fclose(headerfile);

	/* cleanup curl stuff */
	curl_easy_cleanup(curl_handle);

	return 0;
}