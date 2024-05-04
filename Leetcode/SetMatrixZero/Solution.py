def setZeroes(matrix: list[list[int]]) -> None:
    """
    Do not return anything, modify matrix in-place instead.
    """
    
    rows = set()
    columns = set()
    m, n = len(matrix), len(matrix[0])

    for arr in enumerate(matrix):
        for a in enumerate(arr[1]):
            if (a[1] == 0):
                rows.add(arr[0])
                columns.add(a[0])
    for i in rows:
        matrix[i] = [0]*n
    for i in columns:
        for j in range(0,m):
            matrix[j][i] = 0

a = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
setZeroes(a)
print(a)