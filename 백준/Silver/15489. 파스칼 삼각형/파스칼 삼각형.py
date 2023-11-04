# 15489. 파스칼 삼각형

r, c, w = map(int, input().split())

pt = [[1 for _ in range(i)] for i in range(1, r + w)]

for i in range(1, r + w - 1):
    for j in range(1, i):
        pt[i][j] = pt[i - 1][j - 1] + pt[i - 1][j]

ans = 0
for i in range(w):
    for j in range(i + 1):
        ans += pt[r + i - 1][c + j - 1]

print(ans)