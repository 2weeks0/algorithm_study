import sys
input = sys.stdin.readline
s,t=map(int,input().split())
v={s}
if s==t :
    print(0)
    exit(0)
opers=['*','+','-', '/']
q=[['',s]]
while q:
    sik,num=q.pop(0)
    for i in range(4):
        tsik,tnum=sik+opers[i],[num*num,2*num,0,1][i]
        if tnum==t :
            print(tsik)
            exit(0)
        elif tnum not in v and tnum<t :
            q.append([tsik,tnum])
            v.add(tnum)
print(-1)