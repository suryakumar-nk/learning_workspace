def firstMissingPositive(nums: list[int]) -> int:
    nums.sort()
    result = 1
    n = len(nums)
    for i in range(0,n):
        if (nums[i] > 0):
            if (nums[i] != result):
                return result
            if (i==(n-1)):
                result+=1
            elif (nums[i] != nums[i+1]):
                result+=1
    return result

print(firstMissingPositive([0,2,2,1,1]))
