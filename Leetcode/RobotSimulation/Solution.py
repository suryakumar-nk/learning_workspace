def robotSim(commands: list[int], obstacles: list[list[int]]) -> int:
    direction = 0
    max_dis = 0
    cord = [0,0]
    for i in commands:
        if i == -1:
            direction = 0 if direction == 3 else direction+1
        elif i == -2:
            direction = 3 if direction == 0 else direction-1
        else:
            for s in range(0, i):
                if direction == 0:
                    if [cord[0], cord[1]+1] in obstacles:
                        break
                    cord = [cord[0], cord[1]+1]
                elif direction == 1:
                    if [cord[0]+1, cord[1]] in obstacles:
                        break
                    cord = [cord[0]+1, cord[1]]
                elif direction == 2:
                    if [cord[0], cord[1]-1] in obstacles:
                        break
                    cord = [cord[0], cord[1]-1]
                else:
                    if [cord[0]-1, cord[1]] in obstacles:
                        break
                    cord = [cord[0]-1, cord[1]]
                max_dis = max(max_dis, cord[0]**2 + cord[1]**2)
    return max_dis

print(robotSim([6,-2,4,-1], [[-3,6],[-2,8]]))