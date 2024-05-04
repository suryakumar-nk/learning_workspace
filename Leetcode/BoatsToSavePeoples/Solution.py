def numRescueBoats(p: list[int], limit: int) -> int:
    p.sort()
    x, l, r = 0, 0, len(p)-1
    while l<=r:
        x+=1
        if p[l]+p[r]<=limit:
            l+=1
        r-=1
    return x


def factorial(num: int) -> int:
    if (num == 1): return 1
    return num*factorial(num-1)

print(factorial(5))
print(numRescueBoats([3,1,3,4,2], 5))