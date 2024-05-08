def findRelativeRanks(score: list[int]) -> list[str]:
    # gold, goldIndex = -1, -1
    # silver, silverIndex = -1, -1
    # bronze, bronzeIndex = -1, -1
    # for i in enumerate(score):
    #     index, value = i[0], i[1]
    #     if (index == 0):
    #         gold, goldIndex = value, index
    #         continue
    #     if (index == 1):
    #         if (value > gold):
    #             silver, silverIndex = gold, goldIndex
    #             gold, goldIndex = value, index
    #         else:
    #             silver, silverIndex = value, index
    #         continue
    #     if (index == 2):
    #         if (value > gold):
    #             bronze, bronzeIndex = silver, silverIndex
    #             silver, silverIndex = gold, goldIndex
    #             gold, goldIndex = value, index
    #         elif (value > silver):
    #             bronze, bronzeIndex = silver, silverIndex
    #             silver, silverIndex = value, index
    #         else:
    #             bronze, bronzeIndex = value, index
    #         continue
    #     if (value < bronze):
    #         score[index] = str(value)
    #         continue
    #     score[bronzeIndex] = str(bronze)
    #     if (value > gold):
    #         bronze, bronzeIndex = silver, silverIndex
    #         silver, silverIndex = gold, goldIndex
    #         gold, goldIndex = value, index
    #     elif (value > silver):
    #         bronze, bronzeIndex = silver, silverIndex
    #         silver, silverIndex = value, index
    #     else:
    #         bronze, bronzeIndex = value, index
    # score[bronzeIndex] = "Bronze Medal"
    # score[silverIndex] = "Silver Medal"
    # score[goldIndex] = "Gold Medal"
    # return score
    sorted = []
    for i,v in enumerate(score):
        j = 0
        for res in sorted:
            if (res[0] < v):
                break
            j+=1
        sorted = sorted[0:j]+[(v,i)]+sorted[j:]
    for i,v in enumerate(sorted):
        if (i == 0):
            score[v[1]] = "Gold Medal"
            continue
        if (i == 1):
            score[v[1]] = "Silver Medal"
            continue
        if (i == 2):
            score[v[1]] = "Bronze Medal"
            continue
        score[v[1]] = str(i+1)
    return score

print(findRelativeRanks([4,5,1,3,2,8,6,9,11,7]))
print(findRelativeRanks([10,3,8,9,4]))