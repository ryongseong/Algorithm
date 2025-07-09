from itertools import permutations


def solution(user_id, banned_id):
    answer = []
    for permute in list(permutations(user_id, len(banned_id))):
        flag = True
        for i in range(len(banned_id)):
            if not (check(permute[i], banned_id[i])):
                flag = False

        if flag:
            if set(permute) not in answer:
                answer.append(set(permute))

    return len(answer)


def check(user, ban):
    if len(user) != len(ban):
        return False
    for i in range(len(user)):
        if ban[i] == "*":
            continue
        else:
            if user[i] != ban[i]:
                return False
    return True
