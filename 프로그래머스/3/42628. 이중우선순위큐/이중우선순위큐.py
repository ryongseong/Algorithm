import heapq


def solution(operations):
    answer = []

    for operation in operations:
        answer.sort()
        command, value = operation.split()
        if command == "I":
            heapq.heappush(answer, int(value))
        elif command == "D":
            if answer:
                if value == "-1":
                    heapq.heappop(answer)
                elif value == "1":
                    answer.pop()

    return [max(answer), min(answer)] if answer else [0, 0]