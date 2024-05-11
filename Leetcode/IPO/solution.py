# PROBLEM NO 502
# from heapq import heappush, heappop
import heapq

def findMaximizedCapital(k: int, w: int, profits: list[int], capital: list[int]) -> int:
    n = len(profits)
    projects = [(capital[i], profits[i]) for i in range(n)]
    i = 0
    projects.sort()
    maxCap = []
    while(k>0):
        while(i<n and projects[i][0]<=w):
            heapq.heappush(maxCap, -projects[i][1])
            i+=1
        if (len(maxCap) == 0):
            break
        w+=(-1*heapq.heappop(maxCap))
        k-=1
    return w

# print(findMaximizedCapital(2, 2, [1,2,4,3], [0,1,1,3]))
print(findMaximizedCapital(2,0,[1,2,3],[0,1,1]))

