// -----------define-----------
#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <err.h>

#define MAXTAM 150
#define bool short
#define true 1
#define false 0
#define cleanBuffer while (getchar() != '\n')

using namespace std;

// -----------classe-----------
class Jogador
{
private:
    int id = 0;
    string nome = "";
    int altura = 0;
    int peso = 0;
    string universidade = "";
    string anoNascimento = "";
    string cidadeNascimento = "";
    string estadoNascimento = "";

public:
    Jogador()
    {
        id = 0;
        nome = "";
        altura = 0;
        peso = 0;
        universidade = "";
        anoNascimento = "";
        cidadeNascimento = "";
        estadoNascimento = "";
    }

    ~Jogador()
    {
    }

    // set
    void setId(int Id)
    {
        id = Id;
    }

    void setnome(string nome)
    {
        nome = nome;
    }

    void setAltura(int Altura)
    {
        altura = Altura;
    }

    void setPeso(int Peso)
    {
        peso = Peso;
    }

    void setUniversidade(string Universidade)
    {
        universidade = Universidade;
    }

    void setAnoNascimento(string AnoNascimento)
    {
        anoNascimento = AnoNascimento;
    }

    void setCidadeNascimento(string CidadeNascimento)
    {
        cidadeNascimento = CidadeNascimento;
    }

    void setEstadoNascimento(string EstadoNascimento)
    {
        estadoNascimento = EstadoNascimento;
    }

    // get
    int getId()
    {
        return id;
    }

    string getNome()
    {
        return nome;
    }

    int getAltura()
    {
        return altura;
    }

    int getPeso()
    {
        return peso;
    }

    string getUniversidade()
    {
        return universidade;
    }

    string getAnoNascimento()
    {
        return anoNascimento;
    }

    string getCidadeNascimento()
    {
        return cidadeNascimento;
    }

    string getEstadoNascimento()
    {
        return estadoNascimento;
    }
    void imprimir()
    {
        cout << "## ";
        cout << getNome();
        cout << " ## ";
        cout << getAltura();
        cout << " ## ";
        cout << getPeso();
        cout << " ## ";
        cout << getAnoNascimento();
        cout << " ## ";
        cout << getUniversidade();
        cout << " ## ";
        cout << getCidadeNascimento();
        cout << " ## ";
        string tmp = getEstadoNascimento();
        cout << tmp << " ##\n";
        // cleanBuffer;
    }

    string ReplaceAll(std::string str, const std::string &from, const std::string &to)
    {
        size_t start_pos = 0;
        while ((start_pos = str.find(from, start_pos)) != std::string::npos)
        {
            str.replace(start_pos, from.length(), to);
            start_pos += to.length(); // Handles case where 'to' is a substring of 'from'
        }
        return str;
    }

    void tratamento(string s)
    {
        string nova = ReplaceAll(s, ",,", ",nao informado,");
        int aux = s.length();
        if (s.at(aux - 1) == ',')
        {
            nova += "nao informado";
        }
        // --------------------
        string delimiter = ",";
        string Id = nova.substr(0, nova.find(delimiter));
        nova.erase(0, nova.find(delimiter) + delimiter.length());
        string nome = nova.substr(0, nova.find(delimiter));
        nova.erase(0, nova.find(delimiter) + delimiter.length());
        string Altura = nova.substr(0, nova.find(delimiter));
        nova.erase(0, nova.find(delimiter) + delimiter.length());
        string Peso = nova.substr(0, nova.find(delimiter));
        nova.erase(0, nova.find(delimiter) + delimiter.length());
        string Universidade = nova.substr(0, nova.find(delimiter));
        nova.erase(0, nova.find(delimiter) + delimiter.length());
        string anoDeNascimento = nova.substr(0, nova.find(delimiter));
        nova.erase(0, nova.find(delimiter) + delimiter.length());
        string cidadeDeNascimento = nova.substr(0, nova.find(delimiter));
        nova.erase(0, nova.find(delimiter) + delimiter.length());
        string estadoDeNascimento = nova.substr(0, nova.find("\n"));
        if (estadoDeNascimento == "")
        {
            estadoDeNascimento += "nao informado";
        }

        setId(stoi(Id));
        setnome(nome);
        setAltura(stoi(Altura));
        setPeso(stoi(Peso));
        setUniversidade(Universidade);
        setAnoNascimento(anoDeNascimento);
        setCidadeNascimento(cidadeDeNascimento);
        setEstadoNascimento(estadoDeNascimento);
    }
    void ler(string id)
    {
        string s = "";
        char sc[300];
        string delimiter = ",";
        string saux = "";
        FILE *arq;
        if ((arq = fopen("/tmp/players.csv", "r")) == NULL)
        {
            printf("Erro ao abrir o arquivo\n");
            abort();
        }
        bool flag = false;
        fgets(sc, 300, arq);
        s = sc;
        while (!feof(arq) && flag == false)
        {
            saux = s.substr(0, s.find(delimiter));
            if (saux == id)
            {
                flag = true;
                tratamento(s);
            }
            fgets(sc, 300, arq);
            s = sc;
        }
    }
};
// -----------No--------------
class No
{
public:
    int elemento; // Conteudo do no.
    No *esq;
    No *dir; // Filhos da esq e dir.
    int nivel; //Numero de niveis abaixo do no

