#User function Template for python3

def lenOfLongSubarr(arr, n, k) : 
    #Complete the function
    preSumMap = {}
    Sum = 0
    maxLen = 0
    for i in range(n):
        Sum += arr[i]
        if Sum == k:
            maxLen = max(maxLen, i + 1)
        rem = Sum - k
        if rem in preSumMap:
            length = i - preSumMap[rem]
            maxLen = max(maxLen, length)
        if Sum not in preSumMap:
            preSumMap[Sum] = i
    return maxLen

lenOfLongSubarr([10, 5, 2, 7, 1, 9], 6, 15)
