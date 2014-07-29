#include <stdio.h>
#include <ncurses.h>
#include <term.h>

#define CONTROL(x)  ((x) & 0x1F)

int main(void)
{
//	FILE *fp = fopen("x", "w");
//	if (fp == 0)
//		return(-1);
	SCREEN *s = newterm(NULL, stdin, stdout);
	set_term (s);
	if (s == 0)
		return(-1);
	cbreak();
	noecho();
	keypad(stdscr, TRUE);

	int ch;
	move (10, 10);
	while ((ch = getch()) != EOF && ch != CONTROL('d')) {
		fprintf (stdout, "%c", ch);
		fprintf (stdout, "\r", ch);
		fflush (stdout);
	}
	endwin();

	return 0;
}
