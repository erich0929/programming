#ifndef __BASE_H__
#define __BASE_H__

#include <glib-object.h>
#include <stdio.h>

typedef struct _Base
{
	GTypeInstance parent;
	gint base_instance_i;
} Base;

typedef struct _BaseClass
{
	GTypeClass parent;
	void (* base_instance_dump) (Base *instance);
} BaseClass;

void base_class_set_i (gint i);
void base_instance_set_i (Base *instance, gint i);
void base_instance_dump (Base *instance);
GType base_get_type ();

#endif /* __BASE_H__ */
