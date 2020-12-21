#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

int numeroFila = 0;
double soma = 0;

int countGlobally = 0;

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

typedef struct Fila
{
   Jogador array[1000];
   /* data */
} Fila;

Jogador array[1000];
int countAux = 0;

typedef struct Celula
{
   Jogador elemento;    // Elemento inserido na celula.
   struct Celula *prox; // Aponta a celula prox.
   struct Celula *ant;  // Aponta a celula anterior.
} CelulaDupla;

Celula *newSCelula(Jogador elemento)
{
   Celula *newS = (Celula *)malloc(sizeof(Celula));
   newS->elemento = elemento;
   newS->ant = newS->prox = NULL;
   return newS;
}

//LISTA PROPRIAMENTE DITA
Celula *primeiro;
Celula *ultimo;

/****************************/

void READ(char PK[]);
char *replace(char *s);
void showAndTell();
void tratamentoString(char dataIn[]);

/***************************/
void start(Jogador elemento);
void inserir(Jogador x);
void remover();
void showAndTell(Jogador x, int i);
void mostrar();
void imprimirR(Jogador x);
bool FIM(char s[]);

/***************************/

// Jogador p[1000];
int countGlobal = 0;
Jogador p;

int main(int argc, char *argv[])
{

   start(array[0]);
   bool x;
   int maior = 0, aux2 = 0, cont = 0;
   char temp[100];
   char arrayID[1000], arrayOps[200];
   fgets(arrayID, 1000, stdin);
   arrayID[strlen(arrayID) - 1] = '\0';

   int numero = 0;

   while (FIM(arrayID) != true)
   {
      strcpy(temp, arrayID);
      READ(temp);
      inserir(array[countAux]);
      countAux++;
      fgets(arrayID, 1000, stdin);
      arrayID[strlen(arrayID) - 1] = '\0';
      cont++;
   }

   cont = 0;
   int cont2 = 0;
   char queueIn[1000];
   int arrayQueue;
   scanf("%d\n", &arrayQueue);
   char charOps[10], id[10], position[10];

   for (int i = 0; i < arrayQueue; i++)
   {
      fgets(queueIn, 1000, stdin);
      queueIn[strlen(queueIn) - 1] = '\0';
      for (int j = 0; j < strlen(queueIn); j++)
      {
         if (queueIn[0] == 'I')
         {
            if (cont == 0)
            {
               if (queueIn[j] != ' ')
               {
                  charOps[cont2] = queueIn[j];
                  cont2++;
               }
               else if (queueIn[0] == 'I')
               {
                  cont++;
                  cont2 = 0;
               }
            }
            else if (cont == 1)
            {
               id[cont2] = queueIn[j];
               cont2++;
            }
         }
         if (queueIn[0] == 'R')
         {
            remover();
         }
      }
      aux2 = atoi(id);
      READ(id);
      memset(id, 0, sizeof(id));
      cont = 0, cont2 = 0;
      if (queueIn[0] == 'I')
         inserir(array[countAux]);
   }
   mostrar();

   return 0;
}

void start(Jogador elemento)
{
   primeiro = newSCelula(elemento);
   ultimo = primeiro;
}

void inserir(Jogador x)
{

   if (numeroFila >= 5)
   {
      CelulaDupla *tmp = primeiro;

      if (tmp->elemento.altura == 0)
      {
         tmp = primeiro->prox;

         soma = soma - tmp->elemento.altura;

         numeroFila--;
         primeiro = primeiro->prox->prox;
         tmp->prox = primeiro->ant = NULL;
      }
      else
      {

         soma = soma - tmp->elemento.altura;

         numeroFila--;

         primeiro = primeiro->prox;
         tmp->prox = primeiro->ant = NULL;
      }
   }

   ultimo->prox = newSCelula(x);
   ultimo->prox->ant = ultimo;
   ultimo = ultimo->prox;

   numeroFila++;
   double media = 0;
   soma = soma + x.altura;
   media = soma / numeroFila;

   int aux2 = 0;
   aux2 = round(media);

   printf("%d\n", aux2);

} //end inserir()

void remover()
{

   if (primeiro == ultimo)
   {
      printf(" Erro ao remover (vazio)! ");
   }

   Celula *tmp = primeiro;

   soma = soma - tmp->elemento.altura;
   imprimirR(tmp->elemento);

   primeiro = primeiro->prox;
   tmp->prox = primeiro->ant = NULL;

   numeroFila--;

   tmp = NULL;
} //end remover

void READ(char PK[])
{

   char dataIn[1000];
   char *sep;
   char *split;
   FILE *jogador = fopen("/tmp/players.csv", "r");

   do
   {

      fgets(dataIn, 1000, jogador);

      strcpy(dataIn, replace(dataIn));

      split = strdup(dataIn);

      sep = strsep(&split, ",");

      if (strcmp(sep, PK) == 0)
      {
         tratamentoString(dataIn);
      } //end if

   } while (!feof(jogador) && strcmp(sep, PK) != 0);

   fclose(jogador);

} //end READ

void tratamentoString(char dataIn[])
{

   strcpy(dataIn, strtok(dataIn, ","));
   array[countAux].id = atoi(dataIn);

   strcpy(dataIn, strtok(NULL, ","));
   strcpy(array[countAux].nome, dataIn);

   strcpy(dataIn, strtok(NULL, ","));
   array[countAux].altura = atoi(dataIn);

   strcpy(dataIn, strtok(NULL, ","));
   array[countAux].peso = atoi(dataIn);

   strcpy(dataIn, strtok(NULL, ","));
   strcpy(array[countAux].anoNascimento, dataIn);

   strcpy(dataIn, strtok(NULL, ","));
   strcpy(array[countAux].universidade, dataIn);

   strcpy(dataIn, strtok(NULL, ","));
   strcpy(array[countAux].cidadeNascimento, dataIn);

   strcpy(dataIn, strtok(NULL, ","));
   strcpy(array[countAux].estadoNascimento, dataIn);

} //end tratamentoString

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
         strcat(newS, "nao queueInrmado");
         j = strlen(newS);
      }
      newS[j] = s[i];

      j++;
   }

   if (newS[strlen(newS) - 1] == ',')
      strcat(newS, "nao queueInrmado");

   char *sOut = newS;
   return sOut;
}

void showAndTell(Jogador x, int i)
{
   printf("[%d] ## %s ## %d ## %d ## %s ## %s ## %s ## %s ##\n", i, x.nome, x.altura, x.peso,
          x.anoNascimento, x.universidade, x.cidadeNascimento, x.estadoNascimento);

} //showAndTell

void mostrar()
{
   int j = 0;
   Celula *i;
   for (i = primeiro; i != NULL; i = i->prox)
   {
      showAndTell(i->elemento, j);
      j++;
   } //end if
} //end mostrar
void imprimirR(Jogador x)
{
   printf("%s%s\n", "(R) ", x.nome);
} //end imprimirR()
bool FIM(char s[])
{
   bool resp = false;
   if (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M')
   {
      resp = true;
   } //teste de parada
   return resp;
} //fim do FIM
void mostrarRec()
{
   int j = 0;
   Celula *i;
   for (i = primeiro; i != NULL; i = i->prox)
   {
      showAndTell(i->elemento, j);
      j++;
   }
}