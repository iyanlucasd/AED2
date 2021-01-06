#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

// só falando que BR vai brilhar em Tokyo 2021

typedef struct Selecao
{
    char nacao[50];
    int ouro;
    int prata;
    int bronze;
} selecao;

static int countDebugger = 0;
void debugger(int n)
{
    printf("debugger %i", n);
}

int desempateSelecao(const void *nacao1, const void *nacao2)
{
    // debugger(countDebugger);
    // countDebugger++;
    Selecao *i = (Selecao *)nacao1, *j = (Selecao *)nacao2;
    if (i->ouro > j->ouro)
    {
        return -1;
    }
    else if (i->ouro < j->ouro)
    {
        return 1;
    }
    else
    {
        // debugger(countDebugger);
        // countDebugger++;

        if (i->prata > j->prata)
        {
            return -1;
        }
        else if (i->prata < j->prata)
        {
            return 1;
        }
        else
        {
            // debugger(countDebugger);
            // countDebugger++;
            if (i->bronze > j->bronze)
            {
                return -1;
            }
            else if (i->bronze < j->bronze)
            {
                return 1;
            }
            else
            {
                // debugger(countDebugger);
                // countDebugger++;
                return strcmp(i->nacao, j->nacao);
            }
        }
    }
}

int main(void)
{
    int entrada = 0;
    scanf("%i", &entrada);
    Selecao Selecao[entrada];
    // Belgica 2 2 2
    // Brasil 7 6 6
    for (int i = 0; i < entrada; i++)
    {
        scanf("%s %d %d %d", &Selecao[i].nacao, &Selecao[i].ouro, &Selecao[i].prata, &Selecao[i].bronze);
    }
    // debugger(countDebugger);
    // countDebugger++;
    qsort(Selecao, entrada, sizeof(struct Selecao), desempateSelecao);
    // debugger(countDebugger);
    // countDebugger++;
    for (int i = 0; i < entrada; i++)
    {
        printf("%s %d %d %d\n", Selecao[i].nacao, Selecao[i].ouro, Selecao[i].prata, Selecao[i].bronze);
    }
}