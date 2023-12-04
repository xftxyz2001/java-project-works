d = {
    "chapter1": [1, 3, 4, 5, 8, 11, 12, 13],
    "chapter2": [1, 2, 3, 4, 5, 6, 7, 8, 12, 13, 14, 15, 18, 19, 20, 21, 23],
    "chapter3": [1, 4, 7, 9, 11, 12, 15, 16, 17, 19, 21, 22, 24, 30, 32],
    "chapter4": [1, 5, 6, 9, 11, 13, 17, 20, 21, 22, 25],
    "chapter5": [
        1,
        4,
        7,
        9,
        12,
        16,
        17,
        19,
        20,
        22,
        24,
        25,
        27,
        29,
        30,
        33,
        34,
        47,
        48,
    ],
    "chapter6": [2, 3, 4, 9, 13, 14, 16, 18, 24, 26, 30, 31, 34, 36, 37, 39],
    "chapter7": [3, 5, 7, 9, 10, 13, 17, 18, 26, 27, 29, 34, 35],
    "chapter8": [1, 2, 4, 5, 6, 10, 11, 13, 16, 22, 23, 25, 26, 27, 29, 32, 35],
    "chapter9": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13],
    "chapter10": [1, 2, 3, 4, 5, 9, 10, 11, 12, 14, 18, 22, 26, 27],
    "chapter11": [1, 2, 3, 4, 5, 7, 8, 12, 13, 14, 18],
    "chapter12": [1, 2, 3, 6, 7, 8, 9, 10, 11, 16, 19, 23, 25, 28, 30],
    "chapter13": [1, 2, 3, 4, 8, 9, 12, 16, 17, 19],
    "chapter14": [1, 2, 3, 8, 9, 10, 11, 12, 18, 20, 26, 27],
    "chapter15": [1, 3, 4, 6, 8, 9, 11, 15, 18, 21, 27, 29, 30, 32],
    "chapter16": [3, 4, 6, 7, 10, 12, 14, 16, 17, 18, 22, 26],
}

# 创建Java文件
import os

base_path = "src/main/java/com/xftxyz"
base_pkg = "com.xftxyz"


for chapter, problems in d.items():
    for problem in problems:
        # 创建文件
        file_name = f"T{problem}.java"
        file_path = os.path.join(base_path, chapter, file_name)
        os.makedirs(os.path.dirname(file_path), exist_ok=True)
        with open(file_path, "w") as f:
            f.write(f"package {base_pkg}.{chapter};\n\n")
            f.write(f"public class T{problem} {{\n\n")
            f.write(f"    public static void main(String[] args) {{\n\n")
            f.write(f"    }}\n")
            f.write(f"}}\n")
        print(f"创建文件: {file_path}")

print("创建完成")
