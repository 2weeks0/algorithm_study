L,K = int(input(),2),int(input(),2)
v,q=[0 for _ in range((1<<11)+1)],[L]
def add(n,tmp):
    if tmp < (1<<11) and not v[tmp]: 
        q.append(tmp)
        v[tmp] = v[n]+1
while q:
    if (n := q.pop(0))==K :
        print(v[n])
        break
    add(n,n+1)
    add(n,n-1)
    for i in range(n.bit_length()-1): add(n,n^(1<<i));