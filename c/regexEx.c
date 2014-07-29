#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

#include <regex.h>

int main(int argc, char *argv[])
{
	regex_t state;
	const char *texts[] = {
		"state : q0",
		"state: q0",
		"state:q0s",
		"#state :q0",
		"state q0",
		"# state :q0"
	};
	const char *pattern = "^[ \\t]*(state)[ \\t]*:.*$";
	int i;

	if (regcomp(&state, pattern, REG_EXTENDED))
		return -1;

	for (i = 0; i < sizeof(texts) / sizeof(texts[0]); i++) {
		int status = regexec(&state, texts[i], 0, NULL, 0);

		fprintf(stderr, "%s: %s\n", texts[i], status == 0 ? "match" : "no match");
	}

	return 0;
}
