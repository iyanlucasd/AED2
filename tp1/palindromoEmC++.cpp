#include <stdio.h>
#include <iostream>

using namespace std;
bool palindromoIterativo(string s, int tam)
{
    bool simNao = false;
    for (int i = 0; i < tam / 2; i++)
    {
        if (s.at(i) == s.at(tam - i - 1))
        {
            simNao = true;
        }
        else
        {
            simNao = false;
            i = tam;
        }
    }


    return simNao;
}

int main(void)
{
    string s[1000];
    int i = 0;
    getline(cin, s[i]);
    while (s[i] != "FIM")
    {
        int tam = 0;
        tam = s[i].length();
        if (palindromoIterativo(s[i], tam) == true)
        {
            cout << "SIM" << endl;
        }
        else
        {
            cout << "NAO" << endl;
        }
        i++;
        getline(cin, s[i]);
    }
}