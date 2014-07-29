#include <iostream>
#include <stdio.h>

using namespace std;

class CTest {
	public :
		int i;
	public :
		virtual void do_something () {	};
};

int main(void)
{
	CTest temp1, temp2;	
	printf ("temp1 method address : %p\n", &temp1.do_something);
	printf ("temp2 method address : %p\n", &temp2.do_something);
	return 0;
}
