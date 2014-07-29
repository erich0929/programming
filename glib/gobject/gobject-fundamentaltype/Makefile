CC      := gcc
CFLAGS  := -ansi -Wall
INCPATH := -I/opt/glib/include/glib-2.0/ -I/opt/glib/lib/glib-2.0/include
LIBS    := -L/opt/glib/lib -lgobject-2.0
TARGET  := main
OBJS    := gobject-fundamentalType.o

all: $(OBJS)
	    $(CC) $(CFLAGS) ${LIBS} $(OBJS) -o $(TARGET)

%.o: %.c
	    $(CC) $(CFLAGS) $(INCPATH) -c $<

clean:
	    rm -f *~
		rm -f *.o
		rm -f $(TARGET)
