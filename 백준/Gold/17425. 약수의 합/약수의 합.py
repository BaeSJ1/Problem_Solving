# python
'''
   # g(N) = f(1) + f(2) + ... + f(N)
   # f[i] 1로 세팅, i=2부터 시작, i*j<=n까지,
'''

MAX = 1000000
f = [1] * (MAX + 1)
g = [0] * (MAX + 1)

for i in range(2, MAX + 1):
    j = 1
    while i * j <= MAX:
        f[i * j] += i
        j += 1

for j in range(1, MAX + 1):
    g[j] = g[j - 1] + f[j]

t = int(input())
sum_val = []

for _ in range(1, t + 1):
    n = int(input())
    sum_val.append(g[n])

print('\n'.join(map(str, sum_val)) + '\n')

print()
