#include <stdio.h>

int main(int argc, const char *argv[])
{
	int format_info;
	/* pipe */
	format_info = 0x1000;
	format_info |= 0x0100;
	format_info |= 0x0030;

	printf ("pipe : %d\n", (format_info & 0xF000) >> 12);
	printf ("positive : %d\n", (format_info & 0x0F00) >> 8);
	printf ("branch : %d\n", (format_info & 0x00f0) >> 4);
	
	return 0;
}
