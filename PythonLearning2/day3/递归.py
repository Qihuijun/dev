﻿#Author:qihuijun
def cal(n):
    print(n)
    if int(n/2)>0:
        return cal(int(n/2))
    print("-->",n)
cal(10)