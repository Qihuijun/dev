# Author:qihuijun
# 生成器要在调用的时候才生成相应的数据
a=[i*2 for i in range(10)]#这是一个list
print(a)
# 只记录当前的位置，只有一个__next__
b=(i*2 for i in range(10))
print(b)
c=0
while c<10:
    print(b.__next__())
    c=c+1