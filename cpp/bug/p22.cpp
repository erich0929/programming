#include <iostream>

int main () {
	int number;

	std::cout << "Enter a number:";
	std::cin >> number;

	std::cout << "Twice " << number << " is " <<
		(number * 2) << '\n';
	return 0;
}
