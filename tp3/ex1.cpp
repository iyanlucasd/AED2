#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_CHAR 50

typedef struct
{
    int id = 0;
    char nome[MAX_CHAR] = "";
    int altura = 0;
    int peso = 0;
    char universidade[MAX_CHAR] = "";
    char anoNascimento[MAX_CHAR] = "";
    char cidadeNascimento[MAX_CHAR] = "";
    char estadoNascimento[MAX_CHAR] = "";
} Jogador;

static Jogador array[1024];
static int count = 0;

void ler()
{
}

int main()
{

    FILE *arq;
    arq = fopen("/tmp/players.csv", "r");
    char *str;
    char id[4];
    int i = 0;

    str = fgets(str, MAX_CHAR, arq);

    while (fgets(str, MAX_CHAR, arq) != NULL)
    {    
        while (str[i] != ',')
        {
            id[i] = str[i];
            i++;
        }
        i = 0;
        printf("%s\n", id);
    }

    // printf("%s\n", aux);

    fclose(arq);
    return 0;
}
