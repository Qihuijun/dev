#Author:qihuijun
def bar():
    print("this is a bar")
def test(func):
    print(func)
    return func
test(bar)#实参为bar()，是将bar()的返回结果传给test，bar是将bar赋值给func
print(bar)#打印内存地址
print(bar())#打印bar函数的运行结果