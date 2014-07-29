#ifndef __DERIVED_H__
#define __DERIVED_H__

#include "base.h"

typedef struct _Derived 
{
	Base parent; 	/* GTypeInstance */
	gint derived_instance_i;
} Derived;

typedef struct _DerivedClass
{
	BaseClass parent;
} DerivedClass;

void derived_instance_set_i (Derived *instance, gint i);
void derived_instance_dump (Base *instance);
GType derived_get_type ();

#endif /* __DERIVED_H__ */
