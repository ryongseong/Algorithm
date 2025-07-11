def comb2(n):
    if n < 2:
        return 0
    return n * (n - 1) // 2


def f(t, L):
    if t < L:
        return 0
    n = t - L + 2
    return comb2(n)


T = int(input())
results = []
for _ in range(T):
    A, B, C, K = map(int, input().split())
    ans = 0
    for t in range(K + 1):
        U1 = (B + C + t - A - 1) // 2
        U2 = (A + C + t - B - 1) // 2
        U3 = (A + B + t - C - 1) // 2
        if U1 < 0 or U2 < 0 or U3 < 0:
            continue

        total = comb2(t + 2)
        sub = f(t, U1 + 1) + f(t, U2 + 1) + f(t, U3 + 1)
        add = (
            f(t, (U1 + 1) + (U2 + 1))
            + f(t, (U1 + 1) + (U3 + 1))
            + f(t, (U2 + 1) + (U3 + 1))
        )
        sub2 = f(t, (U1 + 1) + (U2 + 1) + (U3 + 1))
        F_t = total - sub + add - sub2
        ans += F_t
    print(ans)
