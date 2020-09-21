#include <stdio.h>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
/**
 * @method escreveFile que abre o arquivo em modo de escrita e escreve as entradas
 * @param numero numero de entradas
 * @param d doubles para escrever no arquivo
 * fecha o arquivo.
*/
void escreveFile(int numero, double d)
{
    FILE *arq = fopen("exemplo2.txt", "w");

    for (int i = 0; i < numero; i++)
    {
        scanf("%lf", &d);
        fprintf(arq,"%lf\n", d);
    } //fim for

    fclose(arq);
} // fim escreveFile

/**
 * @method printaContrario função que abre o arquivo em leitura e 
 * vai pro final do arquivo
 * le as entradas e printa na tela
 * fecha o arquivo.
 * @param numero numero de entradas
 * @param d doubles para escrever no arquivo
*/
void printaContrario(int numero, double d)
{
    FILE *arq = fopen("exemplo2.txt", "rb");

    double real = 0.0;
    int inteiro = 0, n = numero;

    for(int i = 0; i < numero; numero--){
        n = numero;
        for(int j = 0; j < n; n--){
            fscanf(arq, "%lf\n", &real);
        }
        inteiro = (int)real;

        if(real == (long) real)
            printf("%d\n", inteiro);
        else
            printf("%g\n", real);
        rewind(arq);
    }
    fclose(arq);

} //fim printaContrario
/**
 * @method main recebe o numero das entradas e chama as funções
*/
int main(void)
{
    int numero;
    double d;
    cin >> numero;
    escreveFile(numero, d);
    printaContrario(numero, d);
}
