#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include "pilha.h"

node *criaPilha(node *p)
{
	p = malloc(sizeof(node));
	p->prox = NULL;
	return p;
}

int vazia(node *PILHA)
{
 if(PILHA->prox == NULL)
  return 1;
 else
  return 0;
}

node *aloca(int x,int y,int orient)
{
 node *novo = malloc(sizeof(node));
 if(!novo){
  printf("Erro ao alocar espaco de memoria!\n");
  exit(1);
 }else{
    novo->x = x;
    novo->y = y;
    novo->orient = orient;
    novo->prox = NULL;

  return novo;
 }
}

void libera(node *p)
{
 if(!vazia(p)) {
  node *tmp;
  
  while(p != NULL) {
   tmp = p->prox;
   free(p);
   p = tmp;
  }
 }
}

void push(node *PILHA,int x,int y,int orient)
{
 node *novo=aloca(x,y,orient);

 if(vazia(PILHA))
  PILHA->prox=novo;
  
 else {
  node *tmp = PILHA->prox;

  while(tmp->prox != NULL)
   tmp = tmp->prox;

  tmp->prox = novo;
 }
}


node *pop(node *PILHA)
{
 if(PILHA->prox == NULL){
  printf("PILHA ja vazia\n\n");
  return NULL;
 }else{
  node *ultimo = PILHA->prox,
              *penultimo = PILHA;

  while(ultimo->prox != NULL){
   penultimo = ultimo;
   ultimo = ultimo->prox;
  }

  penultimo->prox = NULL;
  return ultimo;
 }
}
char* translate(node* PILHA,char *regras,int angle,int z){
    node* tmp;
    char comando, *turtle = calloc(100,1);
    int orient=0,fim,i,j,cont=0,y = 0,x = 0,*p_x = &x,*p_y = &y;
    fim = strlen(regras);
    orient = angle;

    for(i=0;i<fim;i++) {
        comando = regras[i];
        switch(comando){
		    case 'F':
		        cont = calcF(turtle,p_x,p_y,z,orient,cont);
		        break;
		    case 'G':
		        cont = calcG(turtle,p_x,p_y,z,orient,cont);
		        break;
		    case '+':
		        orient = orient + angle;
		        break;
		    case '-':
		        if(orient > angle)
		        orient = orient - angle;
		        break;
		    case '[':
		         push(PILHA,x,y,orient);
		        break;
		    case ']':
		        tmp = pop(PILHA);
                if(tmp != NULL){
                    y = tmp->y;
                    x = tmp->x;
                    orient = tmp->orient;
                }
        }
     }
    return turtle;
}
int calcx(int x0,int z,int angle){
        int x;
        x = (x0 + (z*cos(2*M_PI/angle)));
        return x;
}

int calcy(int y0,int z,int angle){
        int y;
        y = (y0 + (z*sin(2*M_PI/angle)));
        return y;
}

int produzturtle(char *turtle,char c,int cont){
        turtle[cont] = c;
        cont++;
        turtle[cont] = ' ';
        cont++;
    return cont;
}

int calcF(char *turtle,int *x,int *y,int z,int angle,int cont){
    char str[20];

    cont = produzturtle(turtle,'n',cont);

    sprintf(str,"%d",*x);
    strcat(turtle,str);

    cont = cont + strlen(str);

    turtle[cont] = ' ';
    cont++;

    sprintf(str,"%d",*y);
    strcat(turtle,str);

    cont = cont + strlen(str);

    turtle[cont] = ' ';
    cont++;

    cont = produzturtle(turtle,'m',cont);

    *y = calcy(*y,z,angle);
    *x = calcx(*x,z,angle);

    sprintf(str,"%d",*x);
    strcat(turtle,str);

    cont = cont + strlen(str);

    turtle[cont] = ' ';
    cont++;

    sprintf(str,"%d",*y);
    strcat(turtle,str);

    cont = cont + strlen(str);

    turtle[cont] = ' ';
    cont++;

    cont = produzturtle(turtle,'l',cont);

    cont = produzturtle(turtle,'s',cont);

    turtle[cont] = ' ';
    cont++;

    return cont;
}

int calcG(char *turtle,int *x,int *y,int z,int angle,int cont){
    char str[20];

    cont = produzturtle(turtle,'n',cont);

    sprintf(str,"%d",*x);
    strcat(turtle,str);

    cont = cont + strlen(str);

    turtle[cont] = ' ';
    cont++;

    sprintf(str,"%d",*y);
    strcat(turtle,str);
    cont = cont + strlen(str);

    turtle[cont] = ' ';
    cont++;

    cont = produzturtle(turtle,'m',cont);

    *y = calcy(*y,z,angle);
    *x = calcx(*x,z,angle);

    sprintf(str,"%d",*x);
    strcat(turtle,str);

    cont = cont + strlen(str);

    turtle[cont] = ' ';
    cont++;

    sprintf(str,"%d",*y);
    strcat(turtle,str);

    cont = cont + strlen(str);

    turtle[cont] = ' ';
    cont++;

    cont = produzturtle(turtle,'l',cont);

    turtle[cont] = ' ';
    cont++;

    return cont;
}
