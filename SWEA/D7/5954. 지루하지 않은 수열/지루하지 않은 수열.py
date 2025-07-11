def is_non_boring(seq):
    prev = [-1] * n
    nxt = [n] * n

    last = {}
    for i, x in enumerate(seq):
        prev[i] = last.get(x, -1)
        last[x] = i
    last.clear()
    for i in range(n - 1, -1, -1):
        nxt[i] = last.get(seq[i], n)
        last[seq[i]] = i

    stack = [(0, n - 1)]
    while stack:
        l, r = stack.pop()
        if l >= r:
            continue

        i, j = l, r
        found = False
        while i <= j:
            if prev[i] < l and nxt[i] > r:
                stack.append((l, i - 1))
                stack.append((i + 1, r))
                found = True
                break
            if prev[j] < l and nxt[j] > r:
                stack.append((l, j - 1))
                stack.append((j + 1, r))
                found = True
                break
            i += 1
            j -= 1
        if not found:
            return False
    return True


T = int(input())
for t in range(1, T + 1):
    n = int(input())
    seq = list(map(int, input().split()))
    result = 1 if is_non_boring(seq) else 0
    print(f"#{t} {result}")
