#include <iostream>
#include <vector>

using namespace std;

int main() {
    string str;
    cin >> str;
    int stage = 0;
    int len = str.length();
    for(int i = 0; i < len; i++) {
        switch(stage) {
            case 0:
                if (str[i] == '0') {
                    stage = 1;
                }
                else {
                    stage = 2;
                }
                break;
            case 1:
                if (str[i] == '0') {
                    stage = 15;
                }
                else {
                    stage = 6;
                }
                break;
            case 2:
                if (str[i] == '0') {
                    stage = 3;
                }
                else {
                    stage = 15;
                }
                break;
            case 3:
                if (str[i] == '0') {
                    stage = 4;
                }
                else {
                    stage = 15;
                }
                break;
            case 4:
                if (str[i] == '0') {
                    stage = 4;
                }
                else {
                    stage = 5;
                }
                break;
            case 5:
                if (str[i] == '0') {
                    stage = 7;
                }
                else {
                    stage = 12;
                }
                break;
            case 6:
                if (str[i] == '0') {
                    stage = 7;
                }
                else {
                    stage = 8;
                }
                break;
            case 7:
                if (str[i] == '0') {
                    stage = 15;
                }
                else {
                    stage = 6;
                }
                break;
            case 8:
                if (str[i] == '0') {
                    stage = 9;
                }
                else {
                    stage = 15;
                }
                break;
            case 9:
                if (str[i] == '0') {
                    stage = 10;
                }
                else {
                    stage = 15;
                }
                break;
            case 10:
                if (str[i] == '0') {
                    stage = 10;
                }
                else {
                    stage = 11;
                }
                break;
            case 11:
                if (str[i] == '0') {
                    stage = 7;
                }
                else {
                    stage = 14;
                }
                break;
            case 12:
                if (str[i] == '0') {
                    stage = 13;
                }
                else {
                    stage = 12;
                }
                break;
            case 13:
                if (str[i] == '0') {
                    stage = 10;
                }
                else {
                    stage = 6;
                }
                break;
            case 14:
                if (str[i] == '0') {
                    stage = 13;
                }
                else {
                    stage = 14;
                }
                break;
            default:
                break;
        }
    }
    if (stage == 5 || stage == 6 || stage == 11 || stage == 12 || stage == 14) {
        cout << "SUBMARINE";
    }
    else {
        cout << "NOISE";
    }
    return 0;
}