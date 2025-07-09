def solution(today, terms, privacies):
    n = len(privacies)
    today_year, today_month, today_day = map(int, today.split("."))
    terms_dict = {term.split()[0]: int(term.split()[1]) for term in terms}

    answer = []
    for i in range(n):
        privacy_date, privacy_term = privacies[i].split()
        privacy_year, privacy_month, privacy_day = map(int, privacy_date.split("."))
        term_duration = terms_dict[privacy_term]

        expiration_year = privacy_year + term_duration // 12
        expiration_month = privacy_month + term_duration % 12
        expiration_day = privacy_day - 1

        if expiration_month > 12:
            expiration_year += 1
            expiration_month -= 12

        if (
            expiration_year < today_year
            or (expiration_year == today_year and expiration_month < today_month)
            or (
                expiration_year == today_year
                and expiration_month == today_month
                and expiration_day < today_day
            )
        ):
            answer.append(i + 1)
    return answer