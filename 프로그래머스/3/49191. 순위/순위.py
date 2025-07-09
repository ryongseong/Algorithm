def solution(n, results):
    versus = [[None for _ in range(n)] for _ in range(n)]

    for win, lose in results:
        versus[win-1][lose-1] = True
        versus[lose-1][win-1] = False
    
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if versus[j][i] == None:
                    continue

                if versus[j][i] == versus[i][k]:
                    versus[j][k] = versus[j][i]
                    versus[k][j] = not versus[j][i]

    answer = 0
    for i in range(n):
        if None in versus[i][:i] + versus[i][i+1:]:
            continue
        answer += 1

    return answer