n, s = map(int, input().split())
arr = list(map(int, input().split()))

def choose(cur, value):
    global ans

    if cur == n:
        if value == s:
            ans += 1
        return
    
    choose(cur + 1, value + arr[cur])
    choose(cur + 1, value)

ans = 0
choose(0, 0)
print(ans if s != 0 else ans - 1)