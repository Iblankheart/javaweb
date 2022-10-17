#JavaWeb课程第一次作业  
定义一个Studnet类，该类包含“学号”，“姓名”，“数学成绩”，“语文成绩”，“外语成绩” 这几个数据字段。  

定义一个StudentManager对象，用于管理学生和成绩。  

从本地文件系统中读取 students.txt 文件（该文件的路径为 c:\students.txt，其中包含学生学号和姓名）， 从中提取信息，将构造好的student对象存储到StudentManager对象中。  

从网络上读取另外三个文件 math.txt,  chinese.txt,  english.txt, 这三个文件分别包含了“学号”，“成绩”两个字段。  
读取并解析文件内容后， 从StudentManager中查询对应学号的student对象，并将分数赋值给对应科目的数据字段。  

#在StudentManager对象中实现如下功能：  

printAll() 打印所有学生的信息，每行学生信息包含 “学号”，“姓名”，“语文”，”数学“，”外语“，”总分“，”平均分“这些字段，用逗号隔开;  

getStudentById(String id) 根据学号查询学生信息;  

findByScore(String classType, int min, int max) 根据课程类别，分值范围查询返回符合要求的学生列表;  

findByScore(int min, int max) 查询三科成绩平均分在指定范围内的学生列表;  

sortByTotal() 返回一个列表，列表中的学生按总分由高到低排序;  

saveAs(Sting filePath) 将学生信息按 “学号”，“姓名”，“语文”，”数学“，”外语“，”总分“，”平均分“ 字段排列存另存到参数指定的文件中，字段用逗号隔开;  
