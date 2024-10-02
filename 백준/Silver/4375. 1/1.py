# python

'''
    1 % 7 = 1
    11 % 7 = (1 * 10 +1) % 7
    11111 % 7 = (1111 * 10 + 1) % 7 = ((1111 % 7) * 10 + 1) % 7
'''
while True:
    try:
        n = int(input())
    except:
        break

    num = 0
    i = 1
    while True:
        num = (num % n * 10 + 1) % n  # num은 1부터 11,111,1111 계속 커지는 역할
        if num == 0:
            print(i)
            break
        else:
            i += 1
