def solution(schedules, timelogs, startday):
    answer = 0

    for i in range(len(schedules)):
        schedule = schedules[i]
        hour = schedule // 100
        minute = schedule % 100

        deadline_min = minute + 10
        deadline_hour = hour + (deadline_min // 60)
        deadline_min = deadline_min % 60
        deadline_time = deadline_hour * 100 + deadline_min

        flag = True

        for day in range(7):
            current_day = (startday + day) % 7

            if current_day in [0, 6]:
                continue

            real_time = timelogs[i][day]
            if real_time > deadline_time:
                flag = False
                break

        if flag:
            answer += 1

    return answer