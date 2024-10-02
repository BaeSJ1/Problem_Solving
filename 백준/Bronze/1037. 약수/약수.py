# python

'''
    n의 진짜 약수는 n의 약수 중에서 1과 n을 제외한 것
    약수의 가장 작은 수 * 가장 큰 수 = n
'''

count = int(input())
num = list(map(int, input().split()))

min_val = min(num)
max_val = max(num)

n = min_val * max_val
print(n)