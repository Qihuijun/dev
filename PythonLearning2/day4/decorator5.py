#Author:qihuijun
import time
username,passwd="Alex","abc123"
def auth(auth_type):
    def deco(func):
        def swarpper():
            username=input("username:")
            passwd=input("passwd:")
            if auth_type=="local":
                if username=="alex" and passwd=="abc123":
                    print("login success!")
                    func()
                else:
                    exit("login fail...")
            elif auth_type=="remote":
                print("hahahah,不会...")
        return swarpper
    return deco
# home欢迎页
@auth(auth_type="local")
def home():
    print("welcome to home...")
# 论坛欢迎页
@auth(auth_type="remote")
def bbs():
    print("welcome to bbs...")
# 学习天地欢迎页
def learningpark():
    print("welcome to learningpark...")
home()
bbs()
# learningpark()