#Author:qihuijun
import sys
f=open("yesterdayonesmore","r",encoding="utf-8")
f_new=open("yesterdayonesmore.bak","w",encoding="utf-8")
for line in f:
    if "昨日当我年少轻狂" in line:
        line=line.replace("昨日当我年少轻狂","昨日当Alex年少轻狂")
    f_new.write(line)
f.close()
f_new.close()




