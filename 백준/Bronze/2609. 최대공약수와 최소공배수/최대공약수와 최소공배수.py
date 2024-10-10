# python

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)
    
x, y = map(int, input().split())

g = gcd(x, y)
lcm = x*y//g

print(g)
print(lcm)
