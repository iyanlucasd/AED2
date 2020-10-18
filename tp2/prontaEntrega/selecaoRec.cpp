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
void sort(int i, int n);
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
    sort(0, countGlobal);

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

void sort(int i, int n)
{
    // find the minimum element in the unsorted subarray[i..n-1]
    // and swap it with arr[i]
    int min = i;
    for (int j = i + 1; j < n; j++)
    {

        if (strcmp(array[j].nome, array[min].nome) < 0)
            min = j;
    }

    swap(min, i);

    if (i + 1 < n)
    {
        sort(i + 1, n);
    }
}
