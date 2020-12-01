#include <iostream>

using namespace std;

int metodo(int *a)
{
    *a = *a + 1;
}
int metodo(int &a)
{
    a++;
}

int main(void)
{
    int x = 0;
    cout << x << endl;
    metodo(x);
    cout << x << endl;
    metodo(&x);
    cout << x << endl;

}