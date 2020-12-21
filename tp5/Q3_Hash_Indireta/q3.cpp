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
// ----------------lista----------

class Celula
{
private:
    /* data */
public:
    Jogador elemento;
    Celula *prox;
    Celula(Jogador x);
    ~Celula();
};
Celula *novaCelula(Jogador elemento)
{
    Celula *nova = (Celula *)malloc(sizeof(Celula));
    nova->elemento = elemento;
    nova->prox = NULL;
    return nova;
}

Celula::Celula(Jogador x)
{
    this->elemento = x;
    this->prox = NULL;
}

Celula::~Celula()
{
}

//LISTA PROPRIAMENTE DITA =======================================================
class Lista
{
private:
    /* data */
public:
    Celula *primeiro;
    Celula *ultimo;
    Lista();
    void inserirInicio(Jogador x);
    bool pesquisar(string x);

    ~Lista();
};

Lista::Lista()
{
    primeiro = NULL;
    ultimo = primeiro;
}

Lista::~Lista()
{
}

void Lista::inserirInicio(Jogador x)
{
    Celula *tmp = novaCelula(x);
    tmp->prox = primeiro->prox;
    primeiro->prox = tmp;
    if (primeiro == ultimo)
    {
        ultimo = tmp;
    }
    tmp = NULL;
}
bool Lista::pesquisar(string x)
{
    bool retorno = false;
    Celula *i;

    for (i = primeiro->prox; i != NULL; i = i->prox)
    {
        if (i->elemento.getNome() == x)
        {
            retorno = true;
            i = ultimo;
        }
    }
    return retorno;
}
// ----------------hash-----------

class Hash
{
private:
public:
    int tamanho;
    Lista tabela[25];
    Hash(int tamanho);
    ~Hash();
    int h(int elemento);
    void inserirInicio(Jogador elemento);
    bool pesquisar(string x, int altura);
};

Hash::Hash(int tamanho)
{
    this->tamanho = tamanho;
}

Hash::~Hash()
{
}

int Hash::h(int elemento)
{
    return elemento % tamanho;
}

void Hash::inserirInicio(Jogador elemento)
{
    int pos = h(elemento.getAltura());
    tabela[pos].inserirInicio(elemento);
}

bool Hash::pesquisar(string x, int altura)
{
    int pos = h(altura);
    return tabela[pos].pesquisar(x);
}

// ----------------main-----------
static Jogador array[1024];
static int countGlobal = 0;

int pesquisaJooj(string key)
{
    bool pos = false;
    int position = 0;
    for (int i = 0; i < countGlobal; i++)
    {
        if (array[i].getNome().compare(key) == 0)
        {
            position = i;
            i = countGlobal;
            pos = true;
        }
        if (pos == true)
        {
            return array[position].getAltura();
        }
        else
        {
            return 1;
        }
    }
}

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
    Hash table(25);
    for (int i = 0; i < countGlobal; i++)
    {
        table.inserirInicio(array[i]);
    }

    string arrayOps[1024];
    int countOps = 0;
    cin >> arrayOps[countOps];
    while (arrayOps[countOps].compare("FIM") == 0)
    {
        countOps++;
        cin >> arrayOps[countOps];
    }
    for (int i = 0; i < countOps; i++)
    {
        cout << arrayOps[i] << " " << (table.pesquisar(arrayOps[i], pesquisaJooj(arrayOps[i])) != false ? "SIM" : "NAO") << endl;
    }
}
