import java.util.*;
class Plan implements Comparable<Plan>{
    String name;
    int time;
    int period;
    public Plan(String name, int time, int period){
        this.name = name;
        this.time = time;
        this.period = period;
    }
    @Override
    public int compareTo(Plan o){
        return this.time - o.time;
    }
}
class Solution {
    public int numOfPlans;
    public PriorityQueue<Plan> planPQ;
    public Stack<Plan> planQ;
    public String[] solution(String[][] plans) {
        numOfPlans = plans.length;
        planPQ = new PriorityQueue<>();
        planQ = new Stack<>();
        for(String[] plan : plans){
            String name = plan[0];
            String timeStr = plan[1];
            String periodStr = plan[2];
            int time = getTime(timeStr);
            int period = Integer.parseInt(periodStr);
            planPQ.add(new Plan(name, time, period));
        }
        int index = 0;
        int currTime = 0;
        String[] answer = new String[numOfPlans];
        while(!planPQ.isEmpty() || !planQ.isEmpty()){
            if(planPQ.isEmpty()){
                while(!planQ.isEmpty()){
                    Plan plan = planQ.pop();
                    answer[index++] = plan.name;
                }
                break;
            }
            Plan nextPlan = planPQ.peek();
            int nextTime = nextPlan.time;
            while(!planQ.isEmpty()){
                if(currTime == nextTime){
                    break;
                }
                Plan plan = planQ.pop();
                if(currTime + plan.period <= nextTime){
                    answer[index++] = plan.name;
                    currTime = currTime + plan.period;
                }
                else{
                    int timeDiff = nextTime - currTime;
                    plan.period = plan.period - timeDiff;
                    planQ.add(plan);
                    break;
                }
            }
            Plan topPlan = planPQ.poll();
            currTime = topPlan.time;
            if(planPQ.isEmpty()){
                answer[index++] = topPlan.name;
                currTime += topPlan.period;
            }
            else{
                int nextTopTime = planPQ.peek().time;
                if(currTime + topPlan.period <= nextTopTime){
                    answer[index++] = topPlan.name;
                    currTime += topPlan.period;
                }
                else{
                    int timeDiff = nextTopTime - currTime;
                    currTime = currTime + timeDiff;
                    topPlan.period = topPlan.period - timeDiff;
                    planQ.push(topPlan);
                }
            }
        }
        return answer;
    }
    public int getTime(String timeStr){
        int time = 0;
        time += (timeStr.charAt(0) - '0') * 10 * 60;
        time += (timeStr.charAt(1) - '0') * 60;
        time += (timeStr.charAt(3) - '0') * 10;
        time += (timeStr.charAt(4) - '0');
        return time;
    }
}