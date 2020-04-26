# LeetCodeAnswerFramework
一个简单的乐色框架，在leetcode做题的时候能更容易的运行自己的的代码，支持批量输入输出。

使用方法：
1.复制出一份main/java/LC000_demo，改成对应的题目名字和编号。
2.将leetcode要求你编写的方法覆盖掉demo里的methodA方法，并且更改tryYourAnswer方法中对应的方法引用参数。
3.根据要输入的类型，定义对应的List<E>,作为参数填入tryYourAnswer方法中。
4.向入参List中添加你的入参。
5.运行main方法即可。
