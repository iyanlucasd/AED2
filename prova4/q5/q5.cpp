#include <iostream>
#include <string>

using namespace std;

class itens
{
private:
    string nome;
    int ano;
    double duracao;
    string estilo;

public:
    itens();
    ~itens();
    string getNome()
    {
        return this->nome;
    }

    void setNome(string nome)
    {
        this->nome = nome;
    }

    int getAno()
    {
        return this->ano;
    }

    void setAno(int ano)
    {
        this->ano = ano;
    }

    double getDuracao()
    {
        return this->duracao;
    }

    void setDuracao(double duracao)
    {
        this->duracao = duracao;
    }

    string getEstilo()
    {
        return this->estilo;
    }

    void setEstilo(string estilo)
    {
        this->estilo = estilo;
    }
    itens()
    {
        this->nome = "";
        this->ano = 0;
        this->duracao = 0;
        this->estilo = "";
    }

    ~itens()
    {
    }
};

class netflix:public itens
{
private:
    /* data */
public:
    netflix(/* args */);
    ~netflix();
};

netflix::netflix(/* args */)
{
}

netflix::~netflix()
{
}

