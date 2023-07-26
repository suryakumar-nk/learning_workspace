def remdup(list):
    i = 0
    while i<len(list):
        print(list[i])
        if list.count(list[i])>1:
            list.remove(list[i])
            continue
        i = i+1
    return list

def splitsum(list):
    pos = 0
    neg = 0
    for i in list:
        if i<0:
            neg = neg + (i*i*i)
        else:
            pos = pos + (i*i)
    return [pos,neg]

def matrixflip(matrix, d):
    m2 = []
    if d=='h':
        for i in range(len(matrix)):
            arr = matrix[i]
            arr2 = []
            for j in range(len(arr)):
                arr2.append(arr[len(arr)-j-1])
            m2.append(arr2)
        return m2
    if d=='v':
        for i in range(len(matrix)):
            m2.append(matrix[len(matrix)-i-1])
        return m2
