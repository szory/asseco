package asseco.classes;

import asseco.db.DataBaseHandler;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tasks {

    DataBaseHandler dataBaseHandler;

    public Tasks(DataBaseHandler dataBaseHandler){
        this.dataBaseHandler = dataBaseHandler;
    }
    public List<String> task1() throws Exception{
        List<String> list = new ArrayList<String>();
        String query = "Select " +
                        "e.last_name " +
                        ",(Select department_name FROM departments where department_id = b.department_id ) as department_name" +
                        " from employees e, (" +
                        "    Select employee_id,department_id,count(1) from job_history" +
                        "    group by department_id,employee_id" +
                        "    having department_id = (SELECT department_id FROM departments Where departments.department_name = 'DRK')" +
                        "    and count(1) >= 1" +
                        ") b " +
                        "Where e.employee_id = b.employee_id " +
                        "ORDER by e.last_name ASC";
        ResultSet rs=  this.dataBaseHandler.getConnection().executeQuery(query);
        while(rs.next())
            list.add("last name: '"+rs.getString(1)+"' department name:'"+rs.getString(2)+"'");
        return list;
    }
    public List<String> task2() throws Exception{
        List<String> list = new ArrayList<String>();
        String query = "" +
                "Select " +
                "    (Select department_name from departments where departments.department_id = jh.department_id) as depratments_name, 'Kowalski' as name, jh.salary, j.max_salary, j.max_salary * 0.75 " +
                "from job_history jh, jobs j " +
                "where employee_id = (select employee_id from employees where last_name = 'Kowalski')" +
                "      and" +
                "      jh.job_id = j.job_id" +
                "      and" +
                "      jh.salary <  j.max_salary * 0.75" +
                " order by depratments_name asc";
        ResultSet rs=  this.dataBaseHandler.getConnection().executeQuery(query);

        while(rs.next())
            list.add("department name: '"+rs.getString(1)+"', last name:'"+rs.getString(2)+"', salary:'"+rs.getInt(3)+"', max salary:'"+rs.getInt(4)+"', 75% max salary:'"+rs.getInt(5)+"'");
        return list;
    }
}