def sol():
    day = 1

    while trees:
        grow = 1 if day % 2 == 1 else 2

        if max(trees) == target_height:
            trees.pop(trees.index(max(trees)))

        if not trees:
            return day - 1

        if grow == 2:
            if max(trees) == target_height - 2:
                trees[trees.index(max(trees))] += grow
            elif min(trees) <= target_height - 2:
                trees[trees.index(min(trees))] += grow
        elif grow == 1:
            if max(trees) == target_height - 1:
                trees[trees.index(max(trees))] += grow
            elif min(trees) <= target_height - 1 and min(trees) != target_height - 2:
                trees[trees.index(min(trees))] += grow

        day += 1


T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    trees = list(map(int, input().split()))
    target_height = max(trees)

    while trees.count(target_height) > 0:
        trees.pop(trees.index(target_height))

    if not trees:
        print(f"#{test_case} {0}")
        continue

    result = sol()
    print(f"#{test_case} {result}")
