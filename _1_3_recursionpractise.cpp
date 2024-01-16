#include <iostream>
#include <stdlib.h>
using namespace std;

int pow(int base, int exp) {
    if(exp <= 0) {
        return 1;
    }

    return base * pow(base, exp - 1);
}

bool isPrime(int n, int i = 2) {
    if(n <= 2) return (n == 2)? true : false;
    if(n % i == 0) return false;
    if(i*i > n) return true;
    
    return isPrime(n, i+1);
}

int findhcl(int a, int b)  {
    if(a == 0) return b;
    if(b == 0) return a;
    if(a == b) return a;
    
    if(a > b) {
        return findhcl(a-b, b);
    }else {
        return findhcl(a, b-a);
    }
}

int find_lcm(int a, int b, int i = 1) {
    if(a > b) {
        if(a % b == 0) {
            return a;
        }

        return find_lcm(a * i, b, i+1);
    }else {
        if(b % a == 0) {
            return b;
        }

        return find_lcm(a, b * i, i+1);
    }
}

int main() {
    int base, exp;
    cout<< "Enter base : " << "\n";
    cin >> base;
    
    cout << "Enter Exponent : " << "\n";
    cin >> exp;

    cout << pow(base, exp);
    cout << "\n" << isPrime(45, 2);

    cout << "finding HCL of a number" << '\n' << findhcl(12, 4);
}