def mergeSort(arr):
    length = len(arr)
    if (length > 1):
        leftArr = mergeSort(arr[:length//2])
        rightArr = mergeSort(arr[length//2:])
        
        i = j =  0
        l = len(leftArr)
        r = len(rightArr)
        arr = []

        while ((i+j)<(l+r)):
            if leftArr[i] < rightArr[j]:
                arr.append(leftArr[i])
                i = i+1
            if leftArr[i] > rightArr[j]:
                arr.append(rightArr[j])
                j = j+1
            if i == l:
                arr = arr + rightArr[j:]
                j = r
            if j == r:
                arr = arr + leftArr[i:]
                i = l
        return arr
    return arr
            
