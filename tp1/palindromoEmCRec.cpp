#include <stdio.h>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

bool palindromoRec(string s, int count, int tam)
{
    bool simNao = true;
    if (tam < (s.length() / 2))
    {
        if (s.at(tam) == s.at(s.length() - tam - 1))
        {
            return palindromoRec(s, count + 1, tam + 1);
        }
        else
        {
            return palindromoRec(s, count, tam + 1);
        }
    }
    else
    {
        if (count == s.length() / 2)
        {
            simNao = true;
        }
        else
        {
            simNao = false;
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
                if (palindromoRec(s[i], 0, 0) == true)
        {
            cout << "SIM " << endl;
        }
        else
        {
            cout << "NAO " << endl;
        }
        i++;
        getline(cin, s[i]);
    }
}
