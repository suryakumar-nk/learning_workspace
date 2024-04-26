def plusOne(digits: list[int]) -> list[int]:
    carry = 1
    i = -1
    n = len(digits)
    while(True):
        if (i*(-1) > n):
            break
        val = digits[i]
        val = val+carry
        if (val <= 9):
            carry = 0
            digits[i] = val
            break
        carry = 1
        digits[i] = 0
        i-=1
    if (carry == 1):
        return [1]+digits
    return digits

print(plusOne([9]))
# print(plusOne([9]))