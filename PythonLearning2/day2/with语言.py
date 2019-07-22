#Author:qihuijun
# with可以自动关闭文件,,\同时打开两个文件
with open("haproxy配置文件","r+",encoding="utf-8") as f :
    # 新增
    arg={
        'bakend': 'www.oldboy.org',
        'record':{
            'server': '100.1.7.9',
            'weight': 20,
            'maxconn': 30
        }
    }
    arg1=str(arg["bakend"])
    arg2=str(arg["record"])
    print(arg1,arg2)
    for line in f:
        if "www.oldboy.org" in line:
            f.write(arg2)
        else:
            f.write(arg1)
    f.close()
