class Solution {
    public long[] solution(int x, int n) {
        long result = 0;
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            result += x;
            arr[i] = result;
        }
        return arr;
    }
}