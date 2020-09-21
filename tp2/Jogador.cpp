#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct Jogador_C{
    int id;
    char nome[30];
    int peso;
    int altura;
    char universidade[50];
    int anoNascimento;
    char cidadeNascimento[50];
    char estadoNascimento[50];
} Jogador;

//Jogador *jogador;

void setId(int id, Jogador *jogador){
    jogador->id = id;
}

int getId(Jogador *jogador){
    return jogador->id;
}
void setNome(char *nome, Jogador *jogador){
    strcpy(jogador->nome, nome);
}

char* getNome(Jogador *jogador){
    return jogador->nome;
}
void setPeso(int peso, Jogador *jogador){
    jogador->peso = peso;
}

int getPeso(Jogador *jogador){
    return jogador->peso;
}
void setAltura(int altura, Jogador *jogador){
    jogador->altura = altura;
}

int getAltura(Jogador *jogador){
    return jogador->altura;
}

void setUniversidade(char *universidade, Jogador *jogador){
    strcpy(jogador->universidade, universidade);
}

char* getUniversidade(Jogador *jogador){
    return jogador->universidade;
}
void setAnoNascimento(int anoNascimento, Jogador *jogador){
    jogador->anoNascimento = anoNascimento;
}

int getAnoNascimento(Jogador *jogador){
    return jogador->anoNascimento;
}
void setCidadeNascimento(char *cidadeNascimento, Jogador *jogador){
    strcpy(jogador ->cidadeNascimento, cidadeNascimento);
}

char* getCidadeNascimento(Jogador *jogador){
    return jogador->cidadeNascimento;
}
void setEstadoNascimento(char *estadoNascimento, Jogador *jogador){      
    estadoNascimento[strlen(estadoNascimento) - 1] = ']';
    strcpy(jogador->estadoNascimento, estadoNascimento);
}

char* getEstadoNascimento(Jogador *jogador){
    return jogador->estadoNascimento;
}
void imprimir(Jogador *jogador){
   //"["+j.getId()+" ## "+j.getNome()+" ## "+j.getAltura()+" ## "+j.getPeso()+" ## "+j.getAnoNascimento()+" ## "+j.getUniversidade()+" ## "+j.getCidadeNascimento()+" ## "+ j.getEstadoNascimento()+"]"
   printf("[%i ## %s ## %i ## %i ## %i ## %s ## %s ## %s]\n",getId(jogador), getNome(jogador),getAltura(jogador), getPeso(jogador), getAnoNascimento(jogador), getUniversidade(jogador), getCidadeNascimento(jogador), getEstadoNascimento(jogador));
}

char* replace(char * s){
    char * nova = (char*)malloc(300);
    int j = 0;
    for(int i = 0; i < strlen(s); i++){
        nova[j] = s[i];
        if(s[i] == ',' && (i == strlen(s) - 2 || s[i+1] == ',')){
            strcat(nova, "nao informado"); j+=13;}
        j++;         
    }
    return nova;
}

Jogador *construtor(int id, char* nome, int peso, int altura, char* universidade, int anoNascimento, char* cidadeNascimento, char* estadoNascimento){
    Jogador *jogador = (Jogador*)malloc(sizeof(Jogador));
    setId(id, jogador);
    setNome(nome, jogador);
    setPeso(peso, jogador);
    setAltura(altura, jogador);
    setUniversidade(universidade,jogador);
    setAnoNascimento(anoNascimento, jogador);
    setCidadeNascimento(cidadeNascimento, jogador);
    setEstadoNascimento(estadoNascimento, jogador);
    return jogador;
}

void ler(int id, Jogador *jogador){
    int j = 0;
    FILE *arq = fopen("/tmp/players.csv", "r");
    char s[300], dados[100];
    bool para = false;
    fgets(s, 300, arq);// desconsider a primeira linha
    fgets(s, 300, arq);
    while(!feof(arq) && para == false){
        strcpy(s, replace(s));
        strcpy(dados, strtok(s, ","));
        if(atoi(s) == id)
            para = true;
        else 
            fgets(s, 300, arq);
    }

    //criar um novo jogador
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
    setAnoNascimento(atoi(s), jogador);
    strcpy(s, strtok(NULL, ","));
    setCidadeNascimento(s, jogador);
    strcpy(s, strtok(NULL, ","));
    setEstadoNascimento(s, jogador);
    fclose(arq);
    imprimir(jogador);
}

int main(){
    Jogador *j1 = (Jogador*)malloc(sizeof(Jogador));
    char dados[10];
    scanf("%s", dados);
    while(dados[0] != 'F' && dados[1] != 'I' && dados [2] != 'M'){
        int id = atoi(dados);
        ler(id, j1);
        scanf("%s", dados);
    }
}
