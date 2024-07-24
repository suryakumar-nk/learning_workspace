def sort_jumbled(mapping: list[int], nums: list[int]) -> list[int]:
    my_array = []
    for i in nums:
        val, x = 0, 1
        for j in str(i):
            val = val * x + mapping[int(j)]
            x = x*10 if val > 0 else x
        my_array.append(val)
    n = len(my_array)
    print(my_array)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if my_array[j] > my_array[j + 1]:
                my_array[j], my_array[j + 1] = my_array[j + 1], my_array[j]
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
    return nums


def sort_jumbled_lambda(mapping: list[int], nums: list[int]) -> list[int]:
    my_array = []
    for i, n in enumerate(nums):
        val, x = 0, 1
        for j in str(n):
            val = val * x + mapping[int(j)]
            x = x * 10 if val > 0 else x
        my_array.append((n, val, i))
    my_array.sort(key=lambda x: (x[1], x[2]))
    sorted_nums = [t[0] for t in my_array]
    return sorted_nums
print(sort_jumbled([7,9,4,1,0,3,8,6,2,5], [47799,19021,162535,454,95,51890378,404]))