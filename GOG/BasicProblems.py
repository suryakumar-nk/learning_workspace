def armstrongNumber(n):
    # code here 
    N, res = n, 0
    while n > 0:
        temp = n%10
        res += temp*temp*temp
        n = n//10
    return True if N == res else False

armstrongNumber(153)

import math

def isPerfectNumber(N):
    # code here 
    result = 1
    for i in range(2, int(math.sqrt(N))+1):
        if N%i == 0:
            result = result + i + N/i
    return 1 if result == N else 0

isPerfectNumber(1)


def thirdLargest(arr):
        if len(arr) < 3:
            return -1
        a, b, c = -1, -1, -1
        for i in arr:
            # if i == a or i == b or i == c:
            #     continue
            if i > c:
                if i > b:
                    if i > a:
                        a, b, c = i, a, b
                    else:
                        b, c = i, b
                else:
                    c = i
        arr.sort()
        print(arr)
        return c if c != -1 else b if b != -1 else a

print(thirdLargest([2, 2, 2, 855, 450, 132, 359, 233, 825, 604, 481, 262, 337, 720, 525, 652, 300, 906, 219, 926, 906, 293, 864, 817, 498, 30, 639, 661]))


def missingNumber(n, arr):
    for i in range(0, len(arr)-1):
        if arr[i] == arr[i+1]+2:
            return arr[i]+1
    return n

print(missingNumber(6, [1,2,3,5,6]))

def firstRepeated(arr):
        pair = {}
        indexs = set()
        for i, a in enumerate(arr):
            if a in pair:
                indexs.add(pair[a])
            else:           
                pair[a] = i
        return min(indexs)+1 if len(indexs) > 0 else -1

print(firstRepeated([1, 2, 0, 3, 4, 3, 0]))

def sort012(arr,n):
    left, right, mid = -1, n, 0
    while mid < right:
        if arr[mid] == 0:
            arr[left+1], arr[mid] = arr[mid], arr[left+1]
            left+=1
            mid+=1
        elif arr[mid] == 2:
            arr[right-1], arr[mid] = arr[mid], arr[right-1]
            right-=1
        else:
            mid+=1
    return arr

print(sort012([2, 1, 0], 3))


def check(arr1, arr2) -> bool:
    #code here
    if len(arr1) != len(arr2):
        return 'false'
    pair, n, i = {}, len(arr1), 0
    while i < n:
        a, b = arr1[i], arr2[i]
        pair[a] = [1,0] if a not in pair else [pair[a][0]+1, pair[a][1]]
        pair[b] = [0,1] if b not in pair else [pair[b][0], pair[b][1]+1]
        i+=1
    for i in pair:
        if pair[i][0] != pair[i][1]:
            return 'false'
    return 'true'

print(check([1,1,1,2], [2,2,2,1]))

def frequencyCount(arr, N):
    a = {}
    for i in arr:
        if i <= N:
            a[i] = 1 if i not in a else a[i]+1
    for i in range(0, len(arr)):
        if i+1 in a:
            arr[i] = a[i+1]
        else:
            arr[i] = 0
    return arr

print(frequencyCount([2, 3, 2, 3, 5], 5))


def two_sum(arr, x, index, arr_size):
    hashMap = {}
    for i in range(index+1, arr_size):
        if x-arr[i] in hashMap:
            return 1
        hashMap[arr[i]] = 1
    return 0

def three_sum(arr, x):
    n = len(arr)
    for i in range(n):
        if two_sum(arr, x-arr[i], i, n) == 1:
            return 1
    return 0

print(three_sum([1, 2, 3, 4], 7))

def countTriplet(arr, n):
    count ,hashMap = 0, {}
    for i in range(n):
        for j in range(n):
            if j == i:
                continue
            if arr[i]-arr[j] in hashMap:
                count+=1
            hashMap[arr[j]] = 1
        hashMap = {}
    return count

print(countTriplet([1, 5, 3, 2, 7, 6], 6))
print(countTriplet([2,3,4], 3))

print()

def lenOfLongSubarr (arr, n, k) : 
    preSumMap = {}
    Sum = 0
    maxLen = 0
    for i in range(n):
        # calculate the prefix sum till index i:
        Sum += arr[i]

        # if the sum = k, update the maxLen:
        if Sum == k:
            maxLen = max(maxLen, i + 1)

        # calculate the sum of remaining part i.e. x-k:
        rem = Sum - k

        # Calculate the length and update maxLen:
        if rem in preSumMap:
            length = i - preSumMap[rem]
            maxLen = max(maxLen, length)

        # Finally, update the map checking the conditions:
        if Sum not in preSumMap:
            preSumMap[Sum] = i

    return maxLen


# arr = [-1, 0, 2, -1, 1, 0, 3]
# print(lenOfLongSubarr(arr, len(arr), 3))

arr = [10, 5, 2, 7, 1, 9]
print(lenOfLongSubarr(arr, len(arr), 15))