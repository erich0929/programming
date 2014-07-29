#include <stdio.h>
#include <ncurses.h>

typedef struct _winEX {
	WINDOW* win;
	int a;
}winEX;

int main(void)
{
	initscr ();
	cbreak ();

	refresh ();
	
	winEX* wnd;
	wnd = (winEX *) newwin (3, 5, 1, 1);
	box ((WINDOW *) wnd, ACS_VLINE, ACS_HLINE);
	wrefresh ((WINDOW *) wnd);
	int ch;
	while ((ch = getch ()) != 'a') {

	}
	delwin ((WINDOW *) wnd);
	endwin ();
	
	return 0;
}
