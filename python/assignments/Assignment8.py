def diffrence(a,b):
    if a>b:
        return a-b
    else:
        return b-a
    
def mindis(fr,to):
    x = diffrence(fr[0], to[0])
    y = diffrence(fr[1], to[1])
    return x+y

line = input().split()
R = int(line[0])
C = int(line[1])
K = int(line[2])
D = int(line[3])
DC = []
for i in range(0,D):
    val = input().split()
    DC.append((int(val[0]), int(val[1])))
DC.sort()
TOTOL_DISTANCE = 0
fr = (0,0)
dragons_can_leave = D-K
dragons_leaved = 0
while(K>0):
    min_distance = R+C
    dragon_cord = (0,0)
    for cord in DC:
        dis = mindis(fr, cord)
        if (dragons_leaved <= dragons_can_leave):
            if ((dis < min_distance) and ((DC.index(cord)+dragons_leaved) <= dragons_can_leave)):
                min_distance = dis
                dragon_cord = cord
                dragons_leaved = dragons_leaved + DC.index(cord)
        else:
            dragon_cord = cord
            min_distance = dis
            break
    TOTOL_DISTANCE = TOTOL_DISTANCE + min_distance
    K = K-1
    DC = DC[DC.index(dragon_cord)+1:]
    fr = dragon_cord
print(TOTOL_DISTANCE, end='')