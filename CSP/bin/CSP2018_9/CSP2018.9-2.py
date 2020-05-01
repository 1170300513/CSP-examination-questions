# -*- coding: utf-8 -*-
"""
Created on Wed Oct  9 19:31:53 2019

@author: junbaba
"""
n = int(input())
a = []
b = []
for i in range(n):
    list = input().split()
    a.append((int(list[0]),int(list[1])))
for i in range(n):
    list = input().split()
    b.append((int(list[0]),int(list[1])))
i = 0
j = 0
totaltime = 0
while i < n and j < n:
    if a[i][1] <= b[j][0]:
        i += 1
        continue
    if b[j][1] <= a[i][0]:
        j += 1
        continue
    if a[i][0] >= b[j][0]:
        if a[i][1] <= b[j][1]:
            totaltime += a[i][1] - a[i][0]
            i += 1
        else:
            totaltime += b[j][1] - a[i][0]
            j += 1

        continue
    if a[i][0] < b[j][0]:
        if b[j][1] <= a[i][1]:
            totaltime += b[j][1] - b[j][0]
            j += 1
        else:
            totaltime += a[i][1] - b[j][0]
            i += 1
        continue
print (totaltime)

