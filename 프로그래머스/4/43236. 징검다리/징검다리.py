def solution(distance, rocks, n):
    rocks.sort()

    left, right = 0, distance
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        count = 0
        prev = 0

        for rock in rocks:
            if rock - prev < mid:
                count += 1
            else:
                prev = rock

        if distance - prev < mid:
            count += 1

        if count > n:
            right = mid - 1
        else:
            answer = mid
            left = mid + 1
    return answer