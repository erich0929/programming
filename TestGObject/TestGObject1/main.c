/* A fundamental type. Only its name is significant. */

#include <stdio.h>
#include <glib-object.h>

int main() {
    /* Initialize type system */
    g_type_init();

    /* This is not important */
    GTypeInfo my_type_info = { 0, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, NULL };
    /* This is not important */
    GTypeFundamentalInfo my_type_fundamental_info = { 0 };
    /* Register a fundamental type */
    GType my_type_id = g_type_register_fundamental(g_type_fundamental_next(),
        "MyFundamentalType", &my_type_info, &my_type_fundamental_info, 0);

    /* Print type names */
    printf("Type name of int: %s\n", g_type_name(G_TYPE_INT));
    printf("Type name of float: %s\n", g_type_name(G_TYPE_FLOAT));
    printf("Type name of object: %s\n", g_type_name(G_TYPE_OBJECT));
    printf("Type name of my fundamental type: %s\n", g_type_name(my_type_id));
    /* Print type id and name of MyFundamentalType */
    printf("Type id: %d\n", g_type_from_name("MyFundamentalType"));
    printf("Type name: %s\n", g_type_name(g_type_from_name("MyFundamentalType")));
    /* Print attributes of MyFundamentalType */
    printf("Is fundamental? %s\n", G_TYPE_IS_FUNDAMENTAL(my_type_id) ? "yes" : "no");
    printf("Is derived? %s\n", G_TYPE_IS_DERIVED(my_type_id) ? "yes" : "no");
    printf("Is interface? %s\n", G_TYPE_IS_INTERFACE(my_type_id) ? "yes" : "no");
    printf("Is classed? %s\n", G_TYPE_IS_CLASSED(my_type_id) ? "yes" : "no");
    printf("Is instantiatable? %s\n", G_TYPE_IS_INSTANTIATABLE(my_type_id) ? "yes" : "no");
    printf("Is derivable? %s\n", G_TYPE_IS_DERIVABLE(my_type_id) ? "yes" : "no");
    printf("Is deep derivable? %s\n", G_TYPE_IS_DEEP_DERIVABLE(my_type_id) ? "yes" : "no");
    printf("Is abstract? %s\n", G_TYPE_IS_ABSTRACT(my_type_id) ? "yes" : "no");
    printf("Is value abstract? %s\n", G_TYPE_IS_VALUE_ABSTRACT(my_type_id) ? "yes" : "no");
    printf("Is value type: %s\n", G_TYPE_IS_VALUE_TYPE(my_type_id) ? "yes" : "no");
    printf("Has value table: %s\n", G_TYPE_HAS_VALUE_TABLE(my_type_id) ? "yes" : "no");

    return 0;
}
