#Author:qihuijun
# 打开文件
f=open("yesterdayonesmore",encoding="utf-8")
# 读取全部文件
# data=f.read()
# data2=f.read()
# 一行行读取文件
# print(f.readline())
# print(f.readline())
# print(f.readline())
# print("-------data2--------")
# 循环读取前五行
# for i in range(5):
#     print(f.readline())
# 读取剩余的所有行,但是没换行显示
# print(f.readlines())
# 换行显示剩余的所有行
# for line in f.readlines():
#     # print(line)
# # 把空格都去掉
#     print(line.strip())
# 在读到第九行打个标签,用read效率不高
# for index,line in enumerate(f.readlines()):
#     if index==9:
#         print("---------这是一条分割线----------")
#         continue
#     print(line.strip())
# 高效率的是一行行读取
count=0
for line in f:
    if count==9:
        print("-------这是一条分割线--------")
        count=count+1
        continue
    print(line.strip())
    count=count+1
# 默认是只读，需要添加write权限，才能写入内容"w"
# 将权限改成"a",在文件末尾追加
# 文件需要关闭了重新读才才行，不能写入了文件直接读取文件
# f1=open("yesterday2","a",encoding="utf-8")
# f1.write("我爱上海东方明珠1\n")
# f1.write("东方明珠是上海的标志性建筑\n")
# f1.close()
