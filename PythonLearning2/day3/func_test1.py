#Author:qihuijun
# 函数，有返回值
def test1():
    print("函数")
    return 0
test1()
# 过程，没有返回值
def test2():
    print("过程")
# 位置参数
def test3(x,y):
    print(x)
    print(y)
# 默认参数,默认参数要放在位置参数后面
def test4(x,y=1):
    print(x)
    print(y)
# test4(0)
# *args将N个位置参数转换成元组的形式
def test5(x,y=1,*args):
    print(x)
    print(y)
    print(args)
# test5(0,2,3,4,5)
def test(*args):
    print(args)
# test(1,2,3,45)
# test(*[1,2,3,45])#args=tuple(1,2,3,45)
def test6(x,*args):
    print(x)
    print([1,2,3,4])
# test6(0,9,9,9)
def test8(x,*args):
    print(x)
    print(args)
# test8(0,*[1,2,3])
def test9(x,*args):
    print(x)
    print(args)
# test9(0,*[1,2,3])
# **kwargs将N个关键字参数转换成字典的形式
def test7(x,**kwargs):
    print(x)
    print(kwargs)
# test7(1,name1="Alex",sex1="F")
# test7(1,**{"name":"alex","sex":"f"})
# 位置参数，默认参数，*args,**kwargs
def test10(x,y=1,*args,**kwargs):
    print(x)
    print(y)
    print(args)
    print(kwargs["name"])
    print(kwargs["sex"])
    # test(1,2,3)
# test10("one",name="alex",sex="f",age=18)

