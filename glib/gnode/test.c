#include <stdio.h>
#include <stdlib.h>
#include <glib.h>

typedef struct test_t {
	int i;
} test;

test arr [] = {
				{1},
				{2},
				{3},
};

int main(void)
{
	test ROOT = {0};
	GNode* root = g_node_new (&ROOT);
	int i = 0;
	for (i = 0; i < 3; i++) {
		GNode* temp = g_node_new (&arr[i]);
		g_node_insert (root, -1, temp);
	}
	
	/* 얕은 복사 */
	test* temp = (test*) malloc (sizeof (test));
	*temp = *(test*) root -> data; 
	GNode* cp_root = g_node_new (temp);

	test* cp_root_data = (test *) cp_root -> data;
	test* root_data = (test*) root -> data;

	/* 복사된 노드의 데이터를 수정 */
	cp_root_data -> i = 100;

	printf ("root_data : %d\n", root_data -> i);
	g_node_destroy (root);
	printf ("cp_root_data : %d\n", cp_root_data -> i);
	g_node_destroy (cp_root);

	return 0;
}
