#Author:qihuijun
# 声明一个shopping_list
shopping_list=[]
# 声明一个变量存储自己的余额
savings=input("请输入自己的余额:")
# 数组存储购物车商品和价格
product_list=[["Bike",888],["cloth",499],["shoes",300],["coffee",31],["bag",599]]
# 判断是不是数字
if savings.isdigit():
    print (savings.isdigit())
    savings=int(savings)
    while True:
        # 枚举输出商品列表
        for index,item in enumerate(product_list):
            print (index,item)
        # 输入商品名称
        product_choice=input("请输入商品序列号：")
        # 判断输入的序列号是不是数字
        if product_choice.isdigit():
            product_choice=int(product_choice)
            # 判断输入的序列号是不是合规和的
            if product_choice<len(product_list) and product_choice>=0:
                # 将取出来的数据存到另一个变量中
                product_item=product_list[product_choice]
                # 判断取出来的数值的金额是不是小于等于自己的所剩余额
                if product_item[1]<=savings:
                    savings=savings-product_item[1]
                    # 将已购买的数据存到一个数组中
                    shopping_list.append(product_item)
                    print ("购买成功,你所剩的余额为：%s"%(savings))
                else:
                    print ("你的余额还剩:%s,买不起"%(savings))
        elif product_choice=="q":
            print ("你买的商品清单：")
            for p in shopping_list:
                print (p)
            print ("你的余额还剩%s"%(savings))
            #     退出
            # exit()
            break
        else:
            print ("invalid option!")
