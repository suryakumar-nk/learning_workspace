def merge(intervals: list[list[int]]) -> list[list[int]]:
    intervals.sort()
    result = [intervals[0]]
    n = len(intervals)
    for i in range(1, n):
        if result[-1][1] >= intervals[i][0]:
            if result[-1][1] >= intervals[i][1]:
                continue
            result[-1] = [result[-1][0], intervals[i][1]]
        else:
            result.append(intervals[i])
    return result


print(merge([[1,3], [2,6], [8,10], [15,18]]))
