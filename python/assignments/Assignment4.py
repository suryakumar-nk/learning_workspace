def rainaverage(list):
    dic = {}
    for rain in list:
        if rain[0] in dic.keys():
            dic[rain[0]] = (dic[rain[0]][0]+rain[1], dic[rain[0]][1]+1)
        else:
            dic[rain[0]] = (rain[1], 1)
    tup = []
    for key in sorted(dic.keys()):
        val = dic[key][0]/dic[key][1]
        tup.append((key, val))
    return tup

def flatten(arr):
    newList = []
    for i in arr:
        if type(i) == list:
            newList = newList + flatten(i)
        else:
            newList.append(i)
    return newList