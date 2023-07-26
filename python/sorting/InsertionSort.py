def insertionSort(list):
    for i in range(len(list)):
        pos = i
        while pos>0 and list[pos]<list[pos-1]:
            (list[pos],list[pos-1]) = (list[pos-1],list[pos])
            pos = pos-1
    return list
#---------------------------------------------------------------------------------------------------#
def insert(list, pos):
    while pos>0 and list[pos]<list[pos-1]:
        (list[pos],list[pos-1]) = (list[pos-1],list[pos])
        pos = pos-1

def insort(list, k):
    if k>1:
        insort(list, k-1)
        insert(list, k-1)

def insertionSortRecussion(list):
    insort(list, len(list))
    return list

# insertionSortRecussion([4,3,2,1])