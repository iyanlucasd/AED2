#include <stdlib.h>
#include <stdio.h>
#include "geracao.h"
#include "selecao.h"

int main()
{
    int array[100];
    int array2[1000];
    int array3[10000];

    for (int i = 0; i < 33; i++)
    {
     aleatorio(array, 100);
     selecao(aleatorio, 100);   
    }
    
    return 0;
}