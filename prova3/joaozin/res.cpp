#include <stdio.h>
#include <stdlib.h>

int minimo(int x, int y)
{
    if (x < y)
        return x;
    else
        return y;
}

int main()
{
    int N, P;
    int i, j, pilha, altura;
    int nesq, ndir, caixa;
    int *v;

    scanf("%d%d", &N, &P);
    while (N != 0 || P != 0)
    {
        v = (int *)malloc(P * sizeof(int));

        for (i = 0; i < P; i++)
        {
            scanf("%d", &v[i]);
            for (j = 0; j < v[i]; j++)
            {
                scanf("%d", &caixa);
                if (caixa == 1)
                {
                    pilha = i;
                    altura = j + 1;
                }
            }
        }

        nesq = v[pilha] - altura; // quantas caixas estao acima do inventario
        for (i = pilha - 1; i >= 0 && v[i] >= altura; i--)
            nesq += (v[i] - altura + 1); // quantas caixas seraos retirada nesta pilha

        ndir = v[pilha] - altura; // quantas caixas estao acima do inventario
        for (i = pilha + 1; i < P && v[i] >= altura; i++)
            ndir += (v[i] - altura + 1); // quantas caixas seraos retirada nesta pilha

        printf("%d\n", minimo(nesq, ndir));

        free(v);

        scanf("%d%d", &N, &P);
    }

    return 0;
}