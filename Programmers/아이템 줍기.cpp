#include <string>
#include <vector>
#include <iostream>
using namespace std;

int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };
bool map[104][104];
int numOfRactangle;
int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    int answer = 0;
    for (int i = 0; i < 104; i++) {
        for (int j = 0; j < 104; j++) {
            map[i][j] = false;
        }
    }
    numOfRactangle = rectangle.size();
    for (int i = 0; i < numOfRactangle; i++) {
        int sX = rectangle[i][0] * 2;
        int sY = rectangle[i][1] * 2;
        int eX = rectangle[i][2] * 2;
        int eY = rectangle[i][3] * 2;
        for (int row = sX; row <= eX; row++) {
            map[row][sY] = true;
            map[row][eY] = true;
        }
        for (int col = sY; col <= eY; col++) {
            map[sX][col] = true;
            map[eX][col] = true;
        }
        for (int j = 0; j < numOfRactangle; j++) {
            if (j == i) {
                continue;
            }
            int tsX = rectangle[j][0] * 2;
            int tsY = rectangle[j][1] * 2;
            int teX = rectangle[j][2] * 2;
            int teY = rectangle[j][3] * 2;
            for (int row = tsX + 1; row < teX; row++) {
                for (int col = tsY + 1; col < teY; col++) {
                    map[row][col] = false;
                }
            }
        }
    }
    int charX = characterX * 2;
    int charY = characterY * 2;
    int currX1 = charX;
    int currY1 = charY;
    int currX2 = charX;
    int currY2 = charY;
    for (int i = 0; i < 4; i++) {
        int testCurrX1 = currX1 + dx[i];
        int testCurrY1 = currY1 + dy[i];
        if (map[testCurrX1][testCurrY1]) {
            currX1 = testCurrX1;
            currY1 = testCurrY1;
            break;
        }
    }
    for (int i = 3; i >= 0; i--) {
        int testCurrX2 = currX2 + dx[i];
        int testCurrY2 = currY2 + dy[i];
        if (map[testCurrX2][testCurrY2]) {
            currX2 = testCurrX2;
            currY2 = testCurrY2;
            break;
        }
    }
    map[charX][charY] = false;
    answer++;
    int iX = itemX * 2;
    int iY = itemY * 2;
    while (!(iX == currX1 && iY == currY1) && !(iX == currX2 && iY == currY2)) {
        for (int i = 0; i < 4; i++) {
            int testCurrX1 = currX1 + dx[i];
            int testCurrY1 = currY1 + dy[i];
            if (map[testCurrX1][testCurrY1]) {
                map[currX1][currY1] = false;
                currX1 = testCurrX1;
                currY1 = testCurrY1;
                break;
            }
        }
        for (int i = 0; i < 4; i++) {
            int testCurrX2 = currX2 + dx[i];
            int testCurrY2 = currY2 + dy[i];
            if (map[testCurrX2][testCurrY2]) {
                map[currX2][currY2] = false;
                currX2 = testCurrX2;
                currY2 = testCurrY2;
                break;
            }
        }
        answer++;
    }

    answer = answer / 2;
    return answer;
}