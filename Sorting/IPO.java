import java.util.*;
/*
*LeetCode Problem: 502. IPO

Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to 
increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the
 best way to maximize its total capital after finishing at most k distinct projects.
You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
The answer is guaranteed to fit in a 32-bit signed integer.
*/

public class IPO{
    public static int maxCap(int k, int w, int[]profits, int[]capital){
        int[][]projects=new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            projects[i][0]=capital[i];
            projects[i][1]=profits[i];
        }
        Arrays.sort(projects,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);

        for(int i=0;i<profits.length && k>0; i++){
            while(projects[i][0]<=w){
                pq.offer(projects[i][1]);
                i++;
            }if(!pq.isEmpty()){
                w+=pq.poll();
                k--;
            }else{break;};
        }return w;
    }

    public static void main(String[] args) {
        int k=2;
        int w=0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};

        System.out.println("Maximum Capital after " + k + " projects: " + 
        maxCap(k, w, profits, capital));
    }
}
