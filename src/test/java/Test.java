import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test {
    int test_a, test_b;
    Test(int a, int b)
    {
        test_a = a;
        test_b = b;
    }

    public static void main (String args[])     {
       Test test = new Test(10,12);
        System.out.println(test.test_a+" "+test.test_b);
    }

    /**
     * https://reqres.in/api/users
     *
     * print email, avatar when user is
     *  "first_name":"Charles"
     */

  /*  private void test(){

        RA.BaseURI("https://reqres.in/api");
        RestLogSpecification log = given().logs().allLog();
        RequestSpecification resp = log.get("/users")
                .then().assertStatus("200");

        JsonPathh jResp = resp.getJsonPath();
        String emailActual ="";
        String avatar = "";
        String emailexpected ="xyz@domain.com";
        String avatarexpected = "abc";

        ObjectMapper.map("resp", testPojo.class);

        array.for(item i -> i.firstName=="" )

        ArrayList<String >data = jResp.getList("data");
      for(object ob : pojoOjbs){
          if(obj.getFirstName().equals("charles")){
              emailActual  = obj.getEmail();
              avatar= obj.getAvatar();
          }
      }

        Assert.assertEquals(emailexpected, emailActual);
        Assert.assertEquals(avatarexpected, avatar);


    }*/

    /**
     *
     * Input: str = “keeg”
     * Output: geke gkee egek egke eegk eekg ekge ekeg kgee geek kege
     *
     * -str input .
     * - List<String> output.
     * - string curStr  to hold the combination of chars. ---> repeating step
     * -
     */

    @org.junit.Test
    public void test(){
        String str = "keeg";
        String curStr = "";
        HashSet<String> output = new HashSet<>();
        repeatStrToFormPattern(str, curStr, output);
//
      //  System.out.println(output);
    }


    private void repeatStrToFormPattern(String s, String curStr, HashSet<String> out){
        if(s.length() == 0) out.add(curStr);

        for(int i = 0; i < s.length(); i++){
            //2 subStr = 0 to i and i+1 to end
            //in my curStr i will ith char
            String temp = s.substring(0, i)+s.substring(i+1); // e + eg

               repeatStrToFormPattern(temp, curStr+s.charAt(i), out); // k
        }
    }


    @org.junit.Test
    public void test1(){
        int n = 12345106;
       solution(n);
    }

    public void solution(int N) {
        int enable_print = N % 10; //
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
                System.out.print(enable_print);
            }
            else if (enable_print >= 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }
}
