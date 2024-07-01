def can_jump(nums: list[int]) -> bool:
    if len(nums) == 1:
        return True
    steps, n = nums[0], len(nums)
    if steps == 0:
        return False
    for i in range(1, n):
        steps -= 1
        if i == (n - 1):
            return True
        if steps == 0 and nums[i] == 0:
            return False
        steps = nums[i] if nums[i] > steps else steps


print(can_jump([3, 0, 1, 2, 4]))