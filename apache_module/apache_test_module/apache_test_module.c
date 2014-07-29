#include "httpd.h"   
#include "http_config.h"   
static int apache_test_handler(request_rec *r)   
{  
		if (strcmp(r->handler, "apache_test_module"))  
		{  
				return DECLINED;   
		}  
		ap_set_content_type(r, "text/html");   
		ap_rputs("<HTML>\n", r);  
		ap_rputs("\t<HEAD>\n", r);  
		ap_rputs("\t\t<TITLE>\n\t\t\tApache Test Module\n\t\t</TITLE>\n", r);  
		ap_rputs("\t</HEAD>\n\n", r);  
		ap_rputs("<H1>Hello Idiots....</H1>\n", r);  
		ap_rprintf(r, "Engineers are inside too..!!! <br>");  
		ap_rprintf(r, "<a href=\"http://blog.friendly.lk\">back to blog</a>\n");  
		ap_rputs("</BODY></HTML>\n" ,r);   
		return OK;   
}   
static void apache_test_register_hook(apr_pool_t *p)   
{   
		ap_hook_handler(apache_test_handler, NULL, NULL, APR_HOOK_MIDDLE);   
}   
module AP_MODULE_DECLARE_DATA apache_test_module =   
{   
		STANDARD20_MODULE_STUFF,   
		NULL, /* per-directory config creator */   
		NULL, /* directory config merger */   
		NULL, /* server config creator */   
		NULL, /* server config merger */   
		NULL, /* command table */   
		apache_test_register_hook, /* other request processing hooks */   
};
