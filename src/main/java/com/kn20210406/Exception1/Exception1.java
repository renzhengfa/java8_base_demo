package com.kn20210406.Exception1;

/*
异常处理：1、error extends Throwable（错误，必须修改源代码改正错误才能解决）。 2、exception extends Throwable(异常可以处理掉)
Throwable是java中所有异常的超类（父类）

1、throw（在方法内 throw new XxxException("数组下标为空...");）
    如果创建的是编译时异常就必须处理掉，运行时异常可以交给调用者处理
2、throws（必须在方法上throws XxxException,XxxException）
异常处理方式：
    1、throws抛出给别人处理
    2、try{
        可能参数异常的代码
    }catch(定义一个变量用来接收try中抛出的异常){
        异常处理逻辑，工作中一般会把异常的信息写在日志里面（如果有多个异常那么就有多个catch）
    }finally{

    }
 */
public class Exception1 {
    public static void main(String[] args) throws Exception {
        Integer[] arr = {10,60,10};
        //getVal(arr,null);//java.lang.NullPointerException: 数组下标为空...
        getVal(arr,2);//java.lang.IndexOutOfBoundsException: 数组索引不正确...
        getVal1(arr,2);
        getVal2(arr,4);
        System.out.println(getAge());
    }

    //获取数组指定索引处的值
    //1、在方法内根据判断抛不同的异常
    public static Integer getVal(Integer[] ints, Integer index){
        if (index >= ints.length || index < 0){
            throw new IndexOutOfBoundsException("数组索引不正确...");//java.lang.IndexOutOfBoundsException
        }
        if (index == null) {
            throw new NullPointerException("数组下标为空...");//java.lang.NullPointerException
        }
        System.out.println("getVal方法内throw抛出异常的后续代码块,,,出现异常后不会执行！！！");
        return ints[index];
    }

    //获取数组指定索引处的值
    //2、在方法上抛出异常
    public static Integer  getVal1 (Integer[] ints, Integer index)throws Exception{
//        if (index >= ints.length || index < 0){
//            throw new IndexOutOfBoundsException("数组索引不正确...");//java.lang.IndexOutOfBoundsException
//        }
//        if (index == null) {
//            throw new NullPointerException("数组下标为空...");//java.lang.NullPointerException
//        }
        Integer integer = ints[index];
        System.out.println("getVal1方法上throws抛出异常的后续代码块,,,出现异常后不会执行！！！");
        return integer;
    }

    //获取数组指定索引处的值
    //3、try{可能出现异常的代码}catch(Exception e){发生异常时才执行的代码}finally{不论异常是否发生都会执行的代码}
    // 3种获取异常信息的方法(e.getMessage()获取大概信息,e.printStackTrace()获取详细信息,e.toString()异常名称)
    public static Integer  getVal2 (Integer[] ints, Integer index) {
//        if (index >= ints.length || index < 0){
//            throw new IndexOutOfBoundsException("数组索引不正确...");//java.lang.IndexOutOfBoundsException
//        }
//        if (index == null) {
//            throw new NullPointerException("数组下标为空...");//java.lang.NullPointerException
//        }
        Integer integer = 0;
        try {
            System.out.println("可能会出现异常的代码块,,,如果出现异常程序将不再继续执行try块代码,将跳到catch块中继续执行");
            integer = ints[index];
            System.out.println("可能会出现异常的代码块,,,出现异常后不会执行！！！");
        } catch (IndexOutOfBoundsException e) {
            //获取异常详细信息打印出来
//            System.out.println(e.getStackTrace());
            System.out.println("出现异常才会执行的代码块！！！");
//            System.out.println(e.getMessage());
            System.out.println(e.toString());//java.lang.ArrayIndexOutOfBoundsException: 4
        } finally {
            System.out.println("无论异常是否产生都会执行的代码块！！！");
        }
        System.out.println("后续代码会执行！！！");//后续代码会执行！！！
        return integer;
    }

    //如果方法内有try...catch语句，尽量不要在finally里面写return语句，因为无论怎么样方法的返回值都是finally里面的值
    public static Integer getAge(){
        Integer age = 0;
        try {
            age = 12;
        }catch (Exception e) {
            age = 11;
        }finally {
            age = 101;
            return age;
        }
    }
}
