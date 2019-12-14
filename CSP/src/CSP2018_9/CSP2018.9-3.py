def cmpstr(str1,str2):
    return str1.startswith(str2) and str2.startswith(str1)

class TreeNode:
    
    def __init__(self, tag , id , linenum , layernum):
        self.tag = tag
        self.id = id
        self.linenum = linenum
        self.layernum = layernum
        self.sons = []

    def addson(self, son):
        self.sons.append(son)

    def makefather(self, father):
        self.father = father

    def equals(self,str):
        if str.find("#") != -1:
            return cmpstr(self.id,str)
        else:
            return cmpstr(self.tag.lower(),str.lower())

      

class Queue:
    def __init__(self):
        self.queue = []

    def getinqueue(self,object):
        self.queue.append(object)

    def getoutqueue(self):
        q = self.queue[0]
        self.queue = self.queue[1:]
        return q
    


def search(root, couple , linenums):
    counts = 0
    lens = len(couple)
    l = Queue()
    l.getinqueue(root)
    while len(l.queue) != 0:
        node = l.getoutqueue()

        for i in range(len(node.sons)):
            l.getinqueue(node.sons[i])
        
        k = lens
        flag = 0
        if node.equals(couple[k-1]):
            flag += 1
            k -= 1
            tempnode = node
            while (tempnode.father != tempnode) and (k >= 1):
                tempnode = tempnode.father
                if tempnode.equals(couple[k-1]):
                    flag += 1
                    k -= 1
    
 
        if flag == lens:
            counts += 1
            linenums.append(node.linenum)
    
    linenums.sort()
    return counts

        




num = input().split()
n = int(num[0])
m = int(num[1])


str = input()
linenum = 1
layernum = str.count("..")
if str.find("#") != -1:
    strs = str.replace('.','').split()
    root = TreeNode(strs[0],strs[1],linenum,layernum)
else:
    root = TreeNode(str.replace('.',''),'',linenum,layernum)
root.father = root
treenow = root
for i in range(n-1):
    str = input()
    linenum = i + 2
    layernum = str.count("..")
    if str.find("#") != -1:
        strs = str.replace('.','').split()
        treenode = TreeNode(strs[0],strs[1],linenum,layernum)
    else:
        treenode = TreeNode(str.replace('.',''),'',linenum,layernum)
    if layernum == treenow.layernum + 1:
        treenow.addson(treenode)
        treenode.makefather(treenow)
        treenow = treenode
    elif layernum <= treenow.layernum:
        while treenow.layernum >= layernum:
            treenow = treenow.father
        treenow.addson(treenode)
        treenode.makefather(treenow)
        treenow = treenode
    

couples = []
for j in range(m):
    couple = input().split()
    couples.append(couple)
    
for j in range(len(couples)):
    linenums = []
    nums = search(root,couples[j],linenums)
    print (nums , end='')
    for i in range(len(linenums)):
        print("",linenums[i],end='')
    print ("")

        
         





