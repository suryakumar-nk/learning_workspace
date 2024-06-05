def rotate(arr: list[list[int]]) -> None:
    """
    Do not return anything, modify matrix in-place instead.
    """
    n = len(arr)
    print(n)
    print(n//2)
    print(n//2+1)
    for i in range(n//2+1):
        for j in range(i, n-1-i):
            arr[i][j], arr[j][n-1-i], arr[n-1-i][n-1-i], arr[n-i-1][j] = arr[n-i-1][j], arr[i][j], arr[j][n-1-i], arr[n-1-i][n-1-i]
    print(arr)

print(rotate([[1,2,3],[4,5,6],[7,8,9]]))