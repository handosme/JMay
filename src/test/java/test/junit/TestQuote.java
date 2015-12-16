package test.junit;
/**
 * Java中只有值传递
 * @author 吴帅
 * @CreationDate 2015年9月18日
 * @version 1.0
 */
class Demo{  
    int a;  
    public Demo(int a){  
        this.a=a;  
    }  
}  
public class TestQuote{  
    public static void main(String args[]){  
        Demo d1=new Demo(1);  
        Demo d2=new Demo(2);  
        System.out.println(d1.a);  
        System.out.println(d2.a);  
        function(d1,d2);  
        System.out.println(d1.a);  
        System.out.println(d2.a);  
    }  
    private static void function(Demo d1,Demo d2){  
        Demo temp;  
        temp=d1;  
        d1=d2;  
        d2=temp;  
    }  
} 