def solution(friends, gifts):
    answer = [0] * len(friends)
    gift_table = [[0] * len(friends) for _ in range(len(friends))]

    gift_index = [0] * len(friends)
    for gift in gifts:
        give, take = gift.split()
        give_idx = friends.index(give)
        take_idx = friends.index(take)
        gift_index[give_idx] += 1
        gift_index[take_idx] -= 1
        gift_table[give_idx][take_idx] += 1

    for i in range(len(friends)):
        for j in range(i+1, len(friends)):
            if gift_table[i][j] > gift_table[j][i]:
                answer[i] += 1
            elif gift_table[i][j] < gift_table[j][i]:
                answer[j] += 1
            else:
                if gift_index[i] > gift_index[j]:
                    answer[i] += 1
                elif gift_index[i] < gift_index[j]:
                    answer[j] += 1

    return max(answer)