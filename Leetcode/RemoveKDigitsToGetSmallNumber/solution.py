def removeKdigits(num: str, k: int) -> str:
    result = []
    size = 0
    for i in num:
        n = int(i)
        if (size!=0):
            if ((result[size-1] > n) and k!=0):
                result[size-1] = n
                k-=1
                continue
        result.append(n)
        size+=1
    if (k>0):
        n = result[0:(size-k)]
        m = result[k:]
        if (sum(n)>sum(m)):
            result = m
        else:
            result = n
    a = ''
    for j in result:
        if (j==0 and a==''):
            continue
        a+=str(j)
    if (a == ''):
        a = '0'
    return a

print(removeKdigits('1234567890', 9))