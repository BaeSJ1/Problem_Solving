#python
# 1+2+3+4 = 10
# 1+2+3+5 = 11
# 1+2+4+5 = 12
s = int(input())
count = 0
sum = 0

while s >= sum:
    count += 1
    sum += count

print(count - 1)