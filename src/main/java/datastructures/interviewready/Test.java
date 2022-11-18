package datastructures.interviewready;

public class Test {
    public static void main(String[] args) {
        A a =new B();
        a.add();
        a.sub();
    //    a.mul(); -> gives complie error as here a is an object refering to "A" where we dont have mul()
    //    B b= new A(); // --> cannot create an obj for subClass refernce using parent calss.
      //  b.mul();




        AB ab = new AB(10);
        AB ab1 = new AB(10);

    }
}

class A{
    void add(){

    }
    void sub(){

    }
}

class B extends A{
    void add(){

    }
    void mul(){

    }
}


class AB{
    int val ;
    AB(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "val["+val+"]";
    }
}

