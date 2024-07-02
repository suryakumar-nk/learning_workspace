def jump(nums: list[int]) -> int:
    start, end, jumps = 0, 0, 0
    while end < len(nums) - 1:
        last = 0
        for i in range(start, end + 1):
            last = max(last, i + nums[i])
        start = end + 1
        end = last
        jumps += 1
    return jumps


print(jump([2, 3, 0, 1, 4]))
