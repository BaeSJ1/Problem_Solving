# python

A, B, C = map(int, input().split())

mod1 = (A + B) % C
mod2 = ((A % C) + (B % C)) % C
mod3 = (A * B) % C
mod4 = ((A % C) * (B % C)) % C

print(mod1)
print(mod2)
print(mod3)
print(mod4)
