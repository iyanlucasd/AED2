#include <iostream>
#include <map>
#include <stack>

using namespace std;
void dictionary();
void tratamento(string str);

int main(int argc, char *argv[])
{
    dictionary();
    int casos;
    cin >> casos;
    string str;
    while (casos--)
    {
        cin >> str;
        tratamento(str);
    }
    return 0;
}

map<char, int> dicionario;
// ainda bem que o hackatruck ensinou isso

void dictionary()
{
    dicionario['+'] = 1;
    dicionario['-'] = 1;
    dicionario['/'] = 2;
    dicionario['*'] = 2;
    dicionario['^'] = 3;
}
void tratamento(string str)
{
    stack<char> overflow;

    for (int i = 0; i < str.length(); i++)
    {
        if (isalnum(str[i]))
            cout << str[i];

        else if (str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/' ||
                 str[i] == '^')
        {
            if (!overflow.empty())
            {
                while (dicionario[str[i]] <= dicionario[overflow.top()])
                {
                    cout << overflow.top();
                    overflow.pop();
                    if (overflow.empty())
                        break;
                }
            }
            overflow.push(str[i]);
        }
        else if (str[i] == '(')
        {
            overflow.push('(');
        }

        else if (str[i] == ')')
        {
            while (overflow.top() != '(')
            {
                cout << overflow.top();
                overflow.pop();
            }
            overflow.pop();
        }
    }
    while (!overflow.empty())
    {
        cout << overflow.top();
        overflow.pop();
    }
    cout << endl;
}
