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

    void setNome(string Nome)
    {
        nome = Nome;
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
        string Nome = nova.substr(0, nova.find(delimiter));
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
        setNome(Nome);
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

// -----------lista-----------

//TIPO CELULA ===================================================================
typedef struct Celula {
	Jogador elemento;        // Elemento inserido na celula.
	struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(Jogador elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova->elemento = elemento;
   nova->prox = NULL;
   return nova;
}

//FILA PROPRIAMENTE DITA ========================================================
Celula* primeiro;
Celula* ultimo;


/**
 * Cria uma fila sem elementos (somente no cabeca).
 */
void start () {
   primeiro = novaCelula(array[0]);
   ultimo = primeiro;
}


/**
 * Insere elemento na fila (politica FIFO).
 * @param x int Elemento a inserir.
 */
void inserir(Jogador x) {
   ultimo->prox = novaCelula(x);
   ultimo = ultimo->prox;
}


/**
 * Remove elemento da fila (politica FIFO).
 * @return Elemento removido.
 */
Jogador remover() {
   if (primeiro == ultimo) {
      errx(1, "Erro ao remover!");
   }
   Celula* tmp = primeiro;
   primeiro = primeiro->prox;
   Jogador resp = primeiro->elemento;
   tmp->prox = NULL;
   free(tmp);
   tmp = NULL;
   return resp;
}


/**
 * Mostra os elementos separados por espacos.
 */
void mostrar() {
   Celula* i;
   printf("[ ");
   for (i = primeiro; i != NULL; i = i->prox) {
      i->elemento.imprimir();
   }
   printf("] \n");
}

// -----------tratamento-----------
static Jogador array[1024];
static int countGlobal = 0;

Jogador pesquisar(string key)
{
    array[countGlobal].ler(key);
    countGlobal++;
    return array[countGlobal - 1];
}

void tratamentoOps(string arrayOps)
{
    string delimiter = " ";
    string op = arrayOps.substr(0, arrayOps.find(delimiter));
    arrayOps.erase(0, arrayOps.find(delimiter) + delimiter.length());
    if (op.at(1) == '*')
    {
        if (op.at(0) == 'I')
        {
            string tmp = arrayOps.substr(0, arrayOps.find(delimiter));
            arrayOps.erase(0, arrayOps.find(delimiter) + delimiter.length());
            string key = arrayOps.substr(0, arrayOps.find(delimiter));
            int pos = stoi(tmp);
            inserir(pesquisar(key), pos);
        }
        else
        {
            // cout << arrayOps << "\n";
            string tmp = arrayOps.substr(0, arrayOps.find(delimiter));
            arrayOps.erase(0, arrayOps.find(delimiter) + delimiter.length());
            // cout << "chegou " << tmp << "\n";
            int pos = stoi(tmp);
            cout << "(R) " << remover(pos).getNome() << "\n";
        }
    }
    else
    {
        if (op.at(0) == 'I')
        {
            if (op == "II")
            {
                string tmp = arrayOps.substr(0, arrayOps.find(delimiter));
                arrayOps.erase(0, arrayOps.find(delimiter) + delimiter.length());
                inserirInicio(pesquisar(tmp));
            }
            else
            {
                string tmp = arrayOps.substr(0, arrayOps.find(delimiter));
                arrayOps.erase(0, arrayOps.find(delimiter) + delimiter.length());
                inserirFim(pesquisar(tmp));
            }
        }
        else
        {
            if (op == "RI")
            {
                cout << "(R) " << removerInicio().getNome() << "\n";
            }
            else
            {
                cout << "(R) " << removerFim().getNome() << "\n";
            }
        }
    }
}

// -----------main-----------

int main(void)
{
    string arrayID = "";
    cin >> arrayID;
    while (arrayID != "FIM")
    {
        array[countGlobal].ler(arrayID);
        countGlobal++;
        cin >> arrayID;
    }
    for (int i = 0; i < countGlobal; i++)
    {
        // array[i].imprimir();
    }
    string numOps = "";
    cin >> numOps;
    int nops = stoi(numOps);
    string arrayOps[nops];
    for (int i = 0; i < countGlobal; i++)
    {
        inserirFim(array[i]);
    }

    for (int i = 0; i <= nops; i++)
    {
        getline(cin, arrayOps[i]);
    }
    // cout << "chegou" << "\n";
    for (int i = 1; i <= nops; i++)
    {
        // cout << arrayOps[i] << "\n";
        tratamentoOps(arrayOps[i]);
    }
    mostrar();
}
