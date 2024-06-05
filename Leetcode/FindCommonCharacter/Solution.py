def commonChars(words: list[str]) -> list[str]:
    results = list(words[0])
    n = len(words)
    if n == 1: return results
    faa = []
    resLen = len(results)
    for r in range(0, resLen):
        count = 0
        for i in range(1,n):
            wl = len(words[i])
            for c in range(0, wl):
                if (words[i][c] == results[r]):
                    words[i] = words[i][0:c]+words[i][c+1:]
                    break
            if (wl > len(words[i])):
                count += 1
            else:
                count = -1
                break
        if (count == (n-1)):
            faa.append(results[r])
    return faa

print(commonChars(["panda","lock","cook"]))