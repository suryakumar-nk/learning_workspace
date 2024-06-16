def min_patches(nums: list[int], n: int) -> int:
    # def sub_sets_sum() -> list[int]:
    #     result = [-1]*(n+1)
    #     s = len(nums)
    #     for i in range(1 << s):
    #         sub_arr = []
    #         for j in range(n):
    #             if i & (1 << j) != 0:
    #                 sub_arr.append(nums[j])
    #         print(sub_arr)
    #         val = sum(sub_arr)
    #         if 0 < val <= n:
    #             print(val)
    #             result[val] = sub_arr
    #     return result
    #
    # if n == 1 and len(nums) == 0:
    #     return 1
    # count = 0
    # added_nums = []
    # while True:
    #     sub_sum = sub_sets_sum()
    #     if sub_sum[1:].count(-1) == 0:
    #         return count
    #     flag = 0
    #     for i in range(1, n+1):
    #         if sub_sum[i] == -1:
    #             nums.append(i)
    #             nums.sort()
    #             added_nums.append(i)
    #             count += 1
    #             flag = 1
    #             break
    #     if flag == 0:
    #         return count

    count, i, miss = 0, 0, 1
    while miss <= n:
        if i < len(nums) and nums[i] <= miss:
            miss += nums[i]
            i += 1
        else:
            miss += miss
            count += 1
    return count


print(min_patches([1], 10))
