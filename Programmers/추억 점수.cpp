#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    int numOfPeople = name.size();
    vector<int> answer;
    unordered_map<string, int> map;
    for(int i = 0; i < numOfPeople; i++){
        string currName = name[i];
        int currYearning = yearning[i];
        map[currName] = currYearning;
    }
    int numOfPhoto = photo.size();
    for(int i = 0; i < numOfPhoto; i++){
        int tmpAnswer = 0;
        vector<string> currPhoto = photo[i];
        int numOfNames = currPhoto.size();
        for(int j = 0; j < numOfNames; j++){
            if(map.find(currPhoto[j]) != map.end()){
                tmpAnswer += map[currPhoto[j]];
            }
        }
        answer.push_back(tmpAnswer);
    }
    return answer;
}