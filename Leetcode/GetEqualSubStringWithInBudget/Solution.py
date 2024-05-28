def equalSubstring(s: str, t: str, maxCost: int) -> int:
    count = 0
    start = 0
    n = len(s)
    for i in range(n):
        maxCost -= abs(ord(s[i])-ord(t[i]))
        while(maxCost<0):
            maxCost += abs(ord(s[start])-ord(t[start]))
            start+=1
        count = max(count, i-start+1)
    return count

print(equalSubstring("abrcd","ncjde",2))