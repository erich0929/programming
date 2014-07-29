#include <iostream>
#include <strings.h>
#include <sys/utsname.h>
using namespace std;
#define HPUX "HPUX"
#define SUNOS "SunOS"

class Scanner {
	public :
		virtual ~Scanner () = 0;
};

class Parser {
	public :
		virtual ~Parser () = 0;
};

class CodeGenerator {
	public :
		virtual ~CodeGenerator () = 0;
};

class Optimizer {
	public :
		virtual ~Optimizer () = 0;
};

Scanner::~Scanner () {}
Parser::~Parser () {}
CodeGenerator::~CodeGenerator () {}
Optimizer::~Optimizer () {}

class HPScanner : public Scaner {};


