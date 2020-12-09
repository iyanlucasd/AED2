#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX_TAM 5
#include <stdbool.h>
#include <math.h>

int numeroFila = 0;
double soma = 0;

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
} Jogador;

typedef struct
{
   Jogador jogadorList[1000];

} Fila;

Jogador jogador[1000];
int contG = 0;

typedef struct No
{
   Jogador elemento;
   int nivel;
   struct No *esq, *dir;
} No;

No *novoNo(Jogador elemento);

No *novoNo(Jogador elemento)
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

bool pesquisar2(Jogador x, No *no)
{
   bool resp;
   if (no == NULL)
   {
      resp = false;
   }
   else if (strcmp(x.nome, no->elemento.nome) == 0)
   {

      resp = true;
   }
   else if (strcmp(x.nome, no->elemento.nome) < 0)
   {
      resp = pesquisar2(x, no->esq);
   }
   else
   {
      resp = pesquisar2(x, no->dir);
   }
   return resp;
}

bool pesquisar(Jogador x)
{
   return pesquisar2(x, raiz);
}

bool pesquisar4(char x[], No *no)
{
   bool resp;
   if (no == NULL)
   {
      resp = false;
   }
   else if (strcmp(x, no->elemento.nome) == 0)
   {

      resp = true;
   }
   else if (strcmp(x, no->elemento.nome) < 0)
   {
      printf(" esq");
      resp = pesquisar4(x, (no->esq));
   }
   else
   {
      printf(" dir");
      resp = pesquisar4(x, (no->dir));
   }
   return resp;
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

void inserirRec(Jogador x, No **i)
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

void inserir(Jogador x)
{
   inserirRec(x, &raiz);
}

/**quando encontrar a palavra FIM vai encerrar o programa**/

bool isFim(char s[])
{
   bool resp = false;
   if (strlen(s) >= 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M')
   {
      resp = true;
   } //teste de parada
   return resp;
} //fim do isFim

void printar(Jogador jogador, int i)
{

   printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", i, jogador.nome, jogador.altura, jogador.peso,
          jogador.AnoDeNacimento, jogador.Universidade, jogador.cindadeNascimento, jogador.estadoNascimento);
}

void organizar(char conteudo[])
{
   //printf("%s\n",conteudo);
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
   int cont = 0, cont2 = 0;
   int i = 0;
   for (int j = cont; j < 1000; j++)
   {

      if (i == 0)
      {
         if (conteudo[j] != ',')
         {
            id[cont2] = conteudo[j];
            cont++;
            cont2++;
         }
         else
         {
            j++;
            cont2 = 0;
            i = 1;
         }
      }

      if (i == 1)
      {
         if (conteudo[j] != ',')
         {
            nome[cont2] = conteudo[j];
            cont++;
            cont2++;
         }
         else
         {
            cont2 = 0;
            i = 2;
            j++;
         }
      }

      if (i == 2)
      {
         if (conteudo[j] != ',')
         {
            altura[cont2] = conteudo[j];
            cont++;
            cont2++;
         }
         else
         {
            cont2 = 0;
            i = 3;
            j++;
         }
      }

      if (i == 3)
      {
         if (conteudo[j] != ',')
         {
            peso[cont2] = conteudo[j];
            cont++;
            cont2++;
         }
         else
         {
            cont2 = 0;
            i = 4;
            j++;
         }
      }

      if (i == 4)
      {
         if (conteudo[j] != ',')
         {
            Universidade[cont2] = conteudo[j];
            cont++;
            cont2++;
         }
         else
         {
            if (conteudo[j] == ',' && conteudo[j - 1] == ',')
               strcpy(Universidade, "nao informado");
            cont2 = 0;
            i = 5;
            j++;
         }
      }

      if (i == 5)
      {
         if (conteudo[j] != ',')
         {

            AnoDeNacimento[cont2] = conteudo[j];
            cont++;
            cont2++;
         }
         else
         {
            cont2 = 0;
            i = 6;
            j++;
         }
      }

      if (i == 6)
      {
         if (conteudo[j] != ',')
         {
            cindadeNascimento[cont2] = conteudo[j];
            cont++;
            cont2++;
         }
         else
         {
            if (conteudo[j] == ',' && conteudo[j - 1] == ',')
               strcpy(cindadeNascimento, "nao informado");
            if (conteudo[j + 1] != '\0')
            {
               cont2 = 0;
               i = 7;
               j++;
            }
            else
            {
               cont2 = 0;
               i = 7;
               j++;
               strcpy(estadoNascimento, "nao informado");
            }
         }
      }

      if (i == 7)
      {
         if (conteudo[j] != '\0')
         {
            estadoNascimento[cont2] = conteudo[j];
            cont++;
            cont2++;
         }
         else
         {
            cont2 = 0;
            j = 1000;
         }
      }
   }

   jogador[contG].id = atoi(id);
   jogador[contG].altura = atoi(altura);
   jogador[contG].peso = atoi(peso);
   jogador[contG].AnoDeNacimento = atoi(AnoDeNacimento);

   strcpy(jogador[contG].nome, nome);
   strcpy(jogador[contG].Universidade, Universidade);
   strcpy(jogador[contG].cindadeNascimento, cindadeNascimento);
   strcpy(jogador[contG].estadoNascimento, estadoNascimento);

   memset(id, 0, sizeof(id));
   memset(nome, 0, sizeof(nome));
   memset(altura, 0, sizeof(altura));
   memset(peso, 0, sizeof(peso));
   memset(Universidade, 0, sizeof(Universidade));
   memset(AnoDeNacimento, 0, sizeof(AnoDeNacimento));
   memset(cindadeNascimento, 0, sizeof(cindadeNascimento));
   memset(estadoNascimento, 0, sizeof(estadoNascimento));

   //printar(jogador[contG]);
}

void LerArquivo(int posicao)
{
   //printf("AA\n");
   //printf("%d\n",posicao);
   char conteudo[1000];
   char *conteudo2;
   FILE *arq;
   int cont = 0;
   bool valido = true;
   //printf("%d\n",cont);
   arq = fopen("/tmp/players.csv", "r");
   if (arq != NULL)
   {
      char *lixo = fgets(conteudo, 1000, arq);
      while (cont <= posicao)
      {
         conteudo2 = fgets(conteudo, 1000, arq);
         conteudo2[strlen(conteudo2) - 1] = '\0';
         if (cont == posicao)
         {
            organizar(conteudo2);
         }
         cont++;
      }
      fclose(arq);
   }
}

int main()
{
   //Jogador *jogador= (Jogador*) malloc(sizeof(jogador));
   start();
   bool x;
   int maior = 0, temp2 = 0, cont = 0;
   char temp[100];
   char entrada[1000], entrada2[200];
   fgets(entrada, 1000, stdin);
   entrada[strlen(entrada) - 1] = '\0';

   int numero = 0;

   while (isFim(entrada) != true)
   {
      strcpy(temp, entrada);
      temp2 = atoi(temp);

      LerArquivo(temp2);

      inserir(jogador[contG]);
      contG++;
      fgets(entrada, 1000, stdin);
      entrada[strlen(entrada) - 1] = '\0';
      cont++;
   }

   fgets(entrada, 1000, stdin);
   entrada[strlen(entrada) - 1] = '\0';

   do
   {

      temp2 = pesquisar3(entrada);

      if (temp2 == false)
      {
         printf(" NAO\n");
      }
      else
      {
         printf(" SIM\n");
      }

      fgets(entrada, 1000, stdin);
      entrada[strlen(entrada) - 1] = '\0';
   } while (isFim(entrada) != true);

   return 0;
}
