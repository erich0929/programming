#include <stdio.h>

int main(void) {
	unsigned char c;

	for (c = 32; c <= 255; c++) putc(c, stdout);
	return 0;
}
