# python

'''
    알고리즘 개요: 에라토스테네스의 체
    에라토스테네스의 체는 소수를 효율적으로 찾기 위한 알고리즘입니다. 소수는 자기 자신과 1 외에는 나누어 떨어지지 않는 수입니다. 이 방법은 다음 단계로 이루어집니다:

    1.  2부터 시작하여 각 수가 소수인지 확인합니다.
    2. 소수라면 그 수의 배수를 모두 지워나갑니다. (배수는 소수가 될 수 없기 때문에)
    3. 최종적으로 남은 수들이 소수입니다.
'''

MAX = 1000000
check = [0] * (MAX + 1)
check[0] = check[1] = True  # 지우기

for i in range(2, MAX + 1):
    if not check[i]:  # 지워지지 않았으면
        j = i + i
        while j <= MAX:
            check[j] = True  # 지우기
            j += i

m, n = map(int, input().split())
for i in range(m, n + 1):
    if check[i] == False: # 지워지지 않았으면
        print(i)
