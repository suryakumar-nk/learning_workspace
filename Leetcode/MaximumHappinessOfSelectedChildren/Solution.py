def maximumHappinessSum(happiness: list[int], k: int) -> int:
    happiness.sort(reverse=True)
    result = 0
    dec = 0
    for i in range(0, k):
        val = happiness[i]
        if ((val-dec) <= 0): break
        result = result + val - dec
        dec+=1
    return result

print(maximumHappinessSum([1,2,3], 2))