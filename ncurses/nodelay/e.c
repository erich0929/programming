#include <ncurses.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>


WINDOW* create_newwin (int , int, int, int);
void destroy_win (WINDOW* wnd);

int main(void)
{
	WINDOW *wnd;
	int x,y,width,height;
	int ch;

	initscr ();
	cbreak ();
	nodelay (stdscr, TRUE);
	keypad (stdscr, TRUE);

	height = 3;
	width = 10;
/*	y = (LINES - height) / 2; 
	x = (COLS - width) / 2; */
	y = 10;
	x = 10;
	printw ("Press F1 to exit x: %d, y: %d", x ,y);
	refresh ();
	wnd = create_newwin (height, width, x, y);

	while ((ch = getch ()) != KEY_F(1)) {
		if (ch == ERR) {
			wmove (wnd, 1, 1);
			usleep (99000);
			wprintw (wnd, "%d%d%d", rand()%10, rand()%10, rand()%10);
			wrefresh (wnd);	
		}
		else {	
			switch (ch) {
					case KEY_LEFT:
							destroy_win (wnd);
							wnd = create_newwin (height, width, y, --x);
							break;
					case KEY_UP :
							destroy_win (wnd);
							wnd = create_newwin (height, width, --y, x);
							break;
					case KEY_DOWN :
							destroy_win (wnd);
							wnd = create_newwin (height, width, ++y, x);
							break;
					case KEY_RIGHT :
							destroy_win (wnd);
							wnd = create_newwin (height, width, y, ++x);
							break;
			}
		}
	}

	endwin ();
	return 0;
}

WINDOW *create_newwin (int height, int width, int y, int x) {
		WINDOW *wnd;
		wnd = newwin (height, width, y, x);
		wborder (wnd, ' ', ' ', ' ', '-', ' ', ' ', ' ', ' ');
		wrefresh (wnd);
		return wnd;
}

void destroy_win (WINDOW* wnd) {
		wborder (wnd,  ' ', ' ', ' ', ' ', ' ' , ' ', ' ', ' ');
		wrefresh (wnd);
		delwin (wnd);
}
