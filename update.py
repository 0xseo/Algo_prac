#!/usr/bin/env python

import os
import re
from urllib import parse

HEADER="""# 
# 백준 & 프로그래머스 문제 풀이 목록


"""
BOJ_RANK = {
    'Bronze': 1,
    'Silver': 2,
    'Gold': 3,
    'Platinum': 4,
    'Diamond': 5,
    'Ruby': 6
}
def sort_key(name):
    if name in BOJ_RANK:
        return (0, BOJ_RANK[name])
    nums = re.findall(r'\d+', name)
    if nums:
        return (1, int(nums[0]))
    return (2, name)

def main():
    content = ""
    content += HEADER
    
    directories = [];
    solveds = [];


    for root, dirs, files in os.walk("."):
        dirs.sort(key=sort_key)
        if root == '.':
            for dir in ('.git', '.github'):
                try:
                    dirs.remove(dir)
                except ValueError:
                    pass
            continue

        category = os.path.basename(root)
        
        if category == 'images':
            continue
        
        directory = os.path.basename(os.path.dirname(root))
        
        if directory == '.':
            continue
            
        if directory not in directories:
            if directory in ["백준", "프로그래머스"]:
                content += "## 📚 {}\n".format(directory)
            else:
                if directory.isdigit():
                    content += "### 🚀 Lv {}\n".format(directory)
                else:
                    content += "### 🚀 {}\n".format(directory)
                content += "| 문제번호 | 링크 |\n"
                content += "| ----- | ----- |\n"
            directories.append(directory)

        for file in files:
            if category not in solveds:
                content += "|{}|[링크]({})|\n".format(category, parse.quote(os.path.join(root, file)))
                solveds.append(category)
                print("category : " + category)

    with open("README.md", "w") as fd:
        fd.write(content)
        
if __name__ == "__main__":
    main()
