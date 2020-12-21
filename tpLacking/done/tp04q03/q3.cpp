#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

int numQueue = 0;
double addiction = 0;

typedef struct
{
   char nome[100],
       Universidade[100],
       cindadeNascimento[100],
       estadoNascimento[100];

   int id;
   int altura;
   int peso;
   int AnoDeNacimento;
} Jogadores;

typedef struct
{
   Jogadores arrayList[1000];

} Fila;

Jogadores jogadores[1000];
int countGlobal = 0;

typedef struct No
{
   Jogadores elemento;
   int nivel;
   struct No *esq, *dir;
} No;

No *novoNo(Jogadores elemento);

No *novoNo(Jogadores elemento)
{
   No *novo = (No *)malloc(sizeof(No));
   novo->elemento = elemento;
   novo->esq = NULL;
   novo->dir = NULL;
   novo->nivel = 0;
   return novo;
}

No *raiz;

void start()
{
   raiz = NULL;
}

bool pesquisar2(Jogadores x, No *no)
{
   bool aux;
   if (no == NULL)
   {
      aux = false;
   }
   else if (strcmp(x.nome, no->elemento.nome) == 0)
   {

      aux = true;
   }
   else if (strcmp(x.nome, no->elemento.nome) < 0)
   {
      aux = pesquisar2(x, no->esq);
   }
   else
   {
      aux = pesquisar2(x, no->dir);
   }
   return aux;
}

bool pesquisar(Jogadores x)
{
   return pesquisar2(x, raiz);
}

bool pesquisar4(char x[], No *no)
{
   bool aux;
   if (no == NULL)
   {
      aux = false;
   }
   else if (strcmp(x, no->elemento.nome) == 0)
   {

      aux = true;
   }
   else if (strcmp(x, no->elemento.nome) < 0)
   {
      printf(" esq");
      aux = pesquisar4(x, (no->esq));
   }
   else
   {
      printf(" dir");
      aux = pesquisar4(x, (no->dir));
   }
   return aux;
}

bool pesquisar3(char x[])
{
   printf("%s", x);
   printf(" raiz");
   return pesquisar4(x, raiz);
}

/**  ------Nivel-------**/

int getNivel(No *no)
{

   if (no == NULL)
      return 0;
   else
      return no->nivel;
}

int Comparar(int x, int y)
{
   if (x > y)
      return x;
   else
      return y;
}

No *setNivel(No *no)
{
   no->nivel = 1 + Comparar(getNivel(no->esq), getNivel(no->dir));
   return no;
}

/**  ------Rotacionar-------**/

No *rotacionarDir(No *no)
{

   No *noEsq = no->esq;
   No *noEsqDir = noEsq->dir;

   noEsq->dir = no;
   no->esq = noEsqDir;

   setNivel(no);
   setNivel(noEsq);

   return noEsq;
}

No *rotacionarEsq(No *no)
{
   No *noDir = no->dir;
   No *noDirEsq = noDir->esq;

   noDir->esq = no;
   no->dir = noDirEsq;

   setNivel(no);
   setNivel(noDir);

   return noDir;
}

/**  ------Balancear-------**/

No *balancear(No *no)
{

   if (no != NULL)
   {

      int fator = getNivel(no->dir) - getNivel(no->esq);

      if (abs(fator) <= 1)
      {
         no = setNivel(no);
      }
      else if (fator == 2)
      {
         int fatorFilhoDir = getNivel(no->dir->dir) - getNivel(no->dir->esq);

         if (fatorFilhoDir == -1)
         {
            no->dir = rotacionarDir(no->dir);
         }
         no = rotacionarEsq(no);
      }
      else if (fator == -2)
      {

         int fatorFilhoEsq = getNivel(no->esq->dir) - getNivel(no->esq->esq);

         if (fatorFilhoEsq == 1)
         {
            no->esq = rotacionarEsq(no->esq);
         }
         no = rotacionarDir(no);
      }
   }
   return no;
}

void mostrarCentralRec(No *i)
{
   if (i != NULL)
   {
      mostrarCentralRec(i->esq);
      printf("%s ", i->elemento.nome);
      mostrarCentralRec(i->dir);
   }
}

void mostrarCentral()
{
   printf("[ ");
   mostrarCentralRec(raiz);
   printf("]\n");
}

void inserirRec(Jogadores x, No **i)
{
   //printf("\n %s   %s",x.nome , (*i)->elemento.nome);
   if (*i == NULL)
   {
      // printf("AA");
      *i = novoNo(x);
   }
   else if (strcmp(x.nome, (*i)->elemento.nome) < 0)
   {
      inserirRec(x, &((*i)->esq));
   }
   else if (strcmp(x.nome, (*i)->elemento.nome) > 0)
   {
      inserirRec(x, &((*i)->dir));
   }

   *i = balancear((*i));
}

void inserir(Jogadores x)
{
   inserirRec(x, &raiz);
}

bool FIM(char s[])
{
   bool aux = false;
   if (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M')
   {
      aux = true;
   } //teste de parada
   return aux;
} //fim do FIM

void printar(Jogadores jogadores, int i)
{

   printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", i, jogadores.nome, jogadores.altura, jogadores.peso,
          jogadores.AnoDeNacimento, jogadores.Universidade, jogadores.cindadeNascimento, jogadores.estadoNascimento);
}

