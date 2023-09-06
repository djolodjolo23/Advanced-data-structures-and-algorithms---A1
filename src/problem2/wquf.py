class WQUnionFind:
  def __init__(self, N:int) -> None:
    self.d = list(range(N))
    self.sz = [1]*N

  def connected(self, a:int, b:int) -> bool:
    return self.root(a) == self.root(b)

  def root(self, a:int) -> int:
    while a != self.d[a]:
      self.d[a] = self.d[self.d[a]]
      a = self.d[a]
    return a

  def union(self, a:int, b:int) -> None:
    ra = self.root(a)
    rb = self.root(b)

    if self.sz[ra] < self.sz[rb]:
      self.d[ra] = rb
      self.sz[rb] += self.sz[ra]
    else:
      self.d[rb] = ra
      self.sz[ra] += self.sz[rb]



wquf = WQUnionFind(15)

print(wquf.sz, wquf.d)

wquf.union(1, 2)
print(wquf.sz, wquf.d)
wquf.union(3, 4)
print(wquf.sz, wquf.d)