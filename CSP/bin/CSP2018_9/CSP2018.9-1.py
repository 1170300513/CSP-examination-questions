# -*- coding: utf-8 -*-
"""
Created on Wed Oct  9 19:31:53 2019

@author: junbaba
"""

n = int(input())
list1 = input().split()
list2 = []
for i in range(n):
    list2.append(int(list1[i]))
for i in range(n):
    if i == 0:
        a = int((list2[1]+list2[0])/2)
        print(a,end='')
    elif i == n - 1:
        a = int((list2[i]+list2[n-2])/2)
        print("",a,end='')
    else:
        a = int((list2[i-1]+list2[i]+list2[i+1])/3)
        print("",a,end='')

