#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    unordered_map<string, int> nameAndRank;
    unordered_map<int, string> rankAndName;
    
    int numOfPlayers = players.size();
    int numOfCallings = callings.size();
    for(int i = 0; i < numOfPlayers; i++){
        string currPlayer = players[i];
        nameAndRank[currPlayer] = i;
        rankAndName[i] = currPlayer;
    }
    for(int i = 0; i < numOfCallings; i++){
        string currString = callings[i];
        int currRank = nameAndRank[currString];
        string parent = rankAndName[currRank - 1];
        nameAndRank[currString] = currRank - 1;
        nameAndRank[parent] = currRank;
        rankAndName[currRank] = parent;
        rankAndName[currRank - 1] = currString;
    }
    vector<string> answer;
    for(int i = 0; i < numOfPlayers; i++){
        answer.push_back(rankAndName[i]);
    }
    return answer;
}