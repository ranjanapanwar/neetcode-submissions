class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> temp = new Stack<>();
        int n = temperatures.length;
        int[] output = new int[n];

        for(int i = 0; i < temperatures.length; i++){
            while((!temp.isEmpty() && temp.peek()[0] < temperatures[i])){
                output[temp.peek()[1]] = i - temp.peek()[1];
                temp.pop();
            }
            temp.push(new int[]{temperatures[i], i});
        }

        return output;
    }
}
