#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

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
    Jogador(/* args */)
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
        cout << " ##";
        cout << endl;
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
        string estadoDeNascimento = nova.substr(0, nova.find(delimiter));
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

static Jogador array[1024];
static int countGlobal = 0;

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
        array[i].imprimir();
    }
    
}
