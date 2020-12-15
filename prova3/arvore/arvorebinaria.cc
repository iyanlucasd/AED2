#include <err.h>
#include <iostream>
/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */

using namespace std;

class No
{
public:
   int elemento;  // Conteudo do no.
   No *esq, *dir; // Filhos da esq e dir.
   No(int elemento)
   {
      this->elemento = elemento;
   }
};

class ArvoreBinaria
{
private:
   No *raiz; // Raiz da arvore.
   bool pesquisar(int, No *);
   void caminharCentral(No *);
   void caminharPre(No *);
   void caminharPos(No *);
   void inserir(int, No *&);
   void remover(int, No *&);
   void antecessor(No *, No *&);
   void caminharPorNivel(No *i, int level);

public:
   ArvoreBinaria();
   bool pesquisar(int);
   void caminharCentral();
   void caminharPre();
   void caminharPos();
   void inserir(int);
   void remover(int);
   void printLevelOrder();
   int getAltura(No *node);
};

/**
 * Construtor da classe.
 */
ArvoreBinaria::ArvoreBinaria()
{
   raiz = NULL;
}

/**
 * Metodo publico iterativo para pesquisar elemento.
 * @param x Elemento que sera procurado.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool ArvoreBinaria::pesquisar(int x)
{
   return pesquisar(x, raiz);
}

/**
 * Metodo privado recursivo para pesquisar elemento.
 * @param x Elemento que sera procurado.
 * @param i No em analise.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool ArvoreBinaria::pesquisar(int x, No *i)
{
   bool resp;
   if (i == NULL)
   {
      resp = false;
   }
   else if (x == i->elemento)
   {
      resp = true;
   }
   else if (x < i->elemento)
   {
      resp = pesquisar(x, i->esq);
   }
   else
   {
      resp = pesquisar(x, i->dir);
   }
   return resp;
}

/**
 * Metodo publico iterativo para exibir elementos.
 */
void ArvoreBinaria::caminharCentral()
{
   cout << "[ ";
   caminharCentral(raiz);
   cout << "]\n";
}

/**
 * Metodo privado recursivo para exibir elementos.
 * @param i No em analise.
 */
void ArvoreBinaria::caminharCentral(No *i)
{
   if (i != NULL)
   {
      caminharCentral(i->esq);    // Elementos da esquerda.
      cout << i->elemento << " "; // Conteudo do no.
      caminharCentral(i->dir);    // Elementos da direita.
   }
}

/**
 * Metodo publico iterativo para exibir elementos.
 */
void ArvoreBinaria::caminharPre()
{
   cout << "[ ";
   caminharPre(raiz);
   cout << "]\n";
}

/**
 * Metodo privado recursivo para exibir elementos.
 * @param i No em analise.
 */
void ArvoreBinaria::caminharPre(No *i)
{
   if (i != NULL)
   {
      cout << i->elemento << " "; // Conteudo do no.
      caminharPre(i->esq);        // Elementos da esquerda.
      caminharPre(i->dir);        // Elementos da direita.
   }
}

/**
 * Metodo publico iterativo para exibir elementos.
 */
void ArvoreBinaria::caminharPos()
{
   cout << "[ ";
   caminharPos(raiz);
   cout << "]\n";
}

/**
 * Metodo privado recursivo para exibir elementos.
 * @param i No em analise.
 */
void ArvoreBinaria::caminharPos(No *i)
{
   if (i != NULL)
   {
      caminharPos(i->esq);        // Elementos da esquerda.
      caminharPos(i->dir);        // Elementos da direita.
      cout << i->elemento << " "; // Conteudo do no.
   }
}

/**
 * Metodo publico iterativo para inserir elemento.
 * @param x Elemento a ser inserido.
 */
void ArvoreBinaria::inserir(int x)
{
   inserir(x, raiz);
}

/**
 * Metodo privado recursivo para inserir elemento.
 * @param x Elemento a ser inserido.
 * @param i No em analise.
 */
void ArvoreBinaria::inserir(int x, No *&i)
{
   if (i == NULL)
   {
      i = new No(x);
   }
   else if (x < i->elemento)
   {
      inserir(x, i->esq);
   }
   else if (x > i->elemento)
   {
      inserir(x, i->dir);
   }
   else
   {
      errx(1, "Erro ao inserir!");
   }
}

/**
    * Metodo publico iterativo para remover elemento.
    * @param x Elemento a ser removido.
 */
void ArvoreBinaria::remover(int x)
{
   remover(x, raiz);
}

/**
 * Metodo privado recursivo para remover elemento.
 * @param x Elemento a ser removido.
 * @param i No em analise.
 */
void ArvoreBinaria::remover(int x, No *&i)
{
   if (i == NULL)
   {
      errx(1, "Erro ao remover!");
   }
   else if (x < i->elemento)
   {
      remover(x, i->esq);
   }
   else if (x > i->elemento)
   {
      remover(x, i->dir);

      // Sem no a direita.
   }
   else if (i->dir == NULL)
   {
      No *del = i;
      i = i->esq;
      delete del;

      // Sem no a esquerda.
   }
   else if (i->esq == NULL)
   {
      No *del = i;
      i = i->dir;
      delete del;

      // No a esquerda e no a direita.
   }
   else
   {
      antecessor(i, i->esq);
   }
}

/**
 * Metodo para trocar no removido pelo antecessor.
 * @param i No que teve o elemento removido.
 * @param j No da subarvore esquerda.
 */
void ArvoreBinaria::antecessor(No *i, No *&j)
{
   // Existe no a direita.
   if (j->dir != NULL)
   {
      antecessor(i, j->dir); // Caminha para direita.

      // Encontrou o maximo da subarvore esquerda.
   }
   else
   {
      No *del = j;
      i->elemento = j->elemento; // Substitui i por j.
      j = j->esq;                // Substitui j por j.ESQ.
      delete del;
   }
}

int ArvoreBinaria::getAltura(No *node)
{
   if (node == NULL)
      return 0;
   else
   {
      /* compute the depth of each subtree */
      int nivelEsq = getAltura(node->esq);
      int nivelDir = getAltura(node->dir);

      /* use the larger one */
      if (nivelEsq > nivelDir)
         return (nivelEsq + 1);
      else
         return (nivelDir + 1);
   }
}

void ArvoreBinaria::printLevelOrder()
{
   int h = getAltura(raiz);
   int i;
   for (i = 1; i <= h; i++)
   {
      caminharPorNivel(raiz, i);
   }
   cout << endl;
}

void ArvoreBinaria::caminharPorNivel(No *i, int level)
{
   if (i == NULL)
      return;
   if (level == 1)
      printf("%d ", i->elemento);
   else if (level > 1)
   {
      caminharPorNivel(i->esq, level - 1);
      caminharPorNivel(i->dir, level - 1);
   }
}

int main(void)
{
   int numTestes = 0;
   int insertsArvore = 0;
   cin >> numTestes;

   for (int i = 0; i < numTestes; i++)
   {
      ArvoreBinaria *arvoreBinaria = new ArvoreBinaria();
      cin >> insertsArvore;
      int array[insertsArvore];
      cout << "case " << i+1 << ":"<< endl;
      for (int i = 0; i < insertsArvore; i++)
      {
         cin >> array[i];
         // cout << array[i] << endl;
      }
      for (int i = 0; i < insertsArvore; i++)
      {
         arvoreBinaria->inserir(array[i]);
      }
      arvoreBinaria->printLevelOrder();
      cout << endl;
   }
}
