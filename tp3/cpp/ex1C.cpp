#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#define MAX_CHAR 40
#define FULL_MALLOCK 300

//debugger, deu mais erro que minha vida ;-;
void debugger(int i)
{
    printf("chegou %i\n", i);
}
//-----------------------------//----------------------------
//começo da "classe"
typedef struct Jogador
{
    int id;
    char nome[MAX_CHAR];
    int peso;
    int altura;
    char universidade[MAX_CHAR];
    int anoDeNascimento;
    char cidadeDeNascimento[MAX_CHAR];
    char estadoDeNascimento[MAX_CHAR];
} jogador;

//setters
void setId(int id, jogador *jogador)
{
    jogador->id = id;
}

void setNome(char *nome, jogador *jogador)
{
    strcpy(jogador->nome, nome);
}

void setPeso(int peso, jogador *jogador)
{
    jogador->peso = peso;
}
void setAltura(int altura, jogador *jogador)
{
    jogador->altura = altura;
}
void setUniversidade(char *universidade, jogador *jogador)
{
    strcpy(jogador->universidade, universidade);
}

void setCidadeDeNascimento(char *cidadeDeNascimento, jogador *jogador)
{
    strcpy(jogador->cidadeDeNascimento, cidadeDeNascimento);
}
void setEstadoDeNascimento(char *estadoDeNascimento, jogador *jogador)
{
    estadoDeNascimento[strlen(estadoDeNascimento) - 1] = ']';
    strcpy(jogador->estadoDeNascimento, estadoDeNascimento);
}
//fim setters
//------------------------
//getters

int getId(jogador *jogador)
{
    return jogador->id;
}

char *getNome(jogador *jogador)
{
    return jogador->nome;
}

int getPeso(jogador *jogador)
{
    return jogador->peso;
}

int getAltura(jogador *jogador)
{
    return jogador->altura;
}

char *getUniversidade(jogador *jogador)
{
    return jogador->universidade;
}
void setAnoDeNascimento(int anoDeNascimento, jogador *jogador)
{
    jogador->anoDeNascimento = anoDeNascimento;
}

int getAnoDeNascimento(jogador *jogador)
{
    return jogador->anoDeNascimento;
}

char *getCidadeDeNascimento(jogador *jogador)
{
    return jogador->cidadeDeNascimento;
}

char *getEstadoDeNascimento(jogador *jogador)
{
    return jogador->estadoDeNascimento;
}
//fim getters
//fim da "classe"
//-----------------------------//----------------------------
//começo metodos
void PRINT(jogador *jogador)
{ //inicio PRINT
    printf("[%i ## %s ## %i ## %i ## %i ## %s ## %s ## %s\n", getId(jogador), getNome(jogador), getAltura(jogador), getPeso(jogador), getAnoDeNascimento(jogador), getUniversidade(jogador), getCidadeDeNascimento(jogador), getEstadoDeNascimento(jogador));
} //fim PRINT

char *REPLACE(char *s)
{ //comeco REPLACE
    char *strNew = (char *)malloc(FULL_MALLOCK);
    int count = 0;
    for (int i = 0; i < strlen(s); i++)
    {
        strNew[count] = s[i];
        if (s[i] == ',' && (i == strlen(s) - 2 || s[i + 1] == ','))
        {
            strcat(strNew, "nao informado");
            count += 13;
        }
        count++;
    }
    return strNew;
} //fim REPLACE

Jogador *CONSTRUCTOR(int id, char *nome, int peso, int altura, char *universidade, int anoDeNascimento, char *cidadeDeNascimento, char *estadoDeNascimento)
{ //começo CONSTRUCTOR
    Jogador *jogador = (Jogador *)malloc(sizeof(Jogador));
    setId(id, jogador);
    setNome(nome, jogador);
    setPeso(peso, jogador);
    setAltura(altura, jogador);
    setUniversidade(universidade, jogador);
    setAnoDeNascimento(anoDeNascimento, jogador);
    setCidadeDeNascimento(cidadeDeNascimento, jogador);
    setEstadoDeNascimento(estadoDeNascimento, jogador);
    return jogador;
} //fim CONSTRUCTOR

void READ(int id, jogador *jogador)
{ //começo READ
    //debugger(4);
    FILE *arq;

    if ((arq = fopen("/tmp/players.csv", "r")) == NULL)
    {
        printf("Erro ao abrir o arquivo\n");
        abort();
    }

    char s[FULL_MALLOCK], in[100];
    bool flag = false;
    //debugger(5);
    fgets(s, FULL_MALLOCK, arq);
    //debugger(6);
    fgets(s, FULL_MALLOCK, arq);
    while (!feof(arq) && flag == false)
    {
        strcpy(s, REPLACE(s));
        strcpy(in, strtok(s, ","));
        if (atoi(s) == id)
            flag = true;
        else
            fgets(s, FULL_MALLOCK, arq);
    }
    //começo dos setts
    setId(atoi(s), jogador);
    strcpy(s, strtok(NULL, ","));
    setNome(s, jogador);
    strcpy(s, strtok(NULL, ","));
    setAltura(atoi(s), jogador);
    strcpy(s, strtok(NULL, ","));
    setPeso(atoi(s), jogador);
    strcpy(s, strtok(NULL, ","));
    setUniversidade(s, jogador);
    strcpy(s, strtok(NULL, ","));
    setAnoDeNascimento(atoi(s), jogador);
    strcpy(s, strtok(NULL, ","));
    setCidadeDeNascimento(s, jogador);
    strcpy(s, strtok(NULL, ","));
    setEstadoDeNascimento(s, jogador);
    //fim dos setts
    fclose(arq);
    PRINT(jogador);
} //fim READ
//fim metodos
//-----------------------------//----------------------------

int main()
{ //começo main
    //debugger(1);
    jogador *j1 = (jogador *)malloc(sizeof(jogador));
    char in[10];
    char FIM[4] = "FIM";
    scanf("%s", in);
    //debugger(2);

    int id = 0;
    while (strcmp(FIM, in) > 0)
    {
        id = atoi(in);
        //debugger(3);
        READ(id, j1);
        scanf("%s", in);
    }
    //debugger(4);
} //fim main