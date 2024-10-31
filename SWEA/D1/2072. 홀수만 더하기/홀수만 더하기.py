T = int(input())
for test_case in range(1, T+1):
    data = list(map(int, input().split()))
    sum = 0
    for i in range(len(data)):
        if data[i] % 2 != 0:
            sum += data[i]
        else:
            continue
    print(f"#{test_case} {sum}")