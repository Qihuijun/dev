#Author:qihuijun
import time
def deco(func):#func=test1
    def timmer(*args,**kwargs):#定义一个timmer方法，将一个函数以参数形式存放
        start_time=time.time()
        func(*args,**kwargs)#调用函数
        end_time=time.time()
        print("the fun run time is %s"%(end_time-start_time))
    print(timmer)
    return timmer
@deco
def test1():
    print("this is test1")
    time.sleep(1)
@deco
def test2(name):#test2=deco(test2)=timmer test2()=timmer()
    print("this is test2",name)
    time.sleep(1)
# test1()#运行流程就是，将test1赋值给了func->依次执行3，4，5行，
# 第六行执行test1()，再执行第7，8行->最后执行第九行返回timmer函数的过程
# 先执行装饰器，再执行调用函数
test2("zhang")
print(test2)