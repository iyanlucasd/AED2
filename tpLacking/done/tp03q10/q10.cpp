#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <locale.h>
#include <err.h>

#define bool short
#define true 1
#define false 0

typedef struct Jogador
{
  int id;
  int altura;
  int peso;
  char nome[100];
  char universidade[100];
  char anoNascimento[100];
  char cidadeNascimento[100];
  char estadoNascimento[100];
} Jogador;

typedef struct
{
  Jogador players[1000]; // Elementos da pilha

} Lista;

//TIPO CELULA ===================================================================
typedef struct Celula
{
  Jogador elemento;
  struct Celula *prox;
} Celula;

Celula *newSCelula(Jogador elemento)
{
  Celula *newS = (Celula *)malloc(sizeof(Celula));
  newS->elemento = elemento;
  newS->prox = NULL;
  return newS;
}

//PILHA PROPRIAMENTE DITA =======================================================
Celula *topo; // Sem celula cabeca.

/****************************/

void READ(char arrayID[]);
char *replace(char *s);
void showAndTell(Jogador x, int pos);
void CLEAN(char dataIn[]);

/***************************/

void inserirFim(Jogador x);
void mostrar();
void mostrarP(Celula i, int j);
void removerFim();
Jogador remover(char pos[]);
void readQueue(char arrayID[]);
void cleanQueue(char dataIn[]);
void start();

/***************************/

int countGlobal = 0;
Jogador p;
Lista list;

int main(int argc, char *argv[])
{
  start();
  char arrayID[1000];

  scanf("%s", arrayID);

  while (strcmp(arrayID, "FIM") != 0)
  {

    READ(arrayID);
    inserirFim(p);
    countGlobal++;
    scanf("%s", arrayID);
  }

  int count = 0;
  int numOps = 0;
  char *operation;
  char *nomeJogador;
  char *polePosition;

  scanf("%d", &numOps);
  while (count < numOps)
  {
    scanf(" %[^\n]s", arrayID);
    if (arrayID[0] == 'I')
    {
      operation = strtok(arrayID, " ");
      nomeJogador = strtok(NULL, " ");
      READ(nomeJogador);
      inserirFim(p);
    }
    if (arrayID[0] == 'R')
    {
      removerFim();
    }
    count++;
  }
  mostrar();
}

void start()
{
  topo = NULL;
}

void inserirFim(Jogador x)
{

  Celula *tmp = newSCelula(x);
  tmp->prox = topo;
  topo = tmp;
  tmp = NULL;

} //end inserirFim

void removerFim()
{

  if (topo == NULL)
  {
    errx(1, "Erro ao remover!");
  }

  Jogador resp = topo->elemento;
  printf("%s%s\n", "(R) ", topo->elemento.nome);
  Celula *tmp = topo;
  topo = topo->prox;
  tmp->prox = NULL;
  free(tmp);
  tmp = NULL;

} //end removerFim

void READ(char arrayID[])
{

  char dataIn[1000];
  char *sep;
  char *separar;
  FILE *jogador = fopen("/tmp/players.csv", "r");

  //fgets(dataIn,1000,jogador);

  do
  {

    fgets(dataIn, 1000, jogador);

    strcpy(dataIn, replace(dataIn));

    separar = strdup(dataIn);

    sep = strsep(&separar, ",");

    if (strcmp(sep, arrayID) == 0)
    {
      CLEAN(dataIn);
    }

  } while (!feof(jogador) && strcmp(sep, arrayID) != 0);

  fclose(jogador);

} 

void CLEAN(char dataIn[])
{

  strcpy(dataIn, strtok(dataIn, ","));
  p.id = atoi(dataIn);

  strcpy(dataIn, strtok(NULL, ","));
  strcpy(p.nome, dataIn);

  strcpy(dataIn, strtok(NULL, ","));
  p.altura = atoi(dataIn);

  strcpy(dataIn, strtok(NULL, ","));
  p.peso = atoi(dataIn);

  strcpy(dataIn, strtok(NULL, ","));
  strcpy(p.anoNascimento, dataIn);

  strcpy(dataIn, strtok(NULL, ","));
  strcpy(p.universidade, dataIn);

  strcpy(dataIn, strtok(NULL, ","));
  strcpy(p.cidadeNascimento, dataIn);

  strcpy(dataIn, strtok(NULL, ","));
  strcpy(p.estadoNascimento, dataIn);

} //end CLEAN

char *replace(char s[])
{
  char newS[300] = "";
  int j = 0;
  int ult = strlen(s);

  for (int i = 0; i < strlen(s) - 1; i++)
  {

    if (s[i] == ',' && s[i - 1] == ',')
    {
      setbuf(stdin, NULL);
      strcat(newS, "nao informado");
      j = strlen(newS);
    }
    newS[j] = s[i];

    j++;
  }

  if (newS[strlen(newS) - 1] == ',')
    strcat(newS, "nao informado");

  char *sOut = newS;
  return sOut;
}

void showAndTell(Jogador x, int pos)
{
  // int tam;

  printf("%s%d%s", "[", pos, "]");
  printf("%s", " ## ");
  printf("%s", x.nome);
  printf("%s", " ## ");
  printf("%d", x.altura);
  printf("%s", " ## ");
  printf("%d", x.peso);
  printf("%s", " ## ");
  printf("%s", x.universidade);
  printf("%s", " ## ");
  printf("%s", x.anoNascimento);
  printf("%s", " ## ");
  printf("%s", x.cidadeNascimento);
  printf("%s", " ## ");
  printf("%s", x.estadoNascimento);
  printf(" ##\n");

} //showAndTell

void mostrarRec(Celula *i, int pos)
{

  if (i != NULL)
  {
    mostrarRec(i->prox, --pos);
    showAndTell(i->elemento, pos);
  }
}

void mostrar()
{

  mostrarRec(topo, 142);
}
