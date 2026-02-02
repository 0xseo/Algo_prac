import sys
sys.setrecursionlimit(10**6)

class Node:
    def __init__(self, l):
        self.index = l[0]
        self.x = l[1]
        self.y = l[2]
        self.left = None
        self.right = None
        self.parent = None
        

def solution(nodeinfo):
    def buildTree(node, cur):
        if node.x < cur.x:
            if cur.left == None:
                cur.left = node
                node.parent = cur
            else:
                buildTree(node, cur.left)
        else:
            if cur.right == None:
                cur.right = node
                node.parent = cur
            else:
                buildTree(node, cur.right)
    def preorder(node, l):
        l.append(node.index)
        if node.left != None:
            preorder(node.left, l)
        if node.right != None:
            preorder(node.right, l)
            
    def postorder(node, l):
        if node.left != None:
            postorder(node.left, l)
        if node.right != None:
            postorder(node.right, l)
        l.append(node.index)
            
    nodesByHeight = {}
    for i, node in enumerate(nodeinfo):
        x = node[0]
        y = node[1]
        if y in nodesByHeight.keys():
            nodesByHeight[y].append([i+1, x, y])
        else:
            nodesByHeight[y] = [[i+1, x, y]]
    for h in nodesByHeight.keys():
        nodesByHeight[h] = sorted(nodesByHeight[h], key=lambda x:x[1])
    heights = sorted(list(nodesByHeight.keys()), reverse=True)
    nodesForTree = []
    for h in heights:
        nodesForTree += nodesByHeight[h]
        
    root = Node(nodesForTree[0])
    for node in nodesForTree[1:]:
        buildTree(Node(node), root)
    
    pre = []
    post = []
    preorder(root, pre)
    postorder(root, post)
    return [pre, post]