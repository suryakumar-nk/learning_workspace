def topKFrequent(nums: list[int], k: int) -> list[int]:
    results = [0]*k
    for i in nums:
        n = k-1
        if (results[n] < i):
            results[n] = i
        else:
            continue
        m = k-1
        if (n%2 == 0):
            m=(n-2)//2
        else:
            m=(n-1)//2
        while(m >= 0):
            if (results[m] < results[n]):
                results[m], results[n] = results[n], results[m]
            else:
                break
            n=m
            if (n%2 == 0):
                m=(n-2)//2
            else:
                m=(n-1)//2
    return results

print(topKFrequent([1,1,4,2,2,3], 3))