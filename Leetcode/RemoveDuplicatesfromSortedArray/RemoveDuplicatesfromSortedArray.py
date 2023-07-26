user_input = input("Enter the numbers separated by spaces: ")
nums = list(map(int, user_input.split()))
if (len(nums) == 0):
    print(0)
if (len(nums) == 1):
    print(1)
k=1
for i in range(0, len(nums)-1):
    if (nums[i] != nums[i+1]):
        # if (k == 0):
        #     nums[k] = nums[i]
        #     k = 1
        nums[k] = nums[i+1]
        k = k+1
print(k)
print(nums)