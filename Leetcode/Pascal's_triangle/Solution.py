def generate(numRows: int) -> list[list[int]]:
    if (numRows == 1): return [[1]]
    if (numRows == 2): return [[1], [1,1]]
    arr = [[1], [1,1]]
    for i in range(1, numRows-1):
        new = [1]
        for j in range(1, i+1):
            new.append(arr[i][j-1] + arr[i][j])
        new.append(1)
        arr.append(new)
    return arr

print(generate(5))