void sort(char elemento[])
{
   //printf("%s\n",elemento);
   char nome[100],
       Universidade[100],
       cindadeNascimento[100],
       estadoNascimento[100],
       id[100], altura[100],
       peso[100], AnoDeNacimento[100];

   memset(id, 0, sizeof(id));
   memset(nome, 0, sizeof(nome));
   memset(altura, 0, sizeof(altura));
   memset(peso, 0, sizeof(peso));
   memset(Universidade, 0, sizeof(Universidade));
   memset(AnoDeNacimento, 0, sizeof(AnoDeNacimento));
   memset(cindadeNascimento, 0, sizeof(cindadeNascimento));
   memset(estadoNascimento, 0, sizeof(estadoNascimento));

   bool parada = false;
   ;
   int iterator = 0, iterator2 = 0;
   int i = 0;
   for (int j = iterator; j < 1000; j++)
   {

      if (i == 0)
      {
         if (elemento[j] != ',')
         {
            id[iterator2] = elemento[j];
            iterator++;
            iterator2++;
         }
         else
         {
            j++;
            iterator2 = 0;
            i = 1;
         }
      }

      if (i == 1)
      {
         if (elemento[j] != ',')
         {
            nome[iterator2] = elemento[j];
            iterator++;
            iterator2++;
         }
         else
         {
            iterator2 = 0;
            i = 2;
            j++;
         }
      }

      if (i == 2)
      {
         if (elemento[j] != ',')
         {
            altura[iterator2] = elemento[j];
            iterator++;
            iterator2++;
         }
         else
         {
            iterator2 = 0;
            i = 3;
            j++;
         }
      }

      if (i == 3)
      {
         if (elemento[j] != ',')
         {
            peso[iterator2] = elemento[j];
            iterator++;
            iterator2++;
         }
         else
         {
            iterator2 = 0;
            i = 4;
            j++;
         }
      }

      if (i == 4)
      {
         if (elemento[j] != ',')
         {
            Universidade[iterator2] = elemento[j];
            iterator++;
            iterator2++;
         }
         else
         {
            if (elemento[j] == ',' && elemento[j - 1] == ',')
               strcpy(Universidade, "nao informado");
            iterator2 = 0;
            i = 5;
            j++;
         }
      }

      if (i == 5)
      {
         if (elemento[j] != ',')
         {

            AnoDeNacimento[iterator2] = elemento[j];
            iterator++;
            iterator2++;
         }
         else
         {
            iterator2 = 0;
            i = 6;
            j++;
         }
      }

      if (i == 6)
      {
         if (elemento[j] != ',')
         {
            cindadeNascimento[iterator2] = elemento[j];
            iterator++;
            iterator2++;
         }
         else
         {
            if (elemento[j] == ',' && elemento[j - 1] == ',')
               strcpy(cindadeNascimento, "nao informado");
            if (elemento[j + 1] != '\0')
            {
               iterator2 = 0;
               i = 7;
               j++;
            }
            else
            {
               iterator2 = 0;
               i = 7;
               j++;
               strcpy(estadoNascimento, "nao informado");
            }
         }
      }

      if (i == 7)
      {
         if (elemento[j] != '\0')
         {
            estadoNascimento[iterator2] = elemento[j];
            iterator++;
            iterator2++;
         }
         else
         {
            iterator2 = 0;
            j = 1000;
         }
      }
   }

   jogadores[countGlobal].id = atoi(id);
   jogadores[countGlobal].altura = atoi(altura);
   jogadores[countGlobal].peso = atoi(peso);
   jogadores[countGlobal].AnoDeNacimento = atoi(AnoDeNacimento);

   strcpy(jogadores[countGlobal].nome, nome);
   strcpy(jogadores[countGlobal].Universidade, Universidade);
   strcpy(jogadores[countGlobal].cindadeNascimento, cindadeNascimento);
   strcpy(jogadores[countGlobal].estadoNascimento, estadoNascimento);

   memset(id, 0, sizeof(id));
   memset(nome, 0, sizeof(nome));
   memset(altura, 0, sizeof(altura));
   memset(peso, 0, sizeof(peso));
   memset(Universidade, 0, sizeof(Universidade));
   memset(AnoDeNacimento, 0, sizeof(AnoDeNacimento));
   memset(cindadeNascimento, 0, sizeof(cindadeNascimento));
   memset(estadoNascimento, 0, sizeof(estadoNascimento));

}

void READ(int posicao)
{
   char elemento[1000];
   char *aux;
   FILE *arq;
   int iterator = 0;
   bool valido = true;
   arq = fopen("/tmp/players.csv", "r");
   if (arq != NULL)
   {
      char *lixo = fgets(elemento, 1000, arq);
      while (iterator <= posicao)
      {
         aux = fgets(elemento, 1000, arq);
         aux[strlen(aux) - 1] = '\0';
         if (iterator == posicao)
         {
            sort(aux);
         }
         iterator++;
      }
      fclose(arq);
   }
}

int main()
{
   start();
   bool x;
   int maior = 0, arrayID2 = 0, iterator = 0;
   char arrayID[100];
   char entrada[1000], arrayOps[200];
   fgets(entrada, 1000, stdin);
   entrada[strlen(entrada) - 1] = '\0';

   int numOps = 0;

   while (FIM(entrada) != true)
   {
      strcpy(arrayID, entrada);
      arrayID2 = atoi(arrayID);
      READ(arrayID2);
      inserir(jogadores[countGlobal]);
      countGlobal++;
      fgets(entrada, 1000, stdin);
      entrada[strlen(entrada) - 1] = '\0';
      iterator++;
   }
   fgets(entrada, 1000, stdin);
   entrada[strlen(entrada) - 1] = '\0';

   do
   {
      arrayID2 = pesquisar3(entrada);
      if (arrayID2 == false)
      {
         printf(" NAO\n");
      }
      else
      {
         printf(" SIM\n");
      }
      fgets(entrada, 1000, stdin);
      entrada[strlen(entrada) - 1] = '\0';
   } while (FIM(entrada) != true);

   return 0;
}