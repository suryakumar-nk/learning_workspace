def findDuplicates(nums: list[int]) -> list[int]:
    maps = {}
    result = []
    for i in nums:
        if ((i in maps.keys()) == False):
            maps[i] = 1
        else:
            maps[i] = maps[i]+1
            if (maps[i] > 1):
                result.append(i)
    result.sort()
    return result

print(findDuplicates([4,3,2,7,8,2,3,1]))