#Author:qihuijun
# 把一个函数名当作参数传递，返回值中包含函数名
def test(x,y,f):
    return f(x)+f(y)
t=test(3,-6,abs)
print(t)