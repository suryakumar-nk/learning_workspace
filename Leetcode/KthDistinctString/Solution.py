def kth_distinct(arr: list[str], k: int) -> str:
    count = {}
    for s in arr:
        if s in count:
            count[s] = count[s] + 1
        else:
            count[s] = 1
    for s in arr:
        if count[s] == 1:
            k -= 1
            if k == 0:
                return s
    return ""


print(kth_distinct(["d", "b", "c", "b", "c", "a"], 2))