    /**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
    No(int elemento)
    {
        this->elemento, NULL, NULL, 1;
    }

    /**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No da esquerda.
	 * @param dir No da direita.
	 */
    No(int elemento, No *esq, No *dir, int nivel)
    {
        this->elemento = elemento;
        this->esq = esq;
        this->dir = dir;
        this->nivel = nivel;
    }

    /**
	 * Cálculo do número de níveis a partir de um vértice
	 */
    void setNivel()
    {
        this->nivel = 1 + max(getNivel(esq), getNivel(dir));
    }

    /**
	 * Retorna o número de níveis a partir de um vértice 
	 * @param no nó que se deseja o nível.
	 */
    int getNivel(No &no)
    {
        return (no.nivel == NULL) ? 0 : no.nivel;
    }
};

// -----------Arvore-----------
/**
 * Arvore binaria de pesquisa
 * @author Max do Val Machado
 */
class AVL
{
private:
    No raiz; // Raiz da arvore.

    /**
	 * Construtor da classe.
	 */
public:
    AVL()
    {
        raiz = NULL;
    }

    /**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param x Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
    bool pesquisar(int x)
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
    bool pesquisar(int x, No *i)
    {
        bool resp;
        if (*i == NULL)
        {
            resp = false;
        }
        else if (x == i.elemento)
        {
            resp = true;
        }
        else if (x < i.elemento)
        {
            resp = pesquisar(x, i.esq);
        }
        else
        {
            resp = pesquisar(x, i.dir);
        }
        return resp;
    }

    /**
	 * Metodo publico iterativo para exibir elementos.
	 */
    void mostrarCentral()
    {
        System.out.print("[ ");
        mostrarCentral(raiz);
        System.out.println("]");
    }

    /**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
    void mostrarCentral(No i)
    {
        if (i != NULL)
        {
            mostrarCentral(i.esq);              // Elementos da esquerda.
            System.out.print(i.elemento + " "); // Conteudo do no.
            mostrarCentral(i.dir);              // Elementos da direita.
        }
    }

    /**
	 * Metodo publico iterativo para exibir elementos.
	 */
    void mostrarPre()
    {
        System.out.print("[ ");
        mostrarPre(raiz);
        System.out.println("]");
    }

    /**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
    void mostrarPre(No i)
    {
        if (i != NULL)
        {
            System.out.print(i.elemento + "(fator " + (No.getNivel(i.dir) - No.getNivel(i.esq)) + ") "); // Conteudo do no.
            mostrarPre(i.esq);                                                                           // Elementos da esquerda.
            mostrarPre(i.dir);                                                                           // Elementos da direita.
        }
    }

    /**
	 * Metodo publico iterativo para exibir elementos.
	 */
    void mostrarPos()
    {
        System.out.print("[ ");
        mostrarPos(raiz);
        System.out.println("]");
    }

    /**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
    void mostrarPos(No i)
    {
        if (i != NULL)
        {
            mostrarPos(i.esq);                  // Elementos da esquerda.
            mostrarPos(i.dir);                  // Elementos da direita.
            System.out.print(i.elemento + " "); // Conteudo do no.
        }
    }

    /**
	 * Metodo publico iterativo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @throws Exception Se o elemento existir.
	 */
    void inserir(int x)
    {
        raiz = inserir(x, raiz);
    }

