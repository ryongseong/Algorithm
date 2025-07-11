def best_cow_line(s):
    left, right = 0, len(s) - 1
    result = []

    while left <= right:
        if s[left] < s[right]:
            result.append(s[left])
            left += 1
        elif s[left] > s[right]:
            result.append(s[right])
            right -= 1
        else:
            l, r = left, right
            while l < r and s[l] == s[r]:
                l += 1
                r -= 1
            if l >= r or s[l] <= s[r]:
                result.append(s[left])
                left += 1
            else:
                result.append(s[right])
                right -= 1
    return "".join(result)


T = int(input())

for tc in range(1, T + 1):
    s = input().strip()
    print(f"#{tc} {best_cow_line(s)}")
