class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        # if (numCourses < (len(prerequisites)*2)):
        #     return False
        pairs = {}
        total = {}
        for arr in prerequisites:
            total[arr[0]] = ''
            total[arr[1]] = ''
            if (arr[0] == arr[1]):
                return False
            if (pairs.get(arr[0]) != None):
                pairs.get(arr[0]).append(arr[1])
            else:
                pairs[arr[0]] = [arr[1]]
        if (numCourses < len(total)):
            return False
        
        for i in pairs.keys():
            temp = Solution.checkCyclic(Solution, pairs, i, [], i)
            if (temp == True):
                return False
        return True
            
    
    def checkCyclic(self, pairs: dict, key: int, processedKeys: list[int], rootKey: int) -> bool:
        if (processedKeys.count(key) > 0 and key == rootKey):
            return True
        values = pairs.get(key)
        if (values == None):
            return False
        processedKeys.append(key)
        for i in values:
            temp = Solution.checkCyclic(Solution, pairs, i, processedKeys, rootKey)
            if (temp == True):
                return True
        return False

# print(Solution.canFinish(Solution, 2, [[1,0],[0,1]]))
print(Solution.canFinish(Solution, 3, [[1,0],[2,0],[0,2]]))