1.Java编译器把.java文件编译成字节码存储在.class文件中，这个文件再在虚拟机上执行<br>
2. 访问修饰符（4）<br>
3. 驼峰命名法 常量名全大写<br>
4. 8中基本类型<br>
5.  三目表达式<br>
	condition?expression1:expression2<br>
条件正确第一个，否则第二个，<br>
6. 运算符优先级 &&>||<br>
7. do...while(至少执行一次)
   while(可能回一次也不执行)<br>
return/break,只要执行到return，整个程序结束，如果是执行到break，所在的代码块执行结束，执行代码块外的代码<br>
return和continue，break是结束当前的代码块，跳出循环，continue是本次循环不执行剩下的代码块，跳到循环的头部，继续循环<br>
8. Arrays.copyOf(array,array.length)   <br>
9. super/this
this 表示隐式参数/可以放在构造器里面，调用公有的构造器<br>
super 用于覆盖时，子类中super.method(父类),还有一种是super()是直接调用的父类的构造方法<br>
10. 静态方法使用类名调用有意义，使用对象没意义：<br>
作用：1.方法不需要访问对象状态，所需参数均为显式<br>
2.方法内部是访问类的静态域<br>
11. 抽象类：含有非抽象方法，可实例化，但是实例化的引用不是抽象方法，而是继承抽象类的方法，实例化的对象只能调用抽象类的方法
12. 抽象类是单继承的，但是接口是允许多实现的<br>


onlyonly