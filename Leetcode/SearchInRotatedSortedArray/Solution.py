def search(nums: list[int], target: int) -> int:
    # n = len(nums)
    # b = nums.index(min(nums))
    # nums = nums[b:]+nums[:b]
    # start = 0
    # end = n
    # mid = 0
    # while (start < end): 
    #     mid = (end+start)//2
    #     if (nums[mid] == target):
    #         return ((mid+b)%n)     
    #     if (target < nums[mid]):
    #         if (nums[mid-1] == target):
    #             return (mid-1+b)%n
    #         else:
    #             end = mid-1
    #     else:
    #         start = mid+1
    #         if (nums[start] == target):
    #             return (start+b)%n       
    # return -1
    try:
        n = nums.index(target)
        return n
    except:
        return -1

print(search([4,5,6,7,0,1,2], 7))