    /**
	 * Metodo privado recursivo para inserir elemento.
	 * @param x Elemento a ser inserido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se o elemento existir.
	 */
    No inserir(int x, No i)
    {
        if (i == NULL)
        {
            i = new No(x);
        }
        else if (x < i.elemento)
        {
            i.esq = inserir(x, i.esq);
        }
        else if (x > i.elemento)
        {
            i.dir = inserir(x, i.dir);
        }
        else
        {
            throw new Exception("Erro ao inserir!");
        }

        return balancear(i);
    }

    /**
	 * Metodo publico iterativo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @throws Exception Se nao encontrar elemento.
	 */
    void remover(int x)
    {
        raiz = remover(x, raiz);
    }

    /**
	 * Metodo privado recursivo para remover elemento.
	 * @param x Elemento a ser removido.
	 * @param i No em analise.
	 * @return No em analise, alterado ou nao.
	 * @throws Exception Se nao encontrar elemento.
	 */
    No remover(int x, No i)
    {

        if (i == NULL)
        {
            throw new Exception("Erro ao remover!");
        }
        else if (x < i.elemento)
        {
            i.esq = remover(x, i.esq);
        }
        else if (x > i.elemento)
        {
            i.dir = remover(x, i.dir);

            // Sem no a direita.
        }
        else if (i.dir == NULL)
        {
            i = i.esq;

            // Sem no a esquerda.
        }
        else if (i.esq == NULL)
        {
            i = i.dir;

            // No a esquerda e no a direita.
        }
        else
        {
            i.esq = antecessor(i, i.esq);
        }

        return balancear(i);
    }

    /**
	 * Metodo para trocar no removido pelo antecessor.
	 * @param i No que teve o elemento removido.
	 * @param j No da subarvore esquerda.
	 * @return No em analise, alterado ou nao.
	 */
    No antecessor(No i, No j)
    {

        // Existe no a direita.
        if (j.dir != NULL)
        {
            // Caminha para direita.
            j.dir = antecessor(i, j.dir);

            // Encontrou o maximo da subarvore esquerda.
        }
        else
        {
            i.elemento = j.elemento; // Substitui i por j.
            j = j.esq;               // Substitui j por j.ESQ.
        }
        return j;
    }

    No balancear(No no)
    {
        if (no != NULL)
        {
            int fator = No.getNivel(no.dir) - no.getNivel(no.esq);

            //Se balanceada
            if (Math.abs(fator) <= 1)
            {
                no.setNivel();

                //Se desbalanceada para a direita
            }
            else if (fator == 2)
            {

                int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);

                //Se o filho a direita tambem estiver desbalanceado
                if (fatorFilhoDir == -1)
                {
                    no.dir = rotacionarDir(no.dir);
                }
                no = rotacionarEsq(no);

                //Se desbalanceada para a esquerda
            }
            else if (fator == -2)
            {

                int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);

                //Se o filho a esquerda tambem estiver desbalanceado
                if (fatorFilhoEsq == 1)
                {
                    no.esq = rotacionarEsq(no.esq);
                }
                no = rotacionarDir(no);
            }
        }

        return no;
    }

    No rotacionarDir(No no)
    {
        System.out.println("Rotacionar DIR(" + no.elemento + ")");
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        no.setNivel();
        noEsq.setNivel();

        return noEsq;
    }

    No rotacionarEsq(No no)
    {
        System.out.println("Rotacionar ESQ(" + no.elemento + ")");
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        no.setNivel();
        noDir.setNivel();
        return noDir;
    }
}

// ----------------main-----------

int main(void)
{
    start();
    string arrayID = "";
    cin >> arrayID;
    while (arrayID != "FIM")
    {
        array[countGlobal].ler(arrayID);
        countGlobal++;
        cin >> arrayID;
    }
    cout << "chegou1\n";
    cout << countGlobal << endl;
    for (int i = 0; i < countGlobal; i++)
    {
        cout << "for: " << i << endl;
        inserir(array[i]);
    }
    cout << "chegou2\n";

    string numOps[1024];
    int count = 0;
    getline(cin, numOps[count]);
    while (numOps[count] != "FIM")
    {
        cout << numOps[count] << endl;
        count++;
        getline(cin, numOps[count]);
    }
    cout << "chegou3\n";

    for (int i = 0; i < count; i++)
    {
        if (pesquisar3(numOps[i]) == false)
        {
            printf(" NAO\n");
        }
        else
        {
            printf(" SIM\n");
        }
    }
    cout << "chegou4\n";
}
