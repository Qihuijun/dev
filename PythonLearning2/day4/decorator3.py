#Author:qihuijun
def grandpa():
    x=1
    print(x)
    def father():
        x=2
        print(x)
        def son():
            x=3
            print(x)
        son()
    father()
grandpa()#如果调用grandpa时不调用father和son,father和son值不打印