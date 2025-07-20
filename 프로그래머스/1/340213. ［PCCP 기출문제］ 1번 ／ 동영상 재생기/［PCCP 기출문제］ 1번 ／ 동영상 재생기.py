def minutes_to_seconds(time_str):
    hours, minutes = map(int, time_str.split(':'))
    return hours * 60 + minutes


def second_to_minutes(minutes):
    hours = minutes // 60
    minutes = minutes % 60
    return f"{hours:02}:{minutes:02}"


def solution(video_len, pos, op_start, op_end, commands):
    video_len_minutes = minutes_to_seconds(video_len)
    pos_sec = minutes_to_seconds(pos)
    op_start_second = minutes_to_seconds(op_start)
    op_end_second = minutes_to_seconds(op_end)

    for command in commands:
        if command == 'prev':
            pos_sec = max(0, pos_sec-10)
        elif command == 'next':
            if op_start_second <= pos_sec <= op_end_second:
                pos_sec = op_end_second
            pos_sec = min(video_len_minutes, pos_sec+10)

        if op_start_second <= pos_sec <= op_end_second:
            pos_sec = op_end_second

    return second_to_minutes(pos_sec)