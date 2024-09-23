def fourSum(arr: list[int], target: int) -> list[list[int]]:
    values=[]
    results=[]
    n=len(arr)
    for i in range(0, n):
        values.append(arr[i])
        for j in range(i+1, n):
            values.append(arr[j])
            hashMap = {}
            for k in range(j+1, n):
                if target-arr[k]-arr[j]-arr[i] in hashMap:
                    values.append(arr[k])
                    values.append(target-arr[k]-arr[j]-arr[i])
                    val = values.copy()
                    val.sort()
                    if val not in results:
                        results.append(val)
                    values = values[:-2]
                hashMap[arr[k]] = 1
            values = values[:-1]
        values = values[:-1]
    print(results)

a = [1,0,-1,0,-2,2]
fourSum(a, 0)
a = [2,2,2,2,2]
fourSum(a, 8)


# class Solution:
#     values = []
#     results = []
#     def two_sum(self, arr, target, s, n):
#         hashMap = {}
#         for i in range(s, n):
#             if target-arr[i] in hashMap:
#                 self.values.append(arr[i])
#                 self.values.append(target-arr[i])
#                 self.results.append(self.values)
#                 self.values = self.values[:-2]
#             hashMap[arr[i]] = 1

#     def n_sum(self, arr, target, nsum, s, n):
#         for i in range(s, n):
#             self.values.append(arr[i])
#             if nsum == 3:
#                 self.two_sum(arr, target-arr[i], i+1, n)
#             else:
#                 self.n_sum(arr, target-arr[i], nsum-1, i+1, n)
#             self.values = self.values[:-1]

#     def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
#         self.n_sum(nums, target, 4, 0, len(nums))
#         res = self.results.copy()
#         self.values.clear()
#         self.results.clear()
#         return res