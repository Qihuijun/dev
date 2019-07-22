#Author:qihuijun
import time
# 时间装饰器
# 装饰器就是函数，运用高阶函数+嵌套函数=》装饰器
def timmer(func):
    def warpper(*args,**kwargs):
        start_time=time.time()
        func()
        end_time=time.time()
        print("system run time is %s"%(start_time-end_time))
    return warpper
@timmer
def test1():
    time.sleep(3)
    print("time sleeped 3s")
test1()