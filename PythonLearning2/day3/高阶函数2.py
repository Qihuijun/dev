#Author:qihuijun
def func1():
    def func2():
        print(1)
    print(2)
    return func2()
func1()
'''运行步骤：2-7-3-5-6-1，所以打印结果应该是2，1'''