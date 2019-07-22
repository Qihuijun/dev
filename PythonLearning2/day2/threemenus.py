#Author:qihuijun
data = {
    '北京':{
        "昌平":{
            "沙河":["oldboy","test"],
            "天通苑":["链家地产","我爱我家"]
        },
        "朝阳":{
            "望京":["奔驰","陌陌"],
            "国贸":{"CICC","HP"},
            "东直门":{"Advent","飞信"},
        },
        "海淀":{},
    },
    '山东':{
        "德州":{},
        "青岛":{},
        "济南":{}
    },
    '广东':{
        "东莞":{},
        "常熟":{},
        "佛山":{},
    }
}
exit_flag=False
while not exit_flag:
    # 打印data的第一层key
    for i in data:
        print(i)
    choice1=input("请选择第1层>>>""")
    if choice1 in data:
        while not exit_flag:
            for i2 in data[choice1]:
                print(i2)
            choice2=input("请选择第2层>>>")
            if choice2 in data[choice1]:
                while not exit_flag:
                    for i3 in  data[choice1][choice2]:
                        print(i3)
                    choice3=input("请选择第3层>>>")
                    if choice3 in data[choice1][choice2]:
                        for i4 in data[choice1][choice2][choice3]:
                            print(i4)
                        choice4 = input("最后一层，按b返回>>:")
                        if choice4 == "b":
                            pass
                        elif choice4 == "q":
                            exit_flag = True
                    if choice3 == "b":
                        break
                    elif choice3 == "q":
                        exit_flag = True
            if choice2 == "b":
                break
            elif choice2 == "q":
                exit_flag = True

