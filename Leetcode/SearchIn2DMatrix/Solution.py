def search_matrix(matrix: list[list[int]], target: int) -> bool:
    start = 0
    end = len(matrix)-1
    mid = 0
    while start < end:
        mid = (start + end)//2
        if target == matrix[mid][0]:
            return True
        if target < matrix[mid][0]:
            end = mid-1
            mid = end
        else:
            start = mid+1
            if target < matrix[start][0]:
                break
            mid = start
    matrix = matrix[mid]
    start = 0
    end = len(matrix)-1
    while start <= end:
        mid = (start + end)//2
        if target == matrix[mid]:
            return True
        if target < matrix[mid]:
            end = mid-1
        else:
            start = mid+1
    return False


print(search_matrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 60))
