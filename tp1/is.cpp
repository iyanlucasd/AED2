#include <stdio.h>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;
/**
     * @method isVogal verifica se a string é só vogal ou não
     * @param x string do pub.in
     * @return true/false
     */
bool isVogal(string x)
{
    std::string str = x;
    std::transform(str.begin(), str.end(), str.begin(), ::toupper);
    bool simNao = false;
    for (int i = 0; i < str.length(); i++)
    {
        if (str.at(i) == 'A' || str.at(i) == 'O' || str.at(i) == 'I' || str.at(i) == 'E' || str.at(i) == 'U')
        {
            simNao = true;
        }
        else
        {
            simNao = false;
            i = str.length();
        }
    }
    return simNao;
}
/**
     * @method isCons verifica se a string é só consoante ou não
     * @param x string do pub.in
     * @return true/false
     */
bool isCons(string x)
{
    std::string str = x;
    std::transform(str.begin(), str.end(), str.begin(), ::toupper);
    bool simNao = false;
    for (int i = 0; i < str.length(); i++)
    {
        if ((int)str.at(i) > 64 && (int)str.at(i) < 91)
        {
            if ((str.at(i) == 'A' || str.at(i) == 'O' || str.at(i) == 'I' || str.at(i) == 'E' || str.at(i) == 'U'))
            {
                simNao = false;
                i = str.length();
            }
            else
            {
                simNao = true;
            }
        }
    }
    return simNao;
}
/**
     * @method isVogal verifica se a string é só inteiro ou não
     * @param x string do pub.in
     * @return true/false
     */
bool isInt(string x)
{
    std::string str = x;
    std::transform(str.begin(), str.end(), str.begin(), ::toupper);
    bool simNao = false;
    for (int i = 0; i < str.length(); i++)
    {
        if ((int)str.at(i) > 47 && (int)str.at(i) < 58)
        {
            simNao = true;
        }
        else
        {
            simNao = false;
            i = str.length();
        }
    }
    return simNao;
}
    /**
     * @method isVogal verifica se a string é só float ou não
     * @param x string do pub.in
     * @return true/false
     */
bool isFloat(string x)
{
    std::string str = x;
    std::transform(str.begin(), str.end(), str.begin(), ::toupper);
    bool simNao = false;
    for (int i = 0; i < str.length(); i++)
    {
        if ((int)str.at(i) > 47 && (int)str.at(i) < 58 || (int)str.at(i) == 44)
        {
            simNao = true;
        }
        else
        {
            simNao = false;
            i = str.length();
        }
    }
    return simNao;
}
/**
     * @method main verifica se é fim, recebe as entradas, chamas as funções e printa sim/não
     */
int main(void)
{
    string s[1000];
    int i = 0;
    getline(cin, s[i]);
    while (s[i] != "FIM")
    {
        if (isVogal(s[i]) == true)
        {
            cout << "SIM ";
        }
        else
        {
            cout << "NAO ";
        }
        if (isCons(s[i]) == true)
        {
            cout << "SIM ";
        }
        else
        {
            cout << "NAO ";
        }

        if (isInt(s[i]) == true)
        {
            cout << "SIM ";
        }
        else
        {
            cout << "NAO ";
        }
        if (isFloat(s[i]) == true)
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