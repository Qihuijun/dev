# Author:qihuijun
# 斐波拉契数列，除第一个和第二个外，任意一个数等于前两个数相加
# 1，1，2，3，5，8，13，21，34...

def test(maxx):
    n,a,b=0,0,1
    while n<10:
        # print(b)#b=1 2
        yield b#生成器
        a,b=b,a+b #相当于t=(b,a+b),a=t[0],b=t[1]  a=1  b=1
        n=n+1
    return "done"
maxx=0
while maxx:
    print(test().__next__())
    maxx=maxx+1