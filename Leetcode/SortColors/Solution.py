def sort_colors(nums: list[int]) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    freq = [0, 0, 0]
    for i in nums:
        freq[i] += 1
    count = 0
    for x in range(3):
        nums[count: count + freq[x]] = [x] * freq[x]
        count += freq[x]
    print(nums)


print(sort_colors([2, 0, 2, 1, 1, 0, 1, 2, 0, 0, 2, 1, 1, 0, 2, 1]))
