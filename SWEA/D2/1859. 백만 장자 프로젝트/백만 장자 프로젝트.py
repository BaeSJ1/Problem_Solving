T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    price = list(map(int, input().split()))
    
    max_price = 0
    profit = 0
    for i in range(N-1,-1,-1):
        if price[i]>max_price:
            max_price = price[i]
        else:
            profit += max_price - price[i]
    print(f"#{test_case} {profit}")
    
