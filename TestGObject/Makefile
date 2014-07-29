PROJECTS := TestGObject1 TestGObject2 TestGObject3 \
		TestGObject4 TestGObject5 TestGObject6 TestGObject7

all:
	for proj in ${PROJECTS}; do \
		$(MAKE) -C $$proj all; \
	done

clean:
	for proj in ${PROJECTS}; do \
		$(MAKE) -C $$proj clean; \
	done
