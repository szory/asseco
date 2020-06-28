package asseco.classes;

import asseco.db.DataBaseHandler;

public class RunMe {
    public static void main(String args[]) {
        DataBaseHandler dataBaseHandler = null;
        try {
            dataBaseHandler = new DataBaseHandler("jdbc:oracle:thin:@localhost:1521/xepdb1", "hr", "hr");
            Tasks ts = new Tasks(dataBaseHandler);
            System.out.println("\nTask 1\n");
            ts.task1().stream().forEach(System.out::println);
            System.out.println("\nTask 2\n");
            ts.task2().stream().forEach(System.out::println);
            dataBaseHandler.DisConnectDB();
        }catch(Exception e){
            System.out.println(e);
            try {
                dataBaseHandler.DisConnectDB();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}