#Author:qihuijun
# 主键唯一性，天生去重，无序性key-value
user_dict={
    "张三":50,
    "李四":77,
    "王五":99,
    "王五1":99
}
print(user_dict)
print(user_dict["张三"])
# b_dict={
#     "张三":501,
#     1:2,
#     3:4
# }
#
# # 创建字典
# c=dict.fromkeys([0,1,3],[1,{"name":"Alex"},4])
# user_dict.update(b_dict)#将字典1和字典2合并，去重
# print(user_dict)
# print(user_dict.items())
# c[3][1]["name"]="zhang"  #将所有的key-value都修改了
# print(c)
# # del user_dict["李四"]#删除
# # user_dict.pop("李四")
# user_dict.popitem()#随机删除，最好不要用
# print(user_dict)
# print("取值",user_dict["张三"])
# print("取值1",user_dict[0])
