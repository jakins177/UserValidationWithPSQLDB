public class Main {

    public static void main(String[] args) {
        DBManager myManager = new DBManager();

        //myManager.connectSample();

       boolean validate = myManager.validateUser("123yayaya","joshua","josh@fakemail.com");

       if (validate)
       {
           System.out.println("The user has been validated");

       }
       else{
           System.out.println("Invalid credentials");
       }


    boolean updated =   myManager.updateUser("123yayaya","joshua", "jokkgsh@fakemail.com");

        if (updated)
        {
            System.out.println("The user has been updated");

        }
        else{
            System.out.println("not updated");
        }



    }


}
