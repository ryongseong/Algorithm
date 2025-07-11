class FenwTree:
    def __init__(self, n):
        self.n = n
        self.tree = [0] * (n + 1)
        
    def update(self, i, delta):
        while i <= self.n:
            self.tree[i] += delta
            i += i & -i
            
    def query(self, i):
        s = 0
        while i > 0:
            s += self.tree[i]
            i -= i & -i
        return s

def count_valid_subarrays(N, P, scores):
    # 누적합 계산
    prefix_sum = [0] * (N + 1)
    for i in range(N):
        prefix_sum[i + 1] = prefix_sum[i] + scores[i]
        
    # 변환: A[i] = prefix_sum[i] - P * i
    A = [prefix_sum[i] - P * i for i in range(N + 1)]
    
    # 좌표 압축: FenwTree의 인덱스로 사용
    sorted_A = sorted(set(A))
    comp = {v: i + 1 for i, v in enumerate(sorted_A)}  # 1-indexed
    
    fenw = FenwTree(len(sorted_A))
    count = 0
    # A 배열을 순회하면서 이전에 나온 값 중 A[i] <= A[j]인 개수를 구함
    for a in A:
        idx = comp[a]
        count += fenw.query(idx)
        fenw.update(idx, 1)
    return count

T = int(input())
for test_case in range(1, T + 1):
    N, P = map(int, input().split())
    scores = list(map(int, input().split()))
    result = count_valid_subarrays(N, P, scores)
    print(f"#{test_case} {result}")
