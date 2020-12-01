#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAXTAM 5
#include <stdbool.h>
#include <math.h>

int numeroFila = 0;
double soma = 0;

int countPly = 0;

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
   Jogador arrayJogador[1000];
   /* data */
} Fila;

Jogador arrayJogador[1000];
int countGlobal = 0;

typedef struct Celula
{
   Jogador elemento;    // Elemento inserido na celula.
   struct Celula *prox; // Aponta a celula prox.
   struct Celula *ant;  // Aponta a celula anterior.
} CelulaDupla;

Celula *novaCelula(Jogador elemento)
{
   Celula *nova = (Celula *)malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->ant = nova->prox = NULL;
   return nova;
}

//LISTA PROPRIAMENTE DITA
Celula *primeiro;
Celula *lastimo;

/****************************/

void readJogador(char PK[]);
char *replace(char *s);
void imprimir();
void tratamentoString(char inDados[]);

void start(Jogador temporary);
void inserir(Jogador x);
void remover();
void imprimir(Jogador x, int i);
void mostrar();
void imprimirR(Jogador x);
bool isFim(char s[]);

int countP = 0;
Jogador p;

int main(int argc, char *argv[])
{

   start(arrayJogador[0]);
   bool x;
   int maior = 0, tmp2 = 0, cont = 0;
   char tmp[100];
   char stdIn[1000], stdIn2[200];

   fgets(stdIn, 1000, stdin);
   stdIn[strlen(stdIn) - 1] = '\0';

   int numero = 0;
   while (isFim(stdIn) != true)
   {
      strcpy(tmp, stdIn);
      readJogador(tmp);
      inserir(arrayJogador[countGlobal]);
      countGlobal++;
      fgets(stdIn, 1000, stdin);
      stdIn[strlen(stdIn) - 1] = '\0';
      cont++;
   }

   cont = 0;
   int cont2 = 0;
   char arrayJogadorChar[1000];
   int actions;
   scanf("%d\n", &actions);
   char letras[10], id[10], posicao[10];

   for (int i = 0; i < actions + 1; i++)
   {
      fgets(arrayJogadorChar, 1000, stdin);
      arrayJogadorChar[strlen(arrayJogadorChar) - 1] = '\0';

      for (int j = 0; j < strlen(arrayJogadorChar); j++)
      {

         // INCERIR
         if (arrayJogadorChar[0] == 'I')
         {
            if (cont == 0)
            {
               if (arrayJogadorChar[j] != ' ')
               {
                  letras[cont2] = arrayJogadorChar[j];
                  cont2++;
               }
               else if (arrayJogadorChar[0] == 'I')
               {
                  cont++;
                  cont2 = 0;
               }
            }
            else if (cont == 1)
            {
               id[cont2] = arrayJogadorChar[j];
               cont2++;
            }
         }

         // REMOVER

         if (arrayJogadorChar[0] == 'R')
         {
            remover();
         }
      }

      tmp2 = atoi(id);
      readJogador(id);
      memset(id, 0, sizeof(id));
      cont = 0, cont2 = 0;

      if (arrayJogadorChar[0] == 'I')
         inserir(arrayJogador[countGlobal]);
   }
   mostrar();

   return 0;
} //end main

void start(Jogador temporary)
{
   primeiro = novaCelula(temporary);
   lastimo = primeiro;

} //end start

void inserir(Jogador x)
{

   if (numeroFila >= MAXTAM)
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

   lastimo->prox = novaCelula(x);
   lastimo->prox->ant = lastimo;
   lastimo = lastimo->prox;

   numeroFila++;
   double media = 0;
   soma = soma + x.altura;
   media = soma / numeroFila;

   int tmp2 = 0;
   tmp2 = round(media);

   printf("%d\n", tmp2);
}

void remover()
{

   if (primeiro == lastimo)
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
}

void readJogador(char PK[])
{

   char inDados[1000];
   char *sep;
   char *split;
   FILE *jogador = fopen("arrayJogador.csv", "r");

   //fgets(inDados,1000,jogador);

   do
   {

      fgets(inDados, 1000, jogador);

      strcpy(inDados, replace(inDados));

      split = strdup(inDados);

      sep = strsep(&split, ",");

      if (strcmp(sep, PK) == 0)
      {
         tratamentoString(inDados);
      }
   } while (!feof(jogador) && strcmp(sep, PK) != 0);
   fclose(jogador);
}

void tratamentoString(char inDados[])
{

   strcpy(inDados, strtok(inDados, ","));
   arrayJogador[countGlobal].id = atoi(inDados);

   strcpy(inDados, strtok(NULL, ","));
   strcpy(arrayJogador[countGlobal].nome, inDados);

   strcpy(inDados, strtok(NULL, ","));
   arrayJogador[countGlobal].altura = atoi(inDados);

   strcpy(inDados, strtok(NULL, ","));
   arrayJogador[countGlobal].peso = atoi(inDados);

   strcpy(inDados, strtok(NULL, ","));
   strcpy(arrayJogador[countGlobal].anoNascimento, inDados);

   strcpy(inDados, strtok(NULL, ","));
   strcpy(arrayJogador[countGlobal].universidade, inDados);

   strcpy(inDados, strtok(NULL, ","));
   strcpy(arrayJogador[countGlobal].cidadeNascimento, inDados);

   strcpy(inDados, strtok(NULL, ","));
   strcpy(arrayJogador[countGlobal].estadoNascimento, inDados);

} //end tratamentoString

char *replace(char s[])
{
   char nova[300] = "";
   int j = 0;
   int last = strlen(s);

   for (int i = 0; i < strlen(s) - 1; i++)
   {

      if (s[i] == ',' && s[i - 1] == ',')
      {
         setbuf(stdin, NULL);
         strcat(nova, "nao arrayJogadorCharrmado");
         j = strlen(nova);
      }
      nova[j] = s[i];

      j++;
   }

   if (nova[strlen(nova) - 1] == ',')
      strcat(nova, "nao arrayJogadorCharrmado");

   char *saida = nova;
   return saida;
}

void imprimir(Jogador x, int i)
{
   printf("[%d] ## %s ## %d ## %d ## %s ## %s ## %s ## %s ##\n", i, x.nome, x.altura, x.peso,
          x.anoNascimento, x.universidade, x.cidadeNascimento, x.estadoNascimento);

} //imprimir

void mostrar()
{
   int j = 0;
   Celula *i;
   for (i = primeiro; i != NULL; i = i->prox)
   {
      imprimir(i->elemento, j);
      j++;
   }
}
void imprimirR(Jogador x)
{
   printf("%s%s\n", "(R) ", x.nome);
}
bool isFim(char s[])
{
   bool resp = false;
   if (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M')
   {
      resp = true;
   }
   return resp;
}
void mostrarRec()
{
   int j = 0;
   Celula *i;
   for (i = primeiro; i != NULL; i = i->prox)
   {
      imprimir(i->elemento, j);
      j++;
   }
}