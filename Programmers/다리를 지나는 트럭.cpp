#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int numOfTruck = truck_weights.size();
    queue<int> expireTimeQueue;
    queue<int> weightQueue;
    int index = 0;
    int currTime = 1;
    int remainWeight = weight;
    while(index < numOfTruck){
        if(!expireTimeQueue.empty() && expireTimeQueue.front() == currTime){
            expireTimeQueue.pop();
            int removeWeight = weightQueue.front();
            weightQueue.pop();
            remainWeight = remainWeight + removeWeight;
        }
        int currTruck = truck_weights[index];
        if(remainWeight >= currTruck){
            remainWeight = remainWeight - currTruck;
            weightQueue.push(currTruck);
            expireTimeQueue.push(currTime + bridge_length);
            index++;
            currTime++;
        }
        else{
            currTime = expireTimeQueue.front();
        }
    }
    while(!expireTimeQueue.empty()){
        currTime = expireTimeQueue.front();
        expireTimeQueue.pop();
    }
    answer = currTime;
    return answer;
}