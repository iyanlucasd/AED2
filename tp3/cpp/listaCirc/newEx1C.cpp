// -----------define-----------
#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>

#define MAXTAM 150
#define bool short
#define true 1
#define false 0

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
        cout << getEstadoNascimento();
        cout << " ##\n";
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
        int aux = nova.length();
        if (nova.at(aux - 1) == ',')
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

Jogador lista[MAXTAM]; // Elementos da pilha
int n;                 // Quantidade de array.

/**
 * Inicializacoes
 */
void start()
{
    n = 0;
}

/**
 * Insere um elemento na primeira posicao da lista e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 */
void inserirInicio(Jogador x)
{
    int i;

    //validar insercao
    if (n >= MAXTAM)
    {
        printf("Erro ao inserir!");
        exit(1);
    }

    //levar elementos para o fim do array
    for (i = n; i > 0; i--)
    {
        lista[i] = lista[i - 1];
    }

    lista[0] = x;
    n++;
}

/**
 * Insere um elemento na ultima posicao da 
 * @param x int elemento a ser inserido.
 */
void inserirFim(Jogador x)
{

    //validar insercao
    if (n >= MAXTAM)
    {
        printf("Erro ao inserir!");
        exit(1);
    }

    lista[n] = x;
    n++;
}

/**
 * Insere um elemento em uma posicao especifica e move os demais
 * elementos para o fim da 
 * @param x int elemento a ser inserido.
 * @param pos Posicao de insercao.
 */
void inserir(Jogador x, int pos)
{
    int i;

    //validar insercao
    if (n >= MAXTAM || pos < 0 || pos > n)
    {
        printf("Erro ao inserir!");
        exit(1);
    }

    //levar elementos para o fim do array
    for (i = n; i > pos; i--)
    {
        lista[i] = lista[i - 1];
    }

    lista[pos] = x;
    n++;
}

/**
 * Remove um elemento da primeira posicao da lista e movimenta 
 * os demais elementos para o inicio da mesma.
 * @return resp int elemento a ser removido.
 */
Jogador removerInicio()
{
    int i;
    Jogador resp;

    //validar remocao
    if (n == 0)
    {
        printf("Erro ao remover!");
        exit(1);
    }

    resp = lista[0];
    n--;

    for (i = 0; i < n; i++)
    {
        lista[i] = lista[i + 1];
    }
    return resp;
}

/**
 * Remove um elemento da ultima posicao da 
 * @return resp int elemento a ser removido.
 */
Jogador removerFim()
{

    //validar remocao
    if (n == 0)
    {
        printf("Erro ao remover!");
        exit(1);
    }
    return lista[--n];
}

/**
 * Remove um elemento de uma posicao especifica da lista e 
 * movimenta os demais elementos para o inicio da mesma.
 * @param pos Posicao de remocao.
 * @return resp int elemento a ser removido.
 */
Jogador remover(int pos)
{
    int i;
    Jogador resp;

    //validar remocao
    if (n == 0 || pos < 0 || pos >= n)
    {
        printf("Erro ao remover!");
        exit(1);
    }

    resp = lista[pos];
    n--;

    for (i = pos; i < n; i++)
    {
        lista[i] = lista[i + 1];
    }

    return resp;
}

/**
 * Mostra os array separados por espacos.
 */
void mostrar()
{
    int i;

    for (i = 0; i < n; i++)
    {
        cout << "[" << i << "] ";
        lista[i].imprimir();
    }
}

/**
 * Procura um array e retorna se ele existe.
 * @param x int elemento a ser pesquisado.
 * @return <code>true</code> se o array existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(Jogador x)
{
    bool retorno = false;
    int i;

    for (i = 0; i < n && retorno == false; i++)
    {
        // retorno = (lista[i] == x);
    }
    return retorno;
}
// -----------tratamento-----------
static Jogador arrayJogador[1024];
static int countGlobal = 0;

Jogador pesquisar(string key)
{
    arrayJogador[countGlobal].ler(key);
    countGlobal++;
    return arrayJogador[countGlobal - 1];
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
        arrayJogador[countGlobal].ler(arrayID);
        countGlobal++;
        cin >> arrayID;
    }
    for (int i = 0; i < countGlobal; i++)
    {
        // arrayJogador[i].imprimir();
    }
    string numOps = "";
    cin >> numOps;
    int nops = stoi(numOps);
    string arrayOps[nops];
    for (int i = 0; i < countGlobal; i++)
    {
        inserirFim(arrayJogador[i]);
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
