from heapq import heappop, heappush

def kthSmallestPrimeFraction(arr: list[int], k: int) -> list[int]:
    minHeap = []
    n = len(arr)
    for i in range(n):
        for j in range(i + 1, n):
            heappush(minHeap, (arr[i] / arr[j], (arr[i], arr[j])))
    for _ in range(k):
        a, b = heappop(minHeap)[1]
    return [a, b]

print(kthSmallestPrimeFraction([1,2,3,5], 3))