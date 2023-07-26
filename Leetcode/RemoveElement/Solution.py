user_input = input("Enter the numbers separated by spaces: ")
nums = list(map(int, user_input.split()))
target = int(input("Enter the Targer: "))
if (len(nums) == 0):
    print(0)
# if (len(nums) == 1 and nums[0] == target):
#     print(1)
# else:
#     print(0)
k = 0
i = 0
while (i < len(nums)):
    if (nums[i] != target):
        if (k<i):
            nums[k] = nums[i]
            nums[i] = target
            i = k
        k = k+1
    i = i+1
print(nums)
print(k)