class Solution
{
    public int solution(int n, int a, int b)
    {
        int result = 0;
        for(int i = 0; a != b; i++){
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            result++;
        }
        return result;
    }
}