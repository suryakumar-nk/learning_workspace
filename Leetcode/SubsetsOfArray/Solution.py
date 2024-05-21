def subsets(nums: list[int]) -> list[list[int]]:
    result = []
    n = len(nums)
    for i in range(1 << n):
        subArr = []
        for j in range(n):
            if (i & (1 << j) != 0):
                subArr.append(nums[j])
        result.append(subArr)
    return result