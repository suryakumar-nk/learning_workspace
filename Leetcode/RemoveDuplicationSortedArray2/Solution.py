def remove_duplicates(nums: list[int]) -> int:
    i, min_pos, n = 1, 1, len(nums)
    num_count = (nums[0], 1)
    while i < n:
        if nums[i] == num_count[0]:
            if num_count[1] == 1:
                num_count = (nums[i], 2)
                nums[min_pos] = nums[i]
                min_pos += 1
        else:
            nums[min_pos] = nums[i]
            num_count = (nums[i], 1)
            min_pos += 1
        i += 1
    return min_pos


def remove_duplicate(nums: list[int]) -> int:
    i = 0
    while i < len(nums) - 2:
        if nums[i] == nums[i + 1] and nums[i] == nums[i + 2]:
            nums.pop(i + 2)
        else:
            i += 1
    return len(nums)


# print(remove_duplicates([0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5]))
print(remove_duplicate([0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5]))
