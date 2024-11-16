'''
    # 가장 왼쪽 2칸, 오른쪽 2칸은 0이다. 빌딩은 2 ~ M-2자리에 존재한다.
    # 현재 빌딩 층수와 좌,우 각각 2개의 빌딩의 층수와 비교했을 때,
    현재 빌딩 층수가 좌,우 빌딩의 층수보다 낮으면 조망권은 없다.
    현재 빌딩 층수가 좌,우 빌딩의 층수보다 높으면 조망권이 있다.
    # 현재 빌딩 층수 - 좌, 우 빌딩의 max = 조망권 갯수
'''
tc = 10  # 테스트케이스 갯수
for i in range(1, tc + 1):
    N = int(input())  # 건물의 개수
    buildings = list(map(int, input().split()))  # N개의 건물 높이
    result = 0
    for current in range(2, N-2):
        leftMax = max(buildings[current-1], buildings[current-2])
        rightMax = max(buildings[current+1], buildings[current+2])
        result += max(buildings[current] - max(leftMax, rightMax), 0)

    print(f'#{i} {result}')
