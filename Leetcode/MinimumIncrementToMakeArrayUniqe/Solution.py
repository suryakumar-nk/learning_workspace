def min_increment_for_unique(nums: list[int]) -> int:
    nums.sort()
    n = len(nums)
    moves = 0
    for i in range(1, n):
        if nums[i] <= nums[i - 1]:
            moves += abs(nums[i] - nums[i - 1]) + 1
            nums[i] += abs(nums[i] - nums[i - 1]) + 1
    return moves


print(min_increment_for_unique([3,2,1,2,1,7]))
