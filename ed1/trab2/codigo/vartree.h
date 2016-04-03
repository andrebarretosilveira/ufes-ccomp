

typedef struct vartree	{
	char *node;
	struct vartree *prim;
	struct vartree *bro;
} Vartree;


Vartree *vtreeEmpty();

Vartree *vtree( char* node );

Vartree* freeVartree( Vartree *vt );

void printVartree( Vartree *vt );


Vartree* insertSon( Vartree *vt, Vartree *son );

