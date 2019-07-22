#Author:qihuijun
school="zhongtian school"
student=["zhang","wang","liu","li"]
score={"yuwen":89,"shuxu":97,"yingyu":99}
def test():
    school="shiyan school"
    student[1]="ge"
    score["yuwen"]=91
    print(school)
    print("inner values",student)
    print("inner values",score)
#打印局部变量的school，局部变量不能改变全局变量的str
# 局部变量的list可以改变全局变量同名称的list
# 局部变量的dict可以改变全局变量同名称的dict
test()
# 打印全局变量的school
print(school)
print(student)
print(score)