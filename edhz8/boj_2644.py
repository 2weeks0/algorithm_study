import sys
input = sys.stdin.readline
n=int(input())
a,b=map(int,input().split())
m=int(input())
graph = [[0 for _ in range(n+1)]for _ in range(n+1)]
for i in range(m):
    x,y=map(int,input().split())
    graph[x][y] = graph[y][x] = 1
q=[[a,0]]
visited = [0 for _ in range(n+1)]
while q:
    num,chon = q.pop()
    if num == b : 
        print(chon)
        exit(0)
    for i in range(1,n+1):
        if graph[num][i] and not visited[i]:
            q.append([i,chon+1])
            visited[i]=1
print(-1)
