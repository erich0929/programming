#include <iostream>
#include <string.h>

using namespace std;

class foo {
	public :
	   string a;
};

int main () {
	foo a, b;
	a.a= "hello world";
	b.a = "hello world";
	cout << (a == b) <<endl; // true
	return 0;
}
