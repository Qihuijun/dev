#Author:qihuijun
# set集合无序，去重
list_1=[1,2,4,5,7,2]
list_1=set(list_1)
print(list_1,type(list_1))
list_2={2,4,6,8}
print(list_2,type(list_2))
# 交集
print(list_1.intersection(list_2))
print(list_1 & list_2)
#并集
print(list_1.union(list_2))
print(list_1 | list_2)
# 差集
print(list_1.difference(list_2))
print(list_1-list_2)
print(list_2.difference(list_1))
# 对称差集 去掉交集内容
print(list_1.symmetric_difference(list_2))
print(list_1^list_2)
# 增加
list_1.add(0)
list_1.update([11,22,33])
print(list_1)
# 删除 无顺序
# print(list_1.pop())
# 指定删除
list_1.remove(0)
print(list_1)
# 子集 list3是list1的子集
list_3={0}
print(list_3.issubset(list_1))
# 父集
print(list_1.issuperset(list_3))
#判断两个集合有没有交集，没有交集返回true
print(list_3.isdisjoint(list_1))