#Author:qihuijun
name="my name is {name},i am {years} old"
name1="Alex"
print(name.isdigit()) #判断是不是数字
print(name.count("u"))#判断u的位置
print(name.lower())#转换为小写
print(name.format(name="June",years="23"))#将name和years传值过去
print(name.format_map({"name":"June","years":"23"}))
print(name.capitalize())#大写首字母
print("l".join("123"))#打印结果1l2l3
print(name1.center(50,"-"))
p=str.maketrans("abced","12345")#将abcde分别由12345替换
print(name.translate(p))#按照P的规则将name中的字符换成P中的规则
print(name.replace("i","2"))#替换字符串中的i为2
print(name.replace("i","2",1))
print("Abc".swapcase())#将大小写置换
print("Abc".upper())
print(name.split(" "))#将字符串按照空格分成多个字符串
print(name.title())#每个单词的首字母大写，空格区分单词
