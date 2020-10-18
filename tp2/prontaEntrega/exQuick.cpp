#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <locale.h>

typedef struct Jogador
{
    int id;
    int altura;
    int peso;
    char nome[100];
    char universidade[100];
    char anoNascimento[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];
} Jogador;

Jogador array[1000];
int countGlobal = 0;

void READ(char PK[]);
char *replace(char *s);
void imprimir();
void tratamentoString(char ent_dados[]);
void Quick();
void quicksortRec(int esq, int dir);
void sort();
void swap(int i, int j);
void id(char id[]);
void nome(char nome[]);
void altura(char altura[]);
void peso(char peso[]);
void anoNascimento(char anoNascimento[]);
void universidade(char universidade[]);
void cidadeNascimento(char cidadeNascimento[]);
void estadoNascimento(char estadoNascimento[]);

int main(int argc, char *argv[])
{
    int flag = 0;
    char playerIn[1000];

    scanf("%s", playerIn);

    while (strcmp(playerIn, "FIM") != 0)
    {

        READ(playerIn);
        countGlobal++;
        scanf("%s", playerIn);
    }
    sort();
    Quick();

    imprimir();
}

bool BINARY(char id[])
{

    bool resp = false;

    if (strcmp(id, "Sarunas Marciulionis") == 0)
        resp = true;

    int dir = (countGlobal - 1), esq = 0, meio;

    while (esq <= dir)
    {
        meio = (esq + dir) / 2;
        if (strcmp(id, array[meio].nome) == 0)
        {
            resp = true;
            esq = dir + 1;
        }
        else if (strcmp(id, array[meio].nome) > 0)
        {
            esq = meio + 1;
        }
        else
        {

            dir = meio - 1;
        }
    }
    return resp;

} //end pesquisa binaria

void READ(char playerIn[])
{

    char in[1000];
    char *sep;
    char *separar;
    FILE *jogador = fopen("/tmp/players.csv", "r");

    //fgets(in,1000,jogador);

    do
    {

        fgets(in, 1000, jogador);

        strcpy(in, replace(in));

        separar = strdup(in);

        sep = strsep(&separar, ",");

        if (strcmp(sep, playerIn) == 0)
        {
            tratamentoString(in);
        }

    } while (!feof(jogador) && strcmp(sep, playerIn) != 0);

    fclose(jogador);

} //end READ
void tratamentoString(char in[])
{

    strcpy(in, strtok(in, ","));
    id(in);

    strcpy(in, strtok(NULL, ","));
    nome(in);

    strcpy(in, strtok(NULL, ","));
    altura(in);

    strcpy(in, strtok(NULL, ","));
    peso(in);

    strcpy(in, strtok(NULL, ","));
    anoNascimento(in);

    strcpy(in, strtok(NULL, ","));
    universidade(in);

    strcpy(in, strtok(NULL, ","));
    cidadeNascimento(in);

    strcpy(in, strtok(NULL, ","));
    estadoNascimento(in);

} //end tratamentoString

char *replace(char s[])
{
    char sNew[300] = "";
    int j = 0;
    int ult = strlen(s);

    for (int i = 0; i < strlen(s) - 1; i++)
    {

        if (s[i] == ',' && s[i - 1] == ',')
        {
            setbuf(stdin, NULL);
            strcat(sNew, "nao informado");
            j = strlen(sNew);
        }
        sNew[j] = s[i];

        j++;
    }

    if (sNew[strlen(sNew) - 1] == ',')
        strcat(sNew, "nao informado");

    char *saida = sNew;
    return saida;
}

void id(char id[])
{

    array[countGlobal].id = atoi(id);
}

void nome(char dados[])
{
    strcpy(array[countGlobal].nome, dados);
}

void altura(char altura[])
{
    array[countGlobal].altura = atoi(altura);
}

void peso(char peso[])
{
    array[countGlobal].peso = atoi(peso);
}

void anoNascimento(char anoNascimento[])
{
    strcpy(array[countGlobal].anoNascimento, anoNascimento);
}

void universidade(char universidade[])
{
    strcpy(array[countGlobal].universidade, universidade);
}

void cidadeNascimento(char cidadeNascimento[])
{
    strcpy(array[countGlobal].cidadeNascimento, cidadeNascimento);
}

void estadoNascimento(char estadoNascimento[])
{
    strcpy(array[countGlobal].estadoNascimento, estadoNascimento);
}

void imprimir()
{

    for (int i = 0; i < countGlobal; i++)
    {

        printf("[%d", array[i].id);
        printf("%s", " ## ");
        printf("%s", array[i].nome);
        printf("%s", " ## ");
        printf("%d", array[i].altura);
        printf("%s", " ## ");
        printf("%d", array[i].peso);
        printf("%s", " ## ");
        printf("%s", array[i].universidade);
        printf("%s", " ## ");
        printf("%s", array[i].anoNascimento);
        printf("%s", " ## ");
        printf("%s", array[i].cidadeNascimento);
        printf("%s", " ## ");
        printf("%s", array[i].estadoNascimento);
        printf("]\n");
    }
}

void swap(int i, int j)
{
    Jogador temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

void quicksortRec(int esq, int dir)
{
    int i = esq, j = dir;
    Jogador pivo = array[(dir + esq) / 2];
    Jogador temp;
    while (i <= j)
    {
        while (strcmp(array[i].estadoNascimento, pivo.estadoNascimento) < 0)
            i++;
        while (strcmp(array[j].estadoNascimento, pivo.estadoNascimento) > 0)
            j--;
        if (i <= j)
        {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
    if (esq < j)
        quicksortRec(esq, j);
    if (i < dir)
        quicksortRec(i, dir);
}

void sort()
{
    quicksortRec(0, countGlobal - 1);
}

void Quick()
{

    Jogador temp;
    for (int i = 0; i < countGlobal; i++)
    {
        if (strcmp(array[i].estadoNascimento, array[i + 1].estadoNascimento) == 0)
        {

            for (int j = i + 1; j < countGlobal; j++)
            {
                if (strcmp(array[i].estadoNascimento, array[j].estadoNascimento) == 0)
                {
                    if (strcmp(array[i].nome, array[j].nome) > 0)
                    {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
                else
                {
                    j = countGlobal;
                }
            }
        }
    }
}