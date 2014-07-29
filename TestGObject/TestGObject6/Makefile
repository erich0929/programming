CC      := gcc
CFLAGS  := -ansi -Wall
INCPATH := -I/usr/include/glib-2.0 -I/usr/lib/glib-2.0/include
LIBS    := -lgobject-2.0
TARGET  := TestGObject6
OBJS    := \
		main.o \
		fakeiface.o \
		fakedesktop.o \
		fakelaptop.o

all: $(OBJS)
	$(CC) $(CFLAGS) ${LIBS} $(OBJS) -o $(TARGET)

%.o: %.c
	$(CC) $(CFLAGS) $(INCPATH) -c $<

clean:
	rm -f *~
	rm -f *.o
	rm -f $(TARGET)
