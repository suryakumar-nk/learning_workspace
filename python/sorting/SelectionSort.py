def selectionSort(list):
    for i in range(len(list)):
        pos = i
        for j in range(i+1, len(list)):
            if list[j]<list[pos]:
                pos = j
        (list[i],list[pos]) = (list[pos],list[i])
    return list
    