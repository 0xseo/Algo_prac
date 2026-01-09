def solution(dirs):
    verRoads = set()
    horRoads = set()
    posX = 5
    posY = 5
    
    for dir in dirs:
        if dir == "U":
            if (posY == 10): continue
            verRoads.add((posX, posY))
            posY += 1
        elif dir == "D":
            if (posY == 0): continue
            verRoads.add((posX, posY-1))
            posY -= 1
        elif dir == "L":
            if (posX == 0): continue
            horRoads.add((posX-1, posY))
            posX -= 1
        elif dir == "R":
            if (posX == 10): continue
            horRoads.add((posX, posY))
            posX += 1
    answer = len(verRoads) + len(horRoads)
    return answer