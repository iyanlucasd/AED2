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

void READ(char playerIn[]);
char *replace(char *s);
void PRINT();
void tratamentoString(char ent_dados[]);
void bubbleSort(int n);
void swap(int a, int b);
void preOrdain(int n);
void id(char id[]);
void nome(char nome[]);
void altura(char altura[]);
void peso(char peso[]);
void anoNascimento(char anoNascimento[]);
void universidade(char universidade[]);
void cidadeNascimento(char cidadeNascimento[]);
void estadoNascimento(char estadoNascimento[]);

Jogador array[1000];
int countGlobal = 0;

int main(int argc, char *argv[])
{

    char playerIn[1000];

    scanf("%s", playerIn);

    while (strcmp(playerIn, "FIM") != 0)
    {

        READ(playerIn);
        countGlobal++;
        scanf("%s", playerIn);
    }
    bubbleSort(countGlobal);
    //preOrdain(countGlobal);
    PRINT();
}
void swap(int a, int b)
{
    Jogador temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}
void bubbleSort(int n)
{

    int i, j;
    for (i = (n - 1); i > 0; i--)
    {
        for (j = 0; j < i; j++)
        {
            if (strcmp(array[j].anoNascimento, array[j + 1].anoNascimento) > 0 || strcmp(array[j].anoNascimento, array[j + 1].anoNascimento) == 0 && strcmp(array[j].nome, array[j + 1].nome) > 0)
            {
                swap(j, j + 1);
            }
        }
    }
}

void preOrdain(int n)
{

    Jogador temp;

    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (strcmp(array[i].anoNascimento, array[j].anoNascimento) == 0)
            {
                if (strcmp(array[i].nome, array[j].nome) < 0)
                {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            else
            {
                j = n;
            }
        }
    }
}

void READ(char playerIn[])
{

    char ent_dados[1000];
    char *sep;
    char *separar;
    FILE *jogador = fopen("/tmp/players.csv", "r");

    do
    {

        fgets(ent_dados, 1000, jogador);

        strcpy(ent_dados, replace(ent_dados));

        separar = strdup(ent_dados);

        sep = strsep(&separar, ",");

        if (strcmp(sep, playerIn) == 0)
        {
            tratamentoString(ent_dados);
        }

    } while (!feof(jogador) && strcmp(sep, playerIn) != 0);

    fclose(jogador);
}
void tratamentoString(char ent_dados[])
{

    array[countGlobal].id = atoi(strtok(ent_dados, ","));
    strcpy(array[countGlobal].nome, strtok(NULL, ","));
    array[countGlobal].altura = atoi(strtok(NULL, ","));
    array[countGlobal].peso = atoi(strtok(NULL, ","));
    strcpy(array[countGlobal].universidade, strtok(NULL, ","));
    strcpy(array[countGlobal].anoNascimento, strtok(NULL, ","));
    strcpy(array[countGlobal].cidadeNascimento, strtok(NULL, ","));
    strcpy(array[countGlobal].estadoNascimento, strtok(NULL, ","));
}

char *replace(char s[])
{
    char nova[300] = "";
    int j = 0;
    int ult = strlen(s);

    for (int i = 0; i < strlen(s) - 1; i++)
    {

        if (s[i] == ',' && s[i - 1] == ',')
        {
            setbuf(stdin, NULL);
            strcat(nova, "nao informado");
            j = strlen(nova);
        }
        nova[j] = s[i];

        j++;
    }

    if (nova[strlen(nova) - 1] == ',')
        strcat(nova, "nao informado");

    char *saida = nova;
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

void PRINT()
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
        printf("%s", array[i].anoNascimento);
        printf("%s", " ## ");
        printf("%s", array[i].universidade);
        printf("%s", " ## ");
        printf("%s", array[i].cidadeNascimento);
        printf("%s", " ## ");
        printf("%s", array[i].estadoNascimento);
        printf("]\n");
    }

} //PRINT