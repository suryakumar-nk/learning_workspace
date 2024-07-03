def min_difference(nums: list[int]) -> int:
    if len(nums) <= 4:
        return 0
    nums.sort()
    result = nums[-1] - nums[0]
    for i in range(4):
        result = min(result, nums[-(4 - i)] - nums[i])
    return result


print(min_difference([1, 5, 0, 2, 10, 14, 5, 6, 75, 76, 32, 66]))
