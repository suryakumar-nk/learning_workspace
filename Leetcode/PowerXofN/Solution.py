def my_pow(x: float, n: int) -> float:
    nn = n
    if n < 0:
        nn = -1 * n
    if n == 0:
        return 1.0
    ans = 1.0
    while nn > 0:
        if nn % 2 == 1:
            ans = ans * x
            nn -= 1
        else:
            x = x * x
            nn /= 2
    return ans if n > 0 else 1 / ans


print(my_pow(2.0, -11))
