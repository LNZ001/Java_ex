# java快速上手和学习 (2020-5-25)
重点关注java和python的差异。
1. 首先上手遇到的是（）{}括号和；,python不需要；
2. 然后是变量声明必须有类型，强类型语言；
3. True 为true， None 为null；
4. 环境配置： 首先是需要大量的设置当前本地版本openjdk14？并设置application，熟悉后再来理解这些配置的作用
    ![image-0](https://github.com/LNZ001/Java_ex/blob/master/20200525230918.png)
5. 作为强类型语言，返回值也是函数必须说明，且代码明确返回的。
6. java中有大量的要导入的java.util.*中的数据类型结构，很常用, 且声明语法使用new实例化。(这里两个<>的含义？)
    ```java
   ArrayDeque<Interger> deque = new ArrayDeque<>(); 
   ```
7. java声明数组列表有两种方式：
    ```java
   String[] str={"AAA","BBB","CCC"};
   String str[]={"AAA","BBB","CCC"}; 
   ```
7. 一些写法上的优化： for if 上的， java是有switch的。
    ```java
   import java.util.ArrayDeque;
   
   public class Solution {
   
       public int evalRPN(String[] tokens) {
           ArrayDeque<Integer> deque = new ArrayDeque<>(); // 双端队列
           for(int i = 0; i< tokens.length; i++){ //这里的for还是老的写法，这里实际只用到具体的值；
               if(tokens[i].equals("+")){ //这里可以替换成switch
                   int v1 = (int)deque.pop();
                   int v2 = deque.pop();
                   int value = v1+v2;
                   deque.add(value);
               }
               else if(tokens[i].equals("-")){
                   int v1 = (int)deque.pop();
                   int v2 = deque.pop();
                   int value = v1-v2;
                   deque.add(value);
               }
               else if(tokens[i].equals("*")){
                   int v1 = (int)deque.pop();
                   int v2 = deque.pop();
                   int value = v1*v2;
                   deque.add(value);
               }
               else if(tokens[i].equals("/")){
                   int v1 = (int)deque.pop();
                   int v2 = deque.pop();
                   int value = v1/v2;
                   deque.add(value);
               }
               else{
                   int value = Integer.parseInt(tokens[i]);
                   deque.add(value);
               }
           }
           return deque.pop();
       }
   } 
   ```
   - 修改后：(-> 似乎在1.8不可用，替换成:可运行, 而且：好像不break会转到default, —> 则不会，可能是java版本的问题)
        ```java
        import java.util.ArrayDeque;
        
        public class Solution {
        
            public static void main(String[] args){
                String[] str = {"4","13","5","/","+"};
                System.out.println(evalRPN(str));
            }
        
            public static int evalRPN(String[] tokens) {
                ArrayDeque<Integer> deque = new ArrayDeque<>(); // 双端队列
        
                for (String token : tokens) {
                    switch (token) {
                        case "+" :{
                            int v1 = deque.pollLast();
                            int v2 = deque.pollLast();
                            int value = v2 + v1;
                            deque.add(value);
                            break;
                        }
                        case "-" :{
                            int v1 = deque.pollLast();
                            int v2 = deque.pollLast();
                            int value = v2 - v1;
                            deque.add(value);
                            break;
                        }
                        case "*" : {
                            int v1 = deque.pollLast();
                            int v2 = deque.pollLast();
                            int value = v2 * v1;
                            deque.add(value);
                            break;
                        }
                        case "/" : {
                            int v1 = deque.pollLast();
                            int v2 = deque.pollLast();
                            int value = v2 / v1;
                            deque.add(value);
                            break;
                        }
                        default: {
                            int value = Integer.parseInt(token);
                            deque.add(value);
                        }
                    }
                }
                return deque.pop();
            }
        }
        


        ```