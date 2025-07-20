def solution(n, w, num):
    h = (n + w - 1) // w

    matrix = [[0] * h for _ in range(w)]

    box_num = 1
    for r in range(h):
        if r % 2 == 0:
            for c in range(w):
                if box_num <= n:
                    matrix[c][r] = box_num
                    box_num += 1
        else:
            for c in range(w-1, -1, -1):
                if box_num <= n:
                    matrix[c][r] = box_num
                    box_num += 1

    for c in range(w):
        for r in range(h):
            if matrix[c][r] == num:
                cnt = 0
                for i in range(r, h):
                    if matrix[c][i] != 0:
                        cnt += 1
                return cnt