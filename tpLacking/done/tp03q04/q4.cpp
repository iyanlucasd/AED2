#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <locale.h>
#include <math.h>

#define bool short
#define true 1
#define false 0

int primeiro;
int ultimo;
int numeroFila = 0;
int countGlobally = 0;
double soma = 0;

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
   Jogador players[5 + 1]; // Elementos da pilha
   /* data */
} Fila;

/****************************/

void READ(char arrayID[]);
char *replace(char *s);
void show();
void CLEAN(char ent_dados[]);

/***************************/
void start();
Fila inserir(Jogador x, Fila fila);
Fila remover(Fila fila);
void show(Jogador x, int i);
void andTell();
void showR(Jogador x);

/***************************/

int countGlobal = 0;
Jogador p;
Fila fila;

int main(int argc, char *argv[])
{
   start();
   char arrayID[100];
   
   scanf("%s", arrayID);
   while (strcmp(arrayID, "FIM") != 0)
   {
      READ(arrayID);
      fila = inserir(p, fila);
      scanf("%s", arrayID);
   } 

   int count = 0;
   int qtdArquivo = 0;
   char *arrayOps;

   scanf("%d", &qtdArquivo);
   while (count < qtdArquivo)
   {

      scanf(" %[^\n]s", arrayID);
      if (arrayID[0] == 'I')
      {
         arrayOps = strtok(arrayID, " ");
         arrayOps = strtok(NULL, " ");
         READ(arrayOps);
         fila = inserir(p, fila);
      } 
      if (arrayID[0] == 'R')
      {
         fila = remover(fila);
      } 
      count++;
   } 
   andTell();
} 

void start()
{

   ultimo = primeiro = 0;

} //end start

Fila inserir(Jogador x, Fila fila)
{
   Jogador temp[5];

   if (numeroFila >= 5)
   {
      temp[0] = fila.players[0];
      soma = soma - temp[0].altura;
      numeroFila--;
      for (int i = 0; i < numeroFila; i++)
      {
         fila.players[i] = fila.players[i + 1];
      }
   }
   fila.players[numeroFila] = x;
   numeroFila++;
   double media = 0;
   soma = soma + x.altura;
   media = soma / numeroFila;
   round(media);
   printf("%.0f\n", media);
   return fila;
}

Fila remover(Fila fila)
{

   Jogador temp[5];
   if (numeroFila == 0)
   {
      printf("Erro ao remover ( Fila vazia )!");
   }
   else
   {

      temp[0] = fila.players[0];
      soma = soma - temp[0].altura;
      showR(temp[0]);
      numeroFila--;
      for (int i = 0; i < numeroFila; i++)
      {
         fila.players[i] = fila.players[i + 1];
      }
   }
   return fila;
} //end remover

void READ(char arrayID[])
{

   char ent_dados[1000];
   char *sep;
   char *separar;
   FILE *jogador = fopen("/tmp/players.csv", "r");

   //fgets(ent_dados,1000,jogador);

   do
   {

      fgets(ent_dados, 1000, jogador);

      strcpy(ent_dados, replace(ent_dados));

      separar = strdup(ent_dados);

      sep = strsep(&separar, ",");

      if (strcmp(sep, arrayID) == 0)
      {
         CLEAN(ent_dados);
      }

   } while (!feof(jogador) && strcmp(sep, arrayID) != 0);

   fclose(jogador);

} //end READ

void CLEAN(char ent_dados[])
{

   strcpy(ent_dados, strtok(ent_dados, ","));
   p.id = atoi(ent_dados);

   strcpy(ent_dados, strtok(NULL, ","));
   strcpy(p.nome, ent_dados);

   strcpy(ent_dados, strtok(NULL, ","));
   p.altura = atoi(ent_dados);

   strcpy(ent_dados, strtok(NULL, ","));
   p.peso = atoi(ent_dados);

   strcpy(ent_dados, strtok(NULL, ","));
   strcpy(p.anoNascimento, ent_dados);

   strcpy(ent_dados, strtok(NULL, ","));
   strcpy(p.universidade, ent_dados);

   strcpy(ent_dados, strtok(NULL, ","));
   strcpy(p.cidadeNascimento, ent_dados);

   strcpy(ent_dados, strtok(NULL, ","));
   strcpy(p.estadoNascimento, ent_dados);

} //end CLEAN

char *replace(char s[])
{
   char nova[300] = "";
   int j = 0;
   int ult = strlen(s);

   for (int i = 0; i < strlen(s) - 1; i++)
   {

      if (s[i] == ',' && s[i - 1] == ',')
      {
         setbuf(stdin, NULL);
         strcat(nova, "nao informado");
         j = strlen(nova);
      }
      nova[j] = s[i];

      j++;
   }

   if (nova[strlen(nova) - 1] == ',')
      strcat(nova, "nao informado");

   char *saida = nova;
   return saida;
}

void show(Jogador x, int i)
{
   printf("[%d] ## %s ## %d ## %d ## %s ## %s ## %s ## %s ##\n", i, x.nome, x.altura, x.peso,
          x.anoNascimento, x.universidade, x.cidadeNascimento, x.estadoNascimento);

} //show

void andTell()
{
   for (int i = 0; i < numeroFila; i++)
   {
      show(fila.players[i], i);
   }
}
void showR(Jogador x)
{
   printf("%s%s\n", "(R) ", x.nome);